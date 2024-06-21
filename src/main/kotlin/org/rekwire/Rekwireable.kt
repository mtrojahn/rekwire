package org.rekwire

import org.rekwire.base.eq
import kotlin.reflect.KProperty
import org.rekwire.base.gt
import org.rekwire.base.gte
import org.rekwire.base.includes
import org.rekwire.base.lt
import org.rekwire.base.lte
import org.rekwire.base.match
import org.rekwire.base.maxLen
import org.rekwire.base.minLen
import org.rekwire.base.neq
import kotlin.runCatching

abstract class Rekwireable {

    protected fun rekwire(block: RekwireContext.() -> Unit) {
        val context = RekwireContext()
        context.block()
        context.validate()
    }
}

class RekwireContext {

    private val rules = mutableListOf<() -> Unit>()
    private val errors = mutableListOf<String>()

    fun validate() {
        rules.forEach { it.invoke() }
        if (errors.isNotEmpty()) {
            throw RekwireValidationException(errors)
        }
    }

    /** STRINGS **/
    infix fun KProperty<String>.match(regex: String): KProperty<String> {
        rules.add {
            runCatching { this.call() match regex }
                .onFailure { errors.add("Property '${this.name}' should match '$regex'") }
        }
        return this
    }

    infix fun KProperty<String>.minLen(min: Int): KProperty<String> {
        rules.add {
            runCatching { this.call() minLen min }
                .onFailure { errors.add("Length of '${this.name}' should be at least $min") }
        }
        return this
    }

    infix fun KProperty<String>.maxLen(max: Int): KProperty<String> {
        rules.add {
            runCatching { this.call() maxLen max }
                .onFailure { errors.add("Length of '${this.name}' should be at most $max") }
        }
        return this
    }

    infix fun KProperty<String>.eq(other: String): KProperty<String> {
        rules.add {
            runCatching { this.call() eq other }
                .onFailure { errors.add("Property '${this.name}' should be equal to $other") }
        }
        return this
    }

    infix fun KProperty<String>.neq(other: String): KProperty<String> {
        rules.add {
            runCatching { this.call() neq other }
                .onFailure { errors.add("Property '${this.name}' should be different from $other") }
        }
        return this
    }

    infix fun KProperty<String>.includes(other: String): KProperty<String> {
        rules.add {
            runCatching { this.call() includes other }
                .onFailure { errors.add("Property '${this.name}' should include '$other'") }
        }
        return this
    }

    /** NUMBERS **/
    infix fun KProperty<Number>.gt(other: Number): KProperty<Number> {
        rules.add {
            runCatching { this.call() gt other }
                .onFailure { errors.add("Property '${this.name}' should be greater than $other") }
        }
        return this
    }

    infix fun KProperty<Number>.lt(other: Number): KProperty<Number> {
        rules.add {
            runCatching { this.call() lt other }
                .onFailure { errors.add("Property '${this.name}' should be lower than $other") }
        }
        return this
    }

    infix fun KProperty<Number>.gte(other: Number): KProperty<Number> {
        rules.add {
            runCatching { this.call() gte other }
                .onFailure { errors.add("Property '${this.name}' should be greater or equal to $other") }
        }
        return this
    }

    infix fun KProperty<Number>.lte(other: Number): KProperty<Number> {
        rules.add {
            runCatching { this.call() lte other }
                .onFailure { errors.add("Property '${this.name}' should be lower or equal to $other") }
        }
        return this
    }

    infix fun KProperty<Number>.eq(other: Number): KProperty<Number> {
        rules.add {
            runCatching { this.call() eq other }
                .onFailure { errors.add("Property '${this.name}' should be equal to $other") }
        }
        return this
    }

    infix fun KProperty<Number>.neq(other: Number): KProperty<Number> {
        rules.add {
            runCatching { this.call() neq other }
                .onFailure { errors.add("Property '${this.name}' should be different from $other") }
        }
        return this
    }
}


