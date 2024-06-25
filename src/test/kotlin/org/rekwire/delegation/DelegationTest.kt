package org.rekwire.delegation

import org.rekwire.classes.Rekwireable
import org.rekwire.exception.RekwireValidationException
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class DelegationTest {

    // regular classes can be validated when the property is being set.
    // the downside is that the validation error will not include all validations that failed. also, the initial value
    // of the property will not be validated, so it is possible to have an invalid value in the object at instantiation.

    class Person : Rekwireable() {

        var name: String by rekwire("") {
            ::name minLen 10 maxLen 100 neq "Foo"
        }
        var age: Int by rekwire(0) {
            ::age gt 10
        }
    }

    @Test
    fun `should pass`() {
        Person().apply {
            name = "Bart Simpson"
            age = 11
        }
    }

    @Test
    fun `should fail`() {
        val exception = assertFailsWith<RekwireValidationException> {
            Person().apply {
                name = "Bart"
                age = 9 // this will not be processed because the validation of name failed
            }
        }
        assertEquals(
            """
            |Rekwire Validation Failed
            |  - Property 'name': 'Bart' should be at least 10 characters long.
            """.trimMargin(), exception.toString()
        )
    }
}