package com.digitalbook.Controler;

import com.digitalbook.Model.AuthorDetails;
import com.digitalbook.Model.Book;
import com.digitalbook.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/digitalbook/")
@CrossOrigin(origins = "*")
public class BookControler {

	@Autowired
	private BookService bookService;


	@PostMapping("{authorID}/book/")
	public ResponseEntity<String> saveBook(@PathVariable Long authorID, @RequestParam String tittle, @RequestParam String category,
			@RequestParam float price, @RequestParam String authorName, @RequestParam String publisher,
			@RequestParam String publisherDate, @RequestParam boolean active, @RequestParam String content) {
		Book bookDto = new Book();
		bookDto.setTittle(tittle);
		bookDto.setCategory(category);
		bookDto.setPrice(price);
		bookDto.setAuthorName(authorName);
		bookDto.setPublisher(publisher);
		bookDto.setPublishedDate(publisherDate);
		bookDto.setActive(active);
		bookDto.setContent(content);
		bookDto.setAuthorDetails(new AuthorDetails(authorID, authorName));
		Book book=bookService.saveBook(bookDto);
		return new ResponseEntity<String>("Book Created Successfully. Book Id is :"+book.getId(),HttpStatus.CREATED);

	}

	@PutMapping("{authorId}/book/{bookId}")
	public ResponseEntity<String> updateBook(@PathVariable Long authorId,

			@PathVariable Long bookId, @RequestParam String tittle, @RequestParam String category,
			@RequestParam float price, @RequestParam String authorName, @RequestParam String publisher,
			@RequestParam String publisherDate, @RequestParam boolean active, @RequestParam String content
			/*@RequestParam("image") MultipartFile image*/) throws IOException {
		Book bookDto = new Book();
		bookDto.setId(bookId);
		bookDto.setTittle(tittle);
		bookDto.setCategory(category);
		bookDto.setPrice(price);
		bookDto.setAuthorName(authorName);
		bookDto.setPublisher(publisher);
		bookDto.setPublishedDate(publisherDate);
		bookDto.setActive(active);
		bookDto.setContent(content);
		bookDto.setAuthorDetails(new AuthorDetails(authorId, authorName));
		
		Book book = bookService.updateBook(bookDto);
		return new ResponseEntity<String>("Book Updated Successfully. Book Id is :"+book.getId(),HttpStatus.CREATED);

	}


	@GetMapping("book/search/{category}/{price}/{authorName}/{publisher}")
	public ResponseEntity<List<Book>> getBooksBySearchCriteria(@PathVariable(name = "category") String category,
			@PathVariable(name = "price") float price, @PathVariable(name = "authorName") String authorName,
			@PathVariable(name = "publisher") String publisher) {
		List<Book> books=bookService.getBooksBySearchCriteria(category, price, authorName, publisher);
		 
		return new ResponseEntity<List<Book>>(books,HttpStatus.OK);

	}

    @GetMapping("book/{bookID}/")
	public ResponseEntity<Book> getBookById(@PathVariable("bookID") Long bookID){
		Book book=bookService.getBookById(bookID);
		return new ResponseEntity<Book>(book,HttpStatus.OK);
	}
}
