package com.xgy.entitty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Parise entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "parise", catalog = "xgy")
public class Parise implements java.io.Serializable {

	// Fields

	private Integer praiseId;
	private Project project;
	private User user;
	private String praiseDate;

	// Constructors

	/** default constructor */
	public Parise() {
	}

	/** minimal constructor */
	public Parise(Project project, User user) {
		this.project = project;
		this.user = user;
	}

	/** full constructor */
	public Parise(Project project, User user, String praiseDate) {
		this.project = project;
		this.user = user;
		this.praiseDate = praiseDate;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "praiseId", unique = true, nullable = false)
	public Integer getPraiseId() {
		return this.praiseId;
	}

	public void setPraiseId(Integer praiseId) {
		this.praiseId = praiseId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "projectId", nullable = false)
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "praiseDate")
	public String getPraiseDate() {
		return this.praiseDate;
	}

	public void setPraiseDate(String praiseDate) {
		this.praiseDate = praiseDate;
	}

}