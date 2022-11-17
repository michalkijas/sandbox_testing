package com.example.spring.presentation

import com.example.spring.domain.books.model.BookDto
import com.example.spring.domain.books.service.BookService
import com.example.spring.domain.books.service.BooksConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa
import org.springframework.test.context.ContextConfiguration

@AutoConfigureDataJpa
@ContextConfiguration(classes = BooksConfiguration)
class K_Configuration_Spec extends TestBaseSpec {

    @Autowired
    private BookService bookService

    def "should rune only custom context"() {
        when:
            def books = bookService.getBooks()

        then:
            books.isEmpty()

        and:
            bookService.create(new BookDto("James S. A. Corey", "The Expanse - Leviathan Wakes"))
            bookService.create(new BookDto("James S. A. Corey", "The Expanse - Caliban's War"))
            bookService.create(new BookDto("James S. A. Corey", "The Expanse - Abaddon's Gate"))
            bookService.create(new BookDto("James S. A. Corey", "The Expanse - Cibola Burn"))

        then:
            bookService.getBooks().size() == 4
    }

}
