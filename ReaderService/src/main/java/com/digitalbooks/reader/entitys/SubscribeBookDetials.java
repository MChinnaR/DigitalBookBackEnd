package com.digitalbooks.reader.entitys;

public class SubscribeBookDetials {

	private int bookId;
	private String name;
	private String emailId;

	public SubscribeBookDetials(int bookId, String name, String emailId) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.emailId = emailId;
	}

	public SubscribeBookDetials(int bookId, String emailId) {
		super();
		this.bookId = bookId;
		this.emailId = emailId;
	}

	public SubscribeBookDetials() {
		super();
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
