package cn.modules.shop.feedback.entity;

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
* 商品反馈表 entity 对象实体类
*
* @author jianconglee
* @Date 2019-02-21 22:41:08
*/
@TableName("shop_feedback")
public class ShopFeedbackEntity extends AbstractModel<ShopFeedbackEntity> {
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
    * 会员会员名称
    */
    @Excel(name = "会员会员名称")
    @TableField(value="user_name")
    private String userName;
    /**
    * 手机
    */
    @Excel(name = "手机")
    @TableField(value="mobile")
    private String mobile;
    /**
    * 反馈类型
    */
    @Excel(name = "反馈类型")
    @TableField(value="feed_Type")
    private Integer feedType;
    /**
    * 详细内容
    */
    @Excel(name = "详细内容")
    @TableField(value="content")
    private String content;
    /**
    * 状态
    */
    @Excel(name = "状态")
    @TableField(value="status")
    private Integer status;
    /**
    * 反馈时间
    */
    @Excel(name = "反馈时间",exportFormat = "yyyy-MM-dd HH:mm:ss")
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
    * 获取: 会员会员名称
    */
    public String getUserName() {
        return userName;
    }
    /**
    * 设置: 会员会员名称
    * 
    */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    /**
    * 获取: 手机
    */
    public String getMobile() {
        return mobile;
    }
    /**
    * 设置: 手机
    * 
    */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    /**
    * 获取: 反馈类型
    */
    public Integer getFeedType() {
        return feedType;
    }
    /**
    * 设置: 反馈类型
    * 
    */
    public void setFeedType(Integer feedType) {
        this.feedType = feedType;
    }
    /**
    * 获取: 详细内容
    */
    public String getContent() {
        return content;
    }
    /**
    * 设置: 详细内容
    * 
    */
    public void setContent(String content) {
        this.content = content;
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
    * 获取: 反馈时间
    */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    public Date getAddTime() {
        return addTime;
    }
    /**
    * 设置: 反馈时间
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


