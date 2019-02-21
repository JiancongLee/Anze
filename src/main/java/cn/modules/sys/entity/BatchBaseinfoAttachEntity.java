package cn.modules.sys.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.base.AbstractModel;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.toolkit.Sequence;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
* 基本附件表 entity 对象实体类
*
* @author zhangheng
* @Date 2018-10-31 17:22:02
*/
@TableName("BATCH_BASEINFO_ATTACH")
public class BatchBaseinfoAttachEntity extends AbstractModel<BatchBaseinfoAttachEntity> {
    private static final long serialVersionUID = 1L;
    /**
    * 关联的模块记录ID
    */
    @Excel(name = "关联的模块记录ID")
    @TableField(value="MODULE_RECORD_ID")
    private String moduleRecordId;
    /**
    * 模块类型
    */
    @Excel(name = "模块类型")
    @TableField(value="MODULE_TYPE")
    private String moduleType;
    /**
    * 业务类型
    */
    @Excel(name = "业务类型")
    @TableField(value="BUSINESS_TYPE")
    private String businessType;
    /**
    * 附件类型
    */
    @Excel(name = "附件类型")
    @TableField(value="ATTACH_TYPE")
    private String attachType;
    /**
    * 文件类型
    */
    @Excel(name = "文件类型")
    @TableField(value="FILE_TYPE")
    private String fileType;
    /**
    * 附件描述
    */
    @Excel(name = "附件描述")
    @TableField(value="ATTACH_DESC")
    private String attachDesc;
    /**
    * 上传文件名称
    */
    @Excel(name = "上传文件名称")
    @TableField(value="UPLOAD_FILE_NAME")
    private String uploadFileName;
    /**
    * 本地存放路径
    */
    @Excel(name = "本地存放路径")
    @TableField(value="LOCAL_SAVE_PATH")
    private String localSavePath;
    /**
    * 远程基础路径
    */
    @Excel(name = "远程基础路径")
    @TableField(value="FS_BASE_PATH")
    private String fsBasePath;
    /**
    * 远程业务路径
    */
    @Excel(name = "远程业务路径")
    @TableField(value="FS_BUSI_PATH")
    private String fsBusiPath;
    /**
    * 远程日期分类路径
    */
    @Excel(name = "远程日期分类路径")
    @TableField(value="FS_DATE_PATH")
    private String fsDatePath;
    /**
    * 远程文件名称
    */
    @Excel(name = "远程文件名称")
    @TableField(value="FS_FILE_NAME")
    private String fsFileName;
    /**
    * 上传人员
    */
    @Excel(name = "上传人员")
    @TableField(value="UPLOAD_USER_ACCOUNT")
    private String uploadUserAccount;
    /**
    * 上传时间
    */
    @Excel(name = "上传时间",exportFormat = "yyyy-MM-dd HH:mm:ss")
    @TableField(value="UPLOAD_DATE")
    private Date uploadDate;
    /**
    * 创建时间
    */
    @Excel(name = "创建时间",exportFormat = "yyyy-MM-dd HH:mm:ss")
    @TableField(value="CREATE_DATE")
    private Date createDate;
    /**
    * 更新时间
    */
    @Excel(name = "更新时间",exportFormat = "yyyy-MM-dd HH:mm:ss")
    @TableField(value="UPDATE_DATE")
    private Date updateDate;
    /**
    * 更新人
    */
    @Excel(name = "更新人")
    @TableField(value="UPDATE_BY")
    private String updateBy;
    /**
    * 创建人
    */
    @Excel(name = "创建人")
    @TableField(value="CREATE_BY")
    private String createBy;
    /**
    * 删除标志
    */
    @Excel(name = "删除标志")
    @TableField(value="DEL_FLAG")
    private String delFlag;
    /**
    * 评论
    */
    @Excel(name = "评论")
    @TableField(value="REMARKS")
    private String remarks;
    /**
    * 主键ID
    */
    @Excel(name = "主键ID")
    @TableId(value ="BATTCH_ID",type = IdType.INPUT)
    private String battchId;
    /**
    * 获取: 关联的模块记录ID
    */
    public String getModuleRecordId() {
        return moduleRecordId;
    }
    /**
    * 设置: 关联的模块记录ID
    * 
    */
    public void setModuleRecordId(String moduleRecordId) {
        this.moduleRecordId = moduleRecordId;
    }
    /**
    * 获取: 模块类型
    */
    public String getModuleType() {
        return moduleType;
    }
    /**
    * 设置: 模块类型
    * 
    */
    public void setModuleType(String moduleType) {
        this.moduleType = moduleType;
    }
    /**
    * 获取: 业务类型
    */
    public String getBusinessType() {
        return businessType;
    }
    /**
    * 设置: 业务类型
    * 
    */
    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }
    /**
    * 获取: 附件类型
    */
    public String getAttachType() {
        return attachType;
    }
    /**
    * 设置: 附件类型
    * 
    */
    public void setAttachType(String attachType) {
        this.attachType = attachType;
    }
    /**
    * 获取: 文件类型
    */
    public String getFileType() {
        return fileType;
    }
    /**
    * 设置: 文件类型
    * 
    */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    /**
    * 获取: 附件描述
    */
    public String getAttachDesc() {
        return attachDesc;
    }
    /**
    * 设置: 附件描述
    * 
    */
    public void setAttachDesc(String attachDesc) {
        this.attachDesc = attachDesc;
    }
    /**
    * 获取: 上传文件名称
    */
    public String getUploadFileName() {
        return uploadFileName;
    }
    /**
    * 设置: 上传文件名称
    * 
    */
    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }
    /**
    * 获取: 本地存放路径
    */
    public String getLocalSavePath() {
        return localSavePath;
    }
    /**
    * 设置: 本地存放路径
    * 
    */
    public void setLocalSavePath(String localSavePath) {
        this.localSavePath = localSavePath;
    }
    /**
    * 获取: 远程基础路径
    */
    public String getFsBasePath() {
        return fsBasePath;
    }
    /**
    * 设置: 远程基础路径
    * 
    */
    public void setFsBasePath(String fsBasePath) {
        this.fsBasePath = fsBasePath;
    }
    /**
    * 获取: 远程业务路径
    */
    public String getFsBusiPath() {
        return fsBusiPath;
    }
    /**
    * 设置: 远程业务路径
    * 
    */
    public void setFsBusiPath(String fsBusiPath) {
        this.fsBusiPath = fsBusiPath;
    }
    /**
    * 获取: 远程日期分类路径
    */
    public String getFsDatePath() {
        return fsDatePath;
    }
    /**
    * 设置: 远程日期分类路径
    * 
    */
    public void setFsDatePath(String fsDatePath) {
        this.fsDatePath = fsDatePath;
    }
    /**
    * 获取: 远程文件名称
    */
    public String getFsFileName() {
        return fsFileName;
    }
    /**
    * 设置: 远程文件名称
    * 
    */
    public void setFsFileName(String fsFileName) {
        this.fsFileName = fsFileName;
    }
    /**
    * 获取: 上传人员
    */
    public String getUploadUserAccount() {
        return uploadUserAccount;
    }
    /**
    * 设置: 上传人员
    * 
    */
    public void setUploadUserAccount(String uploadUserAccount) {
        this.uploadUserAccount = uploadUserAccount;
    }
    /**
    * 获取: 上传时间
    */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    public Date getUploadDate() {
        return uploadDate;
    }
    /**
    * 设置: 上传时间
    * 
    */
    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }
    /**
    * 获取: 创建时间
    */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    public Date getCreateDate() {
        return createDate;
    }
    /**
    * 设置: 创建时间
    * 
    */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    /**
    * 获取: 更新时间
    */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    public Date getUpdateDate() {
        return updateDate;
    }
    /**
    * 设置: 更新时间
    * 
    */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    /**
    * 获取: 更新人
    */
    public String getUpdateBy() {
        return updateBy;
    }
    /**
    * 设置: 更新人
    * 
    */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
    /**
    * 获取: 创建人
    */
    public String getCreateBy() {
        return createBy;
    }
    /**
    * 设置: 创建人
    * 
    */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    /**
    * 获取: 删除标志
    */
    public String getDelFlag() {
        return delFlag;
    }
    /**
    * 设置: 删除标志
    * 
    */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
    /**
    * 获取: 评论
    */
    public String getRemarks() {
        return remarks;
    }
    /**
    * 设置: 评论
    * 
    */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    /**
    * 获取: 主键ID
    */
    public String getBattchId() {
        return battchId;
    }
    /**
    * 设置: 主键ID
    * 
    */
    public void setBattchId(String battchId) {
        this.battchId = battchId;
    }

    @Override
    public Serializable pkVal() {
        return this.battchId;
    }

    @Override
    public void preInsert() {
        Sequence sequence = new Sequence(0, 0);
        this.battchId = String.valueOf(sequence.nextId());
    }
    @Override
    public void preUpdate() {

    }
    @JSONField(serialize = false)
    @Override
    public boolean getIsNewRecord() {
        return isNewRecord || StringUtils.isBlank(getBattchId());

    }


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}


