package com.lem.service.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author ukathinokkula
 * 
 */
@Controller
@RequestMapping("/lem")
public class AdminPageController {

	private static final Logger logger = Logger
			.getLogger(AdminPageController.class);

	@RequestMapping(value = "/login/adminPage", method = RequestMethod.GET)
	public ModelAndView adminLogin() throws Exception {
		logger.info("adminPage Called....");
		ModelAndView model = new ModelAndView("admin/adminPage");

		return model;
	}

}
