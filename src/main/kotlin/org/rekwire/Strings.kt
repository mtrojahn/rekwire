package org.rekwire

/**
 * Infix function for String type to check if its length is greater than the specified minimum length.
 * The function throws an exception if the condition is not met.
 *
 * @param min The minimum length the string should have.
 * @return This string if its length is greater than or equal to the minimum length.
 * @throws IllegalArgumentException If the length of this string is less than the minimum length.
 */
infix fun String.minLen(min: Int): String {
    require(this.length >= min) { "'$this' should be at least $min characters long." }
    return this
}

/**
 * Infix function for String type to check if its length is less than the specified maximum length.
 * The function throws an exception if the condition is not met.
 *
 * @param max The maximum length the string should have.
 * @return This string if its length is less than or equal to the maximum length.
 * @throws IllegalArgumentException If the length of this string is greater than the maximum length.
 */
infix fun String.maxLen(max: Int): String {
    require(this.length <= max) { "'$this' should be at most $max characters long." }
    return this
}

/**
 * Infix function for String type to check if it matches the given regular expression.
 * The function throws an exception if the condition is not met.
 *
 * @param regex The regular expression the string should match.
 * @return This string if it matches the regular expression.
 * @throws IllegalArgumentException If this string does not match the regular expression.
 */
infix fun String.match(regex: String): String {
    require(regex.toRegex().matches(this)) { "'$this' should match '$regex'." }
    return this
}

/**
 * Infix function for String type to check if it is equal to the other string.
 * The function throws an exception if the condition is not met.
 *
 * @param other The string to compare this string with.
 * @return This string if it is equal to the other string.
 * @throws IllegalArgumentException If this string is not equal to the other string.
 */
infix fun String.eq(other: String): String {
    require(this == other) { "'$this' should be equal to '$other'." }
    return this
}

/**
 * Infix function for String type to check if it is different from the other string.
 * The function throws an exception if the condition is not met.
 *
 * @param other The string to compare this string with.
 * @return This string if it is different from the other string.
 * @throws IllegalArgumentException If this string is not different from the other string.
 */
infix fun String.neq(other: String): String {
    require(this != other) { "'$this' should be different from '$other'." }
    return this
}

/**
 * Infix function for String type to check if it contains the other string.
 * The function throws an exception if the condition is not met.
 *
 * @param other The string that should be contained in this string.
 * @return This string if it contains the other string.
 * @throws IllegalArgumentException If this string does not contain the other string.
 */
infix fun String.includes(other: String): String {
    require(this.contains(other)) { "'$this' should include '$other'." }
    return this
}

/**
 * Infix function for String type to check if it does not contain the other string.
 * The function throws an exception if the condition is not met.
 *
 * @param other The string that should not be contained in this string.
 * @return This string if it does not contain the other string.
 * @throws IllegalArgumentException If this string contains the other string.
 */
infix fun String.excludes(other: String): String {
    require(!this.contains(other)) { "'$this' should not include '$other'." }
    return this
}

/**
 * Infix function for String type to check if it starts with the specified prefix.
 * The function throws an exception if the condition is not met.
 *
 * @param prefix The prefix the string should start with.
 * @return This string if it starts with the specified prefix.
 * @throws IllegalArgumentException If this string does not start with the specified prefix.
 */
infix fun String.startingWith(prefix: String): String {
    require(this.startsWith(prefix)) { "'$this' should start with '$prefix'." }
    return this
}

/**
 * Infix function for String type to check if it ends with the specified suffix.
 * The function throws an exception if the condition is not met.
 *
 * @param suffix The suffix the string should end with.
 * @return This string if it ends with the specified suffix.
 * @throws IllegalArgumentException If this string does not end with the specified suffix.
 */
infix fun String.endingWith(suffix: String): String {
    require(this.endsWith(suffix)) { "'$this' should end with '$suffix'." }
    return this
}