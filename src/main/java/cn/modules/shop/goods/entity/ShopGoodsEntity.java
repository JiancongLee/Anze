package cn.modules.shop.goods.entity;

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
* 商品表 entity 对象实体类
*
* @author jianconglee
* @Date 2019-02-28 22:40:27
*/
@TableName("shop_goods")
public class ShopGoodsEntity extends AbstractModel<ShopGoodsEntity> {
    private static final long serialVersionUID = 1L;
    /**
    * 主键
    */
    @Excel(name = "主键")
    @TableId(value ="id",type = IdType.ID_WORKER)
    private Long id;
    /**
    * 商品名称
    */
    @Excel(name = "商品名称")
    @TableField(value="name")
    private String name;
    /**
     * 种类
     */
    @Excel(name = "种类")
    @TableField(value="kind")
    private Integer kind;
    /**
    * 品牌id
    */
    @Excel(name = "品牌id")
    @TableField(value="brand_id")
    private Long brandId;
    /**
    * 商品类别ID
    */
    @Excel(name = "商品类别ID")
    @TableField(value="category_id")
    private String categoryId;
    /**
     * 商品第一级类别ID
     */
    @Excel(name = "商品第一级类别ID")
    @TableField(value="first_level_category_id")
    private Long firstLevelCategoryId;
    /**
     * 商品第二级类别ID
     */
    @Excel(name = "商品第二级类别ID")
    @TableField(value="second_level_category_id")
    private Long secondLevelCategoryId;
    /**
    * 序列号
    */
    @Excel(name = "序列号")
    @TableField(value="goods_number")
    private String goodsNumber;
    /**
    * 关键字
    */
    @Excel(name = "关键字")
    @TableField(value="keywords")
    private String keywords;
    /**
    * 专柜价格
    */
    @Excel(name = "专柜价格")
    @TableField(value="counter_price")
    private BigDecimal counterPrice;
    /**
    * 价格
    */
    @Excel(name = "价格")
    @TableField(value="price")
    private BigDecimal price;
    /**
    * 商品简介
    */
    @Excel(name = "商品简介")
    @TableField(value="goods_brief")
    private String goodsBrief;
    /**
    * 商品详细介绍
    */
    @Excel(name = "商品详细介绍")
    @TableField(value="goods_desc")
    private String goodsDesc;
    /**
    * SortOrder
    */
    @Excel(name = "SortOrder")
    @TableField(value="sort_order")
    private Integer sortOrder;
    /**
    * 商品单位
    */
    @Excel(name = "商品单位")
    @TableField(value="goods_unit")
    private String goodsUnit;
    /**
    * 商品主图
    */
    @Excel(name = "商品主图")
    @TableField(value="primary_pic_id")
    private String primaryPicId;
    /**
    * 商品列表图
    */
    @Excel(name = "商品列表图")
    @TableField(value="list_pic_ids")
    private String listPicIds;
    /**
    * 是否新品：0否 1是
    */
    @Excel(name = "是否新品：0否 1是")
    @TableField(value="is_new")
    private Integer isNew;
    /**
    * 是否在售:0否 1是
    */
    @Excel(name = "是否在售:0否 1是")
    @TableField(value="is_on_sale")
    private Integer isOnSale;
    /**
    * 是否热销：0否 1是
    */
    @Excel(name = "是否热销：0否 1是")
    @TableField(value="is_hot")
    private Integer isHot;
    /**
    * 软删除：0否 1是
    */
    @Excel(name = "软删除：0否 1是")
    @TableField(value="is_delete")
    private Integer isDelete;
    /**
    * 创建人ID
    */
    @Excel(name = "创建人ID")
    @TableField(value="create_user_id")
    private Integer createUserId;
    /**
    * CreateTime
    */
    @Excel(name = "CreateTime",exportFormat = "yyyy-MM-dd HH:mm:ss")
    @TableField(value="create_time")
    private Date createTime;
    /**
    * 修改人ID
    */
    @Excel(name = "修改人ID")
    @TableField(value="update_user_id")
    private Integer updateUserId;
    /**
    * 修改时间
    */
    @Excel(name = "修改时间",exportFormat = "yyyy-MM-dd HH:mm:ss")
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
    * 获取: 商品名称
    */
    public String getName() {
        return name;
    }
    /**
    * 设置: 商品名称
    * 
    */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 获取: 种类
     */
    public Integer getKind() {
        return kind;
    }
    /**
     * 设置: 种类
     *
     */
    public void setKind(Integer kind) {
        this.kind = kind;
    }
    /**
    * 获取: 品牌id
    */
    public Long getBrandId() {
        return brandId;
    }
    /**
    * 设置: 品牌id
    * 
    */
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
    /**
    * 获取: 商品类别ID
    */
    public String getCategoryId() {
        return categoryId;
    }
    /**
    * 设置: 商品类别ID
    * 
    */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Long getFirstLevelCategoryId() {
        return firstLevelCategoryId;
    }

