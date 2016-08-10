package com.lem.service.manager;

import java.util.List;

import com.lem.form.ReportForm;
import com.lem.service.model.ProjectDetails;

public interface ProjectDetailsService {

	public List<ProjectDetails> getProjectDetails();

	public Long addProjectDetails(ProjectDetails ProjectDetails)
			throws Exception;

	public ProjectDetails getProjectDetailsById(Long projectDetailId);

	public void updateProjectDetailsById(ProjectDetails ProjectDetails);

	public void updateProjectDetailsStatus(Long id, Integer status);
	
	public List<ProjectDetails> getActiveProjectDetails();
	
	public List<ProjectDetails> searchReport(ReportForm  reportForm);

}
