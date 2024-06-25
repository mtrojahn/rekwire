package org.rekwire.dataclass

import org.rekwire.classes.Rekwireable
import org.rekwire.exception.RekwireValidationException
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class DataClassUsageTests {

    // This test is just to show how to use Rekwireable in a data class
    // also how to use the DSL to assert tests
    @Test
    fun `should pass`() {
        data class Person(val name: String, val age: Int) : Rekwireable() {
            init {
                rekwire {
                    ::name match "[a-zA-Z]+ [a-zA-Z]+"
                    ::name minLen 10 maxLen 100
                    ::name eq "Bart Simpson" neq "Homer Simpson"
                    ::name includes "Simpson" excludes "banana"
                    ::name startingWith "Bart" endingWith "Simpson"
                    ::age gt 10 gte 11 eq 11 lt 20 lte 11 neq 12
                }
            }
        }
        Person("Bart Simpson", 11)
    }

    @Test
    fun `demonstrating the formatted toString validation report`() {
        data class Person(val name: String, val age: Int) : Rekwireable() {
            init {
                rekwire {
                    // all validations will fail
                    ::name match "[a-zA-Z]+ [a-zA-Z]+"
                    ::name minLen 100 maxLen 10
                    ::name eq "Bar" neq "Bar"
                    ::name includes "Bar" excludes "Foo"
                    ::name startingWith "Bar" endingWith "Foo"
                    ::age gt 10 gte 11 eq 11 lt 9 lte 9 eq 20 neq 10
                }
            }
        }

        val exception = assertFailsWith<RekwireValidationException> {
            Person(name = "Foo", age = 10)
        }
        assertEquals(
            """
            |Rekwire Validation Failed
            |  - Property 'name': 'Foo' should match '[a-zA-Z]+ [a-zA-Z]+'.
            |  - Property 'name': 'Foo' should be at least 100 characters long.
            |  - Property 'name': 'Foo' should be equal to 'Bar'.
            |  - Property 'name': 'Foo' should include 'Bar'.
            |  - Property 'name': 'Foo' should not include 'Foo'.
            |  - Property 'name': 'Foo' should start with 'Bar'.
            |  - Property 'age': 10 should be greater than 10.
            |  - Property 'age': 10 should be greater than or equal to 11.
            |  - Property 'age': 10 should be equal to 11.
            |  - Property 'age': 10 should be lower than 9.
            |  - Property 'age': 10 should be lower than or equal to 9.
            |  - Property 'age': 10 should be equal to 20.
            |  - Property 'age': 10 should be different from 10.
            """.trimMargin(),
            exception.toString()
        )
    }
}