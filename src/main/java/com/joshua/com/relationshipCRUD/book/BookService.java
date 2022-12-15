package com.joshua.com.relationshipCRUD.book;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
}
