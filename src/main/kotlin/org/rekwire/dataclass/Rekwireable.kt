package org.rekwire.dataclass

import org.rekwire.exception.RekwireValidationException
import org.rekwire.endingWith
import org.rekwire.eq
import org.rekwire.excludes
import org.rekwire.gt
import org.rekwire.gte
import org.rekwire.includes
import org.rekwire.lt
import org.rekwire.lte
import org.rekwire.match
import org.rekwire.maxLen
import org.rekwire.minLen
import org.rekwire.neq
import org.rekwire.startingWith
import kotlin.reflect.KProperty
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
            val value = this.call()
            runCatching { value match regex }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    infix fun KProperty<String>.minLen(min: Int): KProperty<String> {
        rules.add {
            val value = this.call()
            runCatching { value minLen min }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    infix fun KProperty<String>.maxLen(max: Int): KProperty<String> {
        rules.add {
            val value = this.call()
            runCatching { value maxLen max }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    infix fun KProperty<String>.eq(other: String): KProperty<String> {
        rules.add {
            val value = this.call()
            runCatching { value eq other }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    infix fun KProperty<String>.neq(other: String): KProperty<String> {
        rules.add {
            val value = this.call()
            runCatching { value neq other }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    infix fun KProperty<String>.includes(other: String): KProperty<String> {
        rules.add {
            val value = this.call()
            runCatching { value includes other }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    infix fun KProperty<String>.excludes(other: String): KProperty<String> {
        rules.add {
            val value = this.call()
            runCatching { value excludes other }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    infix fun KProperty<String>.startingWith(prefix: String): KProperty<String> {
        rules.add {
            val value = this.call()
            runCatching { value startingWith prefix }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    infix fun KProperty<String>.endingWith(suffix: String): KProperty<String> {
        rules.add {
            val value = this.call()
            runCatching { value endingWith suffix }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    /** NUMBERS **/

    infix fun KProperty<Number>.gt(other: Number): KProperty<Number> {
        rules.add {
            val value = this.call()
            runCatching { value gt other }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    infix fun KProperty<Number>.lt(other: Number): KProperty<Number> {
        rules.add {
            val value = this.call()
            runCatching { value lt other }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    infix fun KProperty<Number>.gte(other: Number): KProperty<Number> {
        rules.add {
            val value = this.call()
            runCatching { value gte other }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    infix fun KProperty<Number>.lte(other: Number): KProperty<Number> {
        rules.add {
            val value = this.call()
            runCatching { value lte other }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    infix fun KProperty<Number>.eq(other: Number): KProperty<Number> {
        rules.add {
            val value = this.call()
            runCatching { value eq other }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    infix fun KProperty<Number>.neq(other: Number): KProperty<Number> {
        rules.add {
            val value = this.call()
            runCatching { value neq other }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }
}


