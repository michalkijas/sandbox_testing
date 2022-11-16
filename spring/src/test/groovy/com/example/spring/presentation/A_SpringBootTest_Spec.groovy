package com.example.spring.presentation

import com.example.spring.App
import org.springframework.boot.test.context.SpringBootTest

/**
 * ???
 * https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#integration-testing-annotations-spring
 */



/**
 * Same as
 * @SpringBootTest
 * @ContextConfiguration (classes = App)
 */
@SpringBootTest(classes = App)
class A_SpringBootTest_Spec extends TestBaseSpec {

    def "Should load new SpringBoot context"() {
        expect:
            true
    }

    def "Should load run test with existing SpringBoot context"() {
        expect:
            true
    }

}
