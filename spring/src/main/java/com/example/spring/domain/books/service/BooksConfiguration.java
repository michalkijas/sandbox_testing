package com.example.spring.domain.books.service;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackageClasses = BooksConfiguration.class)
@EnableJpaRepositories(basePackageClasses = BooksConfiguration.class)
class BooksConfiguration {

    @Bean
    BookService bookService(BookRepository bookRepository) {
        return new BookService(bookRepository);
    }

}