    public void setFirstLevelCategoryId(Long firstLevelCategoryId) {
        this.firstLevelCategoryId = firstLevelCategoryId;
    }

    public Long getSecondLevelCategoryId() {
        return secondLevelCategoryId;
    }

    public void setSecondLevelCategoryId(Long secondLevelCategoryId) {
        this.secondLevelCategoryId = secondLevelCategoryId;
    }

    /**
    * 获取: 序列号
    */
    public String getGoodsNumber() {
        return goodsNumber;
    }
    /**
    * 设置: 序列号
    * 
    */
    public void setGoodsNumber(String goodsNumber) {
        this.goodsNumber = goodsNumber;
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
    * 获取: 专柜价格
    */
    public BigDecimal getCounterPrice() {
        return counterPrice;
    }
    /**
    * 设置: 专柜价格
    * 
    */
    public void setCounterPrice(BigDecimal counterPrice) {
        this.counterPrice = counterPrice;
    }
    /**
    * 获取: 价格
    */
    public BigDecimal getPrice() {
        return price;
    }
    /**
    * 设置: 价格
    * 
    */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    /**
    * 获取: 商品简介
    */
    public String getGoodsBrief() {
        return goodsBrief;
    }
    /**
    * 设置: 商品简介
    * 
    */
    public void setGoodsBrief(String goodsBrief) {
        this.goodsBrief = goodsBrief;
    }
    /**
    * 获取: 商品详细介绍
    */
    public String getGoodsDesc() {
        return goodsDesc;
    }
    /**
    * 设置: 商品详细介绍
    * 
    */
    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
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
    * 获取: 商品单位
    */
    public String getGoodsUnit() {
        return goodsUnit;
    }
    /**
    * 设置: 商品单位
    * 
    */
    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }
    /**
     * 获取: 商品主图
     */
    public String getPrimaryPicId() {
        return primaryPicId;
    }
    /**
     * 设置: 商品主图
     *
     */
    public void setPrimaryPicId(String primaryPicId) {
        this.primaryPicId = primaryPicId;
    }
    /**
     * 获取: 商品列表图
     */
    public String getListPicIds() {
        return listPicIds;
    }
    /**
     * 设置: 商品列表图
     *
     */
    public void setListPicIds(String listPicIds) {
        this.listPicIds = listPicIds;
    }
    /**
    * 获取: 是否新品：0否 1是
    */
    public Integer getIsNew() {
        return isNew;
    }
    /**
    * 设置: 是否新品：0否 1是
    * 
    */
    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }
    /**
    * 获取: 是否在售:0否 1是
    */
    public Integer getIsOnSale() {
        return isOnSale;
    }
    /**
    * 设置: 是否在售:0否 1是
    * 
    */
    public void setIsOnSale(Integer isOnSale) {
        this.isOnSale = isOnSale;
    }
    /**
    * 获取: 是否热销：0否 1是
    */
    public Integer getIsHot() {
        return isHot;
    }
    /**
    * 设置: 是否热销：0否 1是
    * 
    */
    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }
    /**
    * 获取: 软删除：0否 1是
    */
    public Integer getIsDelete() {
        return isDelete;
    }
    /**
    * 设置: 软删除：0否 1是
    * 
    */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
    /**
    * 获取: 创建人ID
    */
    public Integer getCreateUserId() {
        return createUserId;
    }
    /**
    * 设置: 创建人ID
    * 
    */
    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }
    /**
    * 获取: CreateTime
    */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    public Date getCreateTime() {
        return createTime;
    }
    /**
    * 设置: CreateTime
    * 
    */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    /**
    * 获取: 修改人ID
    */
    public Integer getUpdateUserId() {
        return updateUserId;
    }
    /**
    * 设置: 修改人ID
    * 
    */
    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }
    /**
    * 获取: 修改时间
    */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    public Date getUpdateTime() {
        return updateTime;
    }
    /**
    * 设置: 修改时间
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


