package org.example

import kotlin.math.pow

class ListOperations {
    companion object {
        fun getSquareValues(integerList: IntegerList): IntegerList {
            return getListWithPoweredValues(integerList, 2.0)
        }

        fun getCubeValues(integerList: IntegerList): IntegerList {
            return getListWithPoweredValues(integerList, 3.0)
        }


        fun getOddValues(integerList: IntegerList): IntegerList {
            return conditionalIterationOnList(integerList) { value -> value % 2 != 0 }
        }

        fun getEvenValues(integerList: IntegerList): IntegerList {
            return conditionalIterationOnList(integerList) { value -> value % 2 == 0 }
        }

        private fun getListWithPoweredValues(integerList: IntegerList, power: Double): IntegerList {
            val poweredValues = IntegerList()

            var current = integerList.getHead()

            while (current != null) {
                poweredValues.addLast(current.value.toDouble().pow(power).toInt())
                current = current.next
            }

            return poweredValues
        }

        private fun conditionalIterationOnList(integerList: IntegerList, condition: (Int) -> Boolean): IntegerList {
            val oddValues = IntegerList()

            var currentNode = integerList.getHead()

            while (currentNode != null) {
                val value = currentNode.value
                if (condition(value)) oddValues.addLast(value)
                currentNode = currentNode.next
            }

            return oddValues
        }
    }
}
