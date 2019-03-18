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
* VIEW entity 对象实体类
*
* @author jianconglee
* @Date 2019-03-01 00:07:22
*/
@TableName("view_shop_goods")
public class ViewShopGoodsEntity extends AbstractModel<ViewShopGoodsEntity> {
    private static final long serialVersionUID = 1L;
    /**
    * 主键
    */
    @Excel(name = "主键")
    @TableField(value="id")
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
    private Integer brandId;
    /**
    * 商品类别ID
    */
    @Excel(name = "商品类别ID")
    @TableField(value="category_id")
    private String categoryId;
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
    * 净含量
    */
    @Excel(name = "净含量")
    @TableField(value="net_weight")
    private String netWeight;
    /**
    * 包装方式
    */
    @Excel(name = "包装方式")
    @TableField(value="packaging_method")
    private String packagingMethod;
    /**
    * 保质期
    */
    @Excel(name = "保质期")
    @TableField(value="quality_guarantee_period")
    private String qualityGuaranteePeriod;
    /**
    * 系列
    */
    @Excel(name = "系列")
    @TableField(value="series")
    private String series;
    /**
    * 存储方法
    */
    @Excel(name = "存储方法")
    @TableField(value="storage_method")
    private String storageMethod;
    /**
    * 尺码
    */
    @Excel(name = "尺码")
    @TableField(value="size")
    private String size;
    /**
    * 颜色分类
    */
    @Excel(name = "颜色分类")
    @TableField(value="color")
    private String color;
    /**
    * 类型
    */
    @Excel(name = "类型")
    @TableField(value="type")
    private String type;
    /**
    * 数量
    */
    @Excel(name = "数量")
    @TableField(value="amount")
    private String amount;
    /**
    * 款式
    */
    @Excel(name = "款式")
    @TableField(value="style")
    private String style;
    /**
    * 型号
    */
    @Excel(name = "型号")
    @TableField(value="model")
    private String model;
    /**
    * 保修期
    */
    @Excel(name = "保修期")
    @TableField(value="defects_liability_period")
    private String defectsLiabilityPeriod;
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
    public Integer getBrandId() {
        return brandId;
    }
    /**
    * 设置: 品牌id
    * 
    */
    public void setBrandId(Integer brandId) {
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
    /**
    * 获取: 净含量
    */
    public String getNetWeight() {
        return netWeight;
    }
    /**
    * 设置: 净含量
    * 
    */
    public void setNetWeight(String netWeight) {
        this.netWeight = netWeight;
    }
    /**
    * 获取: 包装方式
    */
    public String getPackagingMethod() {
        return packagingMethod;
    }
    /**
    * 设置: 包装方式
    * 
    */
    public void setPackagingMethod(String packagingMethod) {
        this.packagingMethod = packagingMethod;
    }
    /**
    * 获取: 保质期
    */
    public String getQualityGuaranteePeriod() {
        return qualityGuaranteePeriod;
    }
    /**
    * 设置: 保质期
    * 
    */
    public void setQualityGuaranteePeriod(String qualityGuaranteePeriod) {
        this.qualityGuaranteePeriod = qualityGuaranteePeriod;
    }
    /**
    * 获取: 系列
    */
    public String getSeries() {
        return series;
    }
    /**
    * 设置: 系列
    * 
    */
    public void setSeries(String series) {
        this.series = series;
    }
    /**
    * 获取: 存储方法
    */
    public String getStorageMethod() {
        return storageMethod;
    }
    /**
    * 设置: 存储方法
    * 
    */
    public void setStorageMethod(String storageMethod) {
        this.storageMethod = storageMethod;
    }
    /**
    * 获取: 尺码
    */
    public String getSize() {
        return size;
    }
    /**
    * 设置: 尺码
    * 
    */
    public void setSize(String size) {
        this.size = size;
    }
    /**
    * 获取: 颜色分类
    */
    public String getColor() {
        return color;
    }
    /**
    * 设置: 颜色分类
    * 
    */
    public void setColor(String color) {
        this.color = color;
    }
    /**
    * 获取: 类型
    */
    public String getType() {
        return type;
    }
    /**
    * 设置: 类型
    * 
    */
    public void setType(String type) {
        this.type = type;
    }
    /**
    * 获取: 数量
    */
    public String getAmount() {
        return amount;
    }
    /**
    * 设置: 数量
    * 
    */
    public void setAmount(String amount) {
        this.amount = amount;
    }
    /**
    * 获取: 款式
    */
    public String getStyle() {
        return style;
    }
    /**
    * 设置: 款式
    * 
    */
    public void setStyle(String style) {
        this.style = style;
    }
    /**
    * 获取: 型号
    */
    public String getModel() {
        return model;
    }
    /**
    * 设置: 型号
    * 
    */
    public void setModel(String model) {
        this.model = model;
    }
    /**
    * 获取: 保修期
    */
    public String getDefectsLiabilityPeriod() {
        return defectsLiabilityPeriod;
    }
    /**
    * 设置: 保修期
    * 
    */
    public void setDefectsLiabilityPeriod(String defectsLiabilityPeriod) {
        this.defectsLiabilityPeriod = defectsLiabilityPeriod;
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
        return false;
    }


    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}


