package cn.modules.shop.category.entity;

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

import javax.persistence.Table;

/**
* 商品类型表 entity 对象实体类
*
* @author jianconglee
* @Date 2019-02-21 21:13:26
*/
@TableName("shop_category")
public class ShopCategoryEntity extends AbstractModel<ShopCategoryEntity> {
    private static final long serialVersionUID = 1L;
    /**
    * Id
    */
    @Excel(name = "Id")
    @TableId(value="id")
    private Long id;
    /**
    * 名称
    */
    @Excel(name = "名称")
    @TableField(value="name")
    private String name;
    /**
    * Keywords
    */
    @Excel(name = "Keywords")
    @TableField(value="keywords")
    private String keywords;
    /**
    * FrontDesc
    */
    @Excel(name = "FrontDesc")
    @TableField(value="front_desc")
    private String frontDesc;
    /**
    * ParentId
    */
    @Excel(name = "ParentId")
    @TableField(value="parent_id")
    private Integer parentId;
    /**
    * SortOrder
    */
    @Excel(name = "SortOrder")
    @TableField(value="sort_order")
    private Integer sortOrder;
    /**
    * ShowIndex
    */
    @Excel(name = "ShowIndex")
    @TableField(value="show_index")
    private Integer showIndex;
    /**
    * IsShow
    */
    @Excel(name = "IsShow")
    @TableField(value="is_show")
    private Integer isShow;
    /**
    * BannerUrl
    */
    @Excel(name = "BannerUrl")
    @TableField(value="banner_url")
    private String bannerUrl;
    /**
    * IconUrl
    */
    @Excel(name = "IconUrl")
    @TableField(value="icon_url")
    private String iconUrl;
    /**
    * ImgUrl
    */
    @Excel(name = "ImgUrl")
    @TableField(value="img_url")
    private String imgUrl;
    /**
    * WapBannerUrl
    */
    @Excel(name = "WapBannerUrl")
    @TableField(value="wap_banner_url")
    private String wapBannerUrl;
    /**
    * Level
    */
    @Excel(name = "Level")
    @TableField(value="level")
    private String level;
    /**
    * Type
    */
    @Excel(name = "Type")
    @TableField(value="type")
    private Integer type;
    /**
    * FrontName
    */
    @Excel(name = "FrontName")
    @TableField(value="front_name")
    private String frontName;
    /**
    * 获取: Id
    */
    public Long getId() {
        return id;
    }
    /**
    * 设置: Id
    * 
    */
    public void setId(Long id) {
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
    * 获取: Keywords
    */
    public String getKeywords() {
        return keywords;
    }
    /**
    * 设置: Keywords
    * 
    */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
    /**
    * 获取: FrontDesc
    */
    public String getFrontDesc() {
        return frontDesc;
    }
    /**
    * 设置: FrontDesc
    * 
    */
    public void setFrontDesc(String frontDesc) {
        this.frontDesc = frontDesc;
    }
    /**
    * 获取: ParentId
    */
    public Integer getParentId() {
        return parentId;
    }
    /**
    * 设置: ParentId
    * 
    */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
    /**
    * 获取: SortOrder
    */
    public Integer getSortOrder() {
        return sortOrder;
    }
    /**
    * 设置: SortOrder
    * 
    */
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }
    /**
    * 获取: ShowIndex
    */
    public Integer getShowIndex() {
        return showIndex;
    }
    /**
    * 设置: ShowIndex
    * 
    */
    public void setShowIndex(Integer showIndex) {
        this.showIndex = showIndex;
    }
    /**
    * 获取: IsShow
    */
    public Integer getIsShow() {
        return isShow;
    }
    /**
    * 设置: IsShow
    * 
    */
    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }
    /**
    * 获取: BannerUrl
    */
    public String getBannerUrl() {
        return bannerUrl;
    }
    /**
    * 设置: BannerUrl
    * 
    */
    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }
    /**
    * 获取: IconUrl
    */
    public String getIconUrl() {
        return iconUrl;
    }
    /**
    * 设置: IconUrl
    * 
    */
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
    /**
    * 获取: ImgUrl
    */
    public String getImgUrl() {
        return imgUrl;
    }
    /**
    * 设置: ImgUrl
    * 
    */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    /**
    * 获取: WapBannerUrl
    */
    public String getWapBannerUrl() {
        return wapBannerUrl;
    }
    /**
    * 设置: WapBannerUrl
    * 
    */
    public void setWapBannerUrl(String wapBannerUrl) {
        this.wapBannerUrl = wapBannerUrl;
    }
    /**
    * 获取: Level
    */
    public String getLevel() {
        return level;
    }
    /**
    * 设置: Level
    * 
    */
    public void setLevel(String level) {
        this.level = level;
    }
    /**
    * 获取: Type
    */
    public Integer getType() {
        return type;
    }
    /**
    * 设置: Type
    * 
    */
    public void setType(Integer type) {
        this.type = type;
    }
    /**
    * 获取: FrontName
    */
    public String getFrontName() {
        return frontName;
    }
    /**
    * 设置: FrontName
    * 
    */
    public void setFrontName(String frontName) {
        this.frontName = frontName;
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


