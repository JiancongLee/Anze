package cn.modules.base.annex.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.base.AbstractModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.toolkit.Sequence;
import java.io.Serializable;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
/**
* 附件表 entity 对象实体类
*
* @author jianconglee
* @Date 2019-03-04 12:55:36
*/
@TableName("base_annex")
public class BaseAnnexEntity extends AbstractModel<BaseAnnexEntity> {
    private static final long serialVersionUID = 1L;
    /**
    * 主键表
    */
    @Excel(name = "主键表")
    @TableId(value ="id",type = IdType.ID_WORKER)
    private Long id;
    /**
    * 附件类型：0图片 1文件
    */
    @Excel(name = "附件类型：0图片 1文件")
    @TableField(value="annex_type")
    private Integer annexType;
    /**
    * 文件类型
    */
    @Excel(name = "文件类型")
    @TableField(value="file_type")
    private String fileType;
    /**
    * 附件名称
    */
    @Excel(name = "附件名称")
    @TableField(value="annex_name")
    private String annexName;
    /**
    * 基础路径
    */
    @Excel(name = "基础路径")
    @TableField(value="base_path")
    private String basePath;
    /**
    * 日期分类路径
    */
    @Excel(name = "日期分类路径")
    @TableField(value="date_path")
    private String datePath;
    /**
    * 文件名称
    */
    @Excel(name = "文件名称")
    @TableField(value="file_name")
    private String fileName;
    /**
    * 上传时间
    */
    @Excel(name = "上传时间",exportFormat = "yyyy-MM-dd HH:mm:ss")
    @TableField(value="upload_date")
    private Date uploadDate;
    /**
    * 附件绝对路径
    */
    @Excel(name = "附件绝对路径")
    @TableField(value="absolute_path")
    private String absolutePath;
    /**
    * 上传人id
    */
    @Excel(name = "上传人id")
    @TableField(value="upload_user_id")
    private Integer uploadUserId;
    /**
    * 上传人姓名
    */
    @Excel(name = "上传人姓名")
    @TableField(value="upload_user_name")
    private String uploadUserName;
    /**
    * 更新时间
    */
    @Excel(name = "更新时间",exportFormat = "yyyy-MM-dd HH:mm:ss")
    @TableField(value="update_date")
    private Date updateDate;
    /**
    * 更新人id
    */
    @Excel(name = "更新人id")
    @TableField(value="update_user_id")
    private Integer updateUserId;
    /**
    * 更新人姓名
    */
    @Excel(name = "更新人姓名")
    @TableField(value="update_user_name")
    private String updateUserName;
    /**
    * 获取: 主键表
    */
    public Long getId() {
        return id;
    }
    /**
    * 设置: 主键表
    * 
    */
    public void setId(Long id) {
        this.id = id;
    }
    /**
    * 获取: 附件类型：0图片 1文件
    */
    public Integer getAnnexType() {
        return annexType;
    }
    /**
    * 设置: 附件类型：0图片 1文件
    * 
    */
    public void setAnnexType(Integer annexType) {
        this.annexType = annexType;
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
    * 获取: 附件名称
    */
    public String getAnnexName() {
        return annexName;
    }
    /**
    * 设置: 附件名称
    * 
    */
    public void setAnnexName(String annexName) {
        this.annexName = annexName;
    }
    /**
    * 获取: 基础路径
    */
    public String getBasePath() {
        return basePath;
    }
    /**
    * 设置: 基础路径
    * 
    */
    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }
    /**
    * 获取: 日期分类路径
    */
    public String getDatePath() {
        return datePath;
    }
    /**
    * 设置: 日期分类路径
    * 
    */
    public void setDatePath(String datePath) {
        this.datePath = datePath;
    }
    /**
    * 获取: 文件名称
    */
    public String getFileName() {
        return fileName;
    }
    /**
    * 设置: 文件名称
    * 
    */
    public void setFileName(String fileName) {
        this.fileName = fileName;
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
    * 获取: 附件绝对路径
    */
    public String getAbsolutePath() {
        return absolutePath;
    }
    /**
    * 设置: 附件绝对路径
    * 
    */
    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }
    /**
    * 获取: 上传人id
    */
    public Integer getUploadUserId() {
        return uploadUserId;
    }
    /**
    * 设置: 上传人id
    * 
    */
    public void setUploadUserId(Integer uploadUserId) {
        this.uploadUserId = uploadUserId;
    }
    /**
    * 获取: 上传人姓名
    */
    public String getUploadUserName() {
        return uploadUserName;
    }
    /**
    * 设置: 上传人姓名
    * 
    */
    public void setUploadUserName(String uploadUserName) {
        this.uploadUserName = uploadUserName;
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
    * 获取: 更新人id
    */
    public Integer getUpdateUserId() {
        return updateUserId;
    }
    /**
    * 设置: 更新人id
    * 
    */
    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }
    /**
    * 获取: 更新人姓名
    */
    public String getUpdateUserName() {
        return updateUserName;
    }
    /**
    * 设置: 更新人姓名
    * 
    */
    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    @Override
    public Serializable pkVal() {
        return this.id;
    }

    @Override
    public void preInsert() {
        Sequence sequence = new Sequence(0, 0);
        this.id = sequence.nextId();
//        Date date = new Date();
//        this.uploadDate = date;
    }
    @Override
    public void preUpdate() {

    }
    @JSONField(serialize = false)
    @Override
    public boolean getIsNewRecord() {
        return isNewRecord || getId() == null;

    }


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}


