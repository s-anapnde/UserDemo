package com.lms.demo.user.demo.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author shital
 * This is class is created to handle validation related to the input/output fields.
 *
 */
@ControllerAdvice
@RestController
public class ValidationHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
		UserExceptions exception =  new UserExceptions(new Date(), ex.getMessage(), request.getDescription(true));
		return new ResponseEntity(exception,HttpStatus.BAD_REQUEST);
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
	//	UserExceptions exception =  new UserExceptions(new Date(), "Validation Failed", ex.getFieldError().toString());
		Map<String, String> errors = new HashMap<>();
		System.out.println(errors);
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName = ((FieldError)error).getField();
			String messagString = error.getDefaultMessage();
			errors.put(fieldName, messagString);
		});
		
		return new ResponseEntity(errors,HttpStatus.BAD_REQUEST);
	}
}
