package org.rekwire

/**
 * A wrapper class for Number that implements the Comparable interface.
 *
 * @param T The type of the number. It must be a subtype of Number.
 * @property value The value of the number.
 * @constructor Creates a new ComparableNumber with the given value.
 */
class ComparableNumber<T : Number>(private val value: T) : Comparable<ComparableNumber<T>> {

    /**
     * Compares this number with the specified number for order.
     * Returns zero if this number is equal to the specified other number, a negative number if it's less than other,
     * or a positive number if it's greater than other.
     *
     * @param other The number to be compared.
     * @return A negative integer, zero, or a positive integer as this number is less than, equal to, or greater than the specified number.
     * @throws IllegalArgumentException If the number type is unsupported.
     */
    override fun compareTo(other: ComparableNumber<T>): Int {
        return when (value) {
            is Byte -> value.compareTo(other.value as Byte)
            is Short -> value.compareTo(other.value as Short)
            is Int -> value.compareTo(other.value as Int)
            is Long -> value.compareTo(other.value as Long)
            is Float -> value.compareTo(other.value as Float)
            is Double -> value.compareTo(other.value as Double)
            else -> throw IllegalArgumentException("Unsupported number type.")
        }
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * The result is true if and only if the argument is not null and is a ComparableNumber object that represents the same number as this object.
     *
     * @param other The reference object with which to compare.
     * @return True if this object is the same as the obj argument; false otherwise.
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ComparableNumber<*>) return false
        if (value != other.value) return false
        return true
    }

    /**
     * Returns a hash code value for the object.
     * This method is supported for the benefit of hash tables such as those provided by HashMap.
     *
     * @return A hash code value for this object.
     */
    override fun hashCode(): Int {
        return value.hashCode()
    }
}