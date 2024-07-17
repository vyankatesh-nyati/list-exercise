package org.example

class StringListOperations {
    companion object {
        fun convertToUppercase(list: Node<String>): Node<String> = list.conditionalIterationAndOperationOnElement(
            operation = { value -> value.uppercase() }
        )

        fun convertToLowercase(list: Node<String>): Node<String> = list.conditionalIterationAndOperationOnElement(
            operation = { value -> value.lowercase() }
        )

        fun getNumberOfCharacterLong(list: Node<String>, number: Int) = list.conditionalIterationAndOperationOnElement(
            condition = { value -> value.length == number },
            operation = { it }
        )

        fun getIntegerListWithStringLength(list: Node<String>) = list.conditionalIterationAndOperationOnElement(
            operation = { value -> value.length }
        )

        fun getSumValueOfStringLength(list: Node<String>): Int = getIntegerListWithStringLength(list).getSumOfElements()

        fun getStringByConcatenating(list: Node<String>, seperator: String): String =
            list.iterateAndCalculate(accumulator = "") { prevValue, nodeValue ->
                if (prevValue != "") prevValue + seperator + nodeValue else nodeValue
            }

        fun getStringByConcatenatingFirstCharacter(list: Node<String>): String =
            list.iterateAndCalculate(accumulator = "") { prev, curr ->
                prev + curr.first()
            }

    }
}