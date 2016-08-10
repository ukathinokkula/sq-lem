package com.lem.service.controller;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lem.service.manager.UserManager;
import com.lem.service.model.JsonResponse;
import com.lem.service.model.User;
import com.lem.service.validator.EmailValidator;
import com.lem.service.validator.ForgotValidator;
import com.lem.service.validator.UserValidation;

@Controller
@RequestMapping(value = "/lem")
public class ForgotPasswordController {

	@Autowired
	private UserManager userManager;


	@RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
	public @ResponseBody
	JsonResponse forgotPassword(@Valid @ModelAttribute User user,
			BindingResult bindingResultForgot, HttpServletRequest request)
			throws MessagingException {
		JsonResponse res = new JsonResponse();
		EmailValidator userValidation = new EmailValidator();
		userValidation
				.validateEmailForForgotPassword(user, bindingResultForgot);
		if (bindingResultForgot.hasErrors()) {

			res.setStatus("FAIL");
			res.setResult(bindingResultForgot.getAllErrors());
		} else {
			if (userManager.verifyUsername(user.getUsername())) {
				String resetPasswordURL = constructURL(request).toString();
				/*emailConfigurer.sendEmail(user.getUsername(),
						user.getUsername(), resetPasswordURL);*/
				res.setStatus("SUCCESS");
			} else {
				userValidation.addErrorMessageIfUsernameNotExists(user,
						bindingResultForgot);
				res.setStatus("FAIL");
				res.setResult(bindingResultForgot.getAllErrors());
			}

		}
		return res;
	}

	@RequestMapping(value = "/forgotPasswordPage")
	public ModelAndView forgotPasswordPage(
			@RequestParam("username") String username) {
		ModelAndView modelAndView = new ModelAndView("forgotPasswordPage");
		modelAndView.addObject("forgotUsername", username);
		return modelAndView;
	}

	@RequestMapping(value = "/forgotPasswordUpdateDB", method = RequestMethod.POST)
	public ModelAndView forgotPasswordUpdateDB(
			@Valid @ModelAttribute User user,
			BindingResult bindingResultResetPassword) {

		ModelAndView modelAndView = new ModelAndView("forgotPasswordPage");
		modelAndView.addObject("forgotUsername", user.getUsername());
		UserValidation userValidation = new UserValidation();
		userValidation.validateForgotPassword(user, bindingResultResetPassword);
		ForgotValidator forgotValidator = new ForgotValidator();
		forgotValidator.validate(user, bindingResultResetPassword);
		if (bindingResultResetPassword.hasErrors()) {
			modelAndView.addObject("hasErrorsForForgotPassword",
					bindingResultResetPassword.getAllErrors().get(0)
							.getDefaultMessage());
			return modelAndView;
		}

		if (userManager.savePassword(user)) {
			modelAndView.addObject("passwordChanged",
					"Password changed successfully");
		} else {
			modelAndView.addObject("passwordChanged",
					"Network is busy please try later");
		}
		return modelAndView;
	}

	public StringBuffer constructURL(HttpServletRequest request) {
		return new StringBuffer().append("http://")
				.append(request.getServerName()).append(":")
				.append(request.getServerPort())
				.append(request.getContextPath());
	}
}
