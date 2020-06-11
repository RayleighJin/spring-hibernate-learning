package com.hao.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator
	implements ConstraintValidator<CourseCode, String> {
	
	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode courseCode) {
		coursePrefix = courseCode.value();
	}
	
	@Override
	public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
		
		boolean result = true;
		
		if (code == null) {
			return result;
		}
		result = code.startsWith(coursePrefix);
		return result;
	}
	
}
