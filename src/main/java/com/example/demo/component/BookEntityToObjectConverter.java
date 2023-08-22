package com.example.demo.component;

import com.example.demo.model.entity.BookEntity;
import com.example.demo.model.response.BookObject;
import org.springframework.stereotype.Component;

@Component
public class BookEntityToObjectConverter {
    public static BookObject convert(BookEntity bookEntity) {

        return BookObject.builder()
                .bookId(bookEntity.getBookId())
                .title(bookEntity.getTitle())
                .author(bookEntity.getAuthor())
                .genre(bookEntity.getGenre())
                .rating(bookEntity.getRating())
                .build();

    }

}
