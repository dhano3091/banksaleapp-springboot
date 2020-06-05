package com.mindtree.banksale.controller.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.banksale.dto.ErrorDTO;
import com.mindtree.banksale.dto.ResponseBody;
import com.mindtree.banksale.exception.BankSaleApplicationException;

@RestControllerAdvice
public class BankSaleControllerHandler {

	@ExceptionHandler(BankSaleApplicationException.class)
	public ResponseEntity<ResponseBody<ErrorDTO>> errorHandler(Exception ex) {
		return new ResponseEntity<ResponseBody<ErrorDTO>>(new ResponseBody<ErrorDTO>(null,
				new ErrorDTO(ex.getMessage(), ex.getClass().getCanonicalName()), false, "error"),
				HttpStatus.BAD_REQUEST);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}

}
