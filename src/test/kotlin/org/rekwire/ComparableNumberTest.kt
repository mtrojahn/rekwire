package org.rekwire

import kotlin.test.Test
import kotlin.test.assertEquals

internal class ComparableNumberTest {

    @Test
    fun `compareTo - should return zero when numbers are equal`() {
        val number1 = ComparableNumber(5)
        val number2 = ComparableNumber(5)
        assertEquals(0, number1.compareTo(number2))
    }

    @Test
    fun `compareTo - should return positive when first number is greater`() {
        val number1 = ComparableNumber(10)
        val number2 = ComparableNumber(5)
        assert(number1.compareTo(number2) > 0)
    }

    @Test
    fun `compareTo - should return negative when first number is smaller`() {
        val number1 = ComparableNumber(5)
        val number2 = ComparableNumber(10)
        assert(number1.compareTo(number2) < 0)
    }

    @Test
    fun `equals - should return true when numbers are equal`() {
        val number1 = ComparableNumber(5)
        val number2 = ComparableNumber(5)
        assertEquals(true, number1.equals(number2))
    }

    @Test
    fun `equals - should return false when numbers are not equal`() {
        val number1 = ComparableNumber(5)
        val number2 = ComparableNumber(10)
        assertEquals(false, number1.equals(number2))
    }

    @Test
    fun `hashCode - should return same hash code for equal numbers`() {
        val number1 = ComparableNumber(5)
        val number2 = ComparableNumber(5)
        assertEquals(number1.hashCode(), number2.hashCode())
    }

    @Test
    fun `hashCode - should return different hash code for different numbers`() {
        val number1 = ComparableNumber(5)
        val number2 = ComparableNumber(10)
        assert(number1.hashCode() != number2.hashCode())
    }
}