package com.example.demo.controller;

import com.example.demo.db.BookObject;
import com.example.demo.db.BookRepository;
import com.example.demo.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/")
    public ResponseEntity<?> getBook() {
        var allBooks = bookService.getAllBook();
        if (allBooks.size()>0){
            log.info("Starting returning all books");
            return new ResponseEntity(allBooks, HttpStatus.OK);
        }
        return new ResponseEntity("sorry we have no books", HttpStatus.OK);

    }
    @PostMapping("/save")
    public ResponseEntity<?> addBook(@RequestBody BookObject bookObject) {
        bookService.saveAllBooks(bookObject);
        return new ResponseEntity("New book added!", HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteBook(BookObject ob) {
        bookService.deleteBookByName(ob.getName());
        return new ResponseEntity("Book deleted!", HttpStatus.OK);
    }
    @PostMapping("/deleteAll")
    public ResponseEntity<?> deleteAllBook() {
        bookService.deleteAll();
        return new ResponseEntity("Book deleted!", HttpStatus.OK);
    }


}
