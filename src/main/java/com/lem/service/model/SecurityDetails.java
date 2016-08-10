package com.lem.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="security_details")
public class SecurityDetails extends BaseEntityAudit{
	
	private static final long serialVersionUID = 1L;

	@Column(name="full_name")
	private String fullName;
	
	@Column(name="security_id")
	private String securityId;
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getSecurityId() {
		return securityId;
	}

	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}

}
