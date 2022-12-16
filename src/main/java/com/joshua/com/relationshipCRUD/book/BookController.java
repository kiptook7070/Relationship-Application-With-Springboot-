package com.joshua.com.relationshipCRUD.book;

import com.joshua.com.relationshipCRUD.utils.httpInterceptor.EntityRequestContext;
import com.joshua.com.relationshipCRUD.utils.httpInterceptor.UserRequestContext;
import com.joshua.com.relationshipCRUD.utils.responses.EntityResponse;
import com.joshua.com.relationshipCRUD.utils.responses.RESPONSEMESSAGES;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Optional;

@Slf4j
@RequestMapping("v1/api/book")
@Api(value = "Books API", tags = "Book PI")
@RestController
public class BookController {
    private final BookService bookService;
    private final BookRepo bookRepo;

    public BookController(BookService bookService1, BookRepo bookRepo1) {
        this.bookService = bookService1;
        this.bookRepo = bookRepo1;
    }
    @PostMapping("/add")
    public ResponseEntity<?> registerBook(@Validated @RequestBody Book book) {
        try {
            Optional<Book> findIsbn = bookRepo.findBookByIsbn(book.getIsbn());
            if (findIsbn.isPresent()){
                EntityResponse response = new EntityResponse();
                response.setMessage("THE BOOK WITH ISBN REGISTRATION"+ " " + book.getIsbn() + " " + "ALREADY REGISTERED");
                response.setStatusCode(HttpStatus.OK.value());
                response.setEntity("");
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                book.setPostedFlag("Y");
                book.setPostedTime(new Date());
                book.setPostedBy("ROTICH");
                book.setEntityId("EN001");

                bookService.registerBook(book);
                EntityResponse response = new EntityResponse();
                response.setMessage(RESPONSEMESSAGES.BOOK + " " + book.getIsbn() + " " + RESPONSEMESSAGES.BOOK_ADDED_SUCCESSFULLY);
                response.setStatusCode(HttpStatus.CREATED.value());
                response.setEntity(book);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }

        } catch (Exception e) {
            return null;
        }
    }
    }
