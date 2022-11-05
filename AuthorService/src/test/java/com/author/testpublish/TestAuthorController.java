package com.author.testpublish;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;

import com.digitalbooks.author.entitys.AuthorDetails;
import com.digitalbooks.author.exceptionhandler.AuthorExceptionHandler;
import com.digitalbooks.author.publish.AuthorDao;
import com.digitalbooks.author.publish.AuthorService;

//@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
@SpringBootConfiguration
@ExtendWith(MockitoExtension.class)
public class TestAuthorController {

	@Mock
	private AuthorDao dao;

	@Autowired
	AuthorService service;

	@Test
	public void testRegister() throws AuthorExceptionHandler {
		when(dao.save(new AuthorDetails())).thenReturn(new AuthorDetails("reddy", "reddy", "reddy"));
		assertEquals(new AuthorDetails("reddy", "reddy", "reddy"),
				service.registerAuthor(new AuthorDetails("reddy", "reddy", "reddy")));
	}
}
