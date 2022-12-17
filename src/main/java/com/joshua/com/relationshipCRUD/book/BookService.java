package com.joshua.com.relationshipCRUD.book;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BookService {
    private final BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public Book registerBook(Book book) {
        try {
            Book saveBook = bookRepo.save(book);
            log.info("BOOK REGISTERED SUCCESSFULLY");
            return saveBook;
        } catch (Exception exception) {
            log.info("BOOK NOT REGISTERED!!" + exception);
            return null;
        }
    }

    public List<Book> getAllBooks() {
        try {
            log.info("BOOKS RETRIEVED SUCCESSFULLY");
            return bookRepo.findAll() ;
        } catch (Exception exception) {
            log.info("FAILED TO GET BOOKS!!" + exception);
            return null;
        }
    }

    public Book updateBook(Book book) {
        try {
            Book updateBook = bookRepo.save(book);
            log.info("BOOK MODIFIED SUCCESSFULLY");
            return updateBook;
        } catch (Exception exception) {
            log.info("CAN NOT MODIFY THE BOOK RESULTS!!" + exception);
            return null;
        }
    }
}
