package com.joshua.com.relationshipCRUD.book;

import com.joshua.com.relationshipCRUD.utils.httpInterceptor.EntityRequestContext;
import com.joshua.com.relationshipCRUD.utils.httpInterceptor.UserRequestContext;
import com.joshua.com.relationshipCRUD.utils.responses.EntityResponse;
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
    public ResponseEntity<?> registerBook(@RequestBody Book book) {
        try {
            book.setPostedFlag("Y");
            book.setPostedTime(new Date());
            book.setPostedBy("ROTICH");
            book.setEntityId("EN001");

            bookService.registerBook(book);
            EntityResponse response = new EntityResponse();
            response.setMessage(HttpStatus.CREATED.getReasonPhrase());
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setEntity(book);
            return new ResponseEntity<>(response, HttpStatus.OK);



        } catch (Exception e) {
            return null;
        }
    }
//    public ResponseEntity<?> addBook(@Validated @RequestBody Book book) {
//        try {
//            Optional<Book> checkBook = bookRepo.findBookByIdAndDeletedFlag(book.getId(), "N");
//            if (checkBook.isPresent()) {
//                return new ResponseEntity<>("Code exist", HttpStatus.valueOf(HttpStatus.NOT_ACCEPTABLE.value()));
//
//            } else {
//                Book addBook = bookRepo.save(book);
//                log.info("BOOK CREATED SUCCESSFULLY");
//                return new ResponseEntity<>("BOOK CREATED SUCCESSFULLY", HttpStatus.CREATED);
//            }
//        } catch (Exception exception) {
//            log.info("CAN NOT CREATE NEW BOOK" + exception);
//            return null;
//        }
//
//    }
    }
