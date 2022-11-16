package com.example.spring.domain.books.service;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAll();
}
