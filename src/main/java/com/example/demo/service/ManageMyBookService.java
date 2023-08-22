package com.example.demo.service;

import com.example.demo.component.PrivateBookEntityToObjectConverter;
import com.example.demo.component.PublicToPrivateConverter;
import com.example.demo.model.entity.BookEntity;
import com.example.demo.model.response.MyBookObject;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.MyBookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ManageMyBookService {
    private final MyBookRepository privateRepository;
    private final BookRepository publicRepository;
    private final PublicBookService publicBookService;

    public boolean saveBook(BookEntity bookEntity){
        log.info("saving book: {} into private repository", bookEntity.getTitle());
        var books = publicRepository.findByTitle(bookEntity.getTitle());
        if (books != null){
            var bookToSave = PublicToPrivateConverter.convertToPrivate(books);
            privateRepository.save(bookToSave);
            log.info("Finished save book service");
            return true;
        } else{
            log.info("Book not found");
            return false;
        }
    }
    public List<MyBookObject> getMyBook(){
        log.info("getting all books from private repository");
        var allBooks = privateRepository.findAll().stream().map(PrivateBookEntityToObjectConverter::entityToObject).toList();
        log.info("Finished Book query service: Number of books found: {}", allBooks.size());
        return allBooks;
    }

}
