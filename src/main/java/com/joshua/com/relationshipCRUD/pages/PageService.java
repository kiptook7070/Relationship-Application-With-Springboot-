package com.joshua.com.relationshipCRUD.pages;

import com.joshua.com.relationshipCRUD.book.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PageService {
    public final PageRepo pageRepo;

    public PageService(PageRepo pageRepo) {
        this.pageRepo = pageRepo;
    }

    public Page addNewPage(Page page) {
        try {
            Page savePage = pageRepo.save(page);
            log.info("PAGE NUMBER ADDED SUCCESSFULLY");
            return savePage;
        } catch (Exception exception) {
            log.info("FAIL TO ADD PAGE NUMBER!!" + exception);
            return null;
        }
    }
}
