package com.lem.service.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="lemusers")
public class User extends BaseEntityAudit{
	
	private static final long serialVersionUID = 1L;

	@Column(name="username", unique=true)
	@NotEmpty(message="Username should not be empty")
	@Email(message="Username must be in a email format")
	private String username;
	
	@Column(name="password")
	@NotEmpty(message="Password should not be empty")
	private String password;

	@Column(name="role_name")
	private String roleName;
	
	@Transient
	private String confirmPassword;
	
	@Column(name = "last_logindate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLoginDate;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

}
