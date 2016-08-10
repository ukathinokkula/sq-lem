package com.lem.service.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lem.service.dao.ComplexityTypeDAO;
import com.lem.service.manager.ComplexityTypeService;
import com.lem.service.model.ComplexityType;

/**
 * 
 * @author ukathinokkula
 *
 */
@Service
public class ComplexityTypeServiceImpl implements
		ComplexityTypeService {

	@Autowired
	protected ComplexityTypeDAO complexityTypeDao;

	public List<ComplexityType> getComplexityTypes() {
		List<ComplexityType> complexityTypeList = complexityTypeDao
				.getComplexityTypes();
		return complexityTypeList;
	}

	public void addComplexityType(ComplexityType complexityType)
			throws Exception {
		complexityType.setCreationBy();
		complexityType.setCreationDate();
		complexityTypeDao.addComplexityType(complexityType);

	}

	public ComplexityType getComplexityTypeById(
			Long complexityTypeId) {
		ComplexityType complexityType = complexityTypeDao
				.getComplexityTypeById(complexityTypeId);
		return complexityType;
	}

	public void updateComplexityTypeById(ComplexityType cType) {
		ComplexityType complexityType = complexityTypeDao
				.getComplexityTypeById(cType.getId());
		complexityType.setDescription(cType.getDescription());
		complexityType.setStatus(cType.getStatus());
		complexityType.setComplexityType(cType.getComplexityType());
		complexityType.setHours(cType.getHours());
		complexityType.setExistingComponentRatio(cType.getExistingComponentRatio());
		complexityType.setChangedBy();
		complexityType.setCreationDate();
		complexityTypeDao.updateComplexityType(complexityType);
	}

	public void updateComplexityTypeStatus(Long id, Integer status) {

		ComplexityType complexityType = complexityTypeDao
				.getComplexityTypeById(id);
		complexityType.setStatus(status);
		complexityTypeDao.updateComplexityType(complexityType);
	}
	
	public List<ComplexityType> getActiveComplexityTypes() {
		List<ComplexityType> complexityTypeList = complexityTypeDao
				.getActiveComplexityTypes();
		return complexityTypeList;
	}


}
