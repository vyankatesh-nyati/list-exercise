package org.example

import org.example.IntegerListOperations.Companion.getSumOfElements

class StringListOperations {
    companion object {
        fun convertToUppercase(list: Node<String>): Node<String> = list.conditionalIterationAndOperationOnElement(
            transform = { value -> value.uppercase() }
        )

        fun convertToLowercase(list: Node<String>): Node<String> = list.conditionalIterationAndOperationOnElement(
            transform = { value -> value.lowercase() }
        )

        fun getNumberOfCharacterLong(list: Node<String>, number: Int) = list.conditionalIterationAndOperationOnElement(
            predicate = { value -> value.length == number },
            transform = { it }
        )

        fun getIntegerListWithStringLength(list: Node<String>) = list.conditionalIterationAndOperationOnElement(
            transform = { value -> value.length }
        )

        fun getSumValueOfStringLength(list: Node<String>): Int = getSumOfElements(getIntegerListWithStringLength(list))

        fun getStringByConcatenating(list: Node<String>, seperator: String): String =
            list.reduce { acc, s -> acc + seperator + s }

        fun getStringByConcatenatingFirstCharacter(list: Node<String>): String =
            list.fold("") { acc, s -> acc + s.first() }

    }
}