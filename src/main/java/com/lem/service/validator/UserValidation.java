package com.lem.service.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.lem.service.model.User;

public class UserValidation implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		if (!(user.getPassword().equals(user.getConfirmPassword()))) {
			errors.rejectValue("password", "password.incorrect",
					"Password and Confirm Password should be same");
		}
	}

	public void validateForgotPassword(Object target, Errors errors) {
		System.out.println("entered validateForgotPassword");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"Password is a required field", "Password is a required field");
		User user = (User) target;
		if (!(user.getPassword().equals(user.getConfirmPassword()))) {
			errors.rejectValue("password", "password.incorrect",
					"Password and Confirm Password should be same");
		}
	}

	public void validateRequiredFields(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username","label.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "area","label.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "postalCode","label.required");
	}
}
