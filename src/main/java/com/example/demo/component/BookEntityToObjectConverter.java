package com.example.demo.component;

import com.example.demo.db.BookEntity;
import com.example.demo.db.BookObject;
import org.springframework.stereotype.Component;

@Component
public class BookEntityToObjectConverter {
    public BookObject convert(BookEntity bookEntity) {

        return BookObject.builder()
                .name(bookEntity.getName())
                .author(bookEntity.getAuthor())
                .genre(bookEntity.getGenre())
                .rating(bookEntity.getRating())
                .build();

    }

}
