package cn.modules.base.annex.controller;
import cn.afterturn.easypoi.excel.ExcelExportUtil;

import static cn.base.AbstractController.EXPORT_MAX;
import static cn.hutool.core.date.DatePattern.PURE_DATETIME_PATTERN;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import cn.base.AbstractController;
import cn.common.exception.DefaultException;
import cn.common.factory.PageFactory;
import cn.common.utils.*;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.modules.sys.entity.BatchBaseinfoAttachEntity;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.*;
import cn.modules.base.annex.entity.BaseAnnexEntity;
import cn.modules.base.annex.service.BaseAnnexService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.util.List;
import java.util.Date;
import java.util.Arrays;
import java.util.UnknownFormatConversionException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;
/**
* 附件表控制器
*
* @author jianconglee
* @date 2019-03-04 12:55:36
*/
@RestController
@RequestMapping("/baseannex")
public class BaseAnnexController extends AbstractController {

    @Autowired
    private BaseAnnexService baseAnnexService;

    /**
    * 获取分页信息
    * @param entity 对象
    * @return Object 分页信息
    */
    @GetMapping(value = "/list")
    public Object list(BaseAnnexEntity entity) {
        Page<BaseAnnexEntity> page = new PageFactory<BaseAnnexEntity>().defaultPage();
        page.setRecords(baseAnnexService.selectPage(page,entity,new EntityWrapper<BaseAnnexEntity>()));

        return Result.ok().put("page", new PageUtils(page));
    }


    /**
    * 新增
    * @param entity 对象
    * @return Object 执行结果
    */
    @PostMapping(value = "/add")
    @RequiresPermissions("baseannex:add")
    public Object add(@RequestBody BaseAnnexEntity entity) {
        baseAnnexService.insert(entity);
        return Result.ok();
    }

    /**
    * 删除多个
    * @param ids 主键
    * @return Object 执行结果
    */
    @PostMapping(value = "/delete")
    @RequiresPermissions("baseannex:delete")
    public Object delete(@RequestBody String[] ids) {

//        System.out.println("hahah");
//        BaseAnnexEntity entity = baseAnnexService.selectById(id);
//        if (entity != null ) {
//            FileUtil.del(entity.getAbsolutePath());
//            baseAnnexService.deleteByModel(entity);
//        }
//        baseAnnexService.deleteById(id);


        for (String id :Arrays.asList(ids)) {
            BaseAnnexEntity entity = baseAnnexService.selectById(id);
            if (entity != null ) {
                FileUtil.del(entity.getAbsolutePath());
            }
            baseAnnexService.deleteByModel(entity);
        }
//        for(Long id :ids) {
//            BaseAnnexEntity entity = baseAnnexService.selectById(id);
//            if (entity != null ) {
//                FileUtil.del(entity.getAbsolutePath());
//            }
//        }
        return Result.ok();
    }

    /**
    * 更新
    * @param entity 对象
    * @return
    */
    @PostMapping(value = "/update")
    public Object update(@RequestBody BaseAnnexEntity entity) {
        baseAnnexService.updateById(entity);
        return Result.ok();
    }

    /**
    * 详情
    * @param entity 对象
    * @return Object 详细对象
    */
    @GetMapping(value = "/info")
    public Object info(BaseAnnexEntity entity) {
        return Result.ok().put("baseannex", baseAnnexService.selectOne(entity));
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
            ExcelImportResult<BaseAnnexEntity> result = ExcelImportUtil.importExcelMore(
                    inputStream,BaseAnnexEntity.class, params);
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
                baseAnnexService.insertBatch(result.getList());
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
    public void export(HttpServletRequest request, HttpServletResponse response,BaseAnnexEntity entity) {

        try {
            int importNum = baseAnnexService.selectCount(entity);
            Workbook workbook = null;
            //第一个是导出的接口
            ExportParams exportParams = new ExportParams();
            if (importNum > EXPORT_MAX) {
                for (int i = 0; i < importNum / EXPORT_MAX + 1; i++) {
                    Page<BaseAnnexEntity> page = new Page<BaseAnnexEntity>(i + 1, EXPORT_MAX);
                    List<BaseAnnexEntity> result = baseAnnexService.selectPage(page, entity, new EntityWrapper<BaseAnnexEntity>());
                    workbook = ExcelExportUtil.exportBigExcel(exportParams, BaseAnnexEntity.class, result);
                    result.clear();
                }
                ExcelExportUtil.closeExportBigExcel();
            } else {
                Page<BaseAnnexEntity> page = new Page<BaseAnnexEntity>(1, EXPORT_MAX);
                List<BaseAnnexEntity> result = baseAnnexService.selectPage(page, entity, new EntityWrapper<>());
                workbook = ExcelExportUtil.exportExcel(exportParams, BaseAnnexEntity.class, result);
            }
            String filename = "附件表(" + DateUtil.today() + ")";
            renderExcel(request, response, filename, workbook);
        } catch (Exception e) {
            e.printStackTrace();
            response.setContentType("text/html;charset=utf-8");
            try {
                response.getWriter().write(e.getMessage());
            } catch (Exception e2) {

            }
        }
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
        return Result.ok().put("batch",entity);
    }

    /**
     * 上传文件
     * @param file  文件
     * @return 对象
     * @throws Exception
     */
    @RequestMapping("/multiupload")
    public Result Multi(@RequestParam("file") MultipartFile[] file) throws Exception {

        System.out.println(file);
        List<BaseAnnexEntity> entities = Lists.newArrayList();
        if (file.length > 0){
            for (MultipartFile multipartFile : file) {
                BaseAnnexEntity entity = AttachUtils.saveTmpFile(multipartFile);
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

        BaseAnnexEntity attach = baseAnnexService.selectById(id);

//        if (!FileUtil.exist(attach.getLocalSavePath())&&!AttachUtils.getDownloadFtp(id)){
//
//        }
//        DownloadUtils.downloadFile(request,response,attach.getUploadFileName(),attach.getLocalSavePath());

    }

    @RequestMapping(value="/viewImage")
    public void viewImage(HttpServletRequest request,
                          HttpServletResponse response,@RequestParam("id")String id) throws IOException {
        ServletContext cntx= request.getServletContext();
        BaseAnnexEntity annex = baseAnnexService.selectById(id);
        String localFullPath = FileUtils.joinDirectory(annex.getAbsolutePath(), annex.getFileName());
        File localFile = new File(localFullPath);
        if (!localFile.exists()) {
            // 文件不不存在去FTP下载
//            File localPath = new File(annex.getAbsolutePath());
//            localPath.mkdirs();
//            FtpSynchronServer ftp = new FtpSynchronServer();
//            boolean downflag = false;
//            try {
//                downflag = ftp.download(localFullPath,
//                        annex.getFsBasePath(), annex.getFsBusiPath(),
//                        annex.getFsDatePath(), annex.getFsFileName());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            if (!downflag) {
//                System.out.println("FTP下载失败:" + annex.getId());
//                localFile = new File(localFullPath);
//                localFile.delete();
//            }
        }
        String mime = cntx.getMimeType(localFullPath);
        if (mime == null) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        response.setContentLength((int)localFile.length());
        response.setContentType(mime);
        FileInputStream in = new FileInputStream(localFile);
        OutputStream out = response.getOutputStream();

        byte[] buf = new byte[1024];
        int count = 0;
        while ((count = in.read(buf)) >= 0) {
            out.write(buf, 0, count);
        }
        out.close();
        in.close();
    }
}