package org.example

import org.example.Node.DataNode
import org.example.Node.EmptyNode

tailrec fun <T, R> Node<T>.fold(initial: R, operation: (acc: R, T) -> R): R = when (this) {
    is DataNode -> this.next.fold(operation(initial, this.value), operation)
    is EmptyNode -> initial
}

fun <T> Node<T>.reduce(operation: (acc: T, T) -> T): T = when (this) {
    is DataNode -> this.next.fold(this.value, operation)
    is EmptyNode -> throw Exception("Reduce can't be applied on the empty list")
}

fun <T, R> Node<T>.map(transform: (T) -> R): Node<R> = when (this) {
    is DataNode -> this.fold(EmptyNode<R>() as Node<R>) { acc, value -> acc.addLast(transform(value)) }
    is EmptyNode -> EmptyNode()
}

fun <T> Node<T>.filter(predicate: (T) -> Boolean): Node<T> = when (this) {
    is DataNode -> this.fold(EmptyNode<T>() as Node<T>) { acc, value -> if (predicate(value)) acc.addLast(value) else acc }
    is EmptyNode -> EmptyNode()
}

//Flat map
tailrec fun <T, R> Node<T>.conditionalIterationAndOperationOnElement(
    predicate: (T) -> Boolean = { true },
    transform: (T) -> R,
    result: Node<R> = EmptyNode()
): Node<R> = when (this) {
    is DataNode -> {
        if (predicate(this.value)) this.next.conditionalIterationAndOperationOnElement(
            predicate,
            transform,
            result.addLast(transform(this.value))
        )
        else this.next.conditionalIterationAndOperationOnElement(predicate, transform, result)
    }

    is EmptyNode -> result
}

fun <T, R> Node<T>.indexedFlatMap(
    predicate: (T, index: Int) -> Boolean = { _, _ -> true },
    operation: (T) -> R,
    result: Node<R> = EmptyNode()
): Node<R> {
    fun solve(
        list: Node<T>,
        index: Int,
        predicate: (T, index: Int) -> Boolean,
        operation: (T) -> R,
        result: Node<R>
    ): Node<R> = when (list) {
        is DataNode -> {
            if (predicate(list.value, index)) solve(
                list.next,
                index + 1,
                predicate,
                operation,
                result.addLast(operation(list.value))
            )
            else solve(list.next, index + 1, predicate, operation, result)
        }

        is EmptyNode -> result
    }

    return solve(this, 0, predicate, operation, result)
}

fun <T> Node<T>.drop(count: Int): Node<T> = this.indexedFlatMap(
    predicate = { _: T, index: Int -> index + 1 > count },
    operation = { it },
    result = EmptyNode()
)

fun <T> Node<T>.dropWhile(predicate: (T) -> Boolean): Node<T> = this.conditionalIterationAndOperationOnElement(
    predicate = predicate,
    transform = { it },
    result = EmptyNode()
)

fun <T> Node<T>.take(count: Int): Node<T> = TODO()

fun <T> Node<T>.takeWhile(predicate: (T) -> Boolean): Node<T> = TODO()

fun <T> Node<T>.exists(predicate: (T) -> Boolean): Boolean = TODO()

fun <T> Node<T>.forall(predicate: (T) -> Boolean): Boolean = TODO()
