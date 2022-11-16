package com.example.spring.presentation


import com.example.spring.domain.books.service.Book
import com.example.spring.domain.books.service.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.jdbc.core.JdbcTemplate

/**
 * https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/autoconfigure/orm/jpa/DataJpaTest.html
 * https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.testing.spring-boot-applications.autoconfigured-spring-data-jpa
 *
 * By default, tests annotated with @DataJpaTest are transactional and roll back at the end of each test.
 * They also use an embedded in-memory database (replacing any explicit or usually auto-configured DataSource).
 * The @AutoConfigureTestDatabase annotation can be used to override these settings.
 *
 * SQL queries are logged by default by setting the spring.jpa.show-sql property to true. This can be disabled using the showSql attribute.
 *
 * If you are looking to load your full application configuration, but use an embedded database,
 * you should consider @SpringBootTest combined with @AutoConfigureTestDatabase rather than this annotation.
 *
 */
@DataJpaTest
class D_DataJpaTest_Spec extends TestBaseSpec {

    @Autowired
    private BookRepository repository;

    def "should run only data context"() {
        given:
            def book = new Book("James S. A. Corey", "The Expanse - Nemesis Games")

        when:
            repository.save(book)

        then:
            repository.count() == 1
    }

}
