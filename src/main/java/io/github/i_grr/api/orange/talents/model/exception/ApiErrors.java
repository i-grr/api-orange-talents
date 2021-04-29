package io.github.i_grr.api.orange.talents.model.exception;

import java.util.Arrays;
import java.util.List;

public class ApiErrors {
	
	private List<String> errors;
	
	public ApiErrors(List<String> errors) {
		this.errors = errors;
	}
	
	public ApiErrors(String message) {
		this.errors = Arrays.asList(message);
	}

	public List<String> getErrors() {
		return errors;
	}

}
