package cn.modules.shop.searchHistory.entity;

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
* 会员搜索历史 entity 对象实体类
*
* @author jianconglee
* @Date 2019-02-21 11:52:35
*/
@TableName("shop_search_history")
public class ShopSearchHistoryEntity extends AbstractModel<ShopSearchHistoryEntity> {
    private static final long serialVersionUID = 1L;
    /**
    * 主键
    */
    @Excel(name = "主键")
    @TableId(value="id")
    private Long id;
    /**
    * 关键字
    */
    @Excel(name = "关键字")
    @TableField(value="keyword")
    private String keyword;
    /**
    * 搜索时间
    */
    @Excel(name = "搜索时间",exportFormat = "yyyy-MM-dd HH:mm:ss")
    @TableField(value="create_time")
    private Date createTime;
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
    * 获取: 关键字
    */
    public String getKeyword() {
        return keyword;
    }
    /**
    * 设置: 关键字
    * 
    */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    /**
    * 获取: 搜索时间
    */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    public Date getCreateTime() {
        return createTime;
    }
    /**
    * 设置: 搜索时间
    * 
    */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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


