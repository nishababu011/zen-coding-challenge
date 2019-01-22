package com.zendesk.exception;

public class InvalidUserInputException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String errorMessage;

	public InvalidUserInputException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String toString() {
		return (errorMessage);
	}

}
