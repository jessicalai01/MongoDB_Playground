package com.example.demo.controller;

import com.example.demo.model.entity.BookEntity;
import com.example.demo.service.ManageMyBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/book")
public class PrivateBookController {
    private ManageMyBookService manageMyBookService;
    @GetMapping("/myList")
    public ResponseEntity<?> getMyList(){
        log.info("getting my list");
        var myList = manageMyBookService.getMyBook();
        if (myList.isEmpty())
            return new ResponseEntity<>("You have no books in your list", HttpStatus.OK);
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }
    @PostMapping("/saveToMyList")
    public ResponseEntity<?> saveToMyList(BookEntity bookEntity){
        log.info("saving book to my list");
        manageMyBookService.saveBook(bookEntity);
        return new ResponseEntity<>("Made the book mine.", HttpStatus.OK);
    }



}
