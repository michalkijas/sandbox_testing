package com.example.spock.presentation

import com.example.spock.SandboxSpockApplication
import com.example.spock.books.AuthorService
import com.example.spock.books.CustomersService
import com.example.spock.books.ShopService
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(classes = SandboxSpockApplication)
class E_Spring extends Specification {

    @Autowired
    ShopService shopService

    @SpringBean
    AuthorService authorService = Mock()

    @SpringBean
    CustomersService customersService = Stub()

    def "should call method from Spring bean"() {
        when:
            def result = shopService.findBooks()

        then:
            !result.isEmpty()
            result.size() == 2
    }

    // Mock dont have default implementation
    def "should call method from MOCK service"() {
        when:
            def result = shopService.findAuthors()

        then:
            1 * authorService.findAuthors()
            result == null
    }

    def "should call method from STUB service and return given response"() {
        given:
            customersService.findCustomers() >> List.of("STUB customer")

        when:
            def result = shopService.findCustomers()

        then:
            result == ["STUB customer"]
    }

}
