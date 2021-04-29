package io.github.i_grr.api.orange.talents.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.github.i_grr.api.orange.talents.model.exception.ApiErrors;
import io.github.i_grr.api.orange.talents.model.exception.ExistingCpfException;
import io.github.i_grr.api.orange.talents.model.exception.ExistingEmailException;
import io.github.i_grr.api.orange.talents.model.exception.UsuarioNotFoundException;


@RestControllerAdvice
public class ApplicationControllerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors handleValidationError(MethodArgumentNotValidException e) {
		BindingResult bindingResult = e.getBindingResult();
		List<String> messages = bindingResult.getAllErrors()
				.stream()
				.map(objectError -> objectError.getDefaultMessage())
				.collect(Collectors.toList());
		return new ApiErrors(messages);
	}
	
	@ExceptionHandler(ExistingCpfException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ApiErrors handleIExistingFieldsError(ExistingCpfException e) {
		return new ApiErrors(e.getMessage());
	}
	
	@ExceptionHandler(ExistingEmailException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ApiErrors handleIExistingFieldsError(ExistingEmailException e) {
		return new ApiErrors(e.getMessage());
	}
	
	@ExceptionHandler(UsuarioNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ApiErrors handleUsuarioNotFound(UsuarioNotFoundException e) {
		return new ApiErrors(e.getMessage());
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors handleUsuarioNotFound() {
		return new ApiErrors("O CEP informado não é válido.");
	}
	
}
