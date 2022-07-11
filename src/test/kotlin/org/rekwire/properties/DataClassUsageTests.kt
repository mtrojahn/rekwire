package org.rekwire.properties

import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import org.junit.jupiter.api.Test
import org.rekwire.Rekwireable

internal class DataClassUsageTests {

    data class Person(val name: String, val age: Int, val income: Double): Rekwireable() {
        init {
            ::name match "[a-zA-Z]+ [a-zA-Z]+" match ".+?Simpson"
            ::name minLen 10 maxLen 30
            ::age gte 10
            ::income gte 1000.toDouble()
        }
    }

    @Test
    fun `should pass`() {
        Person("Bart Simpson", 30, 100000.0)
    }

    @Test
    fun `should fail due to income`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            Person("Bart Simpson", 30, -100000.0)
        }
        assertEquals("Property 'income' should be greater or equal to 1000.0", exception.message)
    }

    @Test
    fun `should fail due to age`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            Person("Bart Simpson", -30, 100000.0)
        }
        assertEquals("Property 'age' should be greater or equal to 10", exception.message)
    }

    @Test
    fun `should fail due to name`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            Person("BartSimpson", 30, 100000.0)
        }
        assertEquals("Property 'name' should match '[a-zA-Z]+ [a-zA-Z]+'", exception.message)
    }
}