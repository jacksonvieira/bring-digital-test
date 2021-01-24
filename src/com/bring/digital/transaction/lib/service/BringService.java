package com.bring.digital.transaction.lib.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.bring.digital.transaction.lib.validation.Violation;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class BringService<T> {

	public abstract List<T> all();

	public abstract List<T> findByTypeTransaction(String type);
	
	

	public void validate(Object bean, Class<?>... classes) throws BringException {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		throwsViolations(validator.validate(bean, classes));
	}

	private void throwsViolations(Set<ConstraintViolation<Object>> violations) throws BringException {
		if (violations.isEmpty()) {
			return;
		}
		String message = formatMessage(violations);
		throw new BringException(message);
	}

	private String formatMessage(Set<ConstraintViolation<Object>> violations) throws BringException {
		List<Violation> msgViolations = new ArrayList<>();
		for (ConstraintViolation<Object> violation : violations) {
			msgViolations.add(new Violation(violation.getPropertyPath().toString(), violation.getMessage()));
		}
		ObjectMapper mapper = new ObjectMapper();
		String messages;
		try {
			messages = mapper.writeValueAsString(msgViolations);
		} catch (IOException e) {
			throw new BringException(e);
		}
		return messages;
	}
}
