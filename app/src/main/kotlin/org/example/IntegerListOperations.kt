package org.example

import org.example.Node.*
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow

fun Node<Int>.getSquareValues(): Node<Int> = conditionalIterationAndOperationOnElement(
    integerList = this,
    operation = { value -> value.toDouble().pow(2.0).toInt() }
)

fun Node<Int>.getCubeValues(): Node<Int> = conditionalIterationAndOperationOnElement(
    integerList = this,
    operation = { value -> value.toDouble().pow(3.0).toInt() }
)

fun Node<Int>.getOddValues(): Node<Int> = conditionalIterationAndOperationOnElement(
    integerList = this,
    condition = { value -> value % 2 != 0 },
)

fun Node<Int>.getEvenValues(): Node<Int> = conditionalIterationAndOperationOnElement(
    integerList = this,
    condition = { value -> value % 2 == 0 },
)

private fun conditionalIterationAndOperationOnElement(
    integerList: Node<Int>,
    condition: (Int) -> Boolean = { true },
    operation: (Int) -> Int = { it },
    result: Node<Int> = EmptyNode()
): Node<Int> = when (integerList) {
    is DataNode -> {
        if (condition(integerList.value)) conditionalIterationAndOperationOnElement(
            integerList.next,
            condition,
            operation,
            result.addLast(operation(integerList.value))
        )
        else conditionalIterationAndOperationOnElement(integerList.next, condition, operation, result)
    }

    is EmptyNode -> result
}

fun Node<Int>.getSumOfElements(): Int {
    return iterateAndCalculate(this, 0) { sum, nodeValue -> sum + nodeValue }
}

fun DataNode<Int>.getMaxValue(): Int = iterateAndCalculate(this, Int.MIN_VALUE) { maxValue, nodeValue ->
    max(maxValue, nodeValue)
}

fun DataNode<Int>.getMinValue(): Int = iterateAndCalculate(this, Int.MAX_VALUE) { minValue, nodeValue ->
    min(minValue, nodeValue)
}

private fun iterateAndCalculate(
    list: Node<Int>,
    accumulator: Int,
    operation: (Int, Int) -> Int
): Int = when(list) {
    is DataNode -> iterateAndCalculate(list.next, operation(accumulator, list.value) ,operation)
    is EmptyNode -> accumulator
}