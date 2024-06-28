package org.rekwire.classes

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
 * Provides methods to define and validate properties with custom rules.
 */
abstract class Rekwireable {

    private val context = RekwireContext()

    /**
     * Defines and validates a set of rules for the properties of the class.
     * @param block Lambda with receiver of type RekwireContext. Defines the rules for the properties.
     */
    protected fun rekwire(block: RekwireContext.() -> Unit) {
        context.block()
        context.validateAll()
    }

    /**
     * Defines and validates a set of rules for a specific property of the class.
     * @param initialValue The initial value of the property.
     * @param block Lambda with receiver of type RekwireContext. Defines the rules for the property.
     * @return A RekwireProperty instance with the defined rules.
     */
    protected fun <T> rekwire(initialValue: T, block: RekwireContext.() -> Unit): RekwireProperty<T> {
        return RekwireProperty(initialValue, context, block)
    }
}

/**
 * Property delegate for Rekwireable classes.
 * Allows to define and validate rules for a specific property.
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

    /**
     * Gets the value of the property.
     * @param thisRef The object for which the value is requested.
     * @param property The metadata for the property.
     * @return The value of the property.
     */
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value
    }

    /**
     * Sets the value of the property and validates it against the defined rules.
     * @param thisRef The object for which the value is set.
     * @param property The metadata for the property.
     * @param newValue The new value for the property.
     */
    operator fun setValue(thisRef: Any?, property: KProperty<*>, newValue: T) {
        value = newValue
        context.validate(property.name, value)
    }

}

/**
 * Context for Rekwireable classes.
 * Allows to define and validate rules for the properties of a class.
 */
class RekwireContext {

    private val rules = mutableMapOf<String, MutableList<(Any?) -> Unit>>()
    private val errors = mutableListOf<String>()

    /**
     * Validates a specific property against the defined rules.
     * @param propertyName The name of the property.
     * @param value The value of the property.
     */
    fun validate(propertyName: String, value: Any?) {
        rules[propertyName]?.forEach { it(value) }
        if (errors.isNotEmpty()) {
            throw RekwireValidationException(errors)
        }
    }

    /**
     * Validates all properties against the defined rules.
     */
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

    // The following methods define rules for String and Number properties.
    // Each method adds a rule to the context and returns the property for chaining.
    // The rule is defined as a lambda that takes the value of the property and checks it against a condition.
    // If the condition is not met, an error message is added to the context.

    /* STRINGS */

