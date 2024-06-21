package org.rekwire.base

/**
 * Requires the string length to be greater than [min]
 */
infix fun String.minLen(min: Int): String {
    require(this.length >= min) { "String length should be at least $min" }
    return this
}

/**
 * Requires the string length to be lower than [max]
 */
infix fun String.maxLen(max: Int): String {
    require(this.length <= max) { "String length should be at most $max" }
    return this
}

/**
 * Requires the string to match the given [regex]
 */
infix fun String.match(regex: String): String {
    require(regex.toRegex().matches(this)) { "String should match '$regex'" }
    return this
}

/**
 * Requires the string to be equal to the [other]
 */
infix fun String.eq(other: String): String {
    require(this == other) { "String should be equal to '$other'" }
    return this
}

/**
 * Requires the string to be different from the [other]
 */
infix fun String.neq(other: String): String {
    require(this != other) { "String should be different from '$other'" }
    return this
}

/**
 * Requires the string to contain the [other]
 */
infix fun String.includes(other: String): String {
    require(this.contains(other)) { "String should include '$other'" }
    return this
}
