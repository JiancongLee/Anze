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
* @Date 2019-02-21 23:00:48
*/
@TableName("shop_goods")
public class ShopGoodsEntity extends AbstractModel<ShopGoodsEntity> {
    private static final long serialVersionUID = 1L;
    /**
    * Id
    */
    @Excel(name = "Id")
    @TableId(value="id")
    private Long id;
    /**
    * CategoryId
    */
    @Excel(name = "CategoryId")
    @TableField(value="category_id")
    private Long categoryId;
    /**
    * GoodsSn
    */
    @Excel(name = "GoodsSn")
    @TableField(value="goods_sn")
    private String goodsSn;
    /**
    * Name
    */
    @Excel(name = "Name")
    @TableField(value="name")
    private String name;
    /**
    * BrandId
    */
    @Excel(name = "BrandId")
    @TableField(value="brand_id")
    private Long brandId;
    /**
    * GoodsNumber
    */
    @Excel(name = "GoodsNumber")
    @TableField(value="goods_number")
    private Integer goodsNumber;
    /**
    * Keywords
    */
    @Excel(name = "Keywords")
    @TableField(value="keywords")
    private String keywords;
    /**
    * GoodsBrief
    */
    @Excel(name = "GoodsBrief")
    @TableField(value="goods_brief")
    private String goodsBrief;
    /**
    * GoodsDesc
    */
    @Excel(name = "GoodsDesc")
    @TableField(value="goods_desc")
    private String goodsDesc;
    /**
    * IsOnSale
    */
    @Excel(name = "IsOnSale")
    @TableField(value="is_on_sale")
    private Integer isOnSale;
    /**
    * AddTime
    */
    @Excel(name = "AddTime",exportFormat = "yyyy-MM-dd HH:mm:ss")
    @TableField(value="add_time")
    private Date addTime;
    /**
    * SortOrder
    */
    @Excel(name = "SortOrder")
    @TableField(value="sort_order")
    private Integer sortOrder;
    /**
    * IsDelete
    */
    @Excel(name = "IsDelete")
    @TableField(value="is_delete")
    private Integer isDelete;
    /**
    * AttributeCategory
    */
    @Excel(name = "AttributeCategory")
    @TableField(value="attribute_category")
    private Integer attributeCategory;
    /**
    * 专柜价格
    */
    @Excel(name = "专柜价格")
    @TableField(value="counter_price")
    private BigDecimal counterPrice;
    /**
    * 附加价格
    */
    @Excel(name = "附加价格")
    @TableField(value="extra_price")
    private BigDecimal extraPrice;
    /**
    * IsNew
    */
    @Excel(name = "IsNew")
    @TableField(value="is_new")
    private Integer isNew;
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
    @TableField(value="primary_pic_url")
    private String primaryPicUrl;
    /**
    * 商品列表图
    */
    @Excel(name = "商品列表图")
    @TableField(value="list_pic_url")
    private String listPicUrl;
    /**
    * 零售价格
    */
    @Excel(name = "零售价格")
    @TableField(value="retail_price")
    private BigDecimal retailPrice;
    /**
    * 销售量
    */
    @Excel(name = "销售量")
    @TableField(value="sell_volume")
    private Integer sellVolume;
    /**
    * 主sku　product_id
    */
    @Excel(name = "主sku　product_id")
    @TableField(value="primary_product_id")
    private Integer primaryProductId;
    /**
    * 单位价格，单价
    */
    @Excel(name = "单位价格，单价")
    @TableField(value="unit_price")
    private BigDecimal unitPrice;
    /**
    * PromotionDesc
    */
    @Excel(name = "PromotionDesc")
    @TableField(value="promotion_desc")
    private String promotionDesc;
    /**
    * PromotionTag
    */
    @Excel(name = "PromotionTag")
    @TableField(value="promotion_tag")
    private String promotionTag;
    /**
    * APP专享价
    */
    @Excel(name = "APP专享价")
    @TableField(value="app_exclusive_price")
    private BigDecimal appExclusivePrice;
    /**
    * 是否是APP专属
    */
    @Excel(name = "是否是APP专属")
    @TableField(value="is_app_exclusive")
    private Integer isAppExclusive;
    /**
    * IsLimited
    */
    @Excel(name = "IsLimited")
    @TableField(value="is_limited")
    private Integer isLimited;
    /**
    * IsHot
    */
    @Excel(name = "IsHot")
    @TableField(value="is_hot")
    private Integer isHot;
    /**
    * MarketPrice
    */
    @Excel(name = "MarketPrice")
    @TableField(value="market_price")
    private BigDecimal marketPrice;
    /**
    * 创建人ID
    */
    @Excel(name = "创建人ID")
    @TableField(value="create_user_id")
    private Integer createUserId;
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
    * CreateUserDeptId
    */
    @Excel(name = "CreateUserDeptId")
    @TableField(value="create_user_dept_id")
    private Integer createUserDeptId;
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
    * 获取: CategoryId
    */
    public Long getCategoryId() {
        return categoryId;
    }
    /**
    * 设置: CategoryId
    * 
    */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    /**
    * 获取: GoodsSn
    */
    public String getGoodsSn() {
        return goodsSn;
    }
    /**
    * 设置: GoodsSn
    * 
    */
    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }
    /**
    * 获取: Name
    */
    public String getName() {
        return name;
    }
    /**
    * 设置: Name
    * 
    */
    public void setName(String name) {
        this.name = name;
    }
    /**
    * 获取: BrandId
    */
    public Long getBrandId() {
        return brandId;
    }
    /**
    * 设置: BrandId
    * 
    */
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
    /**
    * 获取: GoodsNumber
    */
    public Integer getGoodsNumber() {
        return goodsNumber;
    }
    /**
    * 设置: GoodsNumber
    * 
    */
    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
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
    * 获取: GoodsBrief
    */
    public String getGoodsBrief() {
        return goodsBrief;
    }
    /**
    * 设置: GoodsBrief
    * 
    */
    public void setGoodsBrief(String goodsBrief) {
        this.goodsBrief = goodsBrief;
    }
    /**
    * 获取: GoodsDesc
    */
    public String getGoodsDesc() {
        return goodsDesc;
    }
    /**
    * 设置: GoodsDesc
    * 
    */
    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }
    /**
    * 获取: IsOnSale
    */
    public Integer getIsOnSale() {
        return isOnSale;
    }
    /**
    * 设置: IsOnSale
    * 
    */
    public void setIsOnSale(Integer isOnSale) {
        this.isOnSale = isOnSale;
    }
    /**
    * 获取: AddTime
    */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    public Date getAddTime() {
        return addTime;
    }
    /**
    * 设置: AddTime
    * 
    */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
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
    * 获取: IsDelete
    */
    public Integer getIsDelete() {
        return isDelete;
    }
    /**
    * 设置: IsDelete
    * 
    */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
    /**
    * 获取: AttributeCategory
    */
    public Integer getAttributeCategory() {
        return attributeCategory;
    }
    /**
    * 设置: AttributeCategory
    * 
    */
    public void setAttributeCategory(Integer attributeCategory) {
        this.attributeCategory = attributeCategory;
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
    * 获取: 附加价格
    */
    public BigDecimal getExtraPrice() {
        return extraPrice;
    }
    /**
    * 设置: 附加价格
    * 
    */
    public void setExtraPrice(BigDecimal extraPrice) {
        this.extraPrice = extraPrice;
    }
    /**
    * 获取: IsNew
    */
    public Integer getIsNew() {
        return isNew;
    }
    /**
    * 设置: IsNew
    * 
    */
    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
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
    public String getPrimaryPicUrl() {
        return primaryPicUrl;
    }
    /**
    * 设置: 商品主图
    * 
    */
    public void setPrimaryPicUrl(String primaryPicUrl) {
        this.primaryPicUrl = primaryPicUrl;
    }
    /**
    * 获取: 商品列表图
    */
    public String getListPicUrl() {
        return listPicUrl;
    }
    /**
    * 设置: 商品列表图
    * 
    */
    public void setListPicUrl(String listPicUrl) {
        this.listPicUrl = listPicUrl;
    }
    /**
    * 获取: 零售价格
    */
    public BigDecimal getRetailPrice() {
        return retailPrice;
    }
    /**
    * 设置: 零售价格
    * 
    */
    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }
    /**
    * 获取: 销售量
    */
    public Integer getSellVolume() {
        return sellVolume;
    }
    /**
    * 设置: 销售量
    * 
    */
    public void setSellVolume(Integer sellVolume) {
        this.sellVolume = sellVolume;
    }
    /**
    * 获取: 主sku　product_id
    */
    public Integer getPrimaryProductId() {
        return primaryProductId;
    }
    /**
    * 设置: 主sku　product_id
    * 
    */
    public void setPrimaryProductId(Integer primaryProductId) {
        this.primaryProductId = primaryProductId;
    }
    /**
    * 获取: 单位价格，单价
    */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }
    /**
    * 设置: 单位价格，单价
    * 
    */
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
    /**
    * 获取: PromotionDesc
    */
    public String getPromotionDesc() {
        return promotionDesc;
    }
    /**
    * 设置: PromotionDesc
    * 
    */
    public void setPromotionDesc(String promotionDesc) {
        this.promotionDesc = promotionDesc;
    }
    /**
    * 获取: PromotionTag
    */
    public String getPromotionTag() {
        return promotionTag;
    }
    /**
    * 设置: PromotionTag
    * 
    */
    public void setPromotionTag(String promotionTag) {
        this.promotionTag = promotionTag;
    }
    /**
    * 获取: APP专享价
    */
    public BigDecimal getAppExclusivePrice() {
        return appExclusivePrice;
    }
    /**
    * 设置: APP专享价
    * 
    */
    public void setAppExclusivePrice(BigDecimal appExclusivePrice) {
        this.appExclusivePrice = appExclusivePrice;
    }
    /**
    * 获取: 是否是APP专属
    */
    public Integer getIsAppExclusive() {
        return isAppExclusive;
    }
    /**
    * 设置: 是否是APP专属
    * 
    */
    public void setIsAppExclusive(Integer isAppExclusive) {
        this.isAppExclusive = isAppExclusive;
    }
    /**
    * 获取: IsLimited
    */
    public Integer getIsLimited() {
        return isLimited;
    }
    /**
    * 设置: IsLimited
    * 
    */
    public void setIsLimited(Integer isLimited) {
        this.isLimited = isLimited;
    }
    /**
    * 获取: IsHot
    */
    public Integer getIsHot() {
        return isHot;
    }
    /**
    * 设置: IsHot
    * 
    */
    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }
    /**
    * 获取: MarketPrice
    */
    public BigDecimal getMarketPrice() {
        return marketPrice;
    }
    /**
    * 设置: MarketPrice
    * 
    */
    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
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
    /**
    * 获取: CreateUserDeptId
    */
    public Integer getCreateUserDeptId() {
        return createUserDeptId;
    }
    /**
    * 设置: CreateUserDeptId
    * 
    */
    public void setCreateUserDeptId(Integer createUserDeptId) {
        this.createUserDeptId = createUserDeptId;
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


