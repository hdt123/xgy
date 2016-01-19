package com.xgy.entitty;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 用户表
 * @author Administrator
 *
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Integer userId;
	private String nickName;   //昵称
	private String openId;    //openId
	private Short gender;     //性别	
	private String country;    //国家
	private String headImageUrl;     //头像地址
	private Integer goodNum;         //点赞数量
	private Integer shareNum;         //分享次数
	private Set<Project> projects = new HashSet<Project>(0);        //点赞


	public User() {
	}

	public User(String nickName, String openId) {
		this.nickName = nickName;
		this.openId = openId;
	}

	public User(String nickName, String openId, Short gender, String country,
			String headImageUrl, Integer goodNum, Integer shareNum,
			Set<Project> projects) {
		this.nickName = nickName;
		this.openId = openId;
		this.gender = gender;
		this.country = country;
		this.headImageUrl = headImageUrl;
		this.goodNum = goodNum;
		this.shareNum = shareNum;
		this.projects = projects;
	}

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

   
   /* @JoinTable(name="user_role",
    			joinColumns=@JoinColumn
           inverseJoinColumns=@JoinColumn(name="role_id")
    )*/
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="parise") 
	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	

}