package org.rekwire

import kotlin.test.Test

internal class NumbersSuccessTest {

    @Test
    fun `integer - should pass greater than check`() {
        3 gt 2
    }

    @Test
    fun `integer - should pass lower than check`() {
        2 lt 3
    }

    @Test
    fun `integer - should pass greater or equal check`() {
        3 gte 3
    }

    @Test
    fun `integer - should pass lower or equal check`() {
        3 lte 3
    }

    @Test
    fun `integer - should pass equality check`() {
        3 eq 3
    }

    @Test
    fun `integer - should pass inequality check`() {
        3 neq 4
    }

    @Test
    fun `long - should pass greater than check`() {
        3L gt 2L
    }

    @Test
    fun `long - should pass lower than check`() {
        2L lt 3L
    }

    @Test
    fun `long - should pass greater or equal check`() {
        3L gte 3L
    }

    @Test
    fun `long - should pass lower or equal check`() {
        3L lte 3L
    }

    @Test
    fun `long - should pass equality check`() {
        3L eq 3L
    }

    @Test
    fun `long - should pass inequality check`() {
        3L neq 4L
    }

    @Test
    fun `double - should pass greater than check`() {
        3.0 gt 2.0
    }

    @Test
    fun `double - should pass lower than check`() {
        2.0 lt 3.0
    }

    @Test
    fun `double - should pass greater or equal check`() {
        val f = 3.0
        print(f)
        3.0 gte 3.0
    }

    @Test
    fun `double - should pass lower or equal check`() {
        3.0 lte 3.0
    }

    @Test
    fun `double - should pass equality check`() {
        3.0 eq 3.0
    }

    @Test
    fun `double - should pass inequality check`() {
        3.0 neq 4.0
    }

    @Test
    fun `float - should pass greater than check`() {
        3.0f gt 2.0f
    }

    @Test
    fun `float - should pass lower than check`() {
        2.0f lt 3.0f
    }

    @Test
    fun `float - should pass greater or equal check`() {
        3.0f gte 3.0f
    }

    @Test
    fun `float - should pass lower or equal check`() {
        3.0f lte 3.0f
    }

    @Test
    fun `float - should pass equality check`() {
        3.0f eq 3.0f
    }

    @Test
    fun `float - should pass inequality check`() {
        3.0f neq 4.0f
    }

    @Test
    fun `byte - should pass greater than check`() {
        3.toByte() gt 2.toByte()
    }

    @Test
    fun `byte - should pass lower than check`() {
        2.toByte() lt 3.toByte()
    }

    @Test
    fun `byte - should pass greater or equal check`() {
        3.toByte() gte 3.toByte()
    }

    @Test
    fun `byte - should pass lower or equal check`() {
        3.toByte() lte 3.toByte()
    }

    @Test
    fun `byte - should pass equality check`() {
        3.toByte() eq 3.toByte()
    }

    @Test
    fun `byte - should pass inequality check`() {
        3.toByte() neq 4.toByte()
    }

    @Test
    fun `short - should pass greater than check`() {
        3.toShort() gt 2.toShort()
    }

    @Test
    fun `short - should pass lower than check`() {
        2.toShort() lt 3.toShort()
    }

    @Test
    fun `short - should pass greater or equal check`() {
        3.toShort() gte 3.toShort()
    }

    @Test
    fun `short - should pass lower or equal check`() {
        3.toShort() lte 3.toShort()
    }

    @Test
    fun `short - should pass equality check`() {
        3.toShort() eq 3.toShort()
    }

    @Test
    fun `short - should pass inequality check`() {
        3.toShort() neq 4.toShort()
    }
}