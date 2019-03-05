package cn.modules.sys.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.base.AbstractController;
import cn.common.exception.DefaultException;
import cn.common.factory.PageFactory;
import cn.common.utils.AttachUtils;
import cn.common.utils.DownloadUtils;
import cn.common.utils.PageUtils;
import cn.common.utils.Result;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.modules.base.annex.entity.BaseAnnexEntity;
import cn.modules.sys.entity.BatchBaseinfoAttachEntity;
import cn.modules.sys.service.BatchBaseinfoAttachService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.collect.Lists;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
* 基本附件表控制器
*
* @author zhangheng
* @date 2018-10-31 17:22:04
*/
@RestController
@RequestMapping("/batchbaseinfoattach")
public class BatchBaseinfoAttachController extends AbstractController {

    @Autowired
    private BatchBaseinfoAttachService batchBaseinfoAttachService;

    /**
    * 获取分页信息
    * @param entity 对象
    * @return Object 分页信息
    */
    @GetMapping(value = "/list")
    public Object list(BatchBaseinfoAttachEntity entity) {
        Page<BatchBaseinfoAttachEntity> page = new PageFactory<BatchBaseinfoAttachEntity>().defaultPage();
        page.setRecords(batchBaseinfoAttachService.selectPage(page,entity,new EntityWrapper<BatchBaseinfoAttachEntity>()));

        return Result.ok().put("page", new PageUtils(page));
    }

    /**
    * 新增
    * @param entity 对象
    * @return Object 执行结果
    */
    @PostMapping(value = "/add")
    @RequiresPermissions("batchbaseinfoattach:add")
    public Object add(@RequestBody BatchBaseinfoAttachEntity entity) {
        batchBaseinfoAttachService.insert(entity);
        return Result.ok();
    }

    /**
    * 删除多个
    * @param ids 主键
    * @return Object 执行结果
    */
    @PostMapping(value = "/delete")
    @RequiresPermissions("batchbaseinfoattach:delete")
    public Object delete(@RequestBody String[] ids) {
        batchBaseinfoAttachService.deleteBatchIds(Arrays.asList(ids));
        return Result.ok();
    }

    /**
    * 更新
    * @param entity 对象
    * @return
    */
    @PostMapping(value = "/update")
    public Object update(@RequestBody BatchBaseinfoAttachEntity entity) {
        batchBaseinfoAttachService.updateById(entity);
        return Result.ok();
    }



    /**
    * 详情
    * @param entity 对象
    * @return Object 详细对象
    */
    @GetMapping(value = "/info")
    public Object info(BatchBaseinfoAttachEntity entity) {
        return Result.ok().put("batchbaseinfoattach", batchBaseinfoAttachService.selectOne(entity));
    }

    /**
     * 上传文件
     * @param file  文件
     * @return 对象
     * @throws Exception
     */
    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw new DefaultException("上传文件不能为空");
        }
        BaseAnnexEntity entity = AttachUtils.saveTmpFile(file);
//        BatchBaseinfoAttachEntity entity = AttachUtils.saveTmpFile(file);
        return Result.ok().put("batch",entity);
    }

    /**
     * 上传文件
     * @param file  文件
     * @return 对象
     * @throws Exception
     */
    @PostMapping("/multiupload")
    public Result Multi(@RequestParam("file") MultipartFile[] file) throws Exception {

        List<BaseAnnexEntity> entities = Lists.newArrayList();
//        List<BatchBaseinfoAttachEntity> entities = Lists.newArrayList();
        if (file.length > 0){
            for (MultipartFile multipartFile : file) {
                BaseAnnexEntity entity = AttachUtils.saveTmpFile(multipartFile);
//                BatchBaseinfoAttachEntity entity = AttachUtils.saveTmpFile(multipartFile);
                entities.add(entity);
            }
        }
        return Result.ok().put("batch",entities);
    }

    /**
     * 通用下载文件接口
     * @param request
     * @param response
     * @param id 文件id
     */
    @GetMapping(value="/download")
    public void downloadFile(HttpServletRequest request,
                             HttpServletResponse response, @RequestParam("id")String id) {

        BatchBaseinfoAttachEntity attach = batchBaseinfoAttachService.selectById(id);

        if (!FileUtil.exist(attach.getLocalSavePath())&&!AttachUtils.getDownloadFtp(id)){

        }
        DownloadUtils.downloadFile(request,response,attach.getUploadFileName(),attach.getLocalSavePath());

    }
    /**
    * 导出Excel文件
    * @param request http请求
    * @param response http返回
    * @param entity 对象
    */
    @GetMapping(value="/export")
    public void export(HttpServletRequest request, HttpServletResponse response, BatchBaseinfoAttachEntity entity){

        try {
            int importNum  = batchBaseinfoAttachService.selectCount(entity);
            Workbook workbook = null;
            //第一个是导出的接口
            ExportParams exportParams = new ExportParams();
            if (importNum > EXPORT_MAX){
                for (int i = 0; i < importNum/EXPORT_MAX + 1; i++) {
                    Page<BatchBaseinfoAttachEntity> page = new Page<BatchBaseinfoAttachEntity>(i+1, EXPORT_MAX);
                    List<BatchBaseinfoAttachEntity> result = batchBaseinfoAttachService.selectPage(page,entity,new EntityWrapper<>());
                    workbook = ExcelExportUtil.exportBigExcel(exportParams, BatchBaseinfoAttachEntity.class,result);
                    result.clear();
                }
                ExcelExportUtil.closeExportBigExcel();
            }else {
                Page<BatchBaseinfoAttachEntity> page = new Page<BatchBaseinfoAttachEntity>(1, EXPORT_MAX);
                List<BatchBaseinfoAttachEntity> result = batchBaseinfoAttachService.selectPage(page,entity,new EntityWrapper<>());
                workbook = ExcelExportUtil.exportExcel(exportParams,BatchBaseinfoAttachEntity.class, result);
                }
                String filename = "("+ DateUtil.today()+")";
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