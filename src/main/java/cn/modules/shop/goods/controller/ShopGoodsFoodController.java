package cn.modules.shop.goods.controller;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import static cn.hutool.core.date.DatePattern.PURE_DATETIME_PATTERN;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import cn.base.AbstractController;
import cn.common.factory.PageFactory;
import cn.common.utils.AttachUtils;
import cn.common.utils.PageUtils;
import cn.common.utils.Result;
import cn.hutool.core.date.DateUtil;
import cn.modules.base.annex.entity.BaseAnnexEntity;
import cn.modules.sys.entity.BatchBaseinfoAttachEntity;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.springframework.web.bind.annotation.*;
import cn.modules.shop.goods.entity.ShopGoodsFoodEntity;
import cn.modules.shop.goods.service.ShopGoodsFoodService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Map;
import java.io.InputStream;
import java.util.Date;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;
/**
* 商品食品表控制器
*
* @author jianconglee
* @date 2019-02-28 23:07:20
*/
@RestController
@RequestMapping("/shopgoodsfood")
public class ShopGoodsFoodController extends AbstractController {

    @Autowired
    private ShopGoodsFoodService shopGoodsFoodService;

    /**
    * 获取分页信息
    * @param entity 对象
    * @return Object 分页信息
    */
    @GetMapping(value = "/list")
    public Object list(ShopGoodsFoodEntity entity) {
        Page<ShopGoodsFoodEntity> page = new PageFactory<ShopGoodsFoodEntity>().defaultPage();
        page.setRecords(shopGoodsFoodService.selectPage(page,entity,new EntityWrapper<ShopGoodsFoodEntity>()));

        return Result.ok().put("page", new PageUtils(page));
    }


    /**
    * 新增
    * @param entity 对象
    * @return Object 执行结果
    */
    @PostMapping(value = "/add")
    @RequiresPermissions("shopgoods:add")
    public Object add(@RequestBody ShopGoodsFoodEntity entity) {
        shopGoodsFoodService.insert(entity);
        return Result.ok();
    }

    /**
    * 删除多个
    * @param ids 主键
    * @return Object 执行结果
    */
    @PostMapping(value = "/delete")
    @RequiresPermissions("shopgoods:delete")
    public Object delete(@RequestBody Integer[] ids) {
        shopGoodsFoodService.deleteBatchIds(Arrays.asList(ids));
        return Result.ok();
    }

    /**
    * 更新
    * @param entity 对象
    * @return
    */
    @PostMapping(value = "/update")
    public Object update(@RequestBody ShopGoodsFoodEntity entity) {
        shopGoodsFoodService.updateById(entity);
        return Result.ok();
    }

    /**
    * 详情
    * @param entity 对象
    * @return Object 详细对象
    */
    @GetMapping(value = "/info")
    public Object info(ShopGoodsFoodEntity entity) {
        return Result.ok().put("shopgoodsfood", shopGoodsFoodService.selectOne(entity));
    }

    /**
    *  基本附件表导入
    * @param file  上传的文件
    * @return
    */
    @RequestMapping(value="/import")
    @ResponseBody
    public Object  importFile(@RequestParam("file")MultipartFile file){

        boolean flag = true;
        BaseAnnexEntity model = new BaseAnnexEntity();
        try {
            InputStream inputStream = file.getInputStream();
            ImportParams params = new ImportParams();
            params.setNeedVerfiy(true);
            params.setTitleRows(0);
            /* params.setVerifyHandler(new ExcelVerifyHandlerImpl());
            * 自定义的验证
            * */
            ExcelImportResult<ShopGoodsFoodEntity> result = ExcelImportUtil.importExcelMore(
                    inputStream,ShopGoodsFoodEntity.class, params);
            if (result.isVerfiyFail()){
                StringBuffer buffer = new StringBuffer();
                for (int i = 0; i < result.getFailList().size(); i++) {
                    buffer.append(ReflectionToStringBuilder.toString(result.getFailList().get(i)));
                }
                String fileName = "导入失败"+ DateUtil.format(new Date(),PURE_DATETIME_PATTERN);
                //保存失败文件到临时目录
                model = AttachUtils.saveTmpFile(result.getFailWorkbook(),fileName);
            } else{
                //	成功的时候
                shopGoodsFoodService.insertBatch(result.getList());
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }
        if (flag){
            return Result.ok();
        }else {
            return Result.error("导入错误").put("batch",model);
        }
    }
    /**
    * 导出Excel文件
    * @param request http请求
    * @param response http返回
    * @param entity 对象
    */
    @GetMapping(value="/export")
    public void export(HttpServletRequest request, HttpServletResponse response,ShopGoodsFoodEntity entity){

        try {
            int importNum  = shopGoodsFoodService.selectCount(entity);
            Workbook workbook = null;
            //第一个是导出的接口
            ExportParams exportParams = new ExportParams();
            if (importNum > EXPORT_MAX){
                for (int i = 0; i < importNum/EXPORT_MAX + 1; i++) {
                    Page<ShopGoodsFoodEntity> page = new Page<ShopGoodsFoodEntity>(i+1, EXPORT_MAX);
                    List<ShopGoodsFoodEntity> result = shopGoodsFoodService.selectPage(page,entity,new EntityWrapper<ShopGoodsFoodEntity>());
                    workbook = ExcelExportUtil.exportBigExcel(exportParams, ShopGoodsFoodEntity.class,result);
                    result.clear();
                }
                ExcelExportUtil.closeExportBigExcel();
            }else {
                Page<ShopGoodsFoodEntity> page = new Page<ShopGoodsFoodEntity>(1, EXPORT_MAX);
                List<ShopGoodsFoodEntity> result = shopGoodsFoodService.selectPage(page,entity,new EntityWrapper<>());
                workbook = ExcelExportUtil.exportExcel(exportParams,ShopGoodsFoodEntity.class, result);
                }
                String filename = "商品食品表("+DateUtil.today()+")";
                renderExcel(request,response,filename,workbook);
        } catch (Exception e) {
                e.printStackTrace();
                response.setContentType("text/html;charset=utf-8");
            try {
                response.getWriter().write(e.getMessage());
            } catch (Exception e2) {

            }
        }
  }
}