package com.example.spock.presentation

import spock.lang.Specification

class C_Assertion extends Specification {

    def "should fail and show mismatch in string"() {
        expect:
            "John Wick" == "Johnatan Wicker"
    }

    def "should fail and show missing values in collection"() {
        expect:
            ["apple", "orange", "peach"] == ["apple", "human", "peach"]
    }

    def "should be equal values from table"() {
        given:
            def firstName = "John"
            def lastName = "Wick"

        when:
            def sut = new Person(firstName, lastName)

        then:
            with(sut) {
                firstName == "John"
                lastName == "Wick"
            }
    }

    def "should check data and fail on first error"() {
        given:
            def firstName = "John"
            def lastName = "Wick"

        when:
            def sut = new Person(firstName, lastName)

        then:
            with(sut) {
                firstName == "john"
                lastName == "wick"
            }
    }

    def "should check all data and fail"() {
        given:
            def firstName = "John"
            def lastName = "Wick"

        when:
            def sut = new Person(firstName, lastName)

        then:
            verifyAll(sut) {
                firstName == "john"
                lastName == "wick"
            }
    }

    def "should check assertion in helper method and fail"() {
        expect:
            testValue("John Wick")
    }

    def testValue(String name) {
        assert name == "Jonathan Wick"
    }

    class Person {

        public String firstName;
        public String lastName

        Person(String firstName, String lastName) {
            this.firstName = firstName
            this.lastName = lastName
        }

    }

}
