package com.spring.fullstack.test.exception;

public class GeneralException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GeneralException(String msg) {
		super(msg);
	}
	
	public GeneralException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	public GeneralException(Throwable cause) {
		super(cause);
	}
}
