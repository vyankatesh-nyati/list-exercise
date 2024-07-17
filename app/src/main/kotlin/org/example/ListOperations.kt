//package org.example
//
//import org.example.Node.*
//import kotlin.math.max
//import kotlin.math.min
//import kotlin.math.pow
//
//fun Node<Int>.getSquareValues(): Node<Int> = conditionalIterationAndOperationOnElement(
//    integerList = this,
//    operation = { value -> value.toDouble().pow(2.0).toInt() }
//)
//
//fun Node<Int>.getCubeValues(): Node<Int> = conditionalIterationAndOperationOnElement(
//    integerList = this,
//    operation = { value -> value.toDouble().pow(3.0).toInt() }
//)
//
//fun Node<Int>.getOddValues(): CustomList<Int> = conditionalIterationAndOperationOnElement(
//    integerList = this,
//    condition = { value -> value % 2 != 0 },
//)
//
//fun Node<Int>.getEvenValues(): Node<Int> = conditionalIterationAndOperationOnElement(
//    integerList = this,
//    condition = { value -> value % 2 == 0 },
//)
//
//private fun conditionalIterationAndOperationOnElement(
//    integerList: Node<Int>,
//    condition: (Int) -> Boolean = { true },
//    operation: (Int) -> Int = { it }
//): Node<Int> {
//    val list = EmptyNode<Int>()
//
//    var currentNode = integerList.getHead()
//
//    while (currentNode != null) {
//        val value = currentNode.value
//        if (condition(value)) list.addLast(operation(value))
//        currentNode = currentNode.next
//    }
//
//    return list
//}
//
//fun Node<Int>.getSumOfElements(): Int {
//    return iterateAndCalculate(this, 0) { sum, nodeValue -> sum + nodeValue }
//}
//
//fun Node<Int>.getMaxValue(): Int? {
//    if (this.getHead() == null) return null
//
//    return iterateAndCalculate(this, Int.MIN_VALUE) { maxValue, nodeValue ->
//        max(maxValue, nodeValue)
//    }
//}
//
//fun Node<Int>.getMinValue(): Int? {
//    if (this.getHead() == null) return null
//
//    return iterateAndCalculate(this, Int.MAX_VALUE) { minValue, nodeValue ->
//        min(minValue, nodeValue)
//    }
//}
//
//private fun iterateAndCalculate(
//    list: Node<Int>,
//    initialValue: Int,
//    operation: (Int, Int) -> Int
//): Int {
//    var cal = initialValue
//    var currentNode = list.getHead()
//
//    while (currentNode != null) {
//        cal = operation(cal, currentNode.value)
//        currentNode = currentNode.next
//    }
//
//    return cal
//}