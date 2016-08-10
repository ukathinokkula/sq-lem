package com.lem.service.dao;

import java.util.List;

import com.lem.service.model.ComplexityType;

/**
 * 
 * @author ukathinokkula
 *
 */
public interface ComplexityTypeDAO {

	public List<ComplexityType> getComplexityTypes();

	public void addComplexityType(ComplexityType complexityType);

	public ComplexityType getComplexityTypeById(Long complexityTypeId);

	public void updateComplexityType(ComplexityType complexityType);
	
	public List<ComplexityType> getActiveComplexityTypes();

}
