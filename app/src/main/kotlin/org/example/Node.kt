package org.example

import org.example.Node.DataNode
import org.example.Node.EmptyNode

sealed class Node<T> {

    data class EmptyNode<T>(val next: Nothing? = null) : Node<T>()

    data class DataNode<T>(val value: T, val next: Node<T>) : Node<T>()

    fun addLast(i: T): Node<T> {
        return when (this) {
            is DataNode -> DataNode(value = this.value, next = this.next.addLast(i))
            is EmptyNode -> DataNode(value = i, next = EmptyNode())
        }
    }
}