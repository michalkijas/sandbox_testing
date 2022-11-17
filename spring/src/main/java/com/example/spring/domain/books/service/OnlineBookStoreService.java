package com.example.spring.domain.books.service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OnlineBookStoreService implements BookStoreService {

    private BookService bookService;

    @Override
    public void makeOrder() {
        // do nothing
    }
}
