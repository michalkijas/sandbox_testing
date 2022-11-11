package com.example.spock.presentation


import spock.lang.Specification

/**
 * https://spockframework.org/spock/docs/2.1/interaction_based_testing.html
 */
class D_Mocking extends Specification {

    def "should values from table be equals to result from REAL implementation"() {
        given:
            def sut = new Calculator()

        when:
            def result = sut.sum(left, right)

        then:
            result == expected

        where:
            left | right || expected
            11   | 1     || 12
            12   | 55    || 67
            13   | 1     || 14
    }

    /**
     * https://spockframework.org/spock/docs/2.1/interaction_based_testing.html#_mocking
     * Mocking is the act of describing (mandatory) interactions between the object under specification
     * and its collaborators.
     */
    def "should values from table be equals to result from MOCK"() {
        given:
            def sut = Mock(Calculator)

        when:
            def result = sut.sum(left, right)

        then:
            1 * sut.sum(_, _)
            result == defaultValue

        where:
            left | right || defaultValue
            11   | 1     || 0
            12   | 55    || 0
            13   | 1     || 0
    }

    /**
     * https://spockframework.org/spock/docs/2.1/interaction_based_testing.html#_stubbing
     * Stubbing is the act of making collaborators respond to method calls in a certain way.
     * When stubbing a method, you don’t care if and how many times the method is going to be called;
     * you just want it to return some value, or perform some side effect, whenever it gets called.
     */
    def "should values from table be equals to result from STUB service"() {
        given:
            def sut = Stub(Calculator)
            sut.sum(_, _) >> 10

        when:
            def result = sut.sum(left, right)

        then:
            result == expected

        where:
            left | right || expected
            11   | 1     || 10
            12   | 55    || 10
            13   | 1     || 10
    }

    def "should count execution like a MOCK and return value like STUB"() {
        given:
            def sut = Mock(Calculator)

        when:
            def result = sut.sum(left, right)

        then:
            1 * sut.sum(_, _) >> 78 // count as a MOC return value as a STUB
            result == defaultValue

        where:
            left | right || defaultValue
            11   | 1     || 78
            12   | 55    || 78
            13   | 1     || 78
    }

    class Calculator {
        public int sum(int left, int right) {
            return left + right;
        }
    }

}
