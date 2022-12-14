package com.joshua.com.relationshipCRUD.book;

import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepo bookRepo;

    public BookService(BookRepo bookRepo1) {
        this.bookRepo = bookRepo1;
    }
}
