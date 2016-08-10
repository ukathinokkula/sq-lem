package com.lem.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * @author ukathinokkula
 *
 */
@Entity
@Table(name="project_details")
public class ProjectDetails extends BaseEntityAudit{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="name", unique=true)
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="client")
	private String client;
	
	@Column(name="country")
	private String country;
	
	@Transient
	private Double totalProjectHours;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Double getTotalProjectHours() {
		return totalProjectHours;
	}

	public void setTotalProjectHours(Double totalProjectHours) {
		this.totalProjectHours = totalProjectHours;
	}
	
}
