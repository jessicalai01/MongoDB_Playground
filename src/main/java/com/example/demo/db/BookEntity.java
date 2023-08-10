package com.example.demo.db;

import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Jacksonized
@Document(collection = "book")
public class BookEntity {
    private String name;
    private String author;
    private String genre;
    private double rating;

}
