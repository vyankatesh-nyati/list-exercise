package org.example

sealed class Node<in T : Any> {

    data class EmptyNode(val next: Nothing? = null) : Node<Any>()

    data class DataNode<T : Any>(val value: T, val next: Node<T>) : Node<T>()

    fun addLast(i: T): Node<T> {
        return when (this) {
            is DataNode -> DataNode(value = this.value, next = this.next.addLast(i))
            is EmptyNode -> DataNode(value = i, next = EmptyNode())
        }
    }
}