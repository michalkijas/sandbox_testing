package com.example.sandbox_spock.books;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorService {

    public List<String> findAuthors() {
        return List.of("Author 1", "Author 2");
    }

}
