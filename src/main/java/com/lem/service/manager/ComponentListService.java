package com.lem.service.manager;

import java.util.List;

import com.lem.service.model.ComponentList;

public interface ComponentListService {

	public List<ComponentList> getComponentListByProjectId(Long projectId);

	public void addComponentList(ComponentList componentList, Long projectId) throws Exception;

	public ComponentList getComponentListById(Long componentListId);

	public void updateComponentListById(ComponentList componentLists, Long projectId);
	
	public void updateComponentListStatus(Long id, Integer status);
	
	public Double getTotalProjectHours(Long projectId, int status);
	
	public Double getTotalProjectHoursByIds(Long[] selectedComponentIds);
	
	public List<ComponentList> getComponentsByProjectIdAndStatus(Long projectId, int status);

}
