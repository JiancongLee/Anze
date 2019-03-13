package cn.modules.shop.category.controller;
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
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;
import cn.modules.shop.category.entity.ShopCategoryEntity;
import cn.modules.shop.category.service.ShopCategoryService;
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
* 商品类型表控制器
*
* @author jianconglee
* @date 2019-03-12 17:15:31
*/
@RestController
@RequestMapping("/shopcategory")
public class ShopCategoryController extends AbstractController {

    @Autowired
    private ShopCategoryService shopCategoryService;

    /**
    * 获取分页信息
    * @param entity 对象
    * @return Object 分页信息
    */
    @GetMapping(value = "/page")
    public Object page(ShopCategoryEntity entity) {
        Page<ShopCategoryEntity> page = new PageFactory<ShopCategoryEntity>().defaultPage();
        page.setRecords(shopCategoryService.selectPage(page,entity,new EntityWrapper<ShopCategoryEntity>()));

        return Result.ok().put("page", new PageUtils(page));
    }

    /**
     * 获取分页信息
     * @param entity 对象
     * @return Object 分页信息
     */
    @GetMapping(value = "/list")
    public Object list(ShopCategoryEntity entity) {
//        Page<ShopCategoryEntity> page = new PageFactory<ShopCategoryEntity>().defaultPage();
//        page.setRecords(shopCategoryService.selectPage(page,entity,new EntityWrapper<ShopCategoryEntity>()));

        EntityWrapper<ShopCategoryEntity> wrapper = new EntityWrapper<>();
        if (entity != null && entity.getLevel()!= null){
            wrapper.eq("level",entity.getLevel());
        }
        List<ShopCategoryEntity> list = shopCategoryService.selectList(wrapper);
        return Result.ok().put("list", list);
    }


    /**
    * 新增
    * @param entity 对象
    * @return Object 执行结果
    */
    @PostMapping(value = "/add")
    @RequiresPermissions("shopcategory:add")
    public Object add(@RequestBody ShopCategoryEntity entity) {
        shopCategoryService.insert(entity);
        return Result.ok();
    }

    /**
    * 删除多个
    * @param ids 主键
    * @return Object 执行结果
    */
    @PostMapping(value = "/delete")
    @RequiresPermissions("shopcategory:delete")
    public Object delete(@RequestBody Integer[] ids) {
        shopCategoryService.deleteBatchIds(Arrays.asList(ids));
        shopCategoryService.deleteBatchIds(Arrays.asList(ids));
        return Result.ok();
    }

    /**
    * 更新
    * @param entity 对象
    * @return
    */
    @PostMapping(value = "/update")
    public Object update(@RequestBody ShopCategoryEntity entity) {
        shopCategoryService.updateById(entity);
        return Result.ok();
    }

    /**
    * 详情
    * @param entity 对象
    * @return Object 详细对象
    */
    @GetMapping(value = "/info")
    public Object info(ShopCategoryEntity entity) {
        return Result.ok().put("shopcategory", shopCategoryService.selectOne(entity));
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
            ExcelImportResult<ShopCategoryEntity> result = ExcelImportUtil.importExcelMore(
                    inputStream,ShopCategoryEntity.class, params);
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
                shopCategoryService.insertBatch(result.getList());
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
    public void export(HttpServletRequest request, HttpServletResponse response,ShopCategoryEntity entity){

        try {
            int importNum  = shopCategoryService.selectCount(entity);
            Workbook workbook = null;
            //第一个是导出的接口
            ExportParams exportParams = new ExportParams();
            if (importNum > EXPORT_MAX){
                for (int i = 0; i < importNum/EXPORT_MAX + 1; i++) {
                    Page<ShopCategoryEntity> page = new Page<ShopCategoryEntity>(i+1, EXPORT_MAX);
                    List<ShopCategoryEntity> result = shopCategoryService.selectPage(page,entity,new EntityWrapper<ShopCategoryEntity>());
                    workbook = ExcelExportUtil.exportBigExcel(exportParams, ShopCategoryEntity.class,result);
                    result.clear();
                }
                ExcelExportUtil.closeExportBigExcel();
            }else {
                Page<ShopCategoryEntity> page = new Page<ShopCategoryEntity>(1, EXPORT_MAX);
                List<ShopCategoryEntity> result = shopCategoryService.selectPage(page,entity,new EntityWrapper<>());
                workbook = ExcelExportUtil.exportExcel(exportParams,ShopCategoryEntity.class, result);
                }
                String filename = "商品类型表("+DateUtil.today()+")";
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