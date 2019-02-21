package cn.modules.shop.collect.entity;

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
* 会员收藏表 entity 对象实体类
*
* @author jianconglee
* @Date 2019-02-21 11:31:58
*/
@TableName("shop_collect")
public class ShopCollectEntity extends AbstractModel<ShopCollectEntity> {
    private static final long serialVersionUID = 1L;
    /**
    * 主键
    */
    @Excel(name = "主键")
    @TableId(value="id")
    private Long id;
    /**
    * 用户Id
    */
    @Excel(name = "用户Id")
    @TableField(value="user_id")
    private Integer userId;
    /**
    * 产品Id
    */
    @Excel(name = "产品Id")
    @TableField(value="value_id")
    private Integer valueId;
    /**
    * 添加时间
    */
    @Excel(name = "添加时间",exportFormat = "yyyy-MM-dd HH:mm:ss")
    @TableField(value="add_time")
    private Date addTime;
    /**
    * 是否提醒
    */
    @Excel(name = "是否提醒")
    @TableField(value="is_attention")
    private Integer isAttention;
    /**
    * TypeId
    */
    @Excel(name = "TypeId")
    @TableField(value="type_id")
    private Integer typeId;
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
    * 获取: 用户Id
    */
    public Integer getUserId() {
        return userId;
    }
    /**
    * 设置: 用户Id
    * 
    */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    /**
    * 获取: 产品Id
    */
    public Integer getValueId() {
        return valueId;
    }
    /**
    * 设置: 产品Id
    * 
    */
    public void setValueId(Integer valueId) {
        this.valueId = valueId;
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
    /**
    * 获取: 是否提醒
    */
    public Integer getIsAttention() {
        return isAttention;
    }
    /**
    * 设置: 是否提醒
    * 
    */
    public void setIsAttention(Integer isAttention) {
        this.isAttention = isAttention;
    }
    /**
    * 获取: TypeId
    */
    public Integer getTypeId() {
        return typeId;
    }
    /**
    * 设置: TypeId
    * 
    */
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
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


