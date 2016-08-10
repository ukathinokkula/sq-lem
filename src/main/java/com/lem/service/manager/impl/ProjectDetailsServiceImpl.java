package com.lem.service.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lem.constants.Constants;
import com.lem.form.ReportForm;
import com.lem.service.dao.ComponentListDAO;
import com.lem.service.dao.ProjectDetailsDAO;
import com.lem.service.manager.ProjectDetailsService;
import com.lem.service.model.ProjectDetails;

@Service
public class ProjectDetailsServiceImpl implements ProjectDetailsService {

	@Autowired
	protected ProjectDetailsDAO projectDetailsDao;
	
	@Autowired
	protected ComponentListDAO componentListDao;

	public List<ProjectDetails> getProjectDetails() {
		List<ProjectDetails> projectDetailsList = projectDetailsDao.getProjectDetails();
		for (ProjectDetails projectDetails : projectDetailsList) {
			Double totalProjectHours =componentListDao.loadTotalProjectHours(projectDetails.getId(), Constants.ACTIVE);
			projectDetails.setTotalProjectHours(totalProjectHours);
		}
		return projectDetailsList;
	}
	
	public List<ProjectDetails> getActiveProjectDetails() {
		List<ProjectDetails> projectDetailsList = projectDetailsDao.getActiveProjectDetails();
		for (ProjectDetails projectDetails : projectDetailsList) {
			Double totalProjectHours =componentListDao.loadTotalProjectHours(projectDetails.getId(), Constants.ACTIVE);
			projectDetails.setTotalProjectHours(totalProjectHours);
		}
		return projectDetailsList;
	}

	public Long addProjectDetails(ProjectDetails projectDetails) throws Exception {
		projectDetails.setCreationBy();
		return projectDetailsDao.addProjectDetails(projectDetails);
	}

	public void updateProjectDetailsById(ProjectDetails pd) {
		
		ProjectDetails projectDetails = projectDetailsDao.getProjectDetailsById(pd.getId());
		projectDetails.setDescription(pd.getDescription());
		projectDetails.setName(pd.getName());
		projectDetails.setStatus(pd.getStatus());
		projectDetails.setClient(pd.getClient());
		projectDetails.setCountry(pd.getCountry());
		projectDetails.setChangedBy();
		projectDetails.setChangeDate();
		projectDetails.setStatus(pd.getStatus());
		projectDetailsDao.updateProjectDetails(projectDetails);
	}

	public void updateProjectDetailsStatus(Long id, Integer status) {
		
		ProjectDetails projectDetails = projectDetailsDao.getProjectDetailsById(id);
		projectDetails.setStatus(status);
		projectDetailsDao.updateProjectDetails(projectDetails);
	}

	@Override
	public ProjectDetails getProjectDetailsById(Long projectDetailsId) {
		ProjectDetails projectDetails = projectDetailsDao.getProjectDetailsById(projectDetailsId);
		return projectDetails;
	}

	@Override
	public List<ProjectDetails> searchReport(ReportForm rf) {
		List<ProjectDetails> projectDetailsList = projectDetailsDao.searchReport
				(rf.getProjectName(), rf.getTotalHoursFrom(), rf.getTotalHoursTo(), rf.getFromDate(), rf.getToDate());
		return projectDetailsList;
	}

}
