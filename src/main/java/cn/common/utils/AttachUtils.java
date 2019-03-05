package cn.common.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.system.OsInfo;
import cn.hutool.system.UserInfo;
import cn.modules.base.annex.entity.BaseAnnexEntity;
import cn.modules.base.annex.service.BaseAnnexService;
import cn.modules.sys.entity.BatchBaseinfoAttachEntity;
import cn.modules.sys.service.BatchBaseinfoAttachService;
import cn.properties.FtpProperties;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static cn.hutool.core.date.DatePattern.PURE_DATETIME_MS_PATTERN;

/**
 * @author zhangheng
 * @date 2018-07-30  14:23:00
 */
public class AttachUtils {

    private static BatchBaseinfoAttachService batchBaseinfoAttachService = SpringContextHolder.getBean(BatchBaseinfoAttachService.class);
    private static BaseAnnexService baseAnnexService = SpringContextHolder.getBean(BaseAnnexService.class);

    private static FtpProperties ftpProperties = SpringContextHolder.getBean(FtpProperties.class);

    private static MyFtpClient myFtpClient = SpringContextHolder.getBean(MyFtpClient.class);

    /**
     * 获取根路径
     * @return
     */
    public static String getUploadPath(){
        String rootLocation = "";
        OsInfo info = new OsInfo();
        UserInfo userInfo = new UserInfo();

        if (info.isLinux()|| info.isMac()){
            rootLocation = StringUtils.isNotBlank(ftpProperties.getLinuxTmp()) ? ftpProperties.getLinuxTmp(): userInfo.getTempDir();
        }else {
            rootLocation = StringUtils.isNotBlank(ftpProperties.getWindowTmp())?ftpProperties.getWindowTmp():userInfo.getTempDir();
        }

        if (!FileUtil.exist(rootLocation)){
            rootLocation = userInfo.getTempDir();
        }
        return rootLocation;
    }

    /**
     * 更新状态
     * @param string
     * @return
     */
    public static boolean updateStatus(String string){

        List<BatchBaseinfoAttachEntity> models = Lists.newArrayList();
        if (StringUtils.isNotBlank(string)){
            Arrays.asList(string.split("\\s*,\\s*")).forEach(s -> {

                if (StringUtils.isNotBlank(s)){
                    BatchBaseinfoAttachEntity model = batchBaseinfoAttachService.selectById(s);
                    if (model != null){
                        model.setDelFlag("1");
                        models.add(model);
                    }
                }
            });
        }

        if (!models.isEmpty()){
            return   batchBaseinfoAttachService.updateBatchById(models);
        } else {
            return false;
        }

    }

    /**
     * 根据状态而删除
     * @return
     */
    public static boolean deleteByStatus(){
        EntityWrapper wrapper =  new EntityWrapper<BatchBaseinfoAttachEntity>();

        wrapper.eq("DEL_FLAG","0").or("DEL_FLAG is null");
        List<BatchBaseinfoAttachEntity> attachModels = batchBaseinfoAttachService.selectList(wrapper);

        attachModels.forEach(batchBaseinfoAttachModel -> {
            FileUtil.del(batchBaseinfoAttachModel.getLocalSavePath());
            if (StringUtils.isNotBlank(batchBaseinfoAttachModel.getBattchId())){
                batchBaseinfoAttachService.deleteById(batchBaseinfoAttachModel.getBattchId());
            }
        });
        return true;


    }

    /**
     * 保存文件
     * @param file
     * @return
     */
    public static BaseAnnexEntity saveTmpFile(MultipartFile file){

        if (!file.isEmpty()){
            BaseAnnexEntity annex = new BaseAnnexEntity();
            String toDayStr = DateUtil.today();
            String savePath = getUploadPath()+"/"+toDayStr.replaceAll("-","/");
            annex.setAnnexName(file.getOriginalFilename());
            if (!FileUtil.exist(savePath)){
                FileUtil.mkdir(savePath);
            }
            String saveName = savePath + "/"+ DateUtil.format(new Date(),PURE_DATETIME_MS_PATTERN)+"."+ FileUtil.extName(file.getOriginalFilename());
            File savefile = new File(saveName);
            try {
                file.transferTo(savefile);
                annex.setAbsolutePath(saveName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            baseAnnexService.insert(annex);
            return annex;
        }else {
            return null;
        }
    }
    /**
     * 保存文件(excel)
     * @param workbook
     * @param fileName
     * @return
     */
    public static BaseAnnexEntity saveTmpFile(Workbook workbook, String fileName){
        BaseAnnexEntity annex = new BaseAnnexEntity();
        String toDayStr = DateUtil.today();
        String savePath = getUploadPath()+"/"+toDayStr.replaceAll("-","/");

        if (workbook instanceof HSSFWorkbook) {
            fileName +=  ".xls";
            savePath += "/"+ DateUtil.format(new Date(),PURE_DATETIME_MS_PATTERN)+".xls";
        } else {
            fileName += ".xlsx";
            savePath += "/"+  DateUtil.format(new Date(),PURE_DATETIME_MS_PATTERN)+".xlsx";
        }
        annex.setAnnexName(fileName);
        if (!FileUtil.exist(savePath)){
            FileUtil.touch(savePath);
        }
        try {
            FileOutputStream fos = new FileOutputStream(savePath);
            workbook.write(fos);
            fos.close();
            annex.setAbsolutePath(savePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        baseAnnexService.insert(annex);
        return annex;
    }

    /**
     * 根据附件id下载文件
     * @param id
     * @return
     */
    public static boolean getDownloadFtp(String id){

        boolean flag = false;
        BatchBaseinfoAttachEntity attach = batchBaseinfoAttachService.selectById(id);
        if (attach != null && StringUtils.isNotBlank(attach.getFsFileName())){
            String fullPath = FileUtils.joinDirectory(attach.getFsBusiPath(),attach.getFsDatePath());
            String localPath = attach.getLocalSavePath();
            if (!FileUtil.exist(localPath)){
                FileUtil.mkdir(localPath);
            }
            if (myFtpClient.download(fullPath,attach.getFsFileName(),attach.getLocalSavePath())){
                flag = true;
            }
        }
        return flag;
    }


}
