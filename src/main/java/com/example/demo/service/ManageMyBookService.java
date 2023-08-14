package com.example.demo.service;

import com.example.demo.component.PrivateBookEntityToObjectConverter;
import com.example.demo.component.PublicToPrivateConverter;
import com.example.demo.model.entity.BookEntity;
import com.example.demo.model.entity.MyBoookEntity;
import com.example.demo.model.response.BookObject;
import com.example.demo.model.response.MyBookObject;
import com.example.demo.repository.MyBookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ManageMyBookService {
    private MyBookRepository privateRepository;
    private PublicBookService publicBookService;
    private PublicToPrivateConverter publicToPrivateConverter;
    private PrivateBookEntityToObjectConverter privateBookEntityToObjectConverter;

    public void saveBook(BookEntity bookEntity){
        log.info("saving book: {} into private repository", bookEntity.getName());
        var bookToSave = publicToPrivateConverter.convertToPrivate(bookEntity);
        privateRepository.save(bookToSave);
        log.info("Finished save book service");
    }
    public List<MyBookObject> getMyBook(){
        log.info("getting all books from private repository");
        var allBooks = privateRepository.findAll().stream().map(privateBookEntityToObjectConverter::entityToObject).toList();
        log.info("Finished Book query service: Number of books found: {}", allBooks.size());
        return allBooks;
    }

}
