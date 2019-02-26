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
    private Long userId;
    /**
    * 产品Id
    */
    @Excel(name = "产品Id")
    @TableField(value="value_id")
    private Long valueId;
    /**
    * 是否提醒
    */
    @Excel(name = "是否提醒")
    @TableField(value="is_attention")
    private Integer isAttention;
    /**
     * 类型
     */
    @Excel(name = "类型")
    @TableField(value="type")
    private Integer type;
    /**
     * 添加时间
     */
    @Excel(name = "添加时间",exportFormat = "yyyy-MM-dd HH:mm:ss")
    @TableField(value="create_time")
    private Date createTime;
    /**
     * 更新时间
     */
    @Excel(name = "更新时间",exportFormat = "yyyy-MM-dd HH:mm:ss")
    @TableField(value="update_time")
    private Date updateTime;
    /**
    * 软删除
    */
    @Excel(name = "软删除")
    @TableField(value="is_delete")
    private Integer isDelete;
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
    public Long getUserId() {
        return userId;
    }
    /**
    * 设置: 用户Id
    * 
    */
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    /**
    * 获取: 产品Id
    */
    public Long getValueId() {
        return valueId;
    }
    /**
    * 设置: 产品Id
    * 
    */
    public void setValueId(Long valueId) {
        this.valueId = valueId;
    }
    /**
    * 获取: 添加时间
    */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    public Date getCreateTime() {
        return createTime;
    }
    /**
    * 设置: 添加时间
    * 
    */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
    * 获取: Type
    */
    public Integer getType() {
        return type;
    }
    /**
    * 设置: Type
    * 
    */
    public void setType(Integer type) {
        this.type = type;
    }
    /**
     * 获取: 软删除
     */
    public Integer getIsDelete() {
        return isDelete;
    }
    /**
     * 设置: 软删除
     *
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 获取: 添加时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    public Date getUpdateTime() {
        return updateTime;
    }
    /**
     * 设置: 添加时间
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


