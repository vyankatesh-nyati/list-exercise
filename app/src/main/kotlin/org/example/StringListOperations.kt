package org.example

fun Node<String>.convertToUppercase(): Node<String> = this.conditionalIterationAndOperationOnElement(
    list = this,
    operation = { value -> value.uppercase() }
)

fun Node<String>.convertToLowercase(): Node<String> = this.conditionalIterationAndOperationOnElement(
    list = this,
    operation = { value -> value.lowercase() }
)

fun Node<String>.getNumberOfCharacterLong(number: Int) = this.conditionalIterationAndOperationOnElement(
    list = this,
    condition = { value -> value.length == 3 },
    operation = { it }
)

fun Node<String>.getIntegerListWithStringLength() = this.conditionalIterationAndOperationOnElement(
    list = this,
    operation = { value -> value.length }
)