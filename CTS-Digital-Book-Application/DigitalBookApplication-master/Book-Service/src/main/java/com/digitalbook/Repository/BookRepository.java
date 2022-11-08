package com.digitalbook.Repository;

import com.digitalbook.Model.Book;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {


	
	@Query(value = "\n"
			+ "select * from  book where book.id=:bookId and book.authoer_details_id in (select authoer_details.id from authoer_details where authoer_details.auth_id=:authId)\n"
			+ "",nativeQuery = true)
	Book getBookByBookIdAndAuthId(Long bookId, Long authId);

	@Query(value = "select * from  book b where b.category=:category and b.price=:price "
			+ "and b.author_name=:authorName "
			+ "and b.publisher=:publisher", nativeQuery = true)
	List<Book> getBookOnSerachCriteria(String category, float price, String authorName, String publisher);

}
