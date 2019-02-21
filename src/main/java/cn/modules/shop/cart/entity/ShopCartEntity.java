package cn.modules.shop.cart.entity;

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
* 购物车 entity 对象实体类
*
* @author jianconglee
* @Date 2019-02-21 12:42:14
*/
@TableName("shop_cart")
public class ShopCartEntity extends AbstractModel<ShopCartEntity> {
    private static final long serialVersionUID = 1L;
    /**
    * 主键
    */
    @Excel(name = "主键")
    @TableId(value="id")
    private Long id;
    /**
    * 会员Id
    */
    @Excel(name = "会员Id")
    @TableField(value="user_id")
    private Long userId;
    /**
    * sessionId
    */
    @Excel(name = "sessionId")
    @TableField(value="session_id")
    private String sessionId;
    /**
    * 商品Id
    */
    @Excel(name = "商品Id")
    @TableField(value="goods_id")
    private Long goodsId;
    /**
    * 商品序列号
    */
    @Excel(name = "商品序列号")
    @TableField(value="goods_sn")
    private String goodsSn;
    /**
    * 产品Id
    */
    @Excel(name = "产品Id")
    @TableField(value="product_id")
    private Long productId;
    /**
    * 产品名称
    */
    @Excel(name = "产品名称")
    @TableField(value="goods_name")
    private String goodsName;
    /**
    * 市场价
    */
    @Excel(name = "市场价")
    @TableField(value="market_price")
    private BigDecimal marketPrice;
    /**
    * 零售价格
    */
    @Excel(name = "零售价格")
    @TableField(value="retail_price")
    private BigDecimal retailPrice;
    /**
    * 数量
    */
    @Excel(name = "数量")
    @TableField(value="number")
    private Integer number;
    /**
    * 规格属性组成的字符串，用来显示用
    */
    @Excel(name = "规格属性组成的字符串，用来显示用")
    @TableField(value="goods_specifition_name_value")
    private String goodsSpecifitionNameValue;
    /**
    * product表对应的goods_specifition_ids
    */
    @Excel(name = "product表对应的goods_specifition_ids")
    @TableField(value="goods_specifition_ids")
    private String goodsSpecifitionIds;
    /**
    * Checked
    */
    @Excel(name = "Checked")
    @TableField(value="checked")
    private Integer checked;
    /**
    * 商品图片
    */
    @Excel(name = "商品图片")
    @TableField(value="list_pic_url")
    private String listPicUrl;
    /**
    * 添加时间
    */
    @Excel(name = "添加时间",exportFormat = "yyyy-MM-dd HH:mm:ss")
    @TableField(value="add_time")
    private Date addTime;
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
    * 获取: 会员Id
    */
    public Long getUserId() {
        return userId;
    }
    /**
    * 设置: 会员Id
    * 
    */
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    /**
    * 获取: sessionId
    */
    public String getSessionId() {
        return sessionId;
    }
    /**
    * 设置: sessionId
    * 
    */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
    /**
    * 获取: 商品Id
    */
    public Long getGoodsId() {
        return goodsId;
    }
    /**
    * 设置: 商品Id
    * 
    */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
    /**
    * 获取: 商品序列号
    */
    public String getGoodsSn() {
        return goodsSn;
    }
    /**
    * 设置: 商品序列号
    * 
    */
    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }
    /**
    * 获取: 产品Id
    */
    public Long getProductId() {
        return productId;
    }
    /**
    * 设置: 产品Id
    * 
    */
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    /**
    * 获取: 产品名称
    */
    public String getGoodsName() {
        return goodsName;
    }
    /**
    * 设置: 产品名称
    * 
    */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    /**
    * 获取: 市场价
    */
    public BigDecimal getMarketPrice() {
        return marketPrice;
    }
    /**
    * 设置: 市场价
    * 
    */
    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
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
    * 获取: 数量
    */
    public Integer getNumber() {
        return number;
    }
    /**
    * 设置: 数量
    * 
    */
    public void setNumber(Integer number) {
        this.number = number;
    }
    /**
    * 获取: 规格属性组成的字符串，用来显示用
    */
    public String getGoodsSpecifitionNameValue() {
        return goodsSpecifitionNameValue;
    }
    /**
    * 设置: 规格属性组成的字符串，用来显示用
    * 
    */
    public void setGoodsSpecifitionNameValue(String goodsSpecifitionNameValue) {
        this.goodsSpecifitionNameValue = goodsSpecifitionNameValue;
    }
    /**
    * 获取: product表对应的goods_specifition_ids
    */
    public String getGoodsSpecifitionIds() {
        return goodsSpecifitionIds;
    }
    /**
    * 设置: product表对应的goods_specifition_ids
    * 
    */
    public void setGoodsSpecifitionIds(String goodsSpecifitionIds) {
        this.goodsSpecifitionIds = goodsSpecifitionIds;
    }
    /**
    * 获取: Checked
    */
    public Integer getChecked() {
        return checked;
    }
    /**
    * 设置: Checked
    * 
    */
    public void setChecked(Integer checked) {
        this.checked = checked;
    }
    /**
    * 获取: 商品图片
    */
    public String getListPicUrl() {
        return listPicUrl;
    }
    /**
    * 设置: 商品图片
    * 
    */
    public void setListPicUrl(String listPicUrl) {
        this.listPicUrl = listPicUrl;
    }
    /**
    * 获取: 添加时间
    */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    public Date getAddTime() {
        return addTime;
    }
    /**
    * 设置: 添加时间
    * 
    */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
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


