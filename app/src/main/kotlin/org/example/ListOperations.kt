package org.example

import kotlin.math.pow

class ListOperations {
    companion object {
        fun getSquareValues(integerList: IntegerList): IntegerList {
            return conditionalIterationAndPerformOperation(
                integerList = integerList,
                operation = { value -> value.toDouble().pow(2.0).toInt() }
            )
        }

        fun getCubeValues(integerList: IntegerList): IntegerList {
            return conditionalIterationAndPerformOperation(
                integerList = integerList,
                operation = { value -> value.toDouble().pow(3.0).toInt() }
            )
        }


        fun getOddValues(integerList: IntegerList): IntegerList {
            return conditionalIterationAndPerformOperation(
                integerList = integerList,
                condition = { value -> value % 2 != 0 },
                operation = { value -> value }
            )
        }

        fun getEvenValues(integerList: IntegerList): IntegerList {
            return conditionalIterationAndPerformOperation(
                integerList = integerList,
                condition = { value -> value % 2 == 0 },
                operation = { value -> value }
            )
        }

        private fun conditionalIterationAndPerformOperation(
            integerList: IntegerList,
            condition: (Int) -> Boolean = { true },
            operation: (Int) -> Int
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
            var sum = 0
            var currentNode = integerList.getHead()

            while (currentNode != null) {
                sum += currentNode.value
                currentNode = currentNode.next
            }

            return sum
        }

        fun getMaxValue(integerList: IntegerList): Int? {
            if (integerList.getHead() == null) return null

            var max = Int.MIN_VALUE
            var currentNode = integerList.getHead()

            while (currentNode != null) {
                if (currentNode.value > max) max = currentNode.value
                currentNode = currentNode.next
            }

            return max
        }

        fun getMinValue(integerList: IntegerList): Int? {
            if (integerList.getHead() == null) return null

            var min = Int.MAX_VALUE
            var currentNode = integerList.getHead()

            while (currentNode != null) {
                if (currentNode.value < min) min = currentNode.value
                currentNode = currentNode.next
            }

            return min
        }
    }
}
