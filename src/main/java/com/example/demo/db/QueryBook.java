package com.example.demo.db;

import java.util.List;

public interface QueryBook {
    List<BookObject> findAll();
    List<BookObject> findByName(String name);
    List<BookObject> findByAuthor(String author);
    List<BookObject> findByGenre(String genre);

    BookObject saveBook(BookObject bookObject);
    void deleteBookByName(String name);


}
