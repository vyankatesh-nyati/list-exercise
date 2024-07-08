package org.example

class ListOperations {
    companion object {
        fun getSquareValues(integerList: IntegerList): IntegerList {
            val squareValues = IntegerList()

            var current = integerList.getHead()

            while (current != null) {
                squareValues.addLast(current.value * current.value)
                current = current.next
            }

            return squareValues
        }
    }
}
