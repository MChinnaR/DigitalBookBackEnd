package com.digitalbook;

import com.digitalbook.Model.AuthorDetails;
import com.digitalbook.Model.Book;
import com.digitalbook.Repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class BookServiceApplicationTests {
	@Autowired
	BookRepository bookRepository;


//Test Cases for Dao Layer
	@Test
	void getBookOnSerachCriteria(){
		List<Book> list=new ArrayList<Book>();
		AuthorDetails authorDetails=new AuthorDetails(Long.valueOf(237324657),"Ramaraju");
		Book b=new Book(Long.valueOf(1),"Do Good Be good","Learn Valus",150000,
				"Ramaraju","Ram Publicashion","2022-08-02",
				"Change the life of leving",true,authorDetails);
		list.add(b);
		List<Book> bookList=bookRepository.getBookOnSerachCriteria("Learn Valus",150000,"Ramaraju","Ram Publicashion");

		assertEquals(bookList.size(),list.size());

	}
	@Test
	void getBookByBookIdAndAuthId(){
		AuthorDetails authorDetails=new AuthorDetails(Long.valueOf(237324657),"Ramaraju");
		Book expected=new Book(Long.valueOf(1),"Do Good Be good","Learn Valus",150000,
				"Ramaraju","Ram Publicashion","2022-08-02",
				"Change the life of leving",true,authorDetails);
		Book actualy=bookRepository.getBookByBookIdAndAuthId(Long.valueOf(1),Long.valueOf(237324657));
		assertEquals(expected.getId(),actualy.getId());

	}






}
