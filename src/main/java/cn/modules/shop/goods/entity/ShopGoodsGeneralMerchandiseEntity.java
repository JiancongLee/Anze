package cn.modules.shop.goods.entity;

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
* 商品百货表 entity 对象实体类
*
* @author jianconglee
* @Date 2019-02-28 23:11:44
*/
@TableName("shop_goods_general_merchandise")
public class ShopGoodsGeneralMerchandiseEntity extends AbstractModel<ShopGoodsGeneralMerchandiseEntity> {
    private static final long serialVersionUID = 1L;
    /**
    * 主键
    */
    @Excel(name = "主键")
    @TableId(value ="id",type = IdType.ID_WORKER)
    private Long id;
    /**
    * 尺码
    */
    @Excel(name = "尺码")
    @TableField(value="size")
    private String size;
    /**
    * 颜色分类
    */
    @Excel(name = "颜色分类")
    @TableField(value="color")
    private String color;
    /**
    * 类型
    */
    @Excel(name = "类型")
    @TableField(value="type")
    private String type;
    /**
    * 数量
    */
    @Excel(name = "数量")
    @TableField(value="amount")
    private String amount;
    /**
    * 款式
    */
    @Excel(name = "款式")
    @TableField(value="style")
    private String style;
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
    * 获取: 尺码
    */
    public String getSize() {
        return size;
    }
    /**
    * 设置: 尺码
    * 
    */
    public void setSize(String size) {
        this.size = size;
    }
    /**
    * 获取: 颜色分类
    */
    public String getColor() {
        return color;
    }
    /**
    * 设置: 颜色分类
    * 
    */
    public void setColor(String color) {
        this.color = color;
    }
    /**
    * 获取: 类型
    */
    public String getType() {
        return type;
    }
    /**
    * 设置: 类型
    * 
    */
    public void setType(String type) {
        this.type = type;
    }
    /**
    * 获取: 数量
    */
    public String getAmount() {
        return amount;
    }
    /**
    * 设置: 数量
    * 
    */
    public void setAmount(String amount) {
        this.amount = amount;
    }
    /**
    * 获取: 款式
    */
    public String getStyle() {
        return style;
    }
    /**
    * 设置: 款式
    * 
    */
    public void setStyle(String style) {
        this.style = style;
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


