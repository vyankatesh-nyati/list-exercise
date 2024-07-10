package org.example

import kotlin.math.pow

class ListOperations {
    companion object {
        fun getSquareValues(integerList: IntegerList): IntegerList {
            return conditionalIterationAndPerformOperation(
                integerList = integerList,
                condition = { true },
                operation = { value -> value.toDouble().pow(2.0).toInt() }
            )
        }

        fun getCubeValues(integerList: IntegerList): IntegerList {
            return conditionalIterationAndPerformOperation(
                integerList = integerList,
                condition = { true },
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
            condition: (Int) -> Boolean,
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
    }
}
