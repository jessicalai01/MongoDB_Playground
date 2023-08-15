package com.example.demo.controller;

import com.example.demo.model.response.BookObject;
import com.example.demo.service.PublicBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {
    private final PublicBookService publicBookService;

    public BookController(PublicBookService publicBookService) {
        this.publicBookService = publicBookService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getBook() {
        var allBooks = publicBookService.getAllBook();
        if (!allBooks.isEmpty()){
            log.info("Starting returning all books");
            return new ResponseEntity(allBooks, HttpStatus.OK);
        }
        return new ResponseEntity("sorry we have no books", HttpStatus.OK);

    }
    @PostMapping("/save")
    public ResponseEntity<?> addBook(@RequestBody BookObject bookObject) {
        publicBookService.saveAllBooks(bookObject);
        return new ResponseEntity("New book added!", HttpStatus.OK);
    }
    @PostMapping("/update")
    public ResponseEntity<?> updateBook(@RequestBody BookObject bookObject) {
        publicBookService.saveAllBooks(bookObject);
        return new ResponseEntity("Update book!", HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteBook(BookObject ob) throws Exception {
        publicBookService.deleteBookByName(ob.getName());
        return new ResponseEntity("Book deleted!", HttpStatus.OK);
    }

    @GetMapping("/findBookByAuthor")
    public ResponseEntity<?> findBookByAuthor(@RequestBody BookObject ob) {
        var books = publicBookService.findBookByAuthor(ob.getAuthor());
        if (books.isEmpty()){
            return new ResponseEntity("No books found", HttpStatus.OK);
        }
        return new ResponseEntity(books, HttpStatus.OK);
    }

}
