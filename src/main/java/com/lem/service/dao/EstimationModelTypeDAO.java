package com.lem.service.dao;

import java.util.List;

import com.lem.service.model.EstimationModelType;

/**
 * 
 * @author ukathinokkula
 *
 */
public interface EstimationModelTypeDAO {

	public List<EstimationModelType> getEstimationModelTypes();

	public void addEstimationModelType(EstimationModelType estimationModelType);

	public EstimationModelType getEstimationModelTypeById(Long estimationModelTypeId);

	public void updateEstimationModelType(EstimationModelType estimationModelType);
	
	public List<EstimationModelType> getActiveEstimationModelTypes();

}
