package cn.modules.shop.coupon.entity;

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
* 优惠券 entity 对象实体类
*
* @author jianconglee
* @Date 2019-02-21 11:03:10
*/
@TableName("shop_coupon")
public class ShopCouponEntity extends AbstractModel<ShopCouponEntity> {
    private static final long serialVersionUID = 1L;
    /**
    * 主键
    */
    @Excel(name = "主键")
    @TableId(value="id")
    private Long id;
    /**
    * 名称
    */
    @Excel(name = "名称")
    @TableField(value="name")
    private String name;
    /**
    * 类型金额
    */
    @Excel(name = "类型金额")
    @TableField(value="type_money")
    private BigDecimal typeMoney;
    /**
    * 下发类型
    */
    @Excel(name = "下发类型")
    @TableField(value="send_type")
    private Integer sendType;
    /**
    * 最小数量
    */
    @Excel(name = "最小数量")
    @TableField(value="min_amount")
    private BigDecimal minAmount;
    /**
    * 最大数量
    */
    @Excel(name = "最大数量")
    @TableField(value="max_amount")
    private BigDecimal maxAmount;
    /**
    * 下发开始时间
    */
    @Excel(name = "下发开始时间",exportFormat = "yyyy-MM-dd HH:mm:ss")
    @TableField(value="send_start_date")
    private Date sendStartDate;
    /**
    * 下发结束时间
    */
    @Excel(name = "下发结束时间",exportFormat = "yyyy-MM-dd HH:mm:ss")
    @TableField(value="send_end_date")
    private Date sendEndDate;
    /**
    * 使用开始时间
    */
    @Excel(name = "使用开始时间",exportFormat = "yyyy-MM-dd HH:mm:ss")
    @TableField(value="use_start_date")
    private Date useStartDate;
    /**
    * 使用结束时间
    */
    @Excel(name = "使用结束时间",exportFormat = "yyyy-MM-dd HH:mm:ss")
    @TableField(value="use_end_date")
    private Date useEndDate;
    /**
    * 货物数量
    */
    @Excel(name = "货物数量")
    @TableField(value="min_goods_amount")
    private BigDecimal minGoodsAmount;
    /**
    * 转发次数
    */
    @Excel(name = "转发次数")
    @TableField(value="min_transmit_num")
    private Integer minTransmitNum;
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
    * 获取: 类型金额
    */
    public BigDecimal getTypeMoney() {
        return typeMoney;
    }
    /**
    * 设置: 类型金额
    * 
    */
    public void setTypeMoney(BigDecimal typeMoney) {
        this.typeMoney = typeMoney;
    }
    /**
    * 获取: 下发类型
    */
    public Integer getSendType() {
        return sendType;
    }
    /**
    * 设置: 下发类型
    * 
    */
    public void setSendType(Integer sendType) {
        this.sendType = sendType;
    }
    /**
    * 获取: 最小数量
    */
    public BigDecimal getMinAmount() {
        return minAmount;
    }
    /**
    * 设置: 最小数量
    * 
    */
    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }
    /**
    * 获取: 最大数量
    */
    public BigDecimal getMaxAmount() {
        return maxAmount;
    }
    /**
    * 设置: 最大数量
    * 
    */
    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }
    /**
    * 获取: 下发开始时间
    */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    public Date getSendStartDate() {
        return sendStartDate;
    }
    /**
    * 设置: 下发开始时间
    * 
    */
    public void setSendStartDate(Date sendStartDate) {
        this.sendStartDate = sendStartDate;
    }
    /**
    * 获取: 下发结束时间
    */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    public Date getSendEndDate() {
        return sendEndDate;
    }
    /**
    * 设置: 下发结束时间
    * 
    */
    public void setSendEndDate(Date sendEndDate) {
        this.sendEndDate = sendEndDate;
    }
    /**
    * 获取: 使用开始时间
    */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    public Date getUseStartDate() {
        return useStartDate;
    }
    /**
    * 设置: 使用开始时间
    * 
    */
    public void setUseStartDate(Date useStartDate) {
        this.useStartDate = useStartDate;
    }
    /**
    * 获取: 使用结束时间
    */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    public Date getUseEndDate() {
        return useEndDate;
    }
    /**
    * 设置: 使用结束时间
    * 
    */
    public void setUseEndDate(Date useEndDate) {
        this.useEndDate = useEndDate;
    }
    /**
    * 获取: 货物数量
    */
    public BigDecimal getMinGoodsAmount() {
        return minGoodsAmount;
    }
    /**
    * 设置: 货物数量
    * 
    */
    public void setMinGoodsAmount(BigDecimal minGoodsAmount) {
        this.minGoodsAmount = minGoodsAmount;
    }
    /**
    * 获取: 转发次数
    */
    public Integer getMinTransmitNum() {
        return minTransmitNum;
    }
    /**
    * 设置: 转发次数
    * 
    */
    public void setMinTransmitNum(Integer minTransmitNum) {
        this.minTransmitNum = minTransmitNum;
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


