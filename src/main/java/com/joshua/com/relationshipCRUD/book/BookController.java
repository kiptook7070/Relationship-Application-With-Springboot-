package com.joshua.com.relationshipCRUD.book;

import com.joshua.com.relationshipCRUD.utils.responses.EntityResponse;
import com.joshua.com.relationshipCRUD.utils.responses.RESPONSEMESSAGES;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Api(value = "Books API", tags = "Book APIs")
@Slf4j
@RequestMapping("v1/api/book")
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
            if (findIsbn.isPresent()) {
                EntityResponse response = new EntityResponse();
                response.setMessage("THE BOOK WITH ISBN REGISTRATION" + " " + book.getIsbn() + " " + "ALREADY REGISTERED");
                response.setStatusCode(HttpStatus.OK.value());
                response.setEntity("");
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                book.setPostedFlag("Y");
                book.setPostedTime(new Date());
                book.setPostedBy("ROTICH");
                book.setEntityId("EN001");
                bookService.updateBook(book);
                EntityResponse response = new EntityResponse();
                response.setMessage(RESPONSEMESSAGES.BOOK + " " + book + " " + RESPONSEMESSAGES.BOOK_ADDED_SUCCESSFULLY);
                response.setStatusCode(HttpStatus.CREATED.value());
                response.setEntity(book);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }

        } catch (Exception e) {
            log.info("{CACHED ERROR}" + e);
            return null;
        }
    }
@GetMapping("/all")
    public ResponseEntity<?> getAllBooks() {
        try {
            List<Book> book = bookService.getAllBooks();
            EntityResponse response = new EntityResponse();
            response.setMessage(RESPONSEMESSAGES.RECORD_FOUND);
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setEntity(book);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            log.info("{CACHED ERROR}" + e);
            return null;
        }
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateBook(@Validated @RequestBody Book book){
        try {
            Optional<Book> bookId = bookRepo.findBookById(book.getId());
            if (!bookId.isPresent()) {
                EntityResponse response = new EntityResponse();
                response.setMessage("THE BOOK WITH CODE REGISTRATION" + " " + book.getId() + " " + "NOT FOUND");
                response.setStatusCode(HttpStatus.OK.value());
                response.setEntity("");
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                book.setModifiedFlag("Y");
                book.setModifiedTime(new Date());
                book.setModifiedBy("ROTICH");
                book.setEntityId("EN001");

                bookService.updateBook(book);
                EntityResponse response = new EntityResponse();
                response.setMessage(RESPONSEMESSAGES.BOOK + " " + book.getIsbn() + " " + RESPONSEMESSAGES.BOOK_UPDATED);
                response.setStatusCode(HttpStatus.CREATED.value());
                response.setEntity(book);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }

        } catch (Exception e) {
            log.info("{CACHED ERROR}" + e);
            return null;
        }
    }
}
