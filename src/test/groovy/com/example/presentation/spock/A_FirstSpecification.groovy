package com.example.presentation.spock

import spock.lang.Specification

/**
 * https://spockframework.org/spock/docs/2.0/spock_primer.html
 */
class A_FirstSpecification extends Specification {

    /**
     * 1. Fixture Methods
     */
    def setupSpec() {}    // runs once -  before the first feature method
    def setup() {}        // runs before every feature method
    def cleanup() {}      // runs after every feature method
    def cleanupSpec() {}  // runs once -  after the last feature method

    /**
     * 2. https://spockframework.org/spock/docs/2.1/spock_primer.html#specifications_as_documentation
     */
    def "should run block EXPECT"() {
        expect:
            11 == 11
    }

    def "should run blocks GIVEN WHEN THEN"() {
        given: "name of new user"
            def name = "John Wick"

        when: "name will be change to uppercase string"
            def result = name.toUpperCase()

        then: "result should be equal to JOHN WICK"
            result == "JOHN WICK"
    }

    def "should run blocks GIVEN WHEN THEN and other"() {
        given:
            def name = "John Wick"

        when:
            def upperCaseResult = name.toUpperCase()

        then:
            upperCaseResult == "JOHN WICK"

        when:
            def loverCaseResult = upperCaseResult.toLowerCase()

        then:
            loverCaseResult == "john wick"
    }

}
