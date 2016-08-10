package com.lem.service.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.lem.service.model.User;

public class ForgotValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out
				.println("entered FORgotValidato   --- validateForgotPassword");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"Password is a required field", "Password is a required field");
		User user = (User) target;
		if (!(user.getPassword().equals(user.getConfirmPassword()))) {
			errors.rejectValue("password", "password.incorrect",
					"Password and Confirm Password should be same");
		}

	}

}
