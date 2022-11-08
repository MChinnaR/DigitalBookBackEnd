package com.digitalbook.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.digitalbook.response.BookResponse;



@FeignClient(name="BOOK-SERVICE")
public interface  BookRestConsumer {
	
	@GetMapping("/api/v1/digitalbook/book/search/{category}/{price}/{authorName}/{publisher}")
	public ResponseEntity<List<BookResponse>> getBooksBySearchCriteria(@PathVariable(name = "category") String category,
			@PathVariable(name = "price") float price, @PathVariable(name = "authorName") String authorName,
			@PathVariable(name = "publisher") String publisher);

	@GetMapping("/api/v1/digitalbook/book/{bookID}/")
	public ResponseEntity<BookResponse> getBookById(@PathVariable("bookID") Long bookID);

}
