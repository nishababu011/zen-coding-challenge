package com.zendesk.exception;

/**
 * Exception thrown when an error occurs due to invalid user input
 *
 */
public class InvalidUserInputException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	String errorMessage;

	public InvalidUserInputException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String toString() {
		return (errorMessage);
	}

}
