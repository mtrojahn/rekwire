package org.rekwire.base

/**
 * Requires the number to be greater than the [other]
 */
infix fun <T : Number> T.gt(other: T): T {
    val exceptionMessage = "Expected $this to be greater than $other."
    when (this) {
        is Byte -> require(this > other as Byte) { exceptionMessage }
        is Double -> require(this > other as Double) { exceptionMessage }
        is Float -> require(this > other as Float) { exceptionMessage }
        is Int -> require(this > other as Int) { exceptionMessage }
        is Long -> require(this > other as Long) { exceptionMessage }
        is Short -> require(this > other as Short) { exceptionMessage }
    }
    return this
}

/**
 * Requires the number to be lower than the [other]
 */
infix fun <T : Number> T.lt(other: T): T {
    val exceptionMessage = "Expected $this to be lower than $other."
    when (this) {
        is Byte -> require(this < other as Byte) { exceptionMessage }
        is Double -> require(this < other as Double) { exceptionMessage }
        is Float -> require(this < other as Float) { exceptionMessage }
        is Int -> require(this < other as Int) { exceptionMessage }
        is Long -> require(this < other as Long) { exceptionMessage }
        is Short -> require(this < other as Short) { exceptionMessage }
    }
    return this
}

/**
 * Requires the number to be greater or equal to the [other]
 */
infix fun <T : Number> T.gte(other: T): T {
    val exceptionMessage = "Expected $this to be greater than or equal to $other."
    when (this) {
        is Byte -> require(this >= other as Byte) { exceptionMessage }
        is Double -> require(this >= other as Double) { exceptionMessage }
        is Float -> require(this >= other as Float) { exceptionMessage }
        is Int -> require(this >= other as Int) { exceptionMessage }
        is Long -> require(this >= other as Long) { exceptionMessage }
        is Short -> require(this >= other as Short) { exceptionMessage }
    }
    return this
}

/**
 * Requires the number to be lower or equal to the [other]
 */
infix fun <T : Number> T.lte(other: T): T {
    val exceptionMessage = "Expected $this to be lower than or equal to $other."
    when (this) {
        is Byte -> require(this <= other as Byte) { exceptionMessage }
        is Double -> require(this <= other as Double) { exceptionMessage }
        is Float -> require(this <= other as Float) { exceptionMessage }
        is Int -> require(this <= other as Int) { exceptionMessage }
        is Long -> require(this <= other as Long) { exceptionMessage }
        is Short -> require(this <= other as Short) { exceptionMessage }
    }
    return this
}