package com.lem.service.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lem.service.manager.EstimationModelTypeService;
import com.lem.service.model.EstimationModelType;

@Controller
@RequestMapping("/lem")
public class EstimationModelTypeController {

	@Autowired
	protected EstimationModelTypeService estimationModelTypeService;

	/**
	 * List of estimation model types for administrator.
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/viewAdminEstimations")
	public ModelAndView viewAdminEstimations() throws Exception {
		ModelAndView model = new ModelAndView("admin/viewEstimations");

		List<EstimationModelType> estimationModelTypes = estimationModelTypeService.getEstimationModelTypes();

		model.addObject("estimationModelTypes", estimationModelTypes);

		return model;
	}
	
	@RequestMapping(value = "/admin/openAddEstimation", method = RequestMethod.GET)
	public ModelAndView openAddEstimation()
			throws Exception {
		
		ModelAndView model = new ModelAndView("admin/addEstimation");
		return model;
	}
	
	@RequestMapping(value = "/admin/openEditEstimation")
	public ModelAndView openEditEstimation(HttpServletRequest request)
			throws Exception {
		
		Long id = Long.parseLong(request.getParameter("id").trim());
		ModelAndView model = new ModelAndView("admin/editEstimation");
		EstimationModelType estimationModelType = estimationModelTypeService.getEstimationModelTypeById(id);
		model.addObject("estimationModelType", estimationModelType);
		
		return model;
	}
	
	@RequestMapping(value = "/admin/editEstimation", method = RequestMethod.POST)
	public ModelAndView editEstimation(@ModelAttribute EstimationModelType estimationModelType)
			throws Exception {
		
		ModelAndView model = new ModelAndView("admin/viewEstimations");
		estimationModelTypeService.updateEstimationModelTypeById(estimationModelType);
		
		List<EstimationModelType> estimationModelTypes = estimationModelTypeService.getEstimationModelTypes();
		model.addObject("estimationModelTypes", estimationModelTypes);
		
		return model;
	}
	
	@RequestMapping(value = "/admin/addEstimation", method = RequestMethod.POST)
	public ModelAndView addEstimation(@ModelAttribute EstimationModelType estimationModelType)
			throws Exception {
		
		ModelAndView model = new ModelAndView("admin/viewEstimations");
		estimationModelTypeService.addEstimationModelType(estimationModelType);		
		List<EstimationModelType> estimationModelTypes = estimationModelTypeService.getEstimationModelTypes();
		model.addObject("estimationModelTypes", estimationModelTypes);
		
		return model;
	}
}
