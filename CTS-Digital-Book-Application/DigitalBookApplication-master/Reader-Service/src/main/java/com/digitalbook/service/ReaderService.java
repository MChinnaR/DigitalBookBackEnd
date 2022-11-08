package com.digitalbook.service;

import java.io.IOException;
import java.util.List;

import com.digitalbook.modal.SubscribtionBook;
import com.digitalbook.response.BookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;



import com.digitalbook.modal.ReaderPaymentInfo;
import com.digitalbook.repository.SubscriptionWithPaymentReository;

@Service
public class ReaderService {
	
	
	@Autowired
	private SubscriptionWithPaymentReository repo;
	@Autowired
	BookRestConsumer consumer;
	
	public String saveSubscibtionBook(ReaderPaymentInfo payInfo) throws IOException {
		ReaderPaymentInfo paymentIno=repo.save(payInfo);
		return "Payment is Completed. Payment Id : "+paymentIno.getId();
	}
	public List<ReaderPaymentInfo> getSubscribtionBooks(String email){
		
		return repo.findByReaderEmail(email);
		
	}
	
	 @KafkaListener(topics ="author-bookupdate-topic", 
	            groupId = "group-id")
	    public void consume(String message) {
		 
	        System.out.println("Message recived from Book Service After Update :"+message);

	       ReaderPaymentInfo paymentInfo= repo.getBookByBookId(Long.parseLong(message));

	       if(paymentInfo!=null){
			   ResponseEntity<BookResponse> bookRespons = consumer.getBookById(Long.parseLong(message));
			   BookResponse response= bookRespons.getBody();

			   SubscribtionBook bookdto = new SubscribtionBook();
			   bookdto.setId(paymentInfo.getBook().getId());
			   bookdto.setBookId(response.id);
			   bookdto.setTittle(response.tittle);
			   bookdto.setCategory(response.getCategory());
			   bookdto.setPrice(response.getPrice());
			   bookdto.setAuthorName(response.getAuthorName());
			   bookdto.setPublisher(response.getPublisher());
			   bookdto.setPublishedDate(response.publishedDate);
			   bookdto.setActive(response.active);
			   bookdto.setContent(response.content);

			   //paymentInfo.setId(paymentInfo.getId());
			   paymentInfo.setBook(bookdto);

			  ReaderPaymentInfo updatedBykafka= repo.save(paymentInfo);
			  System.out.println("Updated with kafka data :"+updatedBykafka);



		   }



	    }
}
