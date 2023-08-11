package com.example.demo.db;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.annotation.Id;

import java.math.BigInteger;

@Data
@Builder
@Jacksonized
public class BookObject {
    @Id
    private BigInteger bookId;
    private String name;
    private String author;
    private String genre;
    private double rating;
}
