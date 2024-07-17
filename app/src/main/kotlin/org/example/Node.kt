package org.example

sealed class Node<T> {

    data class EmptyNode<T>(val next: Nothing? = null) : Node<T>()

    data class DataNode<T>(val value: T, val next: Node<T>) : Node<T>()

    fun insert(i: T): Node<T> {
        return when (this) {
            is DataNode -> DataNode(value = this.value, next = this.next.insert(i))
            is EmptyNode -> DataNode(value = i, next = EmptyNode())
        }
    }
}

//data class EmptyNode<T>(val next: Nothing? = null) : Node<T>()
//
//data class DataNode<T>(val value: T, val next: Node<T>) : Node<T>()

//data class Node<T>(val value: T, var next: Node<T>? = null)
