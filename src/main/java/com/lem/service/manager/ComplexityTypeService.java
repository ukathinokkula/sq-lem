package com.lem.service.manager;

import java.util.List;

import com.lem.service.model.ComplexityType;

public interface ComplexityTypeService {

	public List<ComplexityType> getComplexityTypes();

	public void addComplexityType(ComplexityType complexityType) throws Exception;

	public ComplexityType getComplexityTypeById(Long complexityTypeId);

	public void updateComplexityTypeById(ComplexityType complexityTypes);
	
	public void updateComplexityTypeStatus(Long id,Integer status);

	public List<ComplexityType> getActiveComplexityTypes();
}
