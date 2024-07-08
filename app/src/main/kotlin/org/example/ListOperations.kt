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
            val cubeValues = IntegerList()

            var current = integerList.getHead()

            while (current != null) {
                cubeValues.addLast(current.value.toDouble().pow(power).toInt())
                current = current.next
            }

            return cubeValues
        }
    }
}
