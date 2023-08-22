package com.example.demo.model.response;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Builder
@Data
@Jacksonized
public class MyBookObject {
    private String title;
    private String author;
    private Double myRating;
    private String finishedReading;

}
