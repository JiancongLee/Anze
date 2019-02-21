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
    @TableId(value="id")
    private Long id;
    /**
    * 会员名称
    */
    @Excel(name = "会员名称")
    @TableField(value="username")
    private String username;
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
    * 性别
    */
    @Excel(name = "性别")
    @TableField(value="gender")
    private Integer gender;
    /**
    * 生日
    */
    @Excel(name = "生日",exportFormat = "yyyy-MM-dd HH:mm:ss")
    @TableField(value="birthday")
    private Date birthday;
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
    * 会员等级code
    */
    @Excel(name = "会员等级code")
    @TableField(value="user_level_code")
    private Integer userLevelCode;
    /**
    * 会员昵称
    */
    @Excel(name = "会员昵称")
    @TableField(value="nickname")
    private String nickname;
    /**
    * 用户电话
    */
    @Excel(name = "用户电话")
    @TableField(value="mobile")
    private String mobile;
    /**
    * 头像
    */
    @Excel(name = "头像")
    @TableField(value="avatar")
    private String avatar;
    /**
    * 微信id
    */
    @Excel(name = "微信id")
    @TableField(value="weixin_openid")
    private String weixinOpenid;
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
    * 获取: 会员名称
    */
    public String getUsername() {
        return username;
    }
    /**
    * 设置: 会员名称
    * 
    */
    public void setUsername(String username) {
        this.username = username;
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
    * 获取: 性别
    */
    public Integer getGender() {
        return gender;
    }
    /**
    * 设置: 性别
    * 
    */
    public void setGender(Integer gender) {
        this.gender = gender;
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
    /**
    * 获取: 会员等级code
    */
    public Integer getUserLevelCode() {
        return userLevelCode;
    }
    /**
    * 设置: 会员等级code
    * 
    */
    public void setUserLevelCode(Integer userLevelCode) {
        this.userLevelCode = userLevelCode;
    }
    /**
    * 获取: 会员昵称
    */
    public String getNickname() {
        return nickname;
    }
    /**
    * 设置: 会员昵称
    * 
    */
    public void setNickname(String nickname) {
        this.nickname = nickname;
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
    * 获取: 微信id
    */
    public String getWeixinOpenid() {
        return weixinOpenid;
    }
    /**
    * 设置: 微信id
    * 
    */
    public void setWeixinOpenid(String weixinOpenid) {
        this.weixinOpenid = weixinOpenid;
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
    }
    @Override
    public void preUpdate() {

    }
    @JSONField(serialize = false)
    @Override
    public boolean getIsNewRecord() {
        System.out.println(getId());
        return isNewRecord || getId() == null;

    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}


