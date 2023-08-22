package com.example.demo.repository;
import com.example.demo.model.entity.BookEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<BookEntity, String> {
    List<BookEntity>findAll();
    BookEntity findByTitle(String title);

    List<BookEntity> findByAuthor(String author);
    BookEntity save(BookEntity bookEntity);
    void deleteBookByTitle(String name);
    void deleteAll();

}
