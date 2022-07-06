package org.mtrojahn

import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import org.junit.jupiter.api.Test

internal class RekwireStringTests {

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
        assertEquals("Expected a string with a minimal length of 4.", exception.message)
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
        assertEquals("Expected a string with a maximum length of 2.", exception.message)
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
        assertEquals("Expected `foo` to match `bar`.", exception.message)
    }

}