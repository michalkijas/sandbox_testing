package com.example.spring.presentation


import spock.lang.Shared
import spock.lang.Specification

class TestBaseSpec extends Specification {

    @Shared
    private def runTime = 0
    private def testTime = 0

    // once on start
    def setupSpec() {
        runTime = System.currentTimeMillis()
    }

    // each test
    def setup() {
        testTime = System.currentTimeMillis()
    }

    // each test
    def cleanup() {
        System.err.println("Full time = " + ((System.currentTimeMillis() - runTime) / 1000))
        System.err.println("Test time = " + ((System.currentTimeMillis() - testTime) / 1000))
    }

}
