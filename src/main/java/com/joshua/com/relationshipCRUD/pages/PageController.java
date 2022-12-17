package com.joshua.com.relationshipCRUD.pages;

import com.joshua.com.relationshipCRUD.book.Book;
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

@Api(value = "Pages API", tags = "Page APIs ")
@Slf4j
@RequestMapping("api/v1/page")
@RestController
public class PageController {
    private final PageService pageService;
    private final PageRepo pageRepo;

    public PageController(PageService pageService1, PageRepo pageRepo1) {
        this.pageService = pageService1;
        this.pageRepo = pageRepo1;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNewPage(@Validated @RequestBody Page page) {
        try {
            Optional<Page> searchPageNumber = pageRepo.findPageByNumber(page.getNumber());
            if (searchPageNumber.isPresent()) {
                EntityResponse response = new EntityResponse();
                response.setMessage("THE PAGE WITH NUMBERING" + " " + page.getNumber() + " " + "ALREADY NUMBERED");
                response.setStatusCode(HttpStatus.OK.value());
                response.setEntity("");
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                pageService.addNewPage(page);
                EntityResponse response = new EntityResponse();
                response.setMessage(RESPONSEMESSAGES.PAGE + " " + page.getNumber() + " " + RESPONSEMESSAGES.BOOK_PAGE_ADDED_SUCCESSFULLY);
                response.setStatusCode(HttpStatus.CREATED.value());
                response.setEntity(page);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }

        } catch (Exception e) {
            log.info("{CACHED ERROR}" + e);
            return null;
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllPages() {
        try {
            List<Page> pages = pageService.getAllPages();
            EntityResponse response = new EntityResponse();
            response.setMessage(RESPONSEMESSAGES.RECORD_FOUND);
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setEntity(pages);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            log.info("{CACHED ERROR}" + e);
            return null;
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getPageById(@PathVariable("id") Long id) {
        try {
            Optional<Page> findpage = pageRepo.findPageById(id);
            EntityResponse response = new EntityResponse();
            if(!findpage.isPresent()){
                response.setMessage("THE PAGE WITH ID" + " " + id + " " + "NOT FOUND");
                response.setStatusCode(HttpStatus.OK.value());
                response.setEntity("");
            } else{
                response.setMessage(RESPONSEMESSAGES.RECORD_FOUND);
                response.setStatusCode(HttpStatus.CREATED.value());
                response.setEntity(findpage);
            }
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {
            log.info("{CACHED ERROR}" + e);
            return null;
        }
    }

    @GetMapping("/find/number/{number}")
    public ResponseEntity<?> getPageByNumber(@PathVariable("number") int number) {
        try {
            Optional<Page> findPageNumber = pageRepo.findPageByNumber(number);
            EntityResponse response = new EntityResponse();
            if(!findPageNumber.isPresent()){
                response.setMessage("THE PAGE WITH NUMBERING" + " " + number + " " + "NOT FOUND");
                response.setStatusCode(HttpStatus.OK.value());
                response.setEntity("");
            } else{
                response.setMessage(RESPONSEMESSAGES.RECORD_FOUND);
                response.setStatusCode(HttpStatus.CREATED.value());
                response.setEntity(findPageNumber);
            }
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {
            log.info("{CACHED ERROR}" + e);
            return null;
        }
    }

}
