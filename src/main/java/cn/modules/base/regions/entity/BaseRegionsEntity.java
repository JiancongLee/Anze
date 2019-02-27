package cn.modules.base.regions.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.base.AbstractModel;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
/**
* 地区基础信息表 entity 对象实体类
*
* @author jianconglee
* @Date 2019-02-26 21:19:23
*/
@TableName("base_regions")
public class BaseRegionsEntity extends AbstractModel<BaseRegionsEntity> {
    private static final long serialVersionUID = 1L;
    /**
    * 主键
    */
    @Excel(name = "主键")
    @TableId(value ="id",type = IdType.ID_WORKER)
    private Integer id;
    /**
    * 名称
    */
    @Excel(name = "名称")
    @TableField(value="name")
    private String name;
    /**
    * 父ID
    */
    @Excel(name = "父ID")
    @TableField(value="parent_id")
    private Integer parentId;
    /**
    * 简称
    */
    @Excel(name = "简称")
    @TableField(value="short_name")
    private String shortName;
    /**
    * 级别
    */
    @Excel(name = "级别")
    @TableField(value="level_type")
    private Integer levelType;
    /**
    * 城市代码
    */
    @Excel(name = "城市代码")
    @TableField(value="city_code")
    private String cityCode;
    /**
    * 邮编
    */
    @Excel(name = "邮编")
    @TableField(value="zip_code")
    private String zipCode;
    /**
    * 复合名称
    */
    @Excel(name = "复合名称")
    @TableField(value="merger_name")
    private String mergerName;
    /**
    * 纬度
    */
    @Excel(name = "纬度")
    @TableField(value="lng")
    private Float lng;
    /**
    * 经度
    */
    @Excel(name = "经度")
    @TableField(value="lat")
    private Float lat;
    /**
    * 拼音缩写
    */
    @Excel(name = "拼音缩写")
    @TableField(value="pinyin")
    private String pinyin;
    /**
    * 获取: 主键
    */
    public Integer getId() {
        return id;
    }
    /**
    * 设置: 主键
    * 
    */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
    * 获取: 名称
    */
    public String getName() {
        return name;
    }
    /**
    * 设置: 名称
    * 
    */
    public void setName(String name) {
        this.name = name;
    }
    /**
    * 获取: 父ID
    */
    public Integer getParentId() {
        return parentId;
    }
    /**
    * 设置: 父ID
    * 
    */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    /**
    * 获取: 简称
    */
    public String getShortName() {
        return shortName;
    }
    /**
    * 设置: 简称
    * 
    */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
    /**
    * 获取: 级别
    */
    public Integer getLevelType() {
        return levelType;
    }
    /**
    * 设置: 级别
    * 
    */
    public void setLevelType(Integer levelType) {
        this.levelType = levelType;
    }
    /**
    * 获取: 城市代码
    */
    public String getCityCode() {
        return cityCode;
    }
    /**
    * 设置: 城市代码
    * 
    */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
    /**
    * 获取: 邮编
    */
    public String getZipCode() {
        return zipCode;
    }
    /**
    * 设置: 邮编
    * 
    */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    /**
    * 获取: 复合名称
    */
    public String getMergerName() {
        return mergerName;
    }
    /**
    * 设置: 复合名称
    * 
    */
    public void setMergerName(String mergerName) {
        this.mergerName = mergerName;
    }
    /**
    * 获取: 纬度
    */
    public Float getLng() {
        return lng;
    }
    /**
    * 设置: 纬度
    * 
    */
    public void setLng(Float lng) {
        this.lng = lng;
    }
    /**
    * 获取: 经度
    */
    public Float getLat() {
        return lat;
    }
    /**
    * 设置: 经度
    * 
    */
    public void setLat(Float lat) {
        this.lat = lat;
    }
    /**
    * 获取: 拼音缩写
    */
    public String getPinyin() {
        return pinyin;
    }
    /**
    * 设置: 拼音缩写
    * 
    */
    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    @Override
    public Serializable pkVal() {
        return this.id;
    }

    @Override
    public void preInsert() {

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


