package cn.modules.shop.specification.entity;

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
* 商品规格表 entity 对象实体类
*
* @author jianconglee
* @Date 2019-02-21 21:02:04
*/
@TableName("shop_specification")
public class ShopSpecificationEntity extends AbstractModel<ShopSpecificationEntity> {
    private static final long serialVersionUID = 1L;
    /**
    * 主键
    */
    @Excel(name = "主键")
    @TableId(value="id")
    private Long id;
    /**
    * 规范名称
    */
    @Excel(name = "规范名称")
    @TableField(value="name")
    private String name;
    /**
    * 排序
    */
    @Excel(name = "排序")
    @TableField(value="sort_order")
    private Integer sortOrder;
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
    * 获取: 规范名称
    */
    public String getName() {
        return name;
    }
    /**
    * 设置: 规范名称
    * 
    */
    public void setName(String name) {
        this.name = name;
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


