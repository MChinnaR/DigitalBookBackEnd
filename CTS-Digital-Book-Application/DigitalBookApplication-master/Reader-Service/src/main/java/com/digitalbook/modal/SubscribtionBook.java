package com.digitalbook.modal;

import javax.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "subscribtion_book")
public class SubscribtionBook implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private  Long bookId;
	private String tittle;
	private String category;
	private float price;
	private String authorName;
	private String publisher;
	private String publishedDate;
	private String content;
	private boolean active;



	public SubscribtionBook(Long bookId,String tittle, String category, float price, String authorName, String publisher, String publishedDate,
			String content, boolean active) {
		this.bookId=bookId;
		this.tittle = tittle;
		this.category = category;
		this.price = price;
		this.authorName = authorName;
		this.publisher = publisher;
		this.publishedDate = publishedDate;
		this.content = content;
		this.active = active;
		
	}

	public SubscribtionBook() {
		super();
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
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


	@Override
	public String toString() {
		return "SubscribtionBook{" +
				"id=" + id +
				", bookId=" + bookId +
				", tittle='" + tittle + '\'' +
				", category='" + category + '\'' +
				", price=" + price +
				", authorName='" + authorName + '\'' +
				", publisher='" + publisher + '\'' +
				", publishedDate='" + publishedDate + '\'' +
				", content='" + content + '\'' +
				", active=" + active +
				'}';
	}
}
