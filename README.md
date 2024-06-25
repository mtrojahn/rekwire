# Rekwire - A validation/assert library for Kotlin

## Description
Rekwire is a tool for Kotlin developers that makes it easy to check and enforce rules on data. It can help creating
a set of validation rules that can be checked during a dataclass instantiation or during a setter call. When used with
dataclasses, it also provides a full report of all the validation errors that occurred during the instantiation, which
is useful for ETL processes.

## Installation
Steps to install the project.

## Usage (dataclass)
When used with dataclasses, Rekwire will validate the dataclass properties during instantiation. If any of the rules
fail, an exception will be thrown with a detailed report of all the validation errors.
```kotlin

data class Person(val name: String, val age: Int): Rekwireable() {
    init {
        rekwire {
            ::name minLen 5 maxLen 100
            ::name match "^[a-zA-Z]+ [a-zA-Z]+$"
            ::age gte 18 lte 100
        }
    }
}

val person = Person("John Doe", 18) // No exception thrown
val personFail = Person("Bob", 11)  // Exception thrown

/*
Example of Exception output:

Rekwire Validation Failed
  - Property 'name': 'Bob' should be at least 5 characters long.
  - Property 'name': 'Bob' should match '^[a-zA-Z]+ [a-zA-Z]+$'.
  - Property 'age': 11 should be greater than or equal to 18.
*/
```

## Usage (delegated properties)
You can also use Rekwire with delegated properties. In this case, the validation rules will be checked during the setter
call. If any of the rules fail, an exception will be thrown with a report of the first validation error that occurred.

```kotlin
class Person: Rekwireable() {
    var name: String by rekwireProperty("") {
        ::name minLen 5 maxLen 100
        ::name match "^[a-zA-Z]+ [a-zA-Z]+$"
    }
    var age: Int by rekwireProperty(0) {
        ::age gte 18 lte 100
    }
}
val person = Person().apply { 
    name = "John Doe"
    age = 18
} // No exception thrown

val personFail = Person().apply {
    name = "Bob"
    age = 11
} // Exception thrown

/*
Example of Exception output:

Rekwire Validation Failed
  - Property 'name': 'Bob' should be at least 5 characters long.
*/

```

## Contributing
Guidelines for contributing to the project.

## License
Licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
