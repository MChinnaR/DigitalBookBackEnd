package com.digitalbook.response;

import java.io.Serializable;

public class BookResponse implements Serializable{
	public Long id;
	public String tittle;
	public String category;
	public float price;
	public String authorName;
	public String publisher;
	public String publishedDate;
	public String content;
	public boolean active;
	public AuthorDetails authorDetails;
	public BookResponse(Long id, String tittle, String category, float price, String authorName, String publisher,
			String publishedDate, String content, boolean active, AuthorDetails authorDetails) {
		super();
		this.id = id;
		this.tittle = tittle;
		this.category = category;
		this.price = price;
		this.authorName = authorName;
		this.publisher = publisher;
		this.publishedDate = publishedDate;
		this.content = content;
		this.active = active;
		
		this.authorDetails = authorDetails;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	public AuthorDetails getAuthorDetails() {
		return authorDetails;
	}
	public void setAuthorDetails(AuthorDetails authorDetails) {
		this.authorDetails = authorDetails;
	}
	
	

}
