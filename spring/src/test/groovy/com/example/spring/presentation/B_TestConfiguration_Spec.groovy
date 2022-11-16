package com.example.spring.presentation

import com.example.spring.domain.books.service.BooksConfiguration
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Ignore

@Ignore
@SpringBootTest(classes = BooksConfiguration)
class B_TestConfiguration_Spec extends TestBaseSpec {

    def "should rune only custom context"() {
        expect:
            true
    }

}
