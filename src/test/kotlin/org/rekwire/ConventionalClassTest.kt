package org.rekwire

import org.rekwire.dataclass.Rekwireable
import kotlin.test.Test

class ConventionalClassTest {
    class Person: Rekwireable() {
        var name: String = ""
        var age: Int = 0

//        init {
//            rekwire {
//                ::name includes "Foo"
//                ::age eq 10
//            }
//        }
    }

    @Test
    fun `should pass`() {
        Person().apply {
            name = "Foo"
            age = 10
        }
    }
}