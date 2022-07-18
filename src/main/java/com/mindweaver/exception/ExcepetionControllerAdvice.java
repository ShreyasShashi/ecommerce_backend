package com.mindweaver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExcepetionControllerAdvice {

	@ExceptionHandler(value = CustomException.class)
	public final ResponseEntity<String> handleCustomException(CustomException exception){
		
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = AuthenticationFailException.class)
	public final ResponseEntity<String> handleAuthenticationException(AuthenticationFailException authenticationException){
		return new ResponseEntity<>(authenticationException.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value =  ProductNotExistsException.class)
	public final ResponseEntity<String> handleProductNotExistsException(ProductNotExistsException productNotExistsException){
		return new ResponseEntity<>( productNotExistsException.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
