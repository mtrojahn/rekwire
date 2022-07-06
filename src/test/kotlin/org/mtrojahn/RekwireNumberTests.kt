package org.mtrojahn

import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import org.junit.jupiter.api.Test

internal class RekwireNumberTests {

    /**
     * GREATER THAN TESTS
     */
    @Test
    fun `int gt success`() {
        1 gt 0
    }

    @Test
    fun `int gt fail`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            1 gt 2
        }
        assertEquals("Expected 1 to be greater than 2.", exception.message)
    }

    @Test
    fun `byte gt success`() {
        1.toByte() gt 0.toByte()
    }

    @Test
    fun `byte gt fail`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            1.toByte() gt 2.toByte()
        }
        assertEquals("Expected 1 to be greater than 2.", exception.message)
    }

    @Test
    fun `double gt success`() {
        1.0 gt 0.0
    }

    @Test
    fun `double gt fail`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            1.0 gt 2.0
        }
        assertEquals("Expected 1.0 to be greater than 2.0.", exception.message)
    }

    @Test
    fun `float gt success`() {
        1.0f gt 0.0f
    }

    @Test
    fun `float gt fail`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            1.0f gt 2.0f
        }
        assertEquals("Expected 1.0 to be greater than 2.0.", exception.message)
    }

    @Test
    fun `long gt success`() {
        1L gt 0L
    }

    @Test
    fun `long gt fail`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            1L gt 2L
        }
        assertEquals("Expected 1 to be greater than 2.", exception.message)
    }

    @Test
    fun `short gt success`() {
        1.toShort() gt 0.toShort()
    }

    @Test
    fun `short gt fail`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            1.toShort() gt 2.toShort()
        }
        assertEquals("Expected 1 to be greater than 2.", exception.message)
    }

    /**
     * LOWER THAN TESTS
     */

    @Test
    fun `int lt success`() {
        1 lt 2
    }

    @Test
    fun `int lt fail`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            1 lt 0
        }
        assertEquals("Expected 1 to be lower than 0.", exception.message)
    }

    @Test
    fun `byte lt success`() {
        1.toByte() lt 2.toByte()
    }

    @Test
    fun `byte lt fail`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            1.toByte() lt 0.toByte()
        }
        assertEquals("Expected 1 to be lower than 0.", exception.message)
    }

    @Test
    fun `double lt success`() {
        1.0 lt 2.0
    }

    @Test
    fun `double lt fail`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            1.0 lt 0.0
        }
        assertEquals("Expected 1.0 to be lower than 0.0.", exception.message)
    }

    @Test
    fun `float lt success`() {
        1.0f lt 2.0f
    }

    @Test
    fun `float lt fail`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            1.0f lt 0.0f
        }
        assertEquals("Expected 1.0 to be lower than 0.0.", exception.message)
    }

    @Test
    fun `long lt success`() {
        1L lt 2L
    }

    @Test
    fun `long lt fail`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            1L lt 0L
        }
        assertEquals("Expected 1 to be lower than 0.", exception.message)
    }

    @Test
    fun `short lt success`() {
        1.toShort() lt 2.toShort()
    }

    @Test
    fun `short lt fail`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            1.toShort() lt 0.toShort()
        }
        assertEquals("Expected 1 to be lower than 0.", exception.message)
    }

    /**
     * GREATER THAN OR EQUAL TO TESTS
     */

    @Test
    fun `int gte success`() {
        1 gte 0
        1 gte 1
    }

    @Test
    fun `int gte fail`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            1 gte 2
        }
        assertEquals("Expected 1 to be greater than or equal to 2.", exception.message)
    }

    @Test
    fun `byte gte success`() {
        1.toByte() gte 0.toByte()
        1.toByte() gte 1.toByte()
    }

    @Test
    fun `byte gte fail`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            1.toByte() gte 2.toByte()
        }
        assertEquals("Expected 1 to be greater than or equal to 2.", exception.message)
    }

    @Test
    fun `double gte success`() {
        1.0 gte 0.0
        1.0 gte 1.0
    }

    @Test
    fun `double gte fail`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            1.0 gte 2.0
        }
        assertEquals("Expected 1.0 to be greater than or equal to 2.0.", exception.message)
    }

    @Test
    fun `float gte success`() {
        1.0f gte 0.0f
        1.0f gte 1.0f
    }

    @Test
    fun `float gte fail`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            1.0f gte 2.0f
        }
        assertEquals("Expected 1.0 to be greater than or equal to 2.0.", exception.message)
    }

    @Test
    fun `long gte success`() {
        1L gte 0L
        1L gte 1L
    }

    @Test
    fun `long gte fail`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            1L gte 2L
        }
        assertEquals("Expected 1 to be greater than or equal to 2.", exception.message)
    }

    @Test
    fun `short gte success`() {
        1.toShort() gte 0.toShort()
        1.toShort() gte 1.toShort()
    }

    @Test
    fun `short gte fail`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            1.toShort() gte 2.toShort()
        }
        assertEquals("Expected 1 to be greater than or equal to 2.", exception.message)
    }

    /**
     * LOWER THAN OR EQUAL TO TESTS
     */

    @Test
    fun `int lte success`() {
        0 lte 1
        1 lte 1
    }

    @Test
    fun `int lte fail`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            1 lte 0
        }
        assertEquals("Expected 1 to be lower than or equal to 0.", exception.message)
    }

    @Test
    fun `byte lte success`() {
        0.toByte() lte 1.toByte()
        1.toByte() lte 1.toByte()
    }

    @Test
    fun `byte lte fail`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            1.toByte() lte 0.toByte()
        }
        assertEquals("Expected 1 to be lower than or equal to 0.", exception.message)
    }

    @Test
    fun `double lte success`() {
        0.0 lte 1.0
        1.0 lte 1.0
    }

    @Test
    fun `double lte fail`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            1.0 lte 0.0
        }
        assertEquals("Expected 1.0 to be lower than or equal to 0.0.", exception.message)
    }

    @Test
    fun `float lte success`() {
        0.0f lte 1.0f
        1.0f lte 1.0f
    }

    @Test
    fun `float lte fail`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            1.0f lte 0.0f
        }
        assertEquals("Expected 1.0 to be lower than or equal to 0.0.", exception.message)
    }

    @Test
    fun `long lte success`() {
        0L lte 1L
        1L lte 1L
    }

    @Test
    fun `long lte fail`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            1L lte 0L
        }
        assertEquals("Expected 1 to be lower than or equal to 0.", exception.message)
    }

    @Test
    fun `short lte success`() {
        0.toShort() lte 1.toShort()
        1.toShort() lte 1.toShort()
    }

    @Test
    fun `short lte fail`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            1.toShort() lte 0.toShort()
        }
        assertEquals("Expected 1 to be lower than or equal to 0.", exception.message)
    }
}