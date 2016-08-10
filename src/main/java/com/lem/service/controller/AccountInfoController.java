package com.lem.service.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.lem.service.manager.UserManager;
import com.lem.service.model.JsonResponse;
import com.lem.service.model.User;
import com.lem.service.validator.ForgotValidator;
import com.lem.service.validator.UserValidation;

/**
 * 
 * @author ukathinokkula
 * 
 */
@Controller
@RequestMapping("/lem/accountInfo")
public class AccountInfoController {

	private static final Logger logger = Logger
			.getLogger(AccountInfoController.class);

	@Autowired
	protected UserManager userManager;

	@RequestMapping(value = "/openUpdateAccountInfo")
	public ModelAndView openUpdateAccountInfoPage() throws Exception {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		ModelAndView model = new ModelAndView("accountInfo/updateAccountInfo");
		User user = userManager.findUserByName(auth.getName());
		model.addObject("user", user);
		return model;
	}

	@RequestMapping(value = "/viewAccountInfo")
	public ModelAndView viewAccountInfo() throws Exception {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		ModelAndView model = new ModelAndView("accountInfo/viewAccountInfo");
		User user = userManager.findUserByName(auth.getName());
		model.addObject("user", user);
		return model;
	}

	@RequestMapping(value = "/updateAccountInfo" , method = RequestMethod.POST)
	public ModelAndView updateAccountInfo(@ModelAttribute User user, @RequestParam("file") MultipartFile file, BindingResult bindingResult)
			throws Exception {
		System.out.println("in update account info");
		ModelAndView model = null;
		UserValidation userValidation = new UserValidation();
		userValidation.validateRequiredFields(user, bindingResult);
		if(bindingResult.hasErrors()){
			model = new ModelAndView("accountInfo/updateAccountInfo");
			model.addObject("user", user);
		}else{
			userManager.updateUser(user);
			model = new ModelAndView("accountInfo/viewAccountInfo");
			User updatedUser = userManager.findUserByName(user.getUsername());
			
			
			model.addObject("user", updatedUser);
		}
		return model;
	}

	@RequestMapping(value = "/openResetPasswordPage")
	public ModelAndView openResetPasswordPage() throws Exception {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		ModelAndView model = new ModelAndView("accountInfo/resetPassword");
		User user = userManager.findUserByName(auth.getName());
		model.addObject("user", user);
		return model;
	}

	@RequestMapping(value = "/resetPassword")
	public @ResponseBody JsonResponse resetPassword(@ModelAttribute User user,
			BindingResult bindingResultResetPassword) throws Exception {
		
		 JsonResponse res = new JsonResponse();
		ForgotValidator forgotValidator = new ForgotValidator();
		forgotValidator.validate(user, bindingResultResetPassword);
		if (!bindingResultResetPassword.hasErrors()) {
			if (userManager.savePassword(user)) {
				res.setStatus("SUCCESS");
                res.setResult("Password changed successfully");
			}
		}else{
			res.setStatus("FAIL");
            res.setResult(bindingResultResetPassword.getAllErrors());
 		}
		return res;
	}
}
