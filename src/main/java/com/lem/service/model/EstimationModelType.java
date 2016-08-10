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
@Table(name="estimation_model_type")
public class EstimationModelType extends BaseEntityAudit{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="name", unique=true)
	private String name;
	
	@Column(name="accuracy")
	private String accuracy;
	
	@Column(name="description")
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
