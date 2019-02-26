package cn.modules.shop.address.entity;

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
* 收货地址表 entity 对象实体类
*
* @author jianconglee
* @Date 2019-02-21 12:53:46
*/
@TableName("shop_address")
public class ShopAddressEntity extends AbstractModel<ShopAddressEntity> {
    private static final long serialVersionUID = 1L;
    /**
    * 主键
    */
    @Excel(name = "主键")
    @TableId(value="id")
    private Long id;
    /**
    * 会员ID
    */
    @Excel(name = "会员ID")
    @TableField(value="member_id")
    private Long memberId;
    /**
    * 收货人姓名
    */
    @Excel(name = "收货人姓名")
    @TableField(value="user_name")
    private String userName;
    /**
    * 手机
    */
    @Excel(name = "手机")
    @TableField(value="tel_number")
    private String telNumber;
    /**
    * 邮编
    */
    @Excel(name = "邮编")
    @TableField(value="postal_Code")
    private String postalCode;
    /**
    * 省
    */
    @Excel(name = "省")
    @TableField(value="province_Name")
    private String provinceName;
    /**
    * 市
    */
    @Excel(name = "市")
    @TableField(value="city_Name")
    private String cityName;
    /**
    * 区
    */
    @Excel(name = "区")
    @TableField(value="county_Name")
    private String countyName;
    /**
    * 详细收货地址信息
    */
    @Excel(name = "详细收货地址信息")
    @TableField(value="detail_Info")
    private String detailInfo;
    /**
     * 是否为默认地址:0不是 1是
     */
    @Excel(name = "是否为默认地址")
    @TableField(value="is_default")
    private Integer isDefault;
    /**
     * 创建时间
     */
    @Excel(name = "创建时间",exportFormat = "yyyy-MM-dd HH:mm:ss")
    @TableField(value="create_time")
    private Date createTime;
    /**
     * 更新时间
     */
    @Excel(name = "更新时间",exportFormat = "yyyy-MM-dd HH:mm:ss")
    @TableField(value="update_time")
    private Date updateTime;


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
    * 获取: 会员ID
    */
    public Long getMemberId() {
        return memberId;
    }
    /**
    * 设置: 会员ID
    * 
    */
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
    /**
    * 获取: 收货人姓名
    */
    public String getUserName() {
        return userName;
    }
    /**
    * 设置: 收货人姓名
    * 
    */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    /**
    * 获取: 手机
    */
    public String getTelNumber() {
        return telNumber;
    }
    /**
    * 设置: 手机
    * 
    */
    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }
    /**
    * 获取: 邮编
    */
    public String getPostalCode() {
        return postalCode;
    }
    /**
    * 设置: 邮编
    * 
    */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    /**
    * 获取: 省
    */
    public String getProvinceName() {
        return provinceName;
    }
    /**
    * 设置: 省
    * 
    */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }
    /**
    * 获取: 市
    */
    public String getCityName() {
        return cityName;
    }
    /**
    * 设置: 市
    * 
    */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    /**
    * 获取: 区
    */
    public String getCountyName() {
        return countyName;
    }
    /**
    * 设置: 区
    * 
    */
    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }
    /**
    * 获取: 详细收货地址信息
    */
    public String getDetailInfo() {
        return detailInfo;
    }
    /**
    * 设置: 详细收货地址信息
    * 
    */
    public void setDetailInfo(String detailInfo) {
        this.detailInfo = detailInfo;
    }
    /**
     * 获取: 是否为默认地址
     */
    public Integer getIsDefault() {
        return isDefault;
    }
    /**
     * 设置: 是否为默认地址
     *
     */
    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }
    /**
     * 获取: 创建时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    public Date getCreateTime() {
        return createTime;
    }
    /**
     * 设置: 创建时间
     *
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    /**
     * 获取: 更新时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    public Date getUpdateTime() {
        return updateTime;
    }
    /**
     * 设置: 更新时间
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


