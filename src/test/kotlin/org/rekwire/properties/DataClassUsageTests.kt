package org.rekwire.properties

import org.junit.jupiter.api.Test
import org.rekwire.RekwireValidationException
import org.rekwire.Rekwireable
import org.rekwire.base.eq
import org.rekwire.base.includes
import kotlin.test.assertFailsWith

internal class DataClassUsageTests {
    // This test is just to show how to use Rekwireable in a data class
    // also how to use the DSL to assert tests

    @Test
    fun `should pass`() {
        data class Person(val name: String, val age: Int): Rekwireable() {
            init {
                rekwire {
                    ::name match "[a-zA-Z]+ [a-zA-Z]+"
                    ::name minLen 10 maxLen 100
                    ::name eq "Bart Simpson" neq "Homer Simpson"
                    ::name includes "Simpson"
                    ::age gt 10 gte 11 eq 11 lt 20 lte 11 neq 12
                }
            }
        }
        Person("Bart Simpson", 11)
    }

    @Test
    fun `should fail name check`() {
        data class Person(val name: String): Rekwireable() {
            init {
                rekwire {
                    ::name eq "Bart Simpson"
                }
            }
        }
        val exception = assertFailsWith<RekwireValidationException> {
            Person("Bart Zimpson")
        }
        exception.errors.size eq 1
        exception.errors[0] includes "Property 'name'"
    }

    @Test
    fun `should fail with several errors`() {
        data class Person(val name: String): Rekwireable() {
            init {
                rekwire {
                    ::name eq "Bart Simpson" minLen 10
                    ::name neq "John"
                    ::name includes  "banana"
                }
            }
        }

        val exception = assertFailsWith<RekwireValidationException> {
            Person("John")
        }
        exception.errors.size eq 4
    }

    @Test
    fun `should fail match`() {
        data class Person(val name: String): Rekwireable() {
            init {
                rekwire {
                    ::name match "[a-zA-Z]+ [a-zA-Z]+"
                }
            }
        }
        val exception = assertFailsWith<RekwireValidationException> {
            Person("Bart Simpson 123")
        }
        exception.errors.size eq 1
        exception.errors[0] includes "Property 'name'"
    }
}