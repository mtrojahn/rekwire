package org.rekwire.properties

import org.rekwire.base.gt
import org.rekwire.base.gte
import org.rekwire.base.lt
import org.rekwire.base.lte
import kotlin.reflect.KProperty

internal interface NumberValidations {
    infix fun KProperty<Number>.gt(other: Number): KProperty<Number> {
        this.call().gt(other, "Property '$name' should be greater than $other")
        return this
    }

    infix fun KProperty<Number>.lt(other: Number): KProperty<Number> {
        this.call().lt(other, "Property '$name' should be lower than $other")
        return this
    }

    infix fun KProperty<Number>.gte(other: Number): KProperty<Number> {
        this.call().gte(other, "Property '$name' should be greater or equal to $other")
        return this
    }

    infix fun KProperty<Number>.lte(other: Number): KProperty<Number> {
        this.call().lte(other, "Property '$name' should be lower or equal to $other")
        return this
    }
}