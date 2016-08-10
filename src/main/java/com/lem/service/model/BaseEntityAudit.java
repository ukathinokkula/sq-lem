package com.lem.service.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Base Entity Audit
 * 
 * @author Umas shankar K
 */
@MappedSuperclass
public abstract class BaseEntityAudit extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Column(name = "created_by", length = 100)
	private String createdBy;

	@Column(name = "updated_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	@Column(name = "updated_by", length = 100)
	private String updatedBy;
	
	@Column(name="status")
	private int status;

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public void setCreationBy() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName(); // get logged in username
		this.createdBy = userName;
	}
	
	public void setChangedBy() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName(); // get logged in username
		this.updatedBy = userName;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * Sets createdAt before insert
	 */
	@PrePersist
	public void setCreationDate() {
		this.createdDate = new Date();
	}

	/**
	 * Sets updatedAt before update
	 */
	@PreUpdate
	public void setChangeDate() {
		this.updatedDate = new Date();
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
