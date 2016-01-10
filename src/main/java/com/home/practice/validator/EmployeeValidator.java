package com.home.practice.validator;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.home.practice.domain.Employee;

@Component
public class EmployeeValidator implements Validator {
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	public boolean supports(Class<?> paramClass) {
		// TODO Auto-generated method stub
		return Employee.class.equals(paramClass);
	}

	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		Employee emp=(Employee)obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "valid.name");
		if(!emp.getEmail().matches(EMAIL_PATTERN))
		{
			 errors.rejectValue("email","valid.email");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "valid.gender");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "valid.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConf", "valid.passwordConf");
		if (!emp.getPassword().equals(emp.getPasswordConf())) {
			errors.rejectValue("passwordConf", "valid.passwordConfDiff");
		}
		List<String> courses = emp.getCourses();
		if (courses == null || courses.size() < 2) {
			errors.rejectValue("courses", "valid.courses");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "role", "valid.role");
	}

}

