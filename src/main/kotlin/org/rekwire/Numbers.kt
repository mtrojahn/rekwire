package org.rekwire

/**
 * Infix function for Number type to check if it's greater than the other number.
 * The function uses ComparableNumber for comparison and throws an exception if the condition is not met.
 *
 * @param other The number to compare this number with.
 * @return This number if it's greater than the other number.
 * @throws IllegalArgumentException If this number is not greater than the other number.
 */
infix fun <T : Number> T.gt(other: T): T {
    require(ComparableNumber(this) > ComparableNumber(other)) { "$this should be greater than $other." }
    return this
}

/**
 * Infix function for Number type to check if it's lower than the other number.
 * The function uses ComparableNumber for comparison and throws an exception if the condition is not met.
 *
 * @param other The number to compare this number with.
 * @return This number if it's lower than the other number.
 * @throws IllegalArgumentException If this number is not lower than the other number.
 */
infix fun <T : Number> T.lt(other: T): T {
    require(ComparableNumber(this) < ComparableNumber(other)) { "$this should be lower than $other." }
    return this
}

/**
 * Infix function for Number type to check if it's greater than or equal to the other number.
 * The function uses ComparableNumber for comparison and throws an exception if the condition is not met.
 *
 * @param other The number to compare this number with.
 * @return This number if it's greater than or equal to the other number.
 * @throws IllegalArgumentException If this number is not greater than or equal to the other number.
 */
infix fun <T : Number> T.gte(other: T): T {
    require(ComparableNumber(this) >= ComparableNumber(other)) { "$this should be greater than or equal to $other." }
    return this
}

/**
 * Infix function for Number type to check if it's lower than or equal to the other number.
 * The function uses ComparableNumber for comparison and throws an exception if the condition is not met.
 *
 * @param other The number to compare this number with.
 * @return This number if it's lower than or equal to the other number.
 * @throws IllegalArgumentException If this number is not lower than or equal to the other number.
 */
infix fun <T : Number> T.lte(other: T): T {
    require(ComparableNumber(this) <= ComparableNumber(other)) { "$this should be lower than or equal to $other." }
    return this
}

/**
 * Infix function for Number type to check if it's equal to the other number.
 * The function uses ComparableNumber for comparison and throws an exception if the condition is not met.
 *
 * @param other The number to compare this number with.
 * @return This number if it's equal to the other number.
 * @throws IllegalArgumentException If this number is not equal to the other number.
 */
infix fun <T : Number> T.eq(other: T): T {
    require(ComparableNumber(this) == ComparableNumber(other)) { "$this should be equal to $other." }
    return this
}

/**
 * Infix function for Number type to check if it's different from the other number.
 * The function uses ComparableNumber for comparison and throws an exception if the condition is not met.
 *
 * @param other The number to compare this number with.
 * @return This number if it's different from the other number.
 * @throws IllegalArgumentException If this number is not different from the other number.
 */
infix fun <T : Number> T.neq(other: T): T {
    require(ComparableNumber(this) != ComparableNumber(other)) { "$this should be different from $other." }
    return this
}