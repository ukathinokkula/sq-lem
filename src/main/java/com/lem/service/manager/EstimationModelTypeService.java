package com.lem.service.manager;

import java.util.List;

import com.lem.service.model.EstimationModelType;

public interface EstimationModelTypeService {

	public List<EstimationModelType> getEstimationModelTypes();

	public void addEstimationModelType(EstimationModelType estimationModelType)	throws Exception;

	public EstimationModelType getEstimationModelTypeById(Long estimationModelTypeId);

	public void updateEstimationModelTypeById(EstimationModelType estimationModelTypes);
	
	public List<EstimationModelType> getActiveEstimationModelTypes();

}
