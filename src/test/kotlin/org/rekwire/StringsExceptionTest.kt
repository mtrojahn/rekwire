package org.rekwire

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class StringsExceptionTest {
    @Test
    fun `should fail minimal length check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            "foo" minLen 4
        }
        assertEquals("'foo' should be at least 4 characters long.", exception.message)
    }

    @Test
    fun `should fail maximal length check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            "foo" maxLen 2
        }
        assertEquals("'foo' should be at most 2 characters long.", exception.message)
    }

    @Test
    fun `should fail regex match`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            "foo" match "bar"
        }
        assertEquals("'foo' should match 'bar'.", exception.message)
    }

    @Test
    fun `should fail equality check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            "foo" eq "bar"
        }
        assertEquals("'foo' should be equal to 'bar'.", exception.message)
    }

    @Test
    fun `should fail inequality check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            "foo" neq "foo"
        }
        assertEquals("'foo' should be different from 'foo'.", exception.message)
    }

    @Test
    fun `should fail inclusion check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            "foo" includes "bar"
        }
        assertEquals("'foo' should include 'bar'.", exception.message)
    }

    @Test
    fun `should fail exclusion check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            "foo" excludes "o"
        }
        assertEquals("'foo' should not include 'o'.", exception.message)
    }

    @Test
    fun `should fail prefix check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            "foo" startingWith "o"
        }
        assertEquals("'foo' should start with 'o'.", exception.message)
    }

    @Test
    fun `should fail suffix check`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            "foo" endingWith "f"
        }
        assertEquals("'foo' should end with 'f'.", exception.message)
    }

}