package com.example.demo.controller;

import com.example.demo.component.BookEntityToObjectConverter;
import com.example.demo.db.BookEntity;
import com.example.demo.db.BookObject;
import com.example.demo.db.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {
    private BookRepository repository;
    private BookEntityToObjectConverter entityToObjectConverter;

    @GetMapping
    public List<BookObject> getBook() {
        var allBooks = repository.findAll().stream().map(entityToObjectConverter::convert).toList();
        log.info("Number of books: {}", allBooks.size());
        return allBooks;
    }
    @PostMapping("/add")
    public String addBook(BookEntity book) {
        repository.save(book);
        return "Added book: " + book.getName();
    }

    @PostMapping("/delete")
    public void deleteBook(String name) {
        repository.deleteByName(name);
    }

}