    /**
     * Extension function for KProperty<String> to add a match rule.
     * The rule checks if the property's value matches the provided regular expression.
     * If the value does not match, an error message is added to the context.
     *
     * @param regex The regular expression to match the property's value against.
     * @return The property for chaining.
     */
    infix fun KProperty<String>.match(regex: String): KProperty<String> {
        addRule(this.name) {
            val value = this.call()
            runCatching { value match regex }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    /**
     * Extension function for KProperty<String> to add a minLen rule.
     * The rule checks if the property's value has a minimum length.
     * If the value does not meet the condition, an error message is added to the context.
     *
     * @param min The minimum length for the property's value.
     * @return The property for chaining.
     */
    infix fun KProperty<String>.minLen(min: Int): KProperty<String> {
        addRule(this.name) {
            val value = this.call()
            runCatching { value minLen min }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    /**
     * Extension function for KProperty<String> to add a maxLen rule.
     * The rule checks if the property's value has a maximum length.
     * If the value does not meet the condition, an error message is added to the context.
     *
     * @param max The maximum length for the property's value.
     * @return The property for chaining.
     */
    infix fun KProperty<String>.maxLen(max: Int): KProperty<String> {
        addRule(this.name) {
            val value = this.call()
            runCatching { value maxLen max }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    /**
     * Extension function for KProperty<String> to add an eq rule.
     * The rule checks if the property's value is equal to the provided string.
     * If the value is not equal, an error message is added to the context.
     *
     * @param other The string to compare the property's value to.
     * @return The property for chaining.
     */
    infix fun KProperty<String>.eq(other: String): KProperty<String> {
        addRule(this.name) {
            val value = this.call()
            runCatching { value eq other }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    /**
     * Extension function for KProperty<String> to add a neq rule.
     * The rule checks if the property's value is not equal to the provided string.
     * If the value is equal, an error message is added to the context.
     *
     * @param other The string to compare the property's value to.
     * @return The property for chaining.
     */
    infix fun KProperty<String>.neq(other: String): KProperty<String> {
        addRule(this.name) {
            val value = this.call()
            runCatching { value neq other }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    /**
     * Extension function for KProperty<String> to add an includes rule.
     * The rule checks if the property's value includes the provided string.
     * If the value does not include the string, an error message is added to the context.
     *
     * @param other The string to check if it is included in the property's value.
     * @return The property for chaining.
     */
    infix fun KProperty<String>.includes(other: String): KProperty<String> {
        addRule(this.name) {
            val value = this.call()
            runCatching { value includes other }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    /**
     * Extension function for KProperty<String> to add an excludes rule.
     * The rule checks if the property's value excludes the provided string.
     * If the value includes the string, an error message is added to the context.
     *
     * @param other The string to check if it is excluded from the property's value.
     * @return The property for chaining.
     */
    infix fun KProperty<String>.excludes(other: String): KProperty<String> {
        addRule(this.name) {
            val value = this.call()
            runCatching { value excludes other }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    /**
     * Extension function for KProperty<String> to add a startingWith rule.
     * The rule checks if the property's value starts with the provided prefix.
     * If the value does not start with the prefix, an error message is added to the context.
     *
     * @param prefix The prefix to check if it is at the beginning of the property's value.
     * @return The property for chaining.
     */
    infix fun KProperty<String>.startingWith(prefix: String): KProperty<String> {
        addRule(this.name) {
            val value = this.call()
            runCatching { value startingWith prefix }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    /**
     * Extension function for KProperty<String> to add an endingWith rule.
     * The rule checks if the property's value ends with the provided suffix.
     * If the value does not end with the suffix, an error message is added to the context.
     *
     * @param suffix The suffix to check if it is at the end of the property's value.
     * @return The property for chaining.
     */
    infix fun KProperty<String>.endingWith(suffix: String): KProperty<String> {
        addRule(this.name) {
            val value = this.call()
            runCatching { value endingWith suffix }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    /* NUMBERS */

    /**
     * Extension function for KProperty<Number> to add a 'greater than' rule.
     * The rule checks if the property's value is greater than the provided number.
     * If the value is not greater, an error message is added to the context.
     *
     * @param other The number to compare the property's value to.
     * @return The property for chaining.
     */
    infix fun KProperty<Number>.gt(other: Number): KProperty<Number> {
        addRule(this.name) {
            val value = this.call()
            runCatching { value gt other }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    /**
     * Extension function for KProperty<Number> to add a 'less than' rule.
     * The rule checks if the property's value is less than the provided number.
     * If the value is not less, an error message is added to the context.
     *
     * @param other The number to compare the property's value to.
     * @return The property for chaining.
     */
    infix fun KProperty<Number>.lt(other: Number): KProperty<Number> {
        addRule(this.name) {
            val value = this.call()
            runCatching { value lt other }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    /**
     * Extension function for KProperty<Number> to add a 'greater than or equal' rule.
     * The rule checks if the property's value is greater than or equal to the provided number.
     * If the value is not greater or equal, an error message is added to the context.
     *
     * @param other The number to compare the property's value to.
     * @return The property for chaining.
     */
    infix fun KProperty<Number>.gte(other: Number): KProperty<Number> {
        addRule(this.name) {
            val value = this.call()
            runCatching { value gte other }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    /**
     * Extension function for KProperty<Number> to add a 'less than or equal' rule.
     * The rule checks if the property's value is less than or equal to the provided number.
     * If the value is not less or equal, an error message is added to the context.
     *
     * @param other The number to compare the property's value to.
     * @return The property for chaining.
     */
    infix fun KProperty<Number>.lte(other: Number): KProperty<Number> {
        addRule(this.name) {
            val value = this.call()
            runCatching { value lte other }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    /**
     * Extension function for KProperty<Number> to add an eq rule.
     * The rule checks if the property's value is equal to the provided number.
     * If the value is not equal, an error message is added to the context.
     *
     * @param other The number to compare the property's value to.
     * @return The property for chaining.
     */
    infix fun KProperty<Number>.eq(other: Number): KProperty<Number> {
        addRule(this.name) {
            val value = this.call()
            runCatching { value eq other }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }

    /**
     * Extension function for KProperty<Number> to add a neq rule.
     * The rule checks if the property's value is not equal to the provided number.
     * If the value is equal, an error message is added to the context.
     *
     * @param other The number to compare the property's value to.
     * @return The property for chaining.
     */
    infix fun KProperty<Number>.neq(other: Number): KProperty<Number> {
        addRule(this.name) {
            val value = this.call()
            runCatching { value neq other }
                .onFailure { exception -> errors.add("Property '${this.name}': ${exception.message}") }
        }
        return this
    }
}


