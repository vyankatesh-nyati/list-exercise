package org.example

import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow

class ListOperations {
    companion object {
        fun getSquareValues(integerList: IntegerList): IntegerList {
            return conditionalIterationAndOperationOnElement(
                integerList = integerList,
                operation = { value -> value.toDouble().pow(2.0).toInt() }
            )
        }

        fun getCubeValues(integerList: IntegerList): IntegerList {
            return conditionalIterationAndOperationOnElement(
                integerList = integerList,
                operation = { value -> value.toDouble().pow(3.0).toInt() }
            )
        }


        fun getOddValues(integerList: IntegerList): IntegerList {
            return conditionalIterationAndOperationOnElement(
                integerList = integerList,
                condition = { value -> value % 2 != 0 },
            )
        }

        fun getEvenValues(integerList: IntegerList): IntegerList {
            return conditionalIterationAndOperationOnElement(
                integerList = integerList,
                condition = { value -> value % 2 == 0 },
            )
        }

        private fun conditionalIterationAndOperationOnElement(
            integerList: IntegerList,
            condition: (Int) -> Boolean = { true },
            operation: (Int) -> Int = { it }
        ): IntegerList {
            val list = IntegerList()

            var currentNode = integerList.getHead()

            while (currentNode != null) {
                val value = currentNode.value
                if (condition(value)) list.addLast(operation(value))
                currentNode = currentNode.next
            }

            return list
        }

        fun getSumOfElements(integerList: IntegerList): Int {
            return iterateAndCalculate(integerList, 0) { sum, nodeValue -> sum + nodeValue }
        }

        fun getMaxValue(integerList: IntegerList): Int? {
            if (integerList.getHead() == null) return null

            return iterateAndCalculate(integerList, Int.MIN_VALUE) { maxValue, nodeValue ->
                max(maxValue, nodeValue)
            }
        }

        fun getMinValue(integerList: IntegerList): Int? {
            if (integerList.getHead() == null) return null

            return iterateAndCalculate(integerList, Int.MAX_VALUE) { minValue, nodeValue ->
                min(minValue, nodeValue)
            }
        }

        private fun iterateAndCalculate(
            integerList: IntegerList,
            initialValue: Int,
            operation: (Int, Int) -> Int
        ): Int {
            var cal = initialValue
            var currentNode = integerList.getHead()

            while (currentNode != null) {
                cal = operation(cal, currentNode.value)
                currentNode = currentNode.next
            }

            return cal
        }
    }
}
