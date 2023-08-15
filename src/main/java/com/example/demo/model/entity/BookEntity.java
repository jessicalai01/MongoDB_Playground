package com.example.demo.model.entity;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Data
@Builder
@Jacksonized
@Document(collection = "book")
public class BookEntity {

    @Id
    private BigInteger bookId;
    private String name;
    private String author;
    private String genre;
    private Double rating;

}
