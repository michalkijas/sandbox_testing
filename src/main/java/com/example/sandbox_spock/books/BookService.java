package com.example.sandbox_spock.books;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    public List<String> findBooks() {
        return List.of("Book 1", "Book 2");
    }

}
