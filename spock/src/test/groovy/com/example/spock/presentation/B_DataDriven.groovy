package com.example.spock.presentation

import spock.lang.Rollup
import spock.lang.Specification
import spock.lang.Unroll

class B_DataDriven extends Specification {

    /**
     * 1. https://spockframework.org/spock/docs/2.1/data_driven_testing.html#data-tables
     */
    def "should be equal values from 1 column table"() {
        expect:
            value == 11

        where:
            value || expected
            11    || _
            12    || _
            13    || _
    }

    @Unroll
    // by default add DataDriven specifications are Unroll
    def "should be #value equal values from table #expected"() {
        expect:
            value == expected

        where:
            value || expected
            11    || 11
            12    || 12
            13    || 13
    }

    @Rollup
    def "should 'value' be  equal values from table"() {
        expect:
            value == expected

        where:
            value || expected
            11    || 11
            12    || 12
            13    || 13
    }

    @Unroll("should be #value equal values from table #expected")
    def "equal values"() {
        expect:
            value == expected

        where:
            value || expected
            11    || 11
            12    || 12
            13    || 13
    }

    @Unroll("should do the math: #a + #b = #c - from table dataset")
    def "use data from table as a input"() {
        expect:
            a + b == c

        where:
            a  | b || c
            11 | 2 || 13
            12 | 2 || 14
            13 | 2 || 15
    }

    @Unroll("should do the math: #a + #b = #c - from collection")
    def "use collection as a input data"() {
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
