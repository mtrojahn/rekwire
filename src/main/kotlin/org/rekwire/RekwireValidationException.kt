package org.rekwire

class RekwireValidationException(val errors: List<String>) : Throwable() {
    override val message = "Rekwire Validation Failed"
    override fun toString(): String {
        val errorMessages = errors.joinToString("\n") { "  - $it" }
        return "${message}\n${errorMessages}"
    }
}