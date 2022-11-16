package com.example.spring.domain.books.service;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "books")
@Entity
@Getter
@NoArgsConstructor
class Book {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String author;
    private String title;

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

}
