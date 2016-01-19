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
 * Project entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "project", catalog = "xgy")
public class Project implements java.io.Serializable {

	// Fields

	private Integer projectId;
	private String projectName;
	private String projectDesc;
	private Integer pariseNum;
	private Integer projectNum;
	private Set<Parise> parises = new HashSet<Parise>(0);

	// Constructors

	/** default constructor */
	public Project() {
	}

	/** minimal constructor */
	public Project(Integer projectNum) {
		this.projectNum = projectNum;
	}

	/** full constructor */
	public Project(String projectName, String projectDesc, Integer pariseNum,
			Integer projectNum, Set<Parise> parises) {
		this.projectName = projectName;
		this.projectDesc = projectDesc;
		this.pariseNum = pariseNum;
		this.projectNum = projectNum;
		this.parises = parises;
	}

	// Property accessors
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "project")
	public Set<Parise> getParises() {
		return this.parises;
	}

	public void setParises(Set<Parise> parises) {
		this.parises = parises;
	}

}