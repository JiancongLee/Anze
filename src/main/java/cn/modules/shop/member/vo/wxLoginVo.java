package cn.modules.shop.member.vo;

import java.io.Serializable;

public class wxLoginVo implements Serializable {

	private String code;
	// 下面为userInfo
	/**
	 * 头像url
	 */
	private String avatarUrl;
	/**
	 * 国家
	 */
	private String country;
	/**
	 * 省份
	 */
	private String province;
	/**
	 * 城市
	 */
	private String city;
	/**
	 * 性别
	 */
	private Integer gender;
	/**
	 * 语言
	 */
	private String language;
	/**
	 * 昵称
	 */
	private String nickName;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}

	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
}
