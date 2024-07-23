package org.example

import org.example.Node.DataNode
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow

class IntegerListOperations {
    companion object {
        fun getSquareValues(list: Node<Int>): Node<Int> = list.map { it * it }

        fun getCubeValues(list: Node<Int>): Node<Int> = list.map { it * it * it }

        fun getOddValues(list: Node<Int>): Node<Int> = list.filter { it % 2 == 1 }

        fun getEvenValues(list: Node<Int>): Node<Int> = list.filter { it % 2 == 0 }

        fun getSumOfElements(list: Node<Int>): Int = list.reduce { acc, i -> acc + i }

        fun getMaxValue(list: DataNode<Int>): Int = list.reduce { acc, i -> max(acc, i) }

        fun getMinValue(list: DataNode<Int>): Int = list.reduce { acc, i -> min(acc, i) }
    }
}