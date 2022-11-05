//package com.book;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.mockito.Mockito.when;
//
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import org.junit.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.SpringBootConfiguration;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.digitalbooks.book.books.BookDao;
//import com.digitalbooks.book.books.BookService;
//import com.digitalbooks.book.constants.ResponseConstants;
//import com.digitalbooks.book.entitys.BaseResponse;
//import com.digitalbooks.book.entitys.BookDetails;
//import com.digitalbooks.book.exceptionhandler.BooksExceptionHandler;
//
////@RunWith(MockitoJUnitRunner.class)
////@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//@SpringBootConfiguration
//@ExtendWith(MockitoExtension.class)
//class BookServiceApplicationTests {
//
//	@InjectMocks
//	private BookService service;
//
//	@Mock
//	private BookDao dao;
//
//	@Test
//	void contextLoads() {
//	}
//
//	@Test
//	public void myTest() {
//		assertNotNull(service);
//		assertNotNull(dao);
//	}
//
//	@Test
//	public void testPublishBook() throws BooksExceptionHandler, NullPointerException {
//		BookDetails details = new BookDetails(1, "c", "c", "c", 200.0, "c", 1, "c", "c", 1234567890l, 1);
//		when(dao.save(details)).thenReturn(details);
////		System.out.println(service.publishBook(details));
//		assertEquals(new BaseResponse(ResponseConstants.SUCCESS, ResponseConstants.SUCCESSMESSAGE),
//				service.publishBook(details));
//	}
//
//	@Test
//	public void testPublishBookNullCase() throws BooksExceptionHandler, NullPointerException {
//		BookDetails details = new BookDetails(1, "c", "c", "c", 200.0, "c", 1, "c", "c", 1234567890l, 1);
//		when(dao.save(details)).thenReturn(null);
//		assertEquals(new BaseResponse(ResponseConstants.FAIL, ResponseConstants.FAILMESSAGE),
//				service.publishBook(details));
//	}
//
//	@Test(expected = BooksExceptionHandler.class)
//	public void testPublishBookNullException() throws BooksExceptionHandler, NullPointerException {
//		BookDetails details = new BookDetails(1, "c", "c", "c", 200.0, "c", 1, "c", "c", 1234567890l, 1);
//		when(dao.save(null)).thenThrow(BooksExceptionHandler.class);
//		service.publishBook(details);
////		assertThrows(BooksExceptionHandler.class, service.publishBook(details),
////				"Exception occured while inserting data into db");
//	}
//
//	@Test
//	public void testGetAllBooks() throws BooksExceptionHandler, NullPointerException {
//		when(dao.findByAuthorId(1)).thenReturn(Stream
//				.of(new BookDetails(1, "c", "c", "c", 200.0, "c", 1, "c", "c", 1234567890l, 1),
//						new BookDetails(1, "c", "c", "c", 200.0, "c", 1, "c", "c", 1234567890l, 1))
//				.collect(Collectors.toList()));
//		assertEquals(2, service.getAllBooksForAuthor(1).size());
//	}
//
//	@Test
//	public void testGetAllBooksException() throws BooksExceptionHandler, NullPointerException {
//		when(dao.findByAuthorId(1)).thenReturn(null);
//		assertEquals(new BooksExceptionHandler("Exception occured while fetching the data with email"),
//				service.getAllBooksForAuthor(1).size());
//	}
//}
