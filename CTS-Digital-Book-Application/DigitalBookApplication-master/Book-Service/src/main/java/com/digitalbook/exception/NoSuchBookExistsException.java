package com.digitalbook.exception;

public class NoSuchBookExistsException extends RuntimeException {
	
	private String message;
	
	public NoSuchBookExistsException() {
		
	}
	public NoSuchBookExistsException(String message) {
		super(message);
		this.message = message;
	}
	


}
