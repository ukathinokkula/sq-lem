package com.lem.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author ukathinokkula
 *
 */
@Entity
@Table(name="complexity_type")
public class ComplexityType extends BaseEntityAudit{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="complexity_type", unique=true)
	private String complexityType;
	
	@Column(name="hours")
	private Double hours;	
	
	@Column(name="description")
	private String description;
	
	@Column(name="existing_component_ratio")
	private Double existingComponentRatio;

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getComplexityType() {
		return complexityType;
	}

	public void setComplexityType(String complexityType) {
		this.complexityType = complexityType;
	}

	public Double getHours() {
		return hours;
	}

	public void setHours(Double hours) {
		this.hours = hours;
	}

	public Double getExistingComponentRatio() {
		return existingComponentRatio;
	}

	public void setExistingComponentRatio(Double existingComponentRatio) {
		this.existingComponentRatio = existingComponentRatio;
	}

}
