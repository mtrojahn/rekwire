package org.rekwire

import kotlin.reflect.KProperty
import org.rekwire.base.gt
import org.rekwire.base.gte
import org.rekwire.base.lt
import org.rekwire.base.lte
import org.rekwire.base.match
import org.rekwire.base.maxLen
import org.rekwire.base.minLen
import kotlin.runCatching

class RekwireValidationException(val errors: List<String>, message: String = "Validation failed"): Throwable(message)

abstract class Rekwireable {
    private val errors = mutableListOf<String>()

    protected fun rekwire(validations: () -> Unit) {
        validations()
        if (errors.isNotEmpty()) {
            throw RekwireValidationException(errors)
        }
    }

    /** STRINGS **/
    infix fun KProperty<String>.match(regex: String): KProperty<String> {
        runCatching { this.call() match regex }
            .onFailure { errors.add("Property '$name' should match '$regex'") }
        return this
    }

    infix fun KProperty<String>.minLen(min: Int): KProperty<String> {
        runCatching { this.call() minLen min }
            .onFailure { errors.add("Length of '${this.name}' should be at least $min") }
        return this
    }

    infix fun KProperty<String>.maxLen(max: Int): KProperty<String> {
        runCatching { this.call() maxLen max }
            .onFailure { errors.add("Length of '${this.name}' should be at most $max") }
        return this
    }

    /** NUMBERS **/
    infix fun KProperty<Number>.gt(other: Number): KProperty<Number> {
        runCatching { this.call() gt other }
            .onFailure { errors.add("Property '$name' should be greater than $other") }
        return this
    }

    infix fun KProperty<Number>.lt(other: Number): KProperty<Number> {
        runCatching { this.call() lt other }
            .onFailure { errors.add("Property '$name' should be lower than $other") }
        return this
    }

    infix fun KProperty<Number>.gte(other: Number): KProperty<Number> {
        runCatching { this.call() gte other }
            .onFailure { errors.add("Property '$name' should be greater or equal to $other") }
        return this
    }

    infix fun KProperty<Number>.lte(other: Number): KProperty<Number> {
        runCatching { this.call() lte other }
            .onFailure { errors.add("Property '$name' should be lower or equal to $other") }
        return this
    }
}


