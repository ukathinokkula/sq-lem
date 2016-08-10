package com.lem.service.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.lem.service.model.User;

public class EmailValidator {

	public boolean supports(Class<?> arg0) {
		return false;
	}

	public void validateEmailForForgotPassword(User target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username",
				"Email is required field", "Email is required field");
	}

	public void addErrorMessageIfUsernameNotExists(User target, Errors errors) {

		errors.rejectValue("username", "Please provide valid Email id",
				"Please provide valid Email id");
	}

}
