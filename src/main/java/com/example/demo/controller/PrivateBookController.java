package com.example.demo.controller;

import com.example.demo.model.entity.BookEntity;
import com.example.demo.repository.MyBookRepository;
import com.example.demo.service.ManageMyBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/book")
public class PrivateBookController {
    private final ManageMyBookService manageMyBookService;
    private final MyBookRepository privateRepository;

    public PrivateBookController(ManageMyBookService manageMyBookService, MyBookRepository privateRepository) {
        this.manageMyBookService = manageMyBookService;
        this.privateRepository = privateRepository;
    }

    @GetMapping("/myList")
    public ResponseEntity<?> getMyList(){
        log.info("getting my list");
        var myList = manageMyBookService.getMyBook();
        if (myList.isEmpty())
            return new ResponseEntity<>("You have no books in your list", HttpStatus.OK);
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }
    @PostMapping("/saveToMyList")
    public ResponseEntity<?> saveToMyList(@RequestBody BookEntity bookEntity){
        log.info("saving book to my list");
        boolean saved = manageMyBookService.saveBook(bookEntity);
        if (!saved)
            return new ResponseEntity<>("Book not found", HttpStatus.OK);
        return new ResponseEntity<>("Made the book mine.", HttpStatus.OK);
    }
    @PostMapping("/deleteAll")
    public ResponseEntity<?> deleteAllBook() {
        privateRepository.deleteAll();
        return new ResponseEntity("Book deleted!", HttpStatus.OK);
    }



}
