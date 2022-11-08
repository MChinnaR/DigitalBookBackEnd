package com.digitalbook.Model;

import javax.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "book")
public class Book implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String tittle;
	private String category;
	private float price;
	private String authorName;
	private String publisher;
	private String publishedDate;
	private String content;
	private boolean active;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE })
	@JoinColumn(name = "authoer_details_id")
	private AuthorDetails authorDetails;

	public Book(Long id,String tittle, String category, float price, String authorName, String publisher, String publishedDate,
			String content, boolean active, AuthorDetails authorDetails) {
		this.id=id;
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
	public Book(String tittle, String category, float price, String authorName, String publisher, String publishedDate,
				String content, boolean active, AuthorDetails authorDetails) {
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

	public Book() {
		super();
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
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

	@Override
	public String toString() {
		return "Book [id=" + id + ", tittle=" + tittle + ", category=" + category + ", price=" + price + ", authorName="
				+ authorName + ", publisher=" + publisher + ", publishedDate=" + publishedDate + ", content=" + content
				+ ", active=" + active + ", authorDetails=" + authorDetails + "]";
	}
	
}
