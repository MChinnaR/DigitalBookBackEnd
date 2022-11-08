package com.digitalbook.exception;

public class BookExistWithTittle extends RuntimeException{
	
	private String message;

	public BookExistWithTittle(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
