package com.example.demo.repository;
import com.example.demo.model.entity.BookEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<BookEntity, String> {
    List<BookEntity>findAll();

    List<BookEntity> findByName(String title);

    List<BookEntity> findByAuthor(String author);

    List<BookEntity> findByGenre(String genre);
    BookEntity save(BookEntity bookEntity);
    void deleteBookByName(String name);
    void deleteAll();

//    BookEntity updateBook(String name);

}
