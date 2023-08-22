package com.example.demo.component;

import com.example.demo.model.entity.BookEntity;
import com.example.demo.model.entity.MyBookEntity;

import org.springframework.stereotype.Component;

@Component
public class PublicToPrivateConverter {
    public static MyBookEntity convertToPrivate(BookEntity bookEntity) {
        return MyBookEntity.builder()
                .title(bookEntity.getTitle())
                .author(bookEntity.getAuthor())
                .myRating(bookEntity.getRating())
                .build();
    }
}
