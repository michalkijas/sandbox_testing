package com.example.spring.presentation

import com.example.spring.domain.books.model.BookDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.json.JsonTest
import org.springframework.boot.test.json.JacksonTester

import static org.assertj.core.api.Assertions.assertThat

/**
 * https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/autoconfigure/json/JsonTest.html
 * https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.testing.spring-boot-applications.json-tests
 * https://www.youtube.com/watch?v=AiiprfLqriY
 *
 * Using this annotation will disable full auto-configuration and instead apply only configuration
 * relevant to JSON tests (i.e. @JsonComponent, Jackson Module)
 *
 * By default, tests annotated with JsonTest will also initialize JacksonTester, JsonbTester and GsonTester fields.
 * More fine-grained control can be provided via the @AutoConfigureJsonTesters annotation.
 */

@JsonTest
class E_JsonTest_Spec extends TestBaseSpec {

    @Autowired
    private JacksonTester<BookDto> json

    def "should validate JSON serialization"() {
        given:
            def book = new BookDto("James S. A. Corey", "The Expanse - Leviathan Wakes")

        when:
            def bookAsJson = json.write(book)

        then:
            assertThat(bookAsJson).extractingJsonPathStringValue('$.author').isEqualTo("James S. A. Corey")
            assertThat(bookAsJson).doesNotHaveJsonPath('$.age')
    }

    def "should validate JSON deserialization"() {
        given:
            def bookAsJson = """{ "author":"James S. A. Corey", "title":"Caliban's War" }"""

        when:
            def book = json.parseObject(bookAsJson)

        then:
            assertThat(book.getAuthor()).isEqualTo("James S. A. Corey")
            assertThat(book).extracting("author").isEqualTo("James S. A. Corey")
    }
}
