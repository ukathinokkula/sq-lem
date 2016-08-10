package com.lem.service.dao;

import java.util.Date;
import java.util.List;

import com.lem.service.model.ProjectDetails;

/**
 * 
 * @author
 * 
 */
public interface ProjectDetailsDAO {

	public List<ProjectDetails> getProjectDetails();

	public Long addProjectDetails(ProjectDetails projectDetails);

	public ProjectDetails getProjectDetailsById(Long projectDetailsId);

	public void updateProjectDetails(ProjectDetails projectDetails);
	
	public List<ProjectDetails> getActiveProjectDetails();
	
	public List<ProjectDetails> searchReport(String projectName, Double totalHoursFrom,
			Double totalHoursTo, Date fromDate, Date toDate);

}
