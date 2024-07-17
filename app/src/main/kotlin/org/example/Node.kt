package org.example

sealed class Node<T> {

    data class EmptyNode<T>(val next: Nothing? = null) : Node<T>()

    data class DataNode<T>(val value: T, val next: Node<T>) : Node<T>()

    fun addLast(i: T): Node<T> {
        return when (this) {
            is DataNode -> DataNode(value = this.value, next = this.next.addLast(i))
            is EmptyNode -> DataNode(value = i, next = EmptyNode())
        }
    }

    // reduce
    fun iterateAndCalculate(
        list: Node<T>,
        accumulator: T,
        operation: (T, T) -> T
    ): T = when (list) {
        is DataNode -> iterateAndCalculate(list.next, operation(accumulator, list.value), operation)
        is EmptyNode -> accumulator
    }

    //Flat map
    fun <T, R> conditionalIterationAndOperationOnElement(
        list: Node<T>,
        condition: (T) -> Boolean = { true },
        operation: (T) -> R,
        result: Node<R> = EmptyNode()
    ): Node<R> = when (list) {
        is DataNode -> {
            if (condition(list.value)) conditionalIterationAndOperationOnElement<T, R>(
                list.next,
                condition,
                operation,
                result.addLast(operation(list.value))
            )
            else conditionalIterationAndOperationOnElement<T, R>(list.next, condition, operation, result)
        }

        is EmptyNode -> result
    }
}
