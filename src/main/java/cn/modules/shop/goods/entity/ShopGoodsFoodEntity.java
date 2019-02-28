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
* 商品食品表 entity 对象实体类
*
* @author jianconglee
* @Date 2019-02-28 23:07:20
*/
@TableName("shop_goods_food")
public class ShopGoodsFoodEntity extends AbstractModel<ShopGoodsFoodEntity> {
    private static final long serialVersionUID = 1L;
    /**
    * 主键
    */
    @Excel(name = "主键")
    @TableId(value ="id",type = IdType.ID_WORKER)
    private Long id;
    /**
    * 净含量
    */
    @Excel(name = "净含量")
    @TableField(value="net_weight")
    private String netWeight;
    /**
    * 包装方式
    */
    @Excel(name = "包装方式")
    @TableField(value="packaging_method")
    private String packagingMethod;
    /**
    * 保质期
    */
    @Excel(name = "保质期")
    @TableField(value="quality_guarantee_period")
    private String qualityGuaranteePeriod;
    /**
    * 系列
    */
    @Excel(name = "系列")
    @TableField(value="series")
    private String series;
    /**
    * 存储方法
    */
    @Excel(name = "存储方法")
    @TableField(value="storage_method")
    private String storageMethod;
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
    * 获取: 净含量
    */
    public String getNetWeight() {
        return netWeight;
    }
    /**
    * 设置: 净含量
    * 
    */
    public void setNetWeight(String netWeight) {
        this.netWeight = netWeight;
    }
    /**
    * 获取: 包装方式
    */
    public String getPackagingMethod() {
        return packagingMethod;
    }
    /**
    * 设置: 包装方式
    * 
    */
    public void setPackagingMethod(String packagingMethod) {
        this.packagingMethod = packagingMethod;
    }
    /**
    * 获取: 保质期
    */
    public String getQualityGuaranteePeriod() {
        return qualityGuaranteePeriod;
    }
    /**
    * 设置: 保质期
    * 
    */
    public void setQualityGuaranteePeriod(String qualityGuaranteePeriod) {
        this.qualityGuaranteePeriod = qualityGuaranteePeriod;
    }
    /**
    * 获取: 系列
    */
    public String getSeries() {
        return series;
    }
    /**
    * 设置: 系列
    * 
    */
    public void setSeries(String series) {
        this.series = series;
    }
    /**
    * 获取: 存储方法
    */
    public String getStorageMethod() {
        return storageMethod;
    }
    /**
    * 设置: 存储方法
    * 
    */
    public void setStorageMethod(String storageMethod) {
        this.storageMethod = storageMethod;
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


