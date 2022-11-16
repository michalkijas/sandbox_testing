package com.example.spring.domain.books.api;

import com.example.spring.domain.books.model.BookDto;
import com.example.spring.domain.books.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
class BooksController {

    private final BookService booService;

    @GetMapping("/books")
    List<BookDto> books() {
        return booService.getBooks();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/books")
    void create(@Validated @RequestBody BookDto request) {

    }

}
