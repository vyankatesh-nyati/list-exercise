package org.example

import org.example.Node.DataNode
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow

class IntegerListOperations {
    companion object {
        fun getSquareValues(list: Node<Int>): Node<Int> = list.conditionalIterationAndOperationOnElement(
            transform = { value -> value.toDouble().pow(2.0).toInt() }
        )

        fun getCubeValues(list: Node<Int>): Node<Int> = list.conditionalIterationAndOperationOnElement(
            transform = { value -> value.toDouble().pow(3.0).toInt() }
        )

        fun getOddValues(list: Node<Int>): Node<Int> = list.conditionalIterationAndOperationOnElement(
            predicate = { value -> value % 2 != 0 },
            transform = { it }
        )

        fun getEvenValues(list: Node<Int>): Node<Int> = list.conditionalIterationAndOperationOnElement(
            predicate = { value -> value % 2 == 0 },
            transform = { it }
        )

        fun getSumOfElements(list: Node<Int>): Int = list.iterateAndCalculate(0) { sum, nodeValue -> sum + nodeValue }

        fun getMaxValue(list: DataNode<Int>): Int = list.iterateAndCalculate(Int.MIN_VALUE) { maxValue, nodeValue ->
            max(maxValue, nodeValue)
        }

        fun getMinValue(list: DataNode<Int>): Int = list.iterateAndCalculate(Int.MAX_VALUE) { minValue, nodeValue ->
            min(minValue, nodeValue)
        }

    }
}