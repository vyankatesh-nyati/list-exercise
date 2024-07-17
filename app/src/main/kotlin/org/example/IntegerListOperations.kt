package org.example

import org.example.Node.*
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow

fun Node<Int>.getSquareValues(): Node<Int> = this.conditionalIterationAndOperationOnElement(
    operation = { value -> value.toDouble().pow(2.0).toInt() }
)

fun Node<Int>.getCubeValues(): Node<Int> = this.conditionalIterationAndOperationOnElement(
    operation = { value -> value.toDouble().pow(3.0).toInt() }
)

fun Node<Int>.getOddValues(): Node<Int> = this.conditionalIterationAndOperationOnElement(
    condition = { value -> value % 2 != 0 },
    operation = { it }
)

fun Node<Int>.getEvenValues(): Node<Int> = this.conditionalIterationAndOperationOnElement(
    condition = { value -> value % 2 == 0 },
    operation = { it }
)

fun Node<Int>.getSumOfElements(): Int = this.iterateAndCalculate(0) { sum, nodeValue -> sum + nodeValue }

fun DataNode<Int>.getMaxValue(): Int = this.iterateAndCalculate(Int.MIN_VALUE) { maxValue, nodeValue ->
    max(maxValue, nodeValue)
}

fun DataNode<Int>.getMinValue(): Int = this.iterateAndCalculate(Int.MAX_VALUE) { minValue, nodeValue ->
    min(minValue, nodeValue)
}
