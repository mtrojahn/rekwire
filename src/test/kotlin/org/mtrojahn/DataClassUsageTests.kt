package org.mtrojahn

import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import org.junit.jupiter.api.Test

internal class DataClassUsageTests {

    data class Person(val name: String, val age: Int, val income: Double) {
        init {
            name minLen 10 match "[a-zA-Z]+ [a-zA-Z]+" match ".+?Simpson" maxLen 30
            age gte 18 lt 100
            income gte 0.toDouble() lt 1000000.toDouble()
        }
    }

    @Test
    fun `test data class`() {
        Person("Bart Simpson", 30, 100000.0)
    }

    @Test
    fun `test data class with invalid income`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            Person("Bart Simpson", 30, -100000.0)
        }
        assertEquals("Expected -100000.0 to be greater than or equal to 0.0.", exception.message)
    }

    @Test
    fun `test data class with invalid age`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            Person("Bart Simpson", -30, 100000.0)
        }
        assertEquals("Expected -30 to be greater than or equal to 18.", exception.message)
    }

    @Test
    fun `test data class with invalid name`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            Person("BartSimpson", 30, 100000.0)
        }
        assertEquals("Expected `BartSimpson` to match `[a-zA-Z]+ [a-zA-Z]+`.", exception.message)
    }
}