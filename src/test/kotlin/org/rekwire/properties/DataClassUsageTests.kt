package org.rekwire.properties

import kotlin.test.assertFailsWith
import org.junit.jupiter.api.Test
import org.rekwire.Rekwireable

internal class DataClassUsageTests {

    data class Person(val name: String, val age: Int, val income: Double) : Rekwireable() {
        init {
            ::name match "[a-zA-Z]+ [a-zA-Z]+" match ".+?Simpson"
            ::name minLen 10 maxLen 30
            ::age gte 10
            ::income gte 1000.toDouble()

            if (hasErrors()) {
                throw IllegalArgumentException(getFormattedErrors())
            }
        }
    }

    @Test
    fun `should pass`() {
        Person("Bart Simpson", 30, 100000.0)
    }

    @Test
    fun `should fail with several errors`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            Person("John", 5, 0.1)
        }
        println(exception.message)
    }
}