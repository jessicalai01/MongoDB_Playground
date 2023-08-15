package com.example.demo.component;

import com.example.demo.model.entity.BookEntity;
import com.example.demo.model.entity.MyBoookEntity;

import org.springframework.stereotype.Component;

@Component
public class PublicToPrivateConverter {
    public static MyBoookEntity convertToPrivate(BookEntity bookEntity) {
        return MyBoookEntity.builder()
                .name(bookEntity.getName())
                .author(bookEntity.getAuthor())
                .build();
    }
}
