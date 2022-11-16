package com.example.spring.domain.books.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class BookDto {

    @Size(min = 10, max = 20)
    private final String author;

    @NotEmpty
    private final String title;

}
