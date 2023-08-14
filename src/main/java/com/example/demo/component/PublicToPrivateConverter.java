package com.example.demo.component;

import com.example.demo.model.entity.BookEntity;
import com.example.demo.model.entity.MyBoookEntity;

import org.springframework.stereotype.Component;

@Component
public class PublicToPrivateConverter {
    public MyBoookEntity convertToPrivate(BookEntity bookEntity) {
        return MyBoookEntity.builder()
                .name(bookEntity.getName()).build();
    }
}
