package com.author;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.digitalbooks.author.entitys.AuthorDetails;
import com.digitalbooks.author.exceptionhandler.AuthorExceptionHandler;
import com.digitalbooks.author.publish.AuthorDao;
import com.digitalbooks.author.publish.AuthorService;

@SpringBootTest(classes = AuthorDao.class)
@ContextConfiguration
class AuthorServiceApplicationTests {

	@Autowired
	private AuthorDao dao;

	@Autowired
	private AuthorService service;

	@Test
	void contextLoads() {
		assertEquals(1, 1);
	}

	@Test
	public void add() throws AuthorExceptionHandler {
		assertEquals("chinna", service.registerAuthor(new AuthorDetails("", "", "")));
	}

}
