package com.lem.service.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lem.service.dao.ComplexityTypeDAO;
import com.lem.service.dao.ComponentListDAO;
import com.lem.service.dao.EstimationModelTypeDAO;
import com.lem.service.dao.ProjectDetailsDAO;
import com.lem.service.manager.ComponentListService;
import com.lem.service.model.ComplexityType;
import com.lem.service.model.ComponentList;
import com.lem.service.model.EstimationModelType;
import com.lem.service.model.ProjectDetails;

/**
 * 
 * @author ukathinokkula
 *
 */
@Service
public class ComponentListServiceImpl implements ComponentListService {

	@Autowired
	protected ComponentListDAO componentListDAO;
	
	@Autowired
	protected ComplexityTypeDAO complexityTypeDAO;
	
	@Autowired
	protected ProjectDetailsDAO projectDetailsDAO;
	
	@Autowired
	protected EstimationModelTypeDAO estimationModelTypeDAO;

	public List<ComponentList> getComponentListByProjectId(Long projectId) {
		List<ComponentList> componentListList = componentListDAO
				.loadComponentListsByProjectId(projectId);
		return componentListList;
	}

	public void addComponentList(ComponentList componentList, Long projectId)
			throws Exception {
		componentList.setCreationDate();
		componentList.setCreationBy();
		ComplexityType ct = complexityTypeDAO.getComplexityTypeById(componentList.getComplexityType().getId());
		componentList.setComplexityType(ct);
		
		ProjectDetails pd = projectDetailsDAO.getProjectDetailsById(projectId);
		componentList.setProjectDetails(pd);
		
		EstimationModelType emt = estimationModelTypeDAO.getEstimationModelTypeById(componentList.getEstimationModelType().getId());
		componentList.setEstimationModelType(emt);
		
		componentListDAO.addComponentList(componentList);

	}

	public void updateComponentListById(ComponentList cType, Long projectId) {
		ComponentList componentList = componentListDAO.loadComponentListById(cType.getId());
		componentList.setName(cType.getName());
		componentList.setDescription(cType.getDescription());
		componentList.setTechnology(cType.getTechnology());
		componentList.setWeightage(cType.getWeightage());
		componentList.setNewComponent(cType.getNewComponent());
		componentList.setEstimationModelType(cType.getEstimationModelType());
		componentList.setAccuracy(cType.getAccuracy());
		if (null != cType.getTotalHours()) {
			componentList.setTotalHours(cType.getTotalHours());
		}
		componentList.setChangedBy();
		componentList.setChangeDate();;
		componentList.setComponentCount(cType.getComponentCount());
		componentList.setProjectDetails(cType.getProjectDetails());
		componentList.setId(cType.getId());
		
		ComplexityType ct = complexityTypeDAO.getComplexityTypeById(cType.getComplexityType().getId());
		componentList.setComplexityType(ct);
		
		ProjectDetails pd = projectDetailsDAO.getProjectDetailsById(projectId);
		componentList.setProjectDetails(pd);
		
		EstimationModelType emt = estimationModelTypeDAO.getEstimationModelTypeById(componentList.getEstimationModelType().getId());
		componentList.setEstimationModelType(emt);
		
		componentListDAO.updateComponentList(componentList);
	}

	public void updateComponentListStatus(Long id, Integer status) {

		ComponentList componentList = componentListDAO
				.loadComponentListById(id);
		componentList.setStatus(status);
		componentListDAO.updateComponentList(componentList);
	}
	
	public ComponentList getComponentListById(Long componentId) {
		ComponentList componentList = componentListDAO.loadComponentListById(componentId);
		return componentList;
	}
	
	public Double getTotalProjectHours(Long projectId, int status) {
		return componentListDAO.loadTotalProjectHours(projectId, status);
	}
	
	public Double getTotalProjectHoursByIds(Long[] selectedComponentIds) {
		return componentListDAO.loadTotalProjectHoursByIds(selectedComponentIds);
	}
	
	public List<ComponentList> getComponentsByProjectIdAndStatus(Long projectId, int status) {
		List<ComponentList> componentListList = componentListDAO
				.loadComponentsByProjectIdAndStatus(projectId, status);
		return componentListList;
	}

}
