package org.rekwire

import kotlin.test.Test

internal class StringsSuccessTest {
    @Test
    fun `should have minimal length`() {
        "" minLen 0
        "foo" minLen 0
        "foo" minLen 1
        "foo" minLen 2
        "foo" minLen 3
    }

    @Test
    fun `should have maximal length`() {
        "" maxLen 0
        "f" maxLen 3
        "fo" maxLen 3
        "foo" maxLen 3
    }

    @Test
    fun `should match regex`() {
        "" match ""
        "foo" match "foo"
        "foo" match "[fo]{3}"
        "foo9" match "[fo0-9]+"
    }

    @Test
    fun `should be equal to`() {
        "" eq ""
        "foo" eq "foo"
        "123" eq "123"
    }

    @Test
    fun `should be different from`() {
        "" neq "foo"
        "foo" neq "bar"
        "123" neq "456"
    }

    @Test
    fun `should include`() {
        "" includes ""
        "foo" includes "f"
        "foo" includes "o"
        "foo" includes "oo"
    }

    @Test
    fun `should not include`() {
        "" excludes "foo"
        "foo" excludes "bar"
        "foo" excludes "baz"
    }

    @Test
    fun `should start with`() {
        "" startingWith ""
        "foo" startingWith "f"
        "foo" startingWith "fo"
        "foo" startingWith "foo"
    }

    @Test
    fun `should end with`() {
        "" endingWith ""
        "foo" endingWith "o"
        "foo" endingWith "oo"
        "foo" endingWith "foo"
    }

}