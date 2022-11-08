package com.digitalbook.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.digitalbook.modal.ReaderPaymentInfo;

@Repository
public interface SubscriptionWithPaymentReository extends JpaRepository<ReaderPaymentInfo, Long> {
	
	@Query(value = "select * from reader_pyment_info where reader_pyment_info.reader_email=:readerEmail",nativeQuery = true)
	List<ReaderPaymentInfo> findByReaderEmail(String readerEmail);

	@Query(value = "SELECT * FROM reader_pyment_info r where r.subscribtion_book in (SELECT b.id FROM subscribtion_book b where b.book_id=:bookId)" ,nativeQuery = true)
	ReaderPaymentInfo getBookByBookId(Long bookId);

}
