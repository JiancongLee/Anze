package cn.modules.shop.keywords.entity;

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
* 商品关键词表 entity 对象实体类
*
* @author jianconglee
* @Date 2019-02-21 22:50:43
*/
@TableName("shop_keywords")
public class ShopKeywordsEntity extends AbstractModel<ShopKeywordsEntity> {
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
    * 热销
    */
    @Excel(name = "热销")
    @TableField(value="is_hot")
    private Integer isHot;
    /**
    * 默认
    */
    @Excel(name = "默认")
    @TableField(value="is_default")
    private Integer isDefault;
    /**
    * 显示
    */
    @Excel(name = "显示")
    @TableField(value="is_show")
    private Integer isShow;
    /**
    * 排序
    */
    @Excel(name = "排序")
    @TableField(value="sort_order")
    private Integer sortOrder;
    /**
    * 关键词的跳转链接
    */
    @Excel(name = "关键词的跳转链接")
    @TableField(value="scheme_url")
    private String schemeUrl;
    /**
    * 类型
    */
    @Excel(name = "类型")
    @TableField(value="type")
    private Integer type;
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
    * 获取: 热销
    */
    public Integer getIsHot() {
        return isHot;
    }
    /**
    * 设置: 热销
    * 
    */
    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }
    /**
    * 获取: 默认
    */
    public Integer getIsDefault() {
        return isDefault;
    }
    /**
    * 设置: 默认
    * 
    */
    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }
    /**
    * 获取: 显示
    */
    public Integer getIsShow() {
        return isShow;
    }
    /**
    * 设置: 显示
    * 
    */
    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }
    /**
    * 获取: 排序
    */
    public Integer getSortOrder() {
        return sortOrder;
    }
    /**
    * 设置: 排序
    * 
    */
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }
    /**
    * 获取: 关键词的跳转链接
    */
    public String getSchemeUrl() {
        return schemeUrl;
    }
    /**
    * 设置: 关键词的跳转链接
    * 
    */
    public void setSchemeUrl(String schemeUrl) {
        this.schemeUrl = schemeUrl;
    }
    /**
    * 获取: 类型
    */
    public Integer getType() {
        return type;
    }
    /**
    * 设置: 类型
    * 
    */
    public void setType(Integer type) {
        this.type = type;
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


