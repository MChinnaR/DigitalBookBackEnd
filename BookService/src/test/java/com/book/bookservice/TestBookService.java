package com.book.bookservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.SpringBootConfiguration;

import com.digitalbooks.book.books.BookDao;
import com.digitalbooks.book.books.BookService;
import com.digitalbooks.book.constants.ResponseConstants;
import com.digitalbooks.book.entitys.BaseResponse;
import com.digitalbooks.book.entitys.BookDetails;
import com.digitalbooks.book.exceptionhandler.BooksExceptionHandler;

//@RunWith(SpringRunner.class)
//@SpringBootTest
@SpringBootConfiguration
@ExtendWith(MockitoExtension.class)
public class TestBookService {

	@InjectMocks
	private BookService service;

	@Mock
	private BookDao dao;

	@Test
	public void myTest() {
		assertNotNull(service);
		assertNotNull(dao);
	}

//	@Test
//	public void testPublishBook() throws BooksExceptionHandler {
//		BookDetails details = new BookDetails();
//		when(dao.save(details)).thenReturn(details);
////		assertEquals(, 0);
//		assertNull(service.publishBook(details));
//	}

	@Test
	public void testGetAllBooks() throws BooksExceptionHandler, NullPointerException {
		when(dao.findByAuthorId(1)).thenReturn(Stream
				.of(new BookDetails(1, "c", "c", "c", 200.0, "c", 1, "c", "c", 1234567890l, 1),
						new BookDetails(1, "c", "c", "c", 200.0, "c", 1, "c", "c", 1234567890l, 1))
				.collect(Collectors.toList()));
		assertEquals(2, service.getAllBooksForAuthor(1).size());
	}

	@Test
	public void testPublishBook() throws BooksExceptionHandler, NullPointerException {
		BookDetails details = new BookDetails(1, "c", "c", "c", 200.0, "c", 1, "c", "c", 1234567890l, 1);
		when(dao.save(details)).thenReturn(details);
		BaseResponse b = service.publishBook(details);
		System.out.println(b.toString());
		assertEquals(new BaseResponse(ResponseConstants.SUCCESS, ResponseConstants.SUCCESSMESSAGE).getStatusCode(),
				b.getStatusCode());

	}

	@Test
	public void testPublishBookNullCase() throws BooksExceptionHandler, NullPointerException {
		BookDetails details = new BookDetails(1, "c", "c", "c", 200.0, "c", 1, "c", "c", 1234567890l, 1);
		when(dao.save(details)).thenReturn(null);
		BaseResponse b = service.publishBook(details);
		System.out.println(b.toString());
		assertEquals(new BaseResponse(ResponseConstants.FAIL, ResponseConstants.FAILMESSAGE).getStatusCode(),
				b.getStatusCode());
	}

	@Test
	public void testPublishBookNullException() throws BooksExceptionHandler, NullPointerException {
		BookDetails details = new BookDetails(1, "c", "c", "c", 200.0, "c", 1, "c", "c", 1234567890l, 1);
		when(dao.save(null)).thenThrow(new BooksExceptionHandler("Exception occured while inserting data into db"));
		assertEquals(new BooksExceptionHandler("Exception occured while inserting data into db").getMessage(),
				service.publishBook(null).getStatusMessage());
	}

//	@Test
//	public void testGetAllBooksException() throws BooksExceptionHandler, NullPointerException {
//		when(dao.findByAuthorId(1))
//				.thenThrow(new BooksExceptionHandler("Exception occured while fetching the data with email"));
//		assertEquals(new BooksExceptionHandler("Exception occured while fetching the data with email").getMessage(),
//				service.getAllBooksForAuthor(1).size());

//		BooksExceptionHandler b = Assertions.assertThrows(BooksExceptionHandler.class, () -> {
//			dao.findByAuthorId(1);
//		}, "Exception occured while fetching the data with email");
//		System.out.println(b.getMessage());
//		assertEquals(new BooksExceptionHandler("Exception occured while fetching the data with email").getMessage(),
//				b.getMessage());
//	}
}
