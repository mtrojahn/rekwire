package org.rekwire.exception

class RekwireValidationException(private val errors: List<String>) : Throwable() {
    override val message = "Rekwire Validation Failed"
    override fun toString(): String {
        val errorMessages = errors.joinToString("\n") { "  - $it" }
        return "${message}\n${errorMessages}"
    }
}