package com.joshua.com.relationshipCRUD.pages;

import com.joshua.com.relationshipCRUD.book.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Page> getAllPages() {
        try {
            log.info("PAGES RETRIEVED SUCCESSFULLY");
            return pageRepo.findAll();
        } catch (Exception exception) {
            log.info("FAIL PAGES!!" + exception);
            return null;
        }
    }

    public Page updatePage(Page page) {
        try {
            log.info("PAGE UPDATED SUCCESSFULLY");
            return pageRepo.save(page);
        } catch (Exception exception) {
            log.info("FAIL PAGES!!" + exception);
            return null;
        }
    }
}
