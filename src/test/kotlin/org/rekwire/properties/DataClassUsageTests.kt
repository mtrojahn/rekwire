package org.rekwire.properties

import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import org.junit.jupiter.api.Test
import org.rekwire.RekwireValidationException
import org.rekwire.Rekwireable

internal class DataClassUsageTests {

    data class Person(val name: String, val age: Int, val income: Double) : Rekwireable() {
        init {
            rekwire {
                ::name match "[a-zA-Z]+ [a-zA-Z]+" match ".+?Simpson"
                ::name minLen 10 maxLen 30
                ::age gt 10 gte 10 lt 100 lte 100
                ::income gte 1000.toDouble()
            }
        }

    }

    @Test
    fun `should pass`() {
        Person("Bart Simpson", 30, 100000.0)
    }

    @Test
    fun `should fail with several errors`() {
        val exception = assertFailsWith<RekwireValidationException> {
            Person("John", 5, -1.0)
        }
        assertEquals(6, exception.errors.size)
        assertEquals("Validation failed", exception.message!!)
    }
}