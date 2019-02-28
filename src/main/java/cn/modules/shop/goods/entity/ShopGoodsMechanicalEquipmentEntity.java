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
* 商品器械设备表 entity 对象实体类
*
* @author jianconglee
* @Date 2019-02-28 23:11:49
*/
@TableName("shop_goods_mechanical_equipment")
public class ShopGoodsMechanicalEquipmentEntity extends AbstractModel<ShopGoodsMechanicalEquipmentEntity> {
    private static final long serialVersionUID = 1L;
    /**
    * 主键
    */
    @Excel(name = "主键")
    @TableId(value ="id",type = IdType.ID_WORKER)
    private Long id;
    /**
    * 型号
    */
    @Excel(name = "型号")
    @TableField(value="model")
    private String model;
    /**
    * 保修期
    */
    @Excel(name = "保修期")
    @TableField(value="defects_liability_period")
    private String defectsLiabilityPeriod;
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
    * 获取: 型号
    */
    public String getModel() {
        return model;
    }
    /**
    * 设置: 型号
    * 
    */
    public void setModel(String model) {
        this.model = model;
    }
    /**
    * 获取: 保修期
    */
    public String getDefectsLiabilityPeriod() {
        return defectsLiabilityPeriod;
    }
    /**
    * 设置: 保修期
    * 
    */
    public void setDefectsLiabilityPeriod(String defectsLiabilityPeriod) {
        this.defectsLiabilityPeriod = defectsLiabilityPeriod;
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


