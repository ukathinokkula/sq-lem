package com.lem.service.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lem.service.manager.UserManager;
import com.lem.service.model.User;
import com.lem.service.validator.UserValidation;

@Controller
@RequestMapping("/lem")
public class HomeController {

	@Autowired
	protected UserManager userManager;
	

	@RequestMapping(value = "/login/form")
	public ModelAndView loginForm() throws Exception {
		ModelAndView model = new ModelAndView("welcomePage");
		return model;
	}

	@RequestMapping(value = "/403")
	public ModelAndView accessDeniedPage() throws Exception {
		return new ModelAndView("accessDeniedPage");
	}

	private boolean isRememberMeAuthenticated() {

		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		if (authentication == null) {
			System.out.println("false 2");
			return false;
		}

		return RememberMeAuthenticationToken.class
				.isAssignableFrom(authentication.getClass());
	}

	@RequestMapping(value = "/admin")
	public ModelAndView loginFormWelcome() throws Exception {
		if (!isRememberMeAuthenticated()) {
			System.out.println("auth 1");
			return new ModelAndView("welcomePage");
		} else {
			System.out.println("auth 3");
			return new ModelAndView("adminPage");
		}
	}

	@RequestMapping(value = "/member")
	public ModelAndView loginFormWelcomeMember() throws Exception {
		return new ModelAndView("member");
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView registerUser(@Valid @ModelAttribute User user,
			BindingResult bindingResult) throws Exception {
		String errorsExist = "false";
		ModelAndView model = new ModelAndView("welcomePage");
		UserValidation userValidation = new UserValidation();
		userValidation.validate(user, bindingResult);
		
		User dbUserObj = userManager.findUserByName(user.getUsername().trim());
		if(null!=dbUserObj && dbUserObj.getUsername().equalsIgnoreCase(user.getUsername())) {
			bindingResult.rejectValue("username", "errormessage.signup.duplicateUser",
					"This user already exist, please provide another user name");
		}
		
		if (bindingResult.hasErrors()) {
			errorsExist = "true";
			model = new ModelAndView("signup");
			model.addObject("hasErrors", errorsExist);
			return model;
		}
		userManager.registerUser(user);
		return model;
	}
	
	
	@RequestMapping(value = "/fillOutApplication")
	public ModelAndView fillOutApplication() throws Exception {
		ModelAndView model = new ModelAndView("home/applicationForm");
		return model;
	}
	
	@RequestMapping(value = "/openSignupPage")
	public ModelAndView openSignupPage() throws Exception {
		return new ModelAndView("signup");
	}
	
	@RequestMapping(value = "/forgotPassword")
	public ModelAndView openForgotPasswordPage() throws Exception {
		return new ModelAndView("forgotPasswordPage");
	}
}
