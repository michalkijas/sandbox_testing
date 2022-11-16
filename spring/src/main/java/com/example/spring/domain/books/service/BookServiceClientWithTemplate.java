package com.example.spring.domain.books.service;

import com.example.spring.domain.books.model.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
class BookServiceClientWithTemplate {

    private final RestTemplate restTemplate;

    BookDto[] searchBooks() {
        return restTemplate.getForObject("/books/search", BookDto[].class);
    }

}
