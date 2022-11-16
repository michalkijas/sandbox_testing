package com.example.spring.domain.books.service;

import com.example.spring.domain.books.model.BookDto;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<BookDto> getBooks() {
        return bookRepository.findAll().stream()
                .map(book -> new BookDto(book.getAuthor(), book.getTitle()))
                .collect(Collectors.toList());
    }

    public Book create(BookDto bookDto) {
        return bookRepository.save(new Book(bookDto.getAuthor(), bookDto.getTitle()));
    }

}
