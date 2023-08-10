package com.example.demo.db;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class BookObject {
    private String name;
    private String author;
    private String genre;
    private double rating;
}
