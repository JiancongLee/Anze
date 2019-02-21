package cn.common.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.system.OsInfo;
import cn.hutool.system.UserInfo;
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

    private static FtpProperties ftpProperties = SpringContextHolder.getBean(FtpProperties.class);

    private static MyFtpClient myFtpClient = SpringContextHolder.getBean(MyFtpClient.class);

    public static BatchBaseinfoAttachEntity saveTmpFile(Workbook workbook, String fileName){
        BatchBaseinfoAttachEntity attach = new BatchBaseinfoAttachEntity();
        String toDayStr = DateUtil.today();
        String savePath = getUploadPath()+"/"+toDayStr;

        if (workbook instanceof HSSFWorkbook) {
            fileName +=  ".xls";
            savePath += "/"+ DateUtil.format(new Date(),PURE_DATETIME_MS_PATTERN)+".xls";
        } else {
            fileName += ".xlsx";
            savePath += "/"+  DateUtil.format(new Date(),PURE_DATETIME_MS_PATTERN)+".xlsx";
        }
        attach.setUploadFileName(fileName);
        if (!FileUtil.exist(savePath)){
            FileUtil.touch(savePath);
        }
        try {
            FileOutputStream fos = new FileOutputStream(savePath);
            workbook.write(fos);
            fos.close();
            attach.setLocalSavePath(savePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        attach.setAttachType("1");
        attach.setDelFlag("0");
        batchBaseinfoAttachService.insert(attach);
        return attach;
    }

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

    public static BatchBaseinfoAttachEntity saveTmpFile(MultipartFile file){

        if (!file.isEmpty()){
            BatchBaseinfoAttachEntity attach = new BatchBaseinfoAttachEntity();
            String toDayStr = DateUtil.today();
            String savePath = getUploadPath()+"/"+toDayStr;
            attach.setUploadFileName(file.getOriginalFilename());

            if (!FileUtil.exist(savePath)){
                FileUtil.mkdir(savePath);
            }

            String saveName = savePath + "/"+ DateUtil.format(new Date(),PURE_DATETIME_MS_PATTERN)+"."+ FileUtil.extName(file.getOriginalFilename());
            File savefile = new File(saveName);
            try {
                file.transferTo(savefile);
                attach.setLocalSavePath(saveName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            attach.setDelFlag("0");
            batchBaseinfoAttachService.insert(attach);
            return attach;
        }else {
            return null;
        }

    }

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
