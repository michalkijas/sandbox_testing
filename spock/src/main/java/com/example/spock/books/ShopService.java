package com.example.spock.books;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final AuthorService authorService;
    private final BookService bookService;
    private final CustomersService customersService;

    public List<String> findBooks() {
        return bookService.findBooks();
    }

    public List<String> findAuthors() {
        return authorService.findAuthors();
    }

    public List<String> findCustomers() {
        return customersService.findCustomers();
    }

}
