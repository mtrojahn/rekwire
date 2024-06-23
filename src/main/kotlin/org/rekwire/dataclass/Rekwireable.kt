package org.rekwire.dataclass

import org.rekwire.endingWith
import org.rekwire.eq
import org.rekwire.exception.RekwireValidationException
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

/**
 * Base class for Rekwireable classes.
 */
abstract class Rekwireable {

    private val context = RekwireContext()

    protected fun rekwire(block: RekwireContext.() -> Unit) {
        context.block()
        context.validateAll()
    }

    protected fun <T> rekwireProperty(initialValue: T, block: RekwireContext.() -> Unit): RekwireProperty<T> {
        return RekwireProperty(initialValue, context, block)
    }
}

/**
 * Property delegate for Rekwireable classes.
 */

class RekwireProperty<T>(
    private var value: T,
    private val context: RekwireContext,
    block: RekwireContext.() -> Unit
) {

    init {
        context.apply {
            block()
        }
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, newValue: T) {
        value = newValue
        context.validate(property.name, value)
    }

}

/**
 * Context for Rekwireable classes.
 */
class RekwireContext {

    private val rules = mutableMapOf<String, MutableList<(Any?) -> Unit>>()
    private val errors = mutableListOf<String>()

    fun validate(propertyName: String, value: Any?) {
        rules[propertyName]?.forEach { it(value) }
        if (errors.isNotEmpty()) {
            throw RekwireValidationException(errors)
        }
    }

    fun validateAll() {
        rules.forEach { (_, propertyRules) ->
            propertyRules.forEach { rule ->
                rule(null)
            }
        }
        if (errors.isNotEmpty()) {
            throw RekwireValidationException(errors)
        }
    }

    private fun addRule(propertyName: String, rule: (Any?) -> Unit) {
        rules.computeIfAbsent(propertyName) { mutableListOf() }.add(rule)
    }

    /** STRINGS **/
    infix fun KProperty<String>.match(regex: String): KProperty<String> {
        addRule(this.name) {
            val value = this.call()
            runCatching { value match regex }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    infix fun KProperty<String>.minLen(min: Int): KProperty<String> {
        addRule(this.name) {
            val value = this.call()
            runCatching { value minLen min }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    infix fun KProperty<String>.maxLen(max: Int): KProperty<String> {
        addRule(this.name) {
            val value = this.call()
            runCatching { value maxLen max }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    infix fun KProperty<String>.eq(other: String): KProperty<String> {
        addRule(this.name) {
            val value = this.call()
            runCatching { value eq other }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    infix fun KProperty<String>.neq(other: String): KProperty<String> {
        addRule(this.name) {
            val value = this.call()
            runCatching { value neq other }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    infix fun KProperty<String>.includes(other: String): KProperty<String> {
        addRule(this.name) {
            val value = this.call()
            runCatching { value includes other }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    infix fun KProperty<String>.excludes(other: String): KProperty<String> {
        addRule(this.name) {
            val value = this.call()
            runCatching { value excludes other }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    infix fun KProperty<String>.startingWith(prefix: String): KProperty<String> {
        addRule(this.name) {
            val value = this.call()
            runCatching { value startingWith prefix }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    infix fun KProperty<String>.endingWith(suffix: String): KProperty<String> {
        addRule(this.name) {
            val value = this.call()
            runCatching { value endingWith suffix }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    /** NUMBERS **/

    infix fun KProperty<Number>.gt(other: Number): KProperty<Number> {
        addRule(this.name) {
            val value = this.call()
            runCatching { value gt other }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    infix fun KProperty<Number>.lt(other: Number): KProperty<Number> {
        addRule(this.name) {
            val value = this.call()
            runCatching { value lt other }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    infix fun KProperty<Number>.gte(other: Number): KProperty<Number> {
        addRule(this.name) {
            val value = this.call()
            runCatching { value gte other }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    infix fun KProperty<Number>.lte(other: Number): KProperty<Number> {
        addRule(this.name) {
            val value = this.call()
            runCatching { value lte other }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    infix fun KProperty<Number>.eq(other: Number): KProperty<Number> {
        addRule(this.name) {
            val value = this.call()
            runCatching { value eq other }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    infix fun KProperty<Number>.neq(other: Number): KProperty<Number> {
        addRule(this.name) {
            val value = this.call()
            runCatching { value neq other }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }
}


