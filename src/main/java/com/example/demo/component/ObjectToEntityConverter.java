package com.example.demo.component;

import com.example.demo.model.entity.BookEntity;
import com.example.demo.model.response.BookObject;
import org.springframework.stereotype.Component;
@Component
public class ObjectToEntityConverter {

        public static BookEntity convert(BookObject ob) {

            return BookEntity.builder()
                    .bookId(ob.getBookId())
                    .name(ob.getName())
                    .author(ob.getAuthor())
                    .genre(ob.getGenre())
                    .rating(ob.getRating())
                    .build();

    }
}
