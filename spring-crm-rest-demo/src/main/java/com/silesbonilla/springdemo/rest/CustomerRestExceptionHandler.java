package com.silesbonilla.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	public CustomerRestExceptionHandler() {
		// TODO Auto-generated constructor stub
	}
	
	// Add an exception handler for CustomerNotFoundException
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exc){
		
		// create CustomerErrorResponse
		CustomerErrorResponse error = new CustomerErrorResponse(
					HttpStatus.NOT_FOUND.value(),
					exc.getMessage(),
					System.currentTimeMillis());
		
		// return ResponseENtitty
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	// Add another exception handler to catch any exception
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleAnyException(Exception exc){
		
		// create CustomerErrorResponse
		CustomerErrorResponse error = new CustomerErrorResponse(
					HttpStatus.BAD_REQUEST.value(),
					exc.getMessage(),
					System.currentTimeMillis());
		
		// return ResponseENtitty
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
}
