package com.lem.service.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lem.form.ReportForm;
import com.lem.service.manager.ComplexityTypeService;
import com.lem.service.manager.ProjectDetailsService;
import com.lem.service.model.ComplexityType;
import com.lem.service.model.ProjectDetails;

/**
 * 
 * @author ukathinokkula
 * 
 */
@Controller
@RequestMapping("/lem")
public class ReportController {

	private static final Logger logger = Logger
			.getLogger(ReportController.class);

	@Autowired
	protected ProjectDetailsService projectDetailsService;

	@RequestMapping(value = "/admin/openReportPage", method = RequestMethod.GET)
	public ModelAndView openReportPage()
			throws Exception {
		logger.info("Trying to open report page");
		ModelAndView model = new ModelAndView("admin/reportPage");
		return model;
	}
	
	@RequestMapping(value = "/admin/searchReport", method = RequestMethod.POST)
	public ModelAndView searchReport(@ModelAttribute ReportForm reportForm)
			throws Exception {
		
		ModelAndView model = new ModelAndView("admin/reportPage");
		List<ProjectDetails> projectList =  projectDetailsService.searchReport(reportForm);
		
		model.addObject("projectList", projectList);
		
		return model;
	}
	
}
