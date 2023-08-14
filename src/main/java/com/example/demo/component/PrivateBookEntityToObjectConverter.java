package com.example.demo.component;

import com.example.demo.model.entity.BookEntity;
import com.example.demo.model.entity.MyBoookEntity;
import com.example.demo.model.response.MyBookObject;
import org.springframework.stereotype.Component;

@Component
public class PrivateBookEntityToObjectConverter {
    public MyBookObject entityToObject(MyBoookEntity myBoookEntity) {
        return MyBookObject.builder()
                .name(myBoookEntity.getName())
                .author(myBoookEntity.getAuthor())
                .build();
    }
}
