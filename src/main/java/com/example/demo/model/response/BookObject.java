package com.example.demo.model.response;

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
    private String title;
    private String author;
    private String genre;
    private double rating;
}
