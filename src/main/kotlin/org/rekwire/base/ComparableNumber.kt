package org.rekwire.base

class ComparableNumber<T : Number>(private val value: T) : Comparable<ComparableNumber<T>> {

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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ComparableNumber<*>) return false
        if (value != other.value) return false
        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}