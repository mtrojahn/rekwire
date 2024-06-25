package org.rekwire.exception

/**
 * Exception class for Rekwire validation errors.
 * This class extends Throwable and overrides the message and toString methods.
 *
 * @property errors A list of error messages.
 */
class RekwireValidationException(private val errors: List<String>) : Throwable() {

    /**
     * The message for this exception.
     * This is always "Rekwire Validation Failed".
     */
    override val message = "Rekwire Validation Failed"

    /**
     * Returns a string representation of this exception.
     * The string contains the message and all error messages, each on a new line.
     *
     * @return A string representation of this exception.
     */
    override fun toString(): String {
        val errorMessages = errors.joinToString("\n") { "  - $it" }
        return "${message}\n${errorMessages}"
    }
}