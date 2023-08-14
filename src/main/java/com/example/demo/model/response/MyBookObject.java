package com.example.demo.model.response;

import com.example.demo.repository.BookRepository;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@Jacksonized
public class MyBookObject {
    private String name;
    private String author;
    private String finishedReading;

}
