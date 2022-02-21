package com.example.presentation.spock

import spock.lang.Specification
import spock.lang.Unroll

class B_DataDriven extends Specification {

    // 1. https://spockframework.org/spock/docs/2.0/data_driven_testing.html#data-tables
    def "should be equal values from 1 column table"() {
        expect:
            value == 11

        where:
            value || expected
            11    || _
    }

    @Unroll
    def "should be #value equal values from table #expected"() {
        expect:
            value == expected

        where:
            value || expected
            11    || 11
            12    || 12
            13    || 13
    }

    @Unroll
    def "should do the math: #a + #b = #c - from table dataset"() {
        expect:
            a + b == c

        where:
            a  | b || c
            11 | 2 || 13
            12 | 2 || 14
            13 | 2 || 15
    }

    @Unroll
    def "should do the math: #a + #b = #c - from collection"() {
        expect:
            a + b == c

        where:
            [a, b, c] << [
                    [11, 2, 13],
                    [12, 2, 14],
                    [13, 2, 15]
            ]
    }

    def "should search in collection with permutations"() {
        expect:
            word.indexOf("apples") == 0

        where:
            word << ["apples", "bananas", "oranges"].permutations()
    }

}
