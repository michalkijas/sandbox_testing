package com.example.spring.presentation

import com.example.spring.domain.books.service.BookStoreService
import com.example.spring.domain.books.service.MockBookStoreService
import com.example.spring.domain.books.service.OnlineBookStoreService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean

/**
 * When class with @TestConfiguration is not inner static class
 */
//@Import(MockConfiguration)

@SpringBootTest
class J_TestConfiguration_Spec extends TestBaseSpec {

    @Autowired
    private BookStoreService mockBookStoreService

    def "should rune only custom context"() {
        expect:
            mockBookStoreService instanceof MockBookStoreService
            !(mockBookStoreService instanceof OnlineBookStoreService)
    }

    /**
     * Inner static class will be loaded automatically
     */
    @TestConfiguration
    static class MockConfiguration {

        @Bean
        BookStoreService mockBookStoreService() {
            return new MockBookStoreService()
        }

    }

}
