package com.example.spring.domain.books.service;

import com.example.spring.domain.books.model.BookDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

class BookServiceClientWithBuilder {

    private final RestTemplate restTemplate;

    BookServiceClientWithBuilder(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    BookDto[] searchBooks() {
        return restTemplate.getForObject("/books/search", BookDto[].class);
    }

}
