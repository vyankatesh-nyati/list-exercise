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

        private fun getListWithPoweredValues(integerList: IntegerList, power: Double): IntegerList {
            val poweredValues = IntegerList()

            var current = integerList.getHead()

            while (current != null) {
                poweredValues.addLast(current.value.toDouble().pow(power).toInt())
                current = current.next
            }

            return poweredValues
        }

        fun getOddValues(integerList: IntegerList): IntegerList {
            val oddValues = IntegerList()

            var currentNode = integerList.getHead()

            while (currentNode != null) {
                val value = currentNode.value
                if (value % 2 != 0) oddValues.addLast(value)
                currentNode = currentNode.next
            }

            return oddValues
        }

        fun getEvenValues(integerList: IntegerList): IntegerList {
            val evenValues = IntegerList()

            var currentNode = integerList.getHead()

            while (currentNode != null) {
                val value = currentNode.value
                if (value % 2 == 0) evenValues.addLast(value)
                currentNode = currentNode.next
            }

            return evenValues
        }
    }
}
