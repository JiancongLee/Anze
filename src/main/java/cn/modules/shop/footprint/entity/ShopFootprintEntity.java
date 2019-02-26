package cn.modules.shop.footprint.entity;

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
* 会员足迹表 entity 对象实体类
*
* @author jianconglee
* @Date 2019-02-21 11:43:59
*/
@TableName("shop_footprint")
public class ShopFootprintEntity extends AbstractModel<ShopFootprintEntity> {
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
    * 商品id
    */
    @Excel(name = "商品id")
    @TableField(value="goods_id")
    private Long goodsId;
    /**
    * 记录时间
    */
    @Excel(name = "记录时间",exportFormat = "yyyy-MM-dd HH:mm:ss")
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
    * 获取: 会员Id
    */
    public Long getMemberId() {
        return memberId;
    }
    /**
    * 设置: 会员Id
    * 
    */
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
    /**
    * 获取: 商品id
    */
    public Long getGoodsId() {
        return goodsId;
    }
    /**
    * 设置: 商品id
    * 
    */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
    /**
    * 获取: 记录时间
    */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    public Date getCreateTime() {
        return createTime;
    }
    /**
    * 设置: 记录时间
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
        Date date = new Date();
        this.createTime = date;
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


