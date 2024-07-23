package org.example

import org.example.IntegerListOperations.Companion.getSumOfElements

class StringListOperations {
    companion object {
        fun convertToUppercase(list: Node<String>): Node<String> = list.map { it.uppercase() }

        fun convertToLowercase(list: Node<String>): Node<String> = list.map { it.lowercase() }

        fun getNumberOfCharacterLong(list: Node<String>, number: Int) = list.filter { it.length == number }

        fun getIntegerListWithStringLength(list: Node<String>) = list.map { it.length }

        fun getSumValueOfStringLength(list: Node<String>): Int = list.fold(0) { acc, s -> acc + s.length }

        fun getStringByConcatenating(list: Node<String>, seperator: String): String =
            list.reduce { acc, s -> acc + seperator + s }

        fun getStringByConcatenatingFirstCharacter(list: Node<String>): String =
            list.fold("") { acc, s -> acc + s.first() }

    }
}