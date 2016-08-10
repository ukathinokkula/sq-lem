package com.lem.service.dao;

import java.util.List;

import com.lem.service.model.ComponentList;

/**
 * 
 * @author ukathinokkula
 *
 */
public interface ComponentListDAO {

	public List<ComponentList> loadComponentListsByProjectId(Long projectId);

	public void addComponentList(ComponentList componentList);

	public ComponentList loadComponentListById(Long componentListId);

	public void updateComponentList(ComponentList componentList);
	
	public Double loadTotalProjectHours(Long projectId, int status);
	
	public Double loadTotalProjectHoursByIds(Long[] selectedComponentIds);
	
	public List<ComponentList> loadComponentsByProjectIdAndStatus(Long projectId, int status);

}
