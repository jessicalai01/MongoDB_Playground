package com.example.demo.service;

import com.example.demo.component.BookEntityToObjectConverter;
import com.example.demo.component.ObjectToEntityConverter;
import com.example.demo.db.BookObject;
import com.example.demo.db.BookRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {
    private final BookRepository repository;

    public List<BookObject> getAllBook() {
        var allBooks = repository.findAll().stream().map(BookEntityToObjectConverter::convert).toList();
        log.info("Finished Book query service: Number of books found: {}", allBooks.size());
        return allBooks;

    }
    public void saveAllBooks(BookObject bookObject){
        log.info("saving book: {}", bookObject.getName());
        repository.save(ObjectToEntityConverter.convert(bookObject));
        log.info("Finished save book service");
    }
    public void deleteBookByName(String name){
        log.info("deleting book: {}", name);
        repository.deleteBookByName(name);
        log.info("Finished deleting book service");
    }

    public void deleteAll(){
        repository.deleteAll();
        log.info("Finished deleting ALL book service");
    }
    public void update(String name){
        repository.updateBook(name);
        log.info("Finished updating book: {}", name);
    }

}
