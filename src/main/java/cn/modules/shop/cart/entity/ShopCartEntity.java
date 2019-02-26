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
    @TableField(value="member_id")
    private Long memberId;
    /**
     * 商品Id
     */
    @Excel(name = "商品Id")
    @TableField(value="goods_id")
    private Long goodsId;
    /**
    * 数量
    */
    @Excel(name = "数量")
    @TableField(value="number")
    private Integer number;
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
     * 获取: 会员ID
     */
    public Long getMemberId() {
        return memberId;
    }
    /**
     * 设置: 会员ID
     *
     */
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
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


