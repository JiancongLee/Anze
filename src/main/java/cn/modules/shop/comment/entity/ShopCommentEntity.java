package cn.modules.shop.comment.entity;

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
* 商品评论 entity 对象实体类
*
* @author jianconglee
* @Date 2019-02-21 23:11:21
*/
@TableName("shop_comment")
public class ShopCommentEntity extends AbstractModel<ShopCommentEntity> {
    private static final long serialVersionUID = 1L;
    /**
    * 主键
    */
    @Excel(name = "主键")
    @TableId(value="id")
    private Long id;
    /**
    * 类型
    */
    @Excel(name = "类型")
    @TableField(value="type_id")
    private Integer typeId;
    /**
    * ValueId
    */
    @Excel(name = "ValueId")
    @TableField(value="value_id")
    private Integer valueId;
    /**
    * 储存为base64编码
    */
    @Excel(name = "储存为base64编码")
    @TableField(value="content")
    private String content;
    /**
    * 记录时间
    */
    @Excel(name = "记录时间")
    @TableField(value="add_time")
    private Integer addTime;
    /**
    * 状态
    */
    @Excel(name = "状态")
    @TableField(value="status")
    private Integer status;
    /**
    * 会员Id
    */
    @Excel(name = "会员Id")
    @TableField(value="user_id")
    private Long userId;
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
    * 获取: 类型
    */
    public Integer getTypeId() {
        return typeId;
    }
    /**
    * 设置: 类型
    * 
    */
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
    /**
    * 获取: ValueId
    */
    public Integer getValueId() {
        return valueId;
    }
    /**
    * 设置: ValueId
    * 
    */
    public void setValueId(Integer valueId) {
        this.valueId = valueId;
    }
    /**
    * 获取: 储存为base64编码
    */
    public String getContent() {
        return content;
    }
    /**
    * 设置: 储存为base64编码
    * 
    */
    public void setContent(String content) {
        this.content = content;
    }
    /**
    * 获取: 记录时间
    */
    public Integer getAddTime() {
        return addTime;
    }
    /**
    * 设置: 记录时间
    * 
    */
    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }
    /**
    * 获取: 状态
    */
    public Integer getStatus() {
        return status;
    }
    /**
    * 设置: 状态
    * 
    */
    public void setStatus(Integer status) {
        this.status = status;
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


