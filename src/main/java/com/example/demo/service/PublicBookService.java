package com.example.demo.service;

import com.example.demo.component.BookEntityToObjectConverter;
import com.example.demo.component.ObjectToEntityConverter;
import com.example.demo.model.response.BookObject;
import com.example.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PublicBookService {
    private final BookRepository repository;

    @Cacheable(value = "allBooks")
    public List<BookObject> getAllBook() {
        var allBooks = repository.findAll().stream().map(BookEntityToObjectConverter::convert).toList();
        log.info("Finished Book query service: Number of books found: {}", allBooks.size());
        return allBooks;

    }
    public void saveAllBooks(BookObject bookObject){
        log.info("saving book: {}", bookObject.getTitle());
        repository.save(ObjectToEntityConverter.convert(bookObject));
        log.info("Finished save book service");
    }
    public void deleteBookByBookTitle(String title) throws Exception{
        log.info("deleting book: {}", title);
        try{repository.deleteBookByTitle(title);
        } catch (Exception e){
            log.info(String.valueOf(e));
        } finally {
            log.info("Finished deleting book service");
        }
    }

    public void deleteAll(){
        repository.deleteAll();
        log.info("Finished deleting ALL book service");
    }
    public List<BookObject> findBookByAuthor(String name){
        log.info("Starting fetching books");
        var books = repository.findByAuthor(name).stream().map(BookEntityToObjectConverter::convert).toList();
        log.info("Fetched books by {}", name);
        return books;
    }

}
