package com.sandeep.project.logging.exception;

public class InvalidLogTypeException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidLogTypeException(String message, Throwable cause) {
		super(message, cause);
	}

}
