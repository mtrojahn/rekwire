package org.rekwire

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class NumbersExceptionTest {

    @Test
    fun `integer - should fail greater than check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            2 gt 3
        }
        assertEquals("2 should be greater than 3.", exception.message)
    }

    @Test
    fun `integer - should fail lower than check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            3 lt 2
        }
        assertEquals("3 should be lower than 2.", exception.message)
    }

    @Test
    fun `integer - should fail greater or equal check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            2 gte 3
        }
        assertEquals("2 should be greater than or equal to 3.", exception.message)
    }

    @Test
    fun `integer - should fail lower or equal check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            3 lte 2
        }
        assertEquals("3 should be lower than or equal to 2.", exception.message)
    }

    @Test
    fun `integer - should fail equality check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            2 eq 3
        }
        assertEquals("2 should be equal to 3.", exception.message)
    }

    @Test
    fun `integer - should fail inequality check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            3 neq 3
        }
        assertEquals("3 should be different from 3.", exception.message)
    }

    @Test
    fun `long - should fail greater than check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            2L gt 3L
        }
        assertEquals("2 should be greater than 3.", exception.message)
    }

    @Test
    fun `long - should fail lower than check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            3L lt 2L
        }
        assertEquals("3 should be lower than 2.", exception.message)
    }

    @Test
    fun `long - should fail greater or equal check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            2L gte 3L
        }
        assertEquals("2 should be greater than or equal to 3.", exception.message)
    }

    @Test
    fun `long - should fail lower or equal check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            3L lte 2L
        }
        assertEquals("3 should be lower than or equal to 2.", exception.message)
    }

    @Test
    fun `long - should fail equality check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            2L eq 3L
        }
        assertEquals("2 should be equal to 3.", exception.message)
    }

    @Test
    fun `long - should fail inequality check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            3L neq 3L
        }
        assertEquals("3 should be different from 3.", exception.message)
    }

    @Test
    fun `float - should fail greater than check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            2.0f gt 3.0f
        }
        assertEquals("2.0 should be greater than 3.0.", exception.message)
    }

    @Test
    fun `float - should fail lower than check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            3.0f lt 2.0f
        }
        assertEquals("3.0 should be lower than 2.0.", exception.message)
    }

    @Test
    fun `float - should fail greater or equal check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            2.0f gte 3.0f
        }
        assertEquals("2.0 should be greater than or equal to 3.0.", exception.message)
    }

    @Test
    fun `float - should fail lower or equal check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            3.0f lte 2.0f
        }
        assertEquals("3.0 should be lower than or equal to 2.0.", exception.message)
    }

    @Test
    fun `float - should fail equality check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            2.0f eq 3.0f
        }
        assertEquals("2.0 should be equal to 3.0.", exception.message)
    }

    @Test
    fun `float - should fail inequality check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            3.0f neq 3.0f
        }
        assertEquals("3.0 should be different from 3.0.", exception.message)
    }

    @Test
    fun `double - should fail greater than check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            2.0 gt 3.0
        }
        assertEquals("2.0 should be greater than 3.0.", exception.message)
    }

    @Test
    fun `double - should fail lower than check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            3.0 lt 2.0
        }
        assertEquals("3.0 should be lower than 2.0.", exception.message)
    }

    @Test
    fun `double - should fail greater or equal check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            2.0 gte 3.0
        }
        assertEquals("2.0 should be greater than or equal to 3.0.", exception.message)
    }

    @Test
    fun `double - should fail lower or equal check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            3.0 lte 2.0
        }
        assertEquals("3.0 should be lower than or equal to 2.0.", exception.message)
    }

    @Test
    fun `double - should fail equality check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            2.0 eq 3.0
        }
        assertEquals("2.0 should be equal to 3.0.", exception.message)
    }

    @Test
    fun `double - should fail inequality check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            3.0 neq 3.0
        }
        assertEquals("3.0 should be different from 3.0.", exception.message)
    }

    @Test
    fun `byte - should fail greater than check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            2.toByte() gt 3.toByte()
        }
        assertEquals("2 should be greater than 3.", exception.message)
    }

    @Test
    fun `byte - should fail lower than check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            3.toByte() lt 2.toByte()
        }
        assertEquals("3 should be lower than 2.", exception.message)
    }

    @Test
    fun `byte - should fail greater or equal check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            2.toByte() gte 3.toByte()
        }
        assertEquals("2 should be greater than or equal to 3.", exception.message)
    }

    @Test
    fun `byte - should fail lower or equal check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            3.toByte() lte 2.toByte()
        }
        assertEquals("3 should be lower than or equal to 2.", exception.message)
    }

    @Test
    fun `byte - should fail equality check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            2.toByte() eq 3.toByte()
        }
        assertEquals("2 should be equal to 3.", exception.message)
    }

    @Test
    fun `byte - should fail inequality check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            3.toByte() neq 3.toByte()
        }
        assertEquals("3 should be different from 3.", exception.message)
    }

    @Test
    fun `short - should fail greater than check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            2.toShort() gt 3.toShort()
        }
        assertEquals("2 should be greater than 3.", exception.message)
    }

    @Test
    fun `short - should fail lower than check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            3.toShort() lt 2.toShort()
        }
        assertEquals("3 should be lower than 2.", exception.message)
    }

    @Test
    fun `short - should fail greater or equal check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            2.toShort() gte 3.toShort()
        }
        assertEquals("2 should be greater than or equal to 3.", exception.message)
    }

    @Test
    fun `short - should fail lower or equal check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            3.toShort() lte 2.toShort()
        }
        assertEquals("3 should be lower than or equal to 2.", exception.message)
    }

    @Test
    fun `short - should fail equality check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            2.toShort() eq 3.toShort()
        }
        assertEquals("2 should be equal to 3.", exception.message)
    }

    @Test
    fun `short - should fail inequality check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            3.toShort() neq 3.toShort()
        }
        assertEquals("3 should be different from 3.", exception.message)
    }
}