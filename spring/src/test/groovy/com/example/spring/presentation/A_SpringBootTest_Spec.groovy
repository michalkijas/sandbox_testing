package com.example.spring.presentation

import com.example.spring.TestApplication
import org.springframework.boot.test.context.SpringBootTest

/**
 * https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#integration-testing-annotations-spring
 *
 * All test slices
 * https://docs.spring.io/spring-boot/docs/current/reference/html/test-auto-configuration.html#appendix.test-auto-configuration

 */


/**
 * Same as
 * @SpringBootTest
 * @ContextConfiguration (classes = App)
 */
@SpringBootTest(classes = TestApplication)
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
