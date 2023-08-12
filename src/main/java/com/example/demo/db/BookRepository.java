package com.example.demo.db;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<BookEntity, String> {
    List<BookEntity>findAll();

    BookEntity findByName(String title);

    List<BookEntity> findByAuthor(String author);

    List<BookEntity> findByGenre(String genre);
    BookEntity save(BookEntity bookEntity);
    void deleteBookByName(String name);
    void deleteAll();


}
