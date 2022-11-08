package com.digitalbook.Service;




import java.util.List;

import com.digitalbook.Repository.BookRepository;
import com.digitalbook.exception.NoSuchBookExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import  com.digitalbook.Model.Book;

@Service
public class BookService {


	private BookRepository bookRepository;
	@Autowired
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	public BookService() {

	}
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public Book saveBook(Book book) {

		return bookRepository.save(book);

	}

	public Book updateBook(Book book) {
		Book previousBook = bookRepository.getBookByBookIdAndAuthId(book.getId(), book.getAuthorDetails().getAuthId());
		if (previousBook == null) {
			throw new NoSuchBookExistsException("There is no Book available for : " + book.getId());
		} else {

			previousBook.setTittle(book.getTittle());
			previousBook.setCategory(book.getCategory());
			previousBook.setPrice(book.getPrice());
			previousBook.setAuthorName(book.getAuthorName());
			previousBook.setPublisher(book.getPublisher());
			previousBook.setPublishedDate(book.getPublishedDate());
			previousBook.setContent(book.getContent());
			previousBook.setActive(book.isActive());

			System.out.println("Object of Book :" + previousBook);
			Book updatedBook=bookRepository.save(book);
			
			kafkaTemplate.send("author-bookupdate-topic", updatedBook.getId().toString());
			
			return updatedBook;

		}
	}

	public List<Book> getBooksBySearchCriteria(String category, float price, String authorName, String publisher) {
		List<Book> books = bookRepository.getBookOnSerachCriteria(category, price, authorName, publisher);
		if (books.isEmpty()) {
			throw new NoSuchBookExistsException("There is no Book available for : " + category);
		}
		return books;
	}

	public Book getBookById(Long bookId){
		return  bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Error: Book is not found."));
	}
}
