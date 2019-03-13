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
/**
* 商品类型表 entity 对象实体类
*
* @author jianconglee
* @Date 2019-03-12 17:15:31
*/
@TableName("shop_category")
public class ShopCategoryEntity extends AbstractModel<ShopCategoryEntity> {
    private static final long serialVersionUID = 1L;
    /**
    * 主键
    */
    @Excel(name = "主键")
    @TableId(value ="id",type = IdType.ID_WORKER)
    private Long id;
    /**
    * 父级id
    */
    @Excel(name = "父级id")
    @TableField(value="parent_id")
    private Long parentId;
    /**
    * 名称
    */
    @Excel(name = "名称")
    @TableField(value="name")
    private String name;
    /**
    * 级别：0 1 2(现有三级)
    */
    @Excel(name = "级别：0 1 2(现有三级)")
    @TableField(value="level")
    private Integer level;
    /**
    * 关键字
    */
    @Excel(name = "关键字")
    @TableField(value="keywords")
    private String keywords;
    /**
    * 描述
    */
    @Excel(name = "描述")
    @TableField(value="desc")
    private String desc;
    /**
    * 排序
    */
    @Excel(name = "排序")
    @TableField(value="sort_order")
    private Integer sortOrder;
    /**
    * 是否显示：0不显示 1显示
    */
    @Excel(name = "是否显示：0不显示 1显示")
    @TableField(value="is_show")
    private Integer isShow;
    /**
    * banner图片
    */
    @Excel(name = "banner图片")
    @TableField(value="banner_url")
    private String bannerUrl;
    /**
    * icon图片
    */
    @Excel(name = "icon图片")
    @TableField(value="icon_url")
    private String iconUrl;
    /**
    * 图片
    */
    @Excel(name = "图片")
    @TableField(value="img_url")
    private String imgUrl;
    /**
    * 更新时间
    */
    @Excel(name = "更新时间",exportFormat = "yyyy-MM-dd HH:mm:ss")
    @TableField(value="update_time")
    private Date updateTime;
    /**
    * 创建时间
    */
    @Excel(name = "创建时间",exportFormat = "yyyy-MM-dd HH:mm:ss")
    @TableField(value="create_time")
    private Date createTime;
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
    * 获取: 父级id
    */
    public Long getParentId() {
        return parentId;
    }
    /**
    * 设置: 父级id
    * 
    */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
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
    * 获取: 级别：0 1 2(现有三级)
    */
    public Integer getLevel() {
        return level;
    }
    /**
    * 设置: 级别：0 1 2(现有三级)
    * 
    */
    public void setLevel(Integer level) {
        this.level = level;
    }
    /**
    * 获取: 关键字
    */
    public String getKeywords() {
        return keywords;
    }
    /**
    * 设置: 关键字
    * 
    */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
    /**
    * 获取: 描述
    */
    public String getDesc() {
        return desc;
    }
    /**
    * 设置: 描述
    * 
    */
    public void setDesc(String desc) {
        this.desc = desc;
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
    * 获取: 是否显示：0不显示 1显示
    */
    public Integer getIsShow() {
        return isShow;
    }
    /**
    * 设置: 是否显示：0不显示 1显示
    * 
    */
    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }
    /**
    * 获取: banner图片
    */
    public String getBannerUrl() {
        return bannerUrl;
    }
    /**
    * 设置: banner图片
    * 
    */
    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }
    /**
    * 获取: icon图片
    */
    public String getIconUrl() {
        return iconUrl;
    }
    /**
    * 设置: icon图片
    * 
    */
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
    /**
    * 获取: 图片
    */
    public String getImgUrl() {
        return imgUrl;
    }
    /**
    * 设置: 图片
    * 
    */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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


