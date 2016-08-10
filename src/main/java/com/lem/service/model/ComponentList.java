package com.lem.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * @author ukathinokkula
 *
 */
@Entity
@Table(name="component_list")
public class ComponentList extends BaseEntityAudit{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="name")
	private String name;	
	
	@Column(name="description")
	private String description;	
	
	/*@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", insertable = false, updatable = false)
	@Fetch(value = FetchMode.JOIN)*/
	
	@ManyToOne
	@JoinColumn(name="project_id")
	private ProjectDetails projectDetails;
	
	@Column(name="technology")
	private String technology;
	
	@Column(name="new_component")
	private Integer newComponent;
	
	@ManyToOne
	@JoinColumn(name="estimation_model_type")
	private EstimationModelType estimationModelType;
	
	@Column(name="accuracy")
	private String accuracy;
	
	@Column(name="total_hours")
	private Double totalHours;
	
	@Column(name="component_count")
	private Integer componentCount;
	
	@Column(name="weightage")
	private Double weightage;
	
	/*@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "complexity_type", insertable = false, updatable = false)
	@Fetch(value = FetchMode.JOIN)*/	
	
	@ManyToOne
	@JoinColumn(name="complexity_type")
	private ComplexityType complexityType;
	
	@Transient
	private Long[] selectedActiveComponentIds;
	
	@Transient
	private Long[] selectedInactiveComponentIds;
	
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

	public ComplexityType getComplexityType() {
		return complexityType;
	}

	public void setComplexityType(ComplexityType complexityType) {
		this.complexityType = complexityType;
	}

	public ProjectDetails getProjectDetails() {
		return projectDetails;
	}

	public void setProjectDetails(ProjectDetails projectDetails) {
		this.projectDetails = projectDetails;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public Integer getNewComponent() {
		return newComponent;
	}

	public void setNewComponent(Integer newComponent) {
		this.newComponent = newComponent;
	}

	
	public EstimationModelType getEstimationModelType() {
		return estimationModelType;
	}

	public void setEstimationModelType(EstimationModelType estimationModelType) {
		this.estimationModelType = estimationModelType;
	}

	public String getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}

	public Double getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(Double totalHours) {
		this.totalHours = totalHours;
	}

	public Integer getComponentCount() {
		return componentCount;
	}

	public void setComponentCount(Integer componentCount) {
		this.componentCount = componentCount;
	}

	public Double getWeightage() {
		return weightage;
	}

	public void setWeightage(Double weightage) {
		this.weightage = weightage;
	}

	public Long[] getSelectedActiveComponentIds() {
		return selectedActiveComponentIds;
	}

	public void setSelectedActiveComponentIds(Long[] selectedActiveComponentIds) {
		this.selectedActiveComponentIds = selectedActiveComponentIds;
	}

	public Long[] getSelectedInactiveComponentIds() {
		return selectedInactiveComponentIds;
	}

	public void setSelectedInactiveComponentIds(Long[] selectedInactiveComponentIds) {
		this.selectedInactiveComponentIds = selectedInactiveComponentIds;
	}

}
