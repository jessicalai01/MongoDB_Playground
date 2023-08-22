package com.example.demo.component;

import com.example.demo.model.entity.MyBookEntity;
import com.example.demo.model.response.MyBookObject;
import org.springframework.stereotype.Component;

@Component
public class PrivateBookEntityToObjectConverter {
    public static MyBookObject entityToObject(MyBookEntity myBookEntity) {
        return MyBookObject.builder()
                .title(myBookEntity.getTitle())
                .author(myBookEntity.getAuthor())
                .myRating(myBookEntity.getMyRating())
                .build();
    }
}
