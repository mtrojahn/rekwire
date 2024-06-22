package org.rekwire.exception

/**
 * Exception thrown when a validation fails. Contains a list of error messages and overrides the toString method to
 * provide a formatted error report with all the validation errors in the stack trace.
 */
class RekwireValidationException(private val errors: List<String>) : Throwable() {
    override val message = "Rekwire Validation Failed"
    override fun toString(): String {
        val errorMessages = errors.joinToString("\n") { "  - $it" }
        return "${message}\n${errorMessages}"
    }
}