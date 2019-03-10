package cn.modules.shop.brand.entity;

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
* 品牌制造商 entity 对象实体类
*
* @author jianconglee
* @Date 2019-03-06 12:41:38
*/
@TableName("shop_brand")
public class ShopBrandEntity extends AbstractModel<ShopBrandEntity> {
    private static final long serialVersionUID = 1L;
    /**
    * 主键
    */
    @Excel(name = "主键")
    @TableId(value ="id",type = IdType.ID_WORKER)
    private Long id;
    /**
    * 品牌名称
    */
    @Excel(name = "品牌名称")
    @TableField(value="name")
    private String name;
    /**
    * 描述
    */
    @Excel(name = "描述")
    @TableField(value="simple_desc")
    private String simpleDesc;
    /**
    * 图片
    */
    @Excel(name = "图片")
    @TableField(value="pic_url")
    private String picUrl;
    /**
    * 排序
    */
    @Excel(name = "排序")
    @TableField(value="sort_order")
    private Integer sortOrder;
    /**
    * 创建时间
    */
    @Excel(name = "创建时间",exportFormat = "yyyy-MM-dd HH:mm:ss")
    @TableField(value="create_time")
    private Date createTime;
    /**
    * 更新时间
    */
    @Excel(name = "更新时间",exportFormat = "yyyy-MM-dd HH:mm:ss")
    @TableField(value="update_time")
    private Date updateTime;
    /**
    * 获取: 主键
    */
    public Long getId() {
        return id;
    }
    /**
    * 设置: 主键
    * 
    */
    public void setId(Long id) {
        this.id = id;
    }
    /**
    * 获取: 品牌名称
    */
    public String getName() {
        return name;
    }
    /**
    * 设置: 品牌名称
    * 
    */
    public void setName(String name) {
        this.name = name;
    }
    /**
    * 获取: 描述
    */
    public String getSimpleDesc() {
        return simpleDesc;
    }
    /**
    * 设置: 描述
    * 
    */
    public void setSimpleDesc(String simpleDesc) {
        this.simpleDesc = simpleDesc;
    }
    /**
    * 获取: 图片
    */
    public String getPicUrl() {
        return picUrl;
    }
    /**
    * 设置: 图片
    * 
    */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
    /**
    * 获取: 排序
    */
    public Integer getSortOrder() {
        return sortOrder;
    }
    /**
    * 设置: 排序
    * 
    */
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }
    /**
    * 获取: 创建时间
    */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    public Date getCreateTime() {
        return createTime;
    }
    /**
    * 设置: 创建时间
    * 
    */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    /**
    * 获取: 更新时间
    */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    public Date getUpdateTime() {
        return updateTime;
    }
    /**
    * 设置: 更新时间
    * 
    */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public Serializable pkVal() {
        return this.id;
    }

    @Override
    public void preInsert() {
        Sequence sequence = new Sequence(0, 0);
        this.id = sequence.nextId();
        Date date = new Date();
        this.createTime = date;
    }
    @Override
    public void preUpdate() {
        Date date = new Date();
        this.updateTime = date;
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


