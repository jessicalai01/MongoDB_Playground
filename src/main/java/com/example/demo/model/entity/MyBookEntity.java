package com.example.demo.model.entity;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@Jacksonized
@Document(collection = "MyBook")
public class MyBookEntity {
    private String title;
    private String author;
    private Double myRating;

}
