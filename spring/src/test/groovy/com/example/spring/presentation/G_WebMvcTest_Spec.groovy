package com.example.spring.presentation

import com.example.spring.domain.books.api.BooksController
import com.example.spring.domain.books.model.BookDto
import com.example.spring.domain.books.service.BookService
import com.fasterxml.jackson.databind.ObjectMapper
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

/**
 * https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/autoconfigure/web/servlet/WebMvcTest.html
 *
 * Using this annotation will disable full auto-configuration and instead apply only configuration
 * relevant to MVC tests (i.e. @Controller, @ControllerAdvice, @JsonComponent, Converter/GenericConverter, Filter,
 * WebMvcConfigurer and HandlerMethodArgumentResolver beans but not @Component, @Service or @Repository beans).
 *
 * By default, tests annotated with @WebMvcTest will also auto-configure Spring Security and MockMvc.
 */
/**
 * Controllers endpoints, body requests, requests validations, filters and security
 */
@WebMvcTest(controllers = BooksController)
class G_WebMvcTest_Spec extends TestBaseSpec {

    @Autowired
    private MockMvc mockMvc

    @Autowired
    private ObjectMapper objectMapper

    // @MockBean - Spring
    // @SpringBean - Spock
    @SpringBean
    private BookService bookService = Mock()

    def "should create context with configuration relevant to MVC tests"() {
        given:
            bookService.getBooks() >> [new BookDto("James S. A. Corey", "The Expanse - Leviathan Wakes")]

        when:
            def response = mockMvc.perform(MockMvcRequestBuilders.get("/books"))

        then:
            response.andExpect(status().isOk())
            response.andExpect(content().contentType(MediaType.APPLICATION_JSON))
            response.andExpect(jsonPath('$[0].author').value("James S. A. Corey"))
    }

    def "should failed on request body validation"() {
        given:
            def invalidBook = new BookDto("Michal", "")
            def invalidRequestBody = objectMapper.writeValueAsBytes(invalidBook)

        when:
            def response = mockMvc.perform(MockMvcRequestBuilders.post("/books")
                    .content(invalidRequestBody)
                    .contentType(MediaType.APPLICATION_JSON))

        then: "validation should failed"
            response.andExpect(status().is4xxClientError())
            response.andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
    }

    def "should pass on request body validation"() {
        given:
            def validBook = new BookDto("James S. A. Corey", "The Expanse - Leviathan Wakes")
            def validRequestBody = objectMapper.writeValueAsBytes(validBook)

        when:
            def response = mockMvc.perform(MockMvcRequestBuilders.post("/books")
                    .content(validRequestBody)
                    .contentType(MediaType.APPLICATION_JSON))

        then: "validation should pass"
            response.andExpect(status().is2xxSuccessful())
            response.andExpect(status().is(HttpStatus.CREATED.value()))
    }

}
