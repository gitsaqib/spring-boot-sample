package com.saqibayub.random.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = { InvalidNumberException.class })
	public ResponseEntity<String> handleInvalidNumberException(InvalidNumberException ex) {
		String bodyOfResponse = "Provided Number is in valid";
		ResponseEntity<String> error = new ResponseEntity<String>(bodyOfResponse, HttpStatus.BAD_REQUEST);

		return error;
	}
	
	@ExceptionHandler(value = { RuntimeException.class })
	public ResponseEntity<String> handleInvalidNumberException(RuntimeException ex) {
		String bodyOfResponse = "Someting went wrong";
		ResponseEntity<String> error = new ResponseEntity<String>(bodyOfResponse, HttpStatus.INTERNAL_SERVER_ERROR);

		return error;
	}
}
