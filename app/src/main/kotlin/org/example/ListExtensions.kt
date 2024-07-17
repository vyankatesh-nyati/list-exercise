package org.example

import org.example.Node.DataNode
import org.example.Node.EmptyNode

// reduce
fun <T> Node<T>.iterateAndCalculate(
    accumulator: T,
    operation: (T, T) -> T
): T = when (this) {
    is DataNode -> this.next.iterateAndCalculate(operation(accumulator, this.value), operation)
    is EmptyNode -> accumulator
}

//Flat map
fun <T, R> Node<T>.conditionalIterationAndOperationOnElement(
    condition: (T) -> Boolean = { true },
    operation: (T) -> R,
    result: Node<R> = EmptyNode()
): Node<R> = when (this) {
    is DataNode -> {
        if (condition(this.value)) this.next.conditionalIterationAndOperationOnElement(
            condition,
            operation,
            result.addLast(operation(this.value))
        )
        else this.next.conditionalIterationAndOperationOnElement(condition, operation, result)
    }

    is EmptyNode -> result
}