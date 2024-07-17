package org.example

import org.example.Node.*
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow

fun Node<Int>.getSquareValues(): Node<Int> = conditionalIterationAndOperationOnElement(
    list = this,
    operation = { value -> value.toDouble().pow(2.0).toInt() }
)

fun Node<Int>.getCubeValues(): Node<Int> = conditionalIterationAndOperationOnElement(
    list = this,
    operation = { value -> value.toDouble().pow(3.0).toInt() }
)

fun Node<Int>.getOddValues(): Node<Int> = conditionalIterationAndOperationOnElement(
    list = this,
    condition = { value -> value % 2 != 0 },
    operation = { it }
)

fun Node<Int>.getEvenValues(): Node<Int> = this.conditionalIterationAndOperationOnElement(
    list = this,
    condition = { value -> value % 2 == 0 },
    operation = { it }
)

fun Node<Int>.getSumOfElements(): Int {
    return iterateAndCalculate(this, 0) { sum, nodeValue -> sum + nodeValue }
}

fun DataNode<Int>.getMaxValue(): Int = iterateAndCalculate(this, Int.MIN_VALUE) { maxValue, nodeValue ->
    max(maxValue, nodeValue)
}

fun DataNode<Int>.getMinValue(): Int = iterateAndCalculate(this, Int.MAX_VALUE) { minValue, nodeValue ->
    min(minValue, nodeValue)
}
