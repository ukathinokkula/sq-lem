package com.lem.service.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lem.service.dao.EstimationModelTypeDAO;
import com.lem.service.manager.EstimationModelTypeService;
import com.lem.service.model.EstimationModelType;

/**
 * 
 * @author ukathinokkula
 *
 */
@Service
public class EstimationModelTypeServiceImpl implements
		EstimationModelTypeService {

	@Autowired
	protected EstimationModelTypeDAO estimationModelTypeDao;

	public List<EstimationModelType> getEstimationModelTypes() {
		List<EstimationModelType> estimationModelTypeList = estimationModelTypeDao
				.getEstimationModelTypes();
		return estimationModelTypeList;
	}

	public List<EstimationModelType> getActiveEstimationModelTypes() {
		List<EstimationModelType> estimationModelTypeList = estimationModelTypeDao
				.getActiveEstimationModelTypes();
		return estimationModelTypeList;
	}
	public void addEstimationModelType(EstimationModelType estimationModelType)
			throws Exception {
		estimationModelType.setCreationBy();
		estimationModelType.setCreationDate();
		estimationModelTypeDao.addEstimationModelType(estimationModelType);

	}

	public EstimationModelType getEstimationModelTypeById(
			Long estimationModelTypeId) {
		EstimationModelType estimationModelType = estimationModelTypeDao
				.getEstimationModelTypeById(estimationModelTypeId);
		return estimationModelType;
	}

	public void updateEstimationModelTypeById(EstimationModelType emType) {
		EstimationModelType estimationModelType = estimationModelTypeDao
				.getEstimationModelTypeById(emType.getId());
		estimationModelType.setDescription(emType.getDescription());
		estimationModelType.setStatus(emType.getStatus());
		estimationModelType.setName(emType.getName());
		estimationModelType.setAccuracy(emType.getAccuracy());
		estimationModelType.setChangedBy();
		estimationModelType.setChangeDate();
		estimationModelTypeDao.updateEstimationModelType(estimationModelType);
	}

	public void updateEstimationModelTypeStatus(Long id, Integer status) {

		EstimationModelType estimationModelType = estimationModelTypeDao
				.getEstimationModelTypeById(id);
		estimationModelType.setStatus(status);
		estimationModelTypeDao.updateEstimationModelType(estimationModelType);
	}

}
