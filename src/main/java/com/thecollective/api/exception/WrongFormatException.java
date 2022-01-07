package com.thecollective.api.exception;

public class WrongFormatException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public WrongFormatException(String message) {
		super(message);
	}

}
