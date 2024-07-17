package org.example

import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow

class ListOperations {
    companion object {
        fun getSquareValues(list: List<Int>): List<Int> = conditionalIterationAndOperationOnElement(
            integerList = list,
            operation = { value -> value.toDouble().pow(2.0).toInt() }
        )

        fun getCubeValues(list: List<Int>): List<Int> = conditionalIterationAndOperationOnElement(
            integerList = list,
            operation = { value -> value.toDouble().pow(3.0).toInt() }
        )


        fun getOddValues(list: List<Int>): List<Int> = conditionalIterationAndOperationOnElement(
            integerList = list,
            condition = { value -> value % 2 != 0 },
        )

        fun getEvenValues(list: List<Int>): List<Int> = conditionalIterationAndOperationOnElement(
            integerList = list,
            condition = { value -> value % 2 == 0 },
        )

        private fun conditionalIterationAndOperationOnElement(
            integerList: List<Int>,
            condition: (Int) -> Boolean = { true },
            operation: (Int) -> Int = { it }
        ): List<Int> {
            val list = List<Int>()

            var currentNode = integerList.getHead()

            while (currentNode != null) {
                val value = currentNode.value
                if (condition(value)) list.addLast(operation(value))
                currentNode = currentNode.next
            }

            return list
        }

        fun getSumOfElements(list: List<Int>): Int {
            return iterateAndCalculate(list, 0) { sum, nodeValue -> sum + nodeValue }
        }

        fun getMaxValue(list: List<Int>): Int? {
            if (list.getHead() == null) return null

            return iterateAndCalculate(list, Int.MIN_VALUE) { maxValue, nodeValue ->
                max(maxValue, nodeValue)
            }
        }

        fun getMinValue(list: List<Int>): Int? {
            if (list.getHead() == null) return null

            return iterateAndCalculate(list, Int.MAX_VALUE) { minValue, nodeValue ->
                min(minValue, nodeValue)
            }
        }

        private fun iterateAndCalculate(
            list: List<Int>,
            initialValue: Int,
            operation: (Int, Int) -> Int
        ): Int {
            var cal = initialValue
            var currentNode = list.getHead()

            while (currentNode != null) {
                cal = operation(cal, currentNode.value)
                currentNode = currentNode.next
            }

            return cal
        }
    }
}
