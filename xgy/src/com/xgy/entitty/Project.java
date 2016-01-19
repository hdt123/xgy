package com.xgy.entitty;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToMany;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * 项目entity
 * @author Administrator
 *
 */
@Entity
public class Project implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer projectId;
	private String projectName;
	private String projectDesc;
	private Integer pariseNum;                //该项目点赞次数
	private Integer projectNum;               //项目编号
	private Set<User>  users = new HashSet<User>(0);


	public Project() {
	}

	public Project(Integer projectNum) {
		this.projectNum = projectNum;
	}

	public Project(String projectName, String projectDesc, Integer pariseNum,
			Integer projectNum, Set<User> users) {
		this.projectName = projectName;
		this.projectDesc = projectDesc;
		this.pariseNum = pariseNum;
		this.projectNum = projectNum;
		this.users = users;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "projectId", unique = true, nullable = false)
	public Integer getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	@Column(name = "projectName")
	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Column(name = "projectDesc")
	public String getProjectDesc() {
		return this.projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	@Column(name = "pariseNum")
	public Integer getPariseNum() {
		return this.pariseNum;
	}

	public void setPariseNum(Integer pariseNum) {
		this.pariseNum = pariseNum;
	}

	@Column(name = "projectNum", nullable = false)
	public Integer getProjectNum() {
		return this.projectNum;
	}

	public void setProjectNum(Integer projectNum) {
		this.projectNum = projectNum;
	}

	@ManyToMany(mappedBy="projects",cascade=CascadeType.ALL)
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	

}