package cn.modules.shop.member.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.base.AbstractModel;
import cn.hutool.core.lang.Console;
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

import javax.xml.crypto.Data;

/**
* 会员管理表 entity 对象实体类
*
* @author jianconglee
* @Date 2019-02-19 23:08:44
*/
@TableName("shop_member")
public class ShopMemberEntity extends AbstractModel<ShopMemberEntity> {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Excel(name = "主键")
    @TableId(value ="id",type = IdType.ID_WORKER)
    private Long id;
    /**
     * 微信openId
     */
    @Excel(name = "微信openId")
    @TableField(value="weixin_open_id")
    private String weixinOpenId;
    /**
     * 会员名称
     */
    @Excel(name = "会员名称")
    @TableField(value="user_name")
    private String userName;
    /**
     * 会员昵称
     */
    @Excel(name = "会员昵称")
    @TableField(value="nick_name")
    private String nickName;
    /**
     * 会员密码
     */
    @Excel(name = "会员密码")
    @TableField(value="password")
    private String password;
    /**
     * 状态：0可用
     */
    @Excel(name = "状态：0可用")
    @TableField(value="status")
    private Integer status;
    /**
     * 头像
     */
    @Excel(name = "头像")
    @TableField(value="avatar")
    private String avatar;
    /**
     * 性别：0男，1女，2保密
     */
    @Excel(name = "性别：0男，1女，2保密")
    @TableField(value="gender")
    private Integer gender;
    /**
     * 用户电话
     */
    @Excel(name = "用户电话")
    @TableField(value="mobile")
    private String mobile;
    /**
     * 国家
     */
    @Excel(name = "国家")
    @TableField(value="country")
    private String country;
    /**
     * 省份
     */
    @Excel(name = "省份")
    @TableField(value="province")
    private String province;
    /**
     * 城市
     */
    @Excel(name = "城市")
    @TableField(value="city")
    private String city;
    /**
     * 生日
     */
    @Excel(name = "生日",exportFormat = "yyyy-MM-dd HH:mm:ss")
    @TableField(value="birthday")
    private Date birthday;
    /**
     * 语言
     */
    @Excel(name = "语言")
    @TableField(value="language")
    private String language;
    /**
     * 会员等级:0普通用户 1VIP用户 2高级VIP用户
     */
    @Excel(name = "会员等级:0普通用户 1VIP用户 2高级VIP用户")
    @TableField(value="member_level_code")
    private Integer memberLevelCode;
    /**
     * 注册时间
     */
    @Excel(name = "注册时间",exportFormat = "yyyy-MM-dd HH:mm:ss")
    @TableField(value="register_time")
    private Date registerTime;
    /**
     * 最后登陆时间
     */
    @Excel(name = "最后登陆时间",exportFormat = "yyyy-MM-dd HH:mm:ss")
    @TableField(value="last_login_time")
    private Date lastLoginTime;
    /**
     * 最后登陆ip
     */
    @Excel(name = "最后登陆ip")
    @TableField(value="last_login_ip")
    private String lastLoginIp;
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
     * 获取: 微信openId
     */
    public String getWeixinOpenId() {
        return weixinOpenId;
    }
    /**
     * 设置: 微信openId
     *
     */
    public void setWeixinOpenId(String weixinOpenId) {
        this.weixinOpenId = weixinOpenId;
    }
    /**
     * 获取: 会员名称
     */
    public String getUserName() {
        return userName;
    }
    /**
     * 设置: 会员名称
     *
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    /**
     * 获取: 会员昵称
     */
    public String getNickName() {
        return nickName;
    }
    /**
     * 设置: 会员昵称
     *
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    /**
     * 获取: 会员密码
     */
    public String getPassword() {
        return password;
    }
    /**
     * 设置: 会员密码
     *
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * 获取: 状态：0可用
     */
    public Integer getStatus() {
        return status;
    }
    /**
     * 设置: 状态：0可用
     * 状态：0可用, 1禁用, 2注销
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
    /**
     * 获取: 头像
     */
    public String getAvatar() {
        return avatar;
    }
    /**
     * 设置: 头像
     *
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    /**
     * 获取: 性别：0男，1女，2保密
     */
    public Integer getGender() {
        return gender;
    }
    /**
     * 设置: 性别：0男，1女，2保密
     *
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }
    /**
     * 获取: 用户电话
     */
    public String getMobile() {
        return mobile;
    }
    /**
     * 设置: 用户电话
     *
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    /**
     * 获取: 国家
     */
    public String getCountry() {
        return country;
    }
    /**
     * 设置: 国家
     *
     */
    public void setCountry(String country) {
        this.country = country;
    }
    /**
     * 获取: 省份
     */
    public String getProvince() {
        return province;
    }
    /**
     * 设置: 省份
     *
     */
    public void setProvince(String province) {
        this.province = province;
    }
    /**
     * 获取: 城市
     */
    public String getCity() {
        return city;
    }
    /**
     * 设置: 城市
     *
     */
    public void setCity(String city) {
        this.city = city;
    }
    /**
     * 获取: 生日
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    public Date getBirthday() {
        return birthday;
    }
    /**
     * 设置: 生日
     *
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    /**
     * 获取: 语言
     */
    public String getLanguage() {
        return language;
    }
    /**
     * 设置: 语言
     *
     */
    public void setLanguage(String language) {
        this.language = language;
    }
    /**
     * 获取: 会员等级:0普通用户 1VIP用户 2高级VIP用户
     */
    public Integer getMemberLevelCode() {
        return memberLevelCode;
    }
    /**
     * 设置: 会员等级:0普通用户 1VIP用户 2高级VIP用户
     *
     */
    public void setMemberLevelCode(Integer memberLevelCode) {
        this.memberLevelCode = memberLevelCode;
    }
    /**
     * 获取: 注册时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    public Date getRegisterTime() {
        return registerTime;
    }
    /**
     * 设置: 注册时间
     *
     */
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }
    /**
     * 获取: 最后登陆时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    public Date getLastLoginTime() {
        return lastLoginTime;
    }
    /**
     * 设置: 最后登陆时间
     *
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
    /**
     * 获取: 最后登陆ip
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }
    /**
     * 设置: 最后登陆ip
     *
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
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
        this.registerTime = date;
        this.lastLoginTime = date;
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


