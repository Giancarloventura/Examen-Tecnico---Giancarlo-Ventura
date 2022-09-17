package com.spring.fullstack.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidElementException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidElementException() {
		
	}
	
	public InvalidElementException(String msg) {
		super(msg);
	}
	
	public InvalidElementException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
