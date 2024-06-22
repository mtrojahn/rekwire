package org.rekwire.base

/**
 * Requires the number to be greater than the [other]
 */
infix fun <T : Number> T.gt(other: T): T {
    require(ComparableNumber(this) > ComparableNumber(other)) { "Expected $this to be greater than $other." }
    return this
}

/**
 * Requires the number to be lower than the [other]
 */
infix fun <T : Number> T.lt(other: T): T {
    require(ComparableNumber(this) < ComparableNumber(other)) { "Expected $this to be lower than $other." }
    return this
}

/**
 * Requires the number to be greater or equal to the [other]
 */
infix fun <T : Number> T.gte(other: T): T {
    require(ComparableNumber(this) >= ComparableNumber(other)) { "Expected $this to be greater than or equal to $other." }
    return this
}

/**
 * Requires the number to be lower or equal to the [other]
 */
infix fun <T : Number> T.lte(other: T): T {
    require(ComparableNumber(this) <= ComparableNumber(other)) { "Expected $this to be lower than or equal to $other." }
    return this
}

/**
 * Requires the number to be equal to the [other]
 */
infix fun <T : Number> T.eq(other: T): T {
    require(ComparableNumber(this) == ComparableNumber(other)) { "Expected $this to be equal to $other." }
    return this
}

/**
 * Requires the number to be different from the [other]
 */
infix fun <T : Number> T.neq(other: T): T {
    require(ComparableNumber(this) != ComparableNumber(other)) { "Expected $this to be different from $other." }
    return this
}