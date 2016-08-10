package com.lem.service.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lem.service.manager.ComplexityTypeService;
import com.lem.service.model.ComplexityType;

/**
 * 
 * @author ukathinokkula
 * 
 */
@Controller
@RequestMapping("/lem")
public class ComplexityTypeController {

	private static final Logger logger = Logger
			.getLogger(ComplexityTypeController.class);

	@Autowired
	protected ComplexityTypeService complexityTypeService;

	/**
	 * List of complexity types for administrator.
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/viewComplexityTypes")
	public ModelAndView viewComplexityTypes() throws Exception {
		ModelAndView model = new ModelAndView("admin/viewComplexityTypes");

		List<ComplexityType> complexityTypes = complexityTypeService.getComplexityTypes();

		model.addObject("complexityTypes", complexityTypes);

		return model;
	}
	
	@RequestMapping(value = "/admin/openAddComplexityType", method = RequestMethod.GET)
	public ModelAndView openAddComplexityType()
			throws Exception {
		
		ModelAndView model = new ModelAndView("admin/addComplexityType");
		return model;
	}
	
	@RequestMapping(value = "/admin/openEditComplexityType")
	public ModelAndView openEditComplexityType(HttpServletRequest request)
			throws Exception {
		
		Long id = Long.parseLong(request.getParameter("id").trim());
		ModelAndView model = new ModelAndView("admin/editComplexityType");
		ComplexityType complexityType = complexityTypeService.getComplexityTypeById(id);
		model.addObject("complexityType", complexityType);
		
		return model;
	}
	
	@RequestMapping(value = "/admin/editComplexityType", method = RequestMethod.POST)
	public ModelAndView editComplexityType(@ModelAttribute ComplexityType complexityType)
			throws Exception {
		
		ModelAndView model = new ModelAndView("admin/viewComplexityTypes");
		complexityTypeService.updateComplexityTypeById(complexityType);
		
		List<ComplexityType> complexityTypes = complexityTypeService.getComplexityTypes();
		model.addObject("complexityTypes", complexityTypes);
		
		return model;
	}
	
	@RequestMapping(value = "/admin/addComplexityType", method = RequestMethod.POST)
	public ModelAndView addComplexityType(@ModelAttribute ComplexityType complexityType)
			throws Exception {
		
		ModelAndView model = new ModelAndView("admin/viewComplexityTypes");
		complexityTypeService.addComplexityType(complexityType);
		
		List<ComplexityType> complexityTypes = complexityTypeService.getComplexityTypes();
		model.addObject("complexityTypes", complexityTypes);
		
		return model;
	}
	
}
