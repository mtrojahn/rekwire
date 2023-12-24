package org.rekwire.properties

import org.junit.jupiter.api.Test
import org.rekwire.RekwireValidationException
import org.rekwire.Rekwireable
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class DataClassUsageTests {

    data class Person(val name: String, val age: Int, val income: Double) : Rekwireable() {
        init {
            rekwire {
                ::name match "[a-zA-Z]+ [a-zA-Z]+" match ".+?Simpson"
                ::name minLen 10 maxLen 30
                ::age gt 10 gte 11 lt 100 lte 100
                ::income gte 1000.toDouble()
            }
        }

    }

    @Test
    fun `should pass`() {
        Person("Bart Simpson", 11, 100000.0)
    }

    @Test
    fun `should fail with several errors`() {
        //    0 = "Property 'name' should match '[a-zA-Z]+ [a-zA-Z]+'"
        //    1 = "Property 'name' should match '.+?Simpson'"
        //    2 = "Length of 'name' should be at least 10"
        //    3 = "Property 'age' should be greater than 10"
        //    4 = "Property 'age' should be greater or equal to 10"
        //    5 = "Property 'income' should be greater or equal to 1000.0"

        val exception = assertFailsWith<RekwireValidationException> {
            Person("John", 5, -1.0)
        }
        assertEquals(6, exception.errors.size)
        assertEquals("Validation failed", exception.message!!)
    }
}