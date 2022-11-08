package com.digitalbook.Service;

import com.digitalbook.Model.AuthorDetails;
import com.digitalbook.Model.Book;
import com.digitalbook.Repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    BookRepository repository;
    BookService bookService;

   @BeforeEach
   void setUp(){
        this.bookService=new BookService(this.repository);
    }
//@Test
//    void getBooksBySearchCriteria(){
//        //Learn Valus/150000/Ramaraju/Ram Publicashion
//        bookService.getBooksBySearchCriteria("Learn Valus",150000,"Ramaraju","Ram Publicashion");
//        verify(repository).getBookOnSerachCriteria("Learn Valus",150000,"Ramaraju","Ram Publicashion");
//    }

    @Test
    void saveBook(){
        AuthorDetails authorDetails=new AuthorDetails(Long.valueOf(237324657),"Ramaraju");
        Book b=new Book("Do Good Be good","Learn Valus",150000,
                "Ramaraju","Ram Publicashion","2022-08-02",
                "Change the life of leving",true,authorDetails);
        bookService.saveBook(b);
        verify(repository).save(b);
    }

}
