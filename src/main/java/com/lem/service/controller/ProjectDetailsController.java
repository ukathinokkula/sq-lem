package com.lem.service.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lem.service.manager.ProjectDetailsService;
import com.lem.service.model.ProjectDetails;

@Controller
@RequestMapping("/lem")
public class ProjectDetailsController {

	/*@Autowired
	protected ProjectDetailsService projectDetailsService;

	@RequestMapping(value = "/project/projectDetails")
	public ModelAndView viewProjectDetails() throws Exception {
		ModelAndView model = new ModelAndView("project/projectDetails");

		List<ProjectDetails> projectDetails = projectDetailsService.getProjectDetails();

		model.addObject("projectList", projectDetails);

		return model;
	}
	
	@RequestMapping(value = "/admin/viewProjectDetails")
	public ModelAndView viewAdminProjectDetails() throws Exception {
		ModelAndView model = new ModelAndView("admin/viewProjectDetails");

		List<ProjectDetails> projectDetails = projectDetailsService.getProjectDetails();

		model.addObject("projectList", projectDetails);

		return model;
	}
	
	@RequestMapping(value = "/admin/openAddProjectDetailsPage", method = RequestMethod.GET)
	public ModelAndView openAddProjectDetailsPage()
			throws Exception {
		ModelAndView model = new ModelAndView("admin/addProjectDetails");
		return model;
	}
	
	@RequestMapping(value = "/admin/openEditProjectDetailsPage")
	public ModelAndView openEditProjectPage(HttpServletRequest request)
			throws Exception {
		Long id = Long.parseLong(request.getParameter("projectId").trim());
		ModelAndView model = new ModelAndView("admin/editProjectDetails");
		ProjectDetails projectDetails = projectDetailsService.getProjectDetailsById(id);
		model.addObject("projectDetails", projectDetails);
		return model;
	}
	
	@RequestMapping(value = "/admin/editProjectDetails", method = RequestMethod.POST)
	public ModelAndView editProjectDetails(@ModelAttribute ProjectDetails projectDetails)
			throws Exception {
		ModelAndView model = new ModelAndView("admin/viewProjectDetails");
		projectDetailsService.updateProjectDetailsById(projectDetails);
		
		List<ProjectDetails> projectDetailsList = projectDetailsService.getProjectDetails();

		model.addObject("projectList", projectDetailsList);
		return model;
	}
	
	@RequestMapping(value = "/admin/addProjectDetails", method = RequestMethod.POST)
	public ModelAndView addProjectDetails(@ModelAttribute ProjectDetails projectDetails)
			throws Exception {
		//Long projectId = Long.parseLong(request.getParameter("projectId").trim());
		ModelAndView model = new ModelAndView("admin/viewProjectDetails");
		projectDetailsService.addProjectDetails(projectDetails);
		
		List<ProjectDetails> projectDetailsList = projectDetailsService.getProjectDetails();

		model.addObject("projectList", projectDetailsList);
		return model;
	}*/
}
