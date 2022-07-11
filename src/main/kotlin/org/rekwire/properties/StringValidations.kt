package org.rekwire.properties

import org.rekwire.base.match
import org.rekwire.base.maxLen
import org.rekwire.base.minLen
import kotlin.reflect.KProperty

internal interface StringValidations {
    infix fun KProperty<String>.match(regex: String): KProperty<String> {
        this.call().match(regex, "Property '$name' should match '$regex'")
        return this
    }

    infix fun KProperty<String>.minLen(min: Int): KProperty<String> {
        this.call().minLen(min, "Length of '${this.name}' should be at least $min")
        return this
    }

    infix fun KProperty<String>.maxLen(max: Int): KProperty<String> {
        this.call().maxLen(max, "Length of '${this.name}' should be at most $max")
        return this
    }
}