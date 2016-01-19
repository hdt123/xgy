package com.xgy.entitty;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "xgy")
public class User implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String nickName;
	private String openId;
	private Short gender;
	private String country;
	private String headImageUrl;
	private Integer goodNum;
	private Integer shareNum;
	private Set<Parise> parises = new HashSet<Parise>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String nickName, String openId) {
		this.nickName = nickName;
		this.openId = openId;
	}

	/** full constructor */
	public User(String nickName, String openId, Short gender, String country,
			String headImageUrl, Integer goodNum, Integer shareNum,
			Set<Parise> parises) {
		this.nickName = nickName;
		this.openId = openId;
		this.gender = gender;
		this.country = country;
		this.headImageUrl = headImageUrl;
		this.goodNum = goodNum;
		this.shareNum = shareNum;
		this.parises = parises;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "userId", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "nickName", nullable = false)
	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Column(name = "openId", nullable = false)
	public String getOpenId() {
		return this.openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	@Column(name = "gender")
	public Short getGender() {
		return this.gender;
	}

	public void setGender(Short gender) {
		this.gender = gender;
	}

	@Column(name = "country")
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "headImageUrl")
	public String getHeadImageUrl() {
		return this.headImageUrl;
	}

	public void setHeadImageUrl(String headImageUrl) {
		this.headImageUrl = headImageUrl;
	}

	@Column(name = "goodNum")
	public Integer getGoodNum() {
		return this.goodNum;
	}

	public void setGoodNum(Integer goodNum) {
		this.goodNum = goodNum;
	}

	@Column(name = "shareNum")
	public Integer getShareNum() {
		return this.shareNum;
	}

	public void setShareNum(Integer shareNum) {
		this.shareNum = shareNum;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Parise> getParises() {
		return this.parises;
	}

	public void setParises(Set<Parise> parises) {
		this.parises = parises;
	}

}