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
    condition = { value -> value.length == number },
    operation = { it }
)

fun Node<String>.getIntegerListWithStringLength() = this.conditionalIterationAndOperationOnElement(
    list = this,
    operation = { value -> value.length }
)

fun Node<String>.getSumValueOfStringLength(): Int = this.getIntegerListWithStringLength().getSumOfElements()

fun Node<String>.getStringByConcatenating(seperator: String): String =
    this.iterateAndCalculate(list = this, accumulator = "") { prevValue, nodeValue ->
        if (prevValue != "") prevValue + seperator + nodeValue else nodeValue
    }

fun Node<String>.getStringByConcatenatingFirstCharacter(): String =
    this.iterateAndCalculate(list = this, accumulator = "") { prev, curr ->
        prev + curr.first()
    }
