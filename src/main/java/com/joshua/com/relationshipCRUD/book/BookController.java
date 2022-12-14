package com.joshua.com.relationshipCRUD.book;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

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
    public ResponseEntity<?> addBook(@Validated @RequestBody Book book) {
        try {
            Optional<Book> checkBook = bookRepo.findBookByIdAndDeletedFlag(book.getId(), "N");
            if (checkBook.isPresent()) {
                return new ResponseEntity<>("Code exist", HttpStatus.valueOf(HttpStatus.NOT_ACCEPTABLE.value()));

            } else {
                Book addBook = bookRepo.save(book);
                log.info("BOOK CREATED SUCCESSFULLY");
                return new ResponseEntity<>("BOOK CREATED SUCCESSFULLY", HttpStatus.CREATED);
            }
        } catch (Exception exception) {
            log.info("CAN NOT CREATE NEW BOOK" + exception);
            return null;
        }

    }
}
