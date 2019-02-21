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
* @Date 2019-02-21 22:20:34
*/
@TableName("shop_brand")
public class ShopBrandEntity extends AbstractModel<ShopBrandEntity> {
    private static final long serialVersionUID = 1L;
    /**
    * 主键
    */
    @Excel(name = "主键")
    @TableId(value="id")
    private Long id;
    /**
    * 品牌名称
    */
    @Excel(name = "品牌名称")
    @TableField(value="name")
    private String name;
    /**
    * 图片
    */
    @Excel(name = "图片")
    @TableField(value="list_pic_url")
    private String listPicUrl;
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
    * 显示
    */
    @Excel(name = "显示")
    @TableField(value="is_show")
    private Integer isShow;
    /**
    * FloorPrice
    */
    @Excel(name = "FloorPrice")
    @TableField(value="floor_price")
    private BigDecimal floorPrice;
    /**
    * app显示图片
    */
    @Excel(name = "app显示图片")
    @TableField(value="app_list_pic_url")
    private String appListPicUrl;
    /**
    * 新品牌
    */
    @Excel(name = "新品牌")
    @TableField(value="is_new")
    private Integer isNew;
    /**
    * 图片
    */
    @Excel(name = "图片")
    @TableField(value="new_pic_url")
    private String newPicUrl;
    /**
    * 排序
    */
    @Excel(name = "排序")
    @TableField(value="new_sort_order")
    private Integer newSortOrder;
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
    * 获取: 图片
    */
    public String getListPicUrl() {
        return listPicUrl;
    }
    /**
    * 设置: 图片
    * 
    */
    public void setListPicUrl(String listPicUrl) {
        this.listPicUrl = listPicUrl;
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
    * 获取: 显示
    */
    public Integer getIsShow() {
        return isShow;
    }
    /**
    * 设置: 显示
    * 
    */
    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }
    /**
    * 获取: FloorPrice
    */
    public BigDecimal getFloorPrice() {
        return floorPrice;
    }
    /**
    * 设置: FloorPrice
    * 
    */
    public void setFloorPrice(BigDecimal floorPrice) {
        this.floorPrice = floorPrice;
    }
    /**
    * 获取: app显示图片
    */
    public String getAppListPicUrl() {
        return appListPicUrl;
    }
    /**
    * 设置: app显示图片
    * 
    */
    public void setAppListPicUrl(String appListPicUrl) {
        this.appListPicUrl = appListPicUrl;
    }
    /**
    * 获取: 新品牌
    */
    public Integer getIsNew() {
        return isNew;
    }
    /**
    * 设置: 新品牌
    * 
    */
    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }
    /**
    * 获取: 图片
    */
    public String getNewPicUrl() {
        return newPicUrl;
    }
    /**
    * 设置: 图片
    * 
    */
    public void setNewPicUrl(String newPicUrl) {
        this.newPicUrl = newPicUrl;
    }
    /**
    * 获取: 排序
    */
    public Integer getNewSortOrder() {
        return newSortOrder;
    }
    /**
    * 设置: 排序
    * 
    */
    public void setNewSortOrder(Integer newSortOrder) {
        this.newSortOrder = newSortOrder;
    }

    @Override
    public Serializable pkVal() {
        return this.id;
    }

    @Override
    public void preInsert() {
        Sequence sequence = new Sequence(0, 0);
        this.id = sequence.nextId();
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


