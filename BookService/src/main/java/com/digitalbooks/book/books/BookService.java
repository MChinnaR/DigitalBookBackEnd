package com.digitalbooks.book.books;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.digitalbooks.book.constants.ResponseConstants;
import com.digitalbooks.book.entitys.BaseResponse;
import com.digitalbooks.book.entitys.BookDetails;
import com.digitalbooks.book.exceptionhandler.BooksExceptionHandler;
import com.digitalbooks.book.kafka.Producer;

@Service
@Component
public class BookService {

	@Autowired
	private BookDao dao;

	@Autowired
	private BookFegin fegin;
	@Autowired
	private Producer producer;

	public BaseResponse publishBook(BookDetails bookDetails) throws BooksExceptionHandler {
		BookDetails details = null;
		BaseResponse b = null;
		try {
			if (bookDetails != null)
				details = dao.save(bookDetails);
		} catch (Exception e) {
			throw new BooksExceptionHandler("Exception occured while inserting data into db");
		}
		b = details != null ? new BaseResponse(ResponseConstants.SUCCESS, ResponseConstants.SUCCESSMESSAGE)
				: new BaseResponse(ResponseConstants.FAIL, ResponseConstants.FAILMESSAGE);
		System.out.println(b.toString());
		return b;
	}

	public List<BookDetails> getAllBooksForAuthor(int authorProfileId) throws BooksExceptionHandler {
		try {
			return dao.findByAuthorId(authorProfileId);
		} catch (Exception e) {
			throw new BooksExceptionHandler("Exception occured while fetching the data with email", e);
		}
	}

	public BaseResponse editOrBlockBook(BookDetails bookDetails) throws BooksExceptionHandler {
		BookDetails response = null;
		BaseResponse baseResponse = new BaseResponse(ResponseConstants.SUCCESS, ResponseConstants.SUCCESSFULL);
		try {
			BookDetails dbDetails = null;
			java.util.Optional<BookDetails> details = dao.findById(bookDetails.getBookId());
			if (details != null) {
				dbDetails = details.get();
				dbDetails.setTitle(bookDetails.getTitle());
				dbDetails.setActive(bookDetails.getActive());
				dbDetails.setContent(bookDetails.getContent());
				dbDetails.setCategory(bookDetails.getCategory());
				dbDetails.setPrice(bookDetails.getPrice());
				response = dao.save(dbDetails);
			}
//			if (response != null) {
//				if (bookDetails.getActive() == 1)
//					producer.sendMsgToConsumer(
//							bookDetails.getTitle().toUpperCase() + " book has been blocked by author "
//									+ bookDetails.getAuthorName().toUpperCase() + " and you cant reade this from now");
//				else
//					producer.sendMsgToConsumer(bookDetails.getTitle().toUpperCase() + " book has been edited by author "
//							+ bookDetails.getAuthorName().toUpperCase());
////				return fegin.blockBookForUser(dbDetails.getBookId());
//			}
		} catch (Exception e) {
			throw new BooksExceptionHandler("Exception occured while fetching the data with bookId", e);
		}
		return baseResponse;
	}

	public List<BookDetails> getBooksBySearch(String title, String author, String publisher, long fromDate, long toDate)
			throws BooksExceptionHandler {
		try {
			return dao.getBooksBySearch(title, author, publisher, fromDate, toDate);
		} catch (Exception e) {
			throw new BooksExceptionHandler("Exception occured while fetching the data with search details", e);
		}
	}

	public List<BookDetails> getPurchasedBooksForUser(List<Integer> bookIds) throws BooksExceptionHandler {
		List<BookDetails> details = new ArrayList<BookDetails>();
		try {
			for (int i : bookIds) {
				details.add(dao.findById(i).get());
			}
		} catch (Exception e) {
			throw new BooksExceptionHandler("Exception occured while fetching the data with bookId", e);
		}
		return details;
	}

	public String hello(String a) {
		try {
			return a;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<BookDetails> getAllBooksForUser() throws BooksExceptionHandler {
		try {
			return dao.findAll();
		} catch (Exception e) {
			throw new BooksExceptionHandler("Exception occured while fetching all books", e);
		}
	}

}
