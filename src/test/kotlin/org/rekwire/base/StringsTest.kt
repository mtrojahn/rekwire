package org.rekwire.base

import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import org.junit.jupiter.api.Test

internal class StringsTest {

    @Test
    fun `string gt success`() {
        "foo" minLen 2
        "foo" minLen 3
    }

    @Test
    fun `string gt fail`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            "foo" minLen 4
        }
        assertEquals("String length should be at least 4", exception.message)
    }

    @Test
    fun `string lt success`() {
        "foo" maxLen 3
        "foo" maxLen 4
    }

    @Test
    fun `string lt fail`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            "foo" maxLen 2
        }
        assertEquals("String length should be at most 2", exception.message)
    }

    @Test
    fun `string matches success`() {
        "foo" match "foo"
        "foo" match "[fo]{3}"
    }

    @Test
    fun `string matches fail`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            "foo" match "bar"
        }
        assertEquals("String should match `bar`", exception.message)
    }

}