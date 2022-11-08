package com.digitalbook.modal;

import org.hibernate.annotations.Type;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name = "reader_pyment_info")
public class ReaderPaymentInfo implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String readerName;
	private String readerEmail;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "subscribtion_book", referencedColumnName = "id")
	private SubscribtionBook book;
	
	public ReaderPaymentInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReaderPaymentInfo(Long id, String readerName, String readerEmail ,SubscribtionBook book ) {
		super();
		this.id = id;
		this.readerName = readerName;
		this.readerEmail = readerEmail;
		this.book=book;
	}
	public ReaderPaymentInfo(String readerName, String readerEmail,SubscribtionBook book) {
		super();
		this.readerName = readerName;
		this.readerEmail = readerEmail;
		this.book=book;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReaderName() {
		return readerName;
	}
	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}
	public String getReaderEmail() {
		return readerEmail;
	}
	public void setReaderEmail(String readerEmail) {
		this.readerEmail = readerEmail;
	}
	
	public SubscribtionBook getBook() {
		return book;
	}
	public void setBook(SubscribtionBook book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "ReaderPaymentInfo [id=" + id + ", readerName=" + readerName + ", readerEmail=" + readerEmail + "]";
	}
	

}
