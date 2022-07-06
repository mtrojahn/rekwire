package org.mtrojahn

/**
 * Requires the string length to be greater than [min]
 */
infix fun String.minLen(min: Int): String {
    require(this.length >= min) { "Expected a string with a minimal length of $min." }
    return this
}

/**
 * Requires the string length to be lower than [max]
 */
infix fun String.maxLen(max: Int): String {
    require(this.length <= max) { "Expected a string with a maximum length of $max." }
    return this
}

/**
 * Requires the string to match the given [regex]
 */
infix fun String.match(regex: String): String {
    require(regex.toRegex().matches(this)) { "Expected `$this` to match `$regex`." }
    return this
}