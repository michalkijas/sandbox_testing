package com.example.spring.presentation


import com.example.spring.domain.books.service.BookServiceClientWithBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.client.MockRestServiceServer

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess

/**
 * https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/autoconfigure/web/client/RestClientTest.html
 *
 * Using this annotation will disable full auto-configuration and instead apply only configuration
 * relevant to rest client tests (i.e. Jackson or GSON auto-configuration and @JsonComponent beans, but not regular @Component beans).
 *
 * By default, tests annotated with RestClientTest will also auto-configure a MockRestServiceServer.
 *
 * If you are testing a bean that doesn't use RestTemplateBuilder but instead injects a RestTemplate directly,
 * you can add @AutoConfigureWebClient(registerRestTemplate=true).
 */


/**
 * Will throw exception Builder is already bound with template
 */
//@AutoConfigureWebClient(registerRestTemplate = true)

/**
 * Mocking requests to external REST services
 */
@ContextConfiguration(classes = BookServiceClientWithBuilder)
@AutoConfigureWebClient
@RestClientTest
class F_RestClientTest_Builder_Spec extends TestBaseSpec {

    @Autowired
    private BookServiceClientWithBuilder client

    @Autowired
    private MockRestServiceServer server;

    def setup() {
        server.expect(requestTo("/books/search"))
                .andRespond(withSuccess("""[{"author":"James S. A. Corey", "title":"Caliban's War"}]""", MediaType.APPLICATION_JSON));
    }

    def "should test"() {
        when:
            def book = client.searchBooks()

        then:
            book[0].getAuthor() == "James S. A. Corey"
            book[0].getTitle() == "Caliban's War"
    }

}
