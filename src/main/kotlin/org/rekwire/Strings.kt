package org.rekwire

/**
 * Requires the string length to be greater than [min]
 */
infix fun String.minLen(min: Int): String {
    require(this.length >= min) { "'$this' should be at least $min characters long." }
    return this
}

/**
 * Requires the string length to be lower than [max]
 */
infix fun String.maxLen(max: Int): String {
    require(this.length <= max) { "'$this' should be at most $max characters long." }
    return this
}

/**
 * Requires the string to match the given [regex]
 */
infix fun String.match(regex: String): String {
    require(regex.toRegex().matches(this)) { "'$this' should match '$regex'." }
    return this
}

/**
 * Requires the string to be equal to the [other]
 */
infix fun String.eq(other: String): String {
    require(this == other) { "'$this' should be equal to '$other'." }
    return this
}

/**
 * Requires the string to be different from the [other]
 */
infix fun String.neq(other: String): String {
    require(this != other) { "'$this' should be different from '$other'." }
    return this
}

/**
 * Requires the string to contain the [other]
 */
infix fun String.includes(other: String): String {
    require(this.contains(other)) { "'$this' should include '$other'." }
    return this
}

/**
 * Requires the string to not contain the [other]
 */
infix fun String.excludes(other: String): String {
    require(!this.contains(other)) { "'$this' should not include '$other'." }
    return this
}

/**
 * Requires the string to start with the [prefix]
 */
infix fun String.startingWith(prefix: String): String {
    require(this.startsWith(prefix)) { "'$this' should start with '$prefix'." }
    return this
}

/**
 * Requires the string to end with the [suffix]
 */
infix fun String.endingWith(suffix: String): String {
    require(this.endsWith(suffix)) { "'$this' should end with '$suffix'." }
    return this
}
