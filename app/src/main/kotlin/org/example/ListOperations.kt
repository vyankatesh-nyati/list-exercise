package org.example

import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow

fun CustomList<Int>.getSquareValues(): CustomList<Int> = conditionalIterationAndOperationOnElement(
    integerList = this,
    operation = { value -> value.toDouble().pow(2.0).toInt() }
)

fun CustomList<Int>.getCubeValues(): CustomList<Int> = conditionalIterationAndOperationOnElement(
    integerList = this,
    operation = { value -> value.toDouble().pow(3.0).toInt() }
)

fun CustomList<Int>.getOddValues(): CustomList<Int> = conditionalIterationAndOperationOnElement(
    integerList = this,
    condition = { value -> value % 2 != 0 },
)

fun CustomList<Int>.getEvenValues(): CustomList<Int> = conditionalIterationAndOperationOnElement(
    integerList = this,
    condition = { value -> value % 2 == 0 },
)

private fun conditionalIterationAndOperationOnElement(
    integerList: CustomList<Int>,
    condition: (Int) -> Boolean = { true },
    operation: (Int) -> Int = { it }
): CustomList<Int> {
    val list = CustomList<Int>()

    var currentNode = integerList.getHead()

    while (currentNode != null) {
        val value = currentNode.value
        if (condition(value)) list.addLast(operation(value))
        currentNode = currentNode.next
    }

    return list
}

fun CustomList<Int>.getSumOfElements(): Int {
    return iterateAndCalculate(this, 0) { sum, nodeValue -> sum + nodeValue }
}

fun CustomList<Int>.getMaxValue(): Int? {
    if (this.getHead() == null) return null

    return iterateAndCalculate(this, Int.MIN_VALUE) { maxValue, nodeValue ->
        max(maxValue, nodeValue)
    }
}

fun CustomList<Int>.getMinValue(): Int? {
    if (this.getHead() == null) return null

    return iterateAndCalculate(this, Int.MAX_VALUE) { minValue, nodeValue ->
        min(minValue, nodeValue)
    }
}

private fun iterateAndCalculate(
    list: CustomList<Int>,
    initialValue: Int,
    operation: (Int, Int) -> Int
): Int {
    var cal = initialValue
    var currentNode = list.getHead()

    while (currentNode != null) {
        cal = operation(cal, currentNode.value)
        currentNode = currentNode.next
    }

    return cal
}