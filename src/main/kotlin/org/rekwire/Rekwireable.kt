package org.rekwire

import kotlin.reflect.KProperty
import org.rekwire.base.gt
import org.rekwire.base.gte
import org.rekwire.base.lt
import org.rekwire.base.lte
import org.rekwire.base.match
import org.rekwire.base.maxLen
import org.rekwire.base.minLen

abstract class Rekwireable {
    private val errors = mutableListOf<String>()

    fun hasErrors(): Boolean = errors.isNotEmpty()
    fun getErrors(): List<String> = errors
    fun getFormattedErrors(): String = "Validation errors:\n\t${errors.joinToString("\n\t")}"

    /** STRINGS **/
    infix fun KProperty<String>.match(regex: String): KProperty<String> {
        try {
            this.call().match(regex, "Property '$name' should match '$regex'")
        } catch (e: IllegalArgumentException) {
            errors.add(e.message!!)
        }
        return this
    }

    infix fun KProperty<String>.minLen(min: Int): KProperty<String> {
        try {
            this.call().minLen(min, "Length of '${this.name}' should be at least $min")
        } catch (e: IllegalArgumentException) {
            errors.add(e.message!!)
        }
        return this
    }

    infix fun KProperty<String>.maxLen(max: Int): KProperty<String> {
        try {
            this.call().maxLen(max, "Length of '${this.name}' should be at most $max")
        } catch (e: IllegalArgumentException) {
            errors.add(e.message!!)
        }
        return this
    }

    /** NUMBERS **/
    infix fun KProperty<Number>.gt(other: Number): KProperty<Number> {
        try {
            this.call().gt(other, "Property '$name' should be greater than $other")
        } catch (e: IllegalArgumentException) {
            errors.add(e.message!!)
        }
        return this
    }

    infix fun KProperty<Number>.lt(other: Number): KProperty<Number> {
        try {
            this.call().lt(other, "Property '$name' should be lower than $other")
        } catch (e: IllegalArgumentException) {
            errors.add(e.message!!)
        }
        return this
    }

    infix fun KProperty<Number>.gte(other: Number): KProperty<Number> {
        try {
            this.call().gte(other, "Property '$name' should be greater or equal to $other")
        } catch (e: IllegalArgumentException) {
            errors.add(e.message!!)
        }
        return this
    }

    infix fun KProperty<Number>.lte(other: Number): KProperty<Number> {
        try {
            this.call().lte(other, "Property '$name' should be lower or equal to $other")
        } catch (e: IllegalArgumentException) {
            errors.add(e.message!!)
        }
        return this
    }
}


