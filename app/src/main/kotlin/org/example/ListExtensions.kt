package org.example

import org.example.Node.DataNode
import org.example.Node.EmptyNode

tailrec fun <T : Any, R> Node<T>.foldRight(initial: R, operation: (acc: R, T) -> R): R = when (this) {
    is DataNode -> this.next.foldRight(operation(initial, this.value), operation)
    is EmptyNode -> initial
}

fun <T : Any, R> Node<T>.foldLeft(initial: R, operation: (acc: R, T) -> R): R = when (this) {
    is DataNode -> operation(this.next.foldLeft(initial, operation), this.value)
    is EmptyNode -> initial
}

fun <T : Any, R> Node<T>.foldIndexed(initial: R, operation: (index: Int, acc: R, T) -> R): R {
    tailrec fun listFoldIndexed(list: Node<T>, index: Int, initial: R, operation: (index: Int, acc: R, T) -> R): R =
        when (list) {
            is DataNode -> listFoldIndexed(list.next, index + 1, operation(index, initial, list.value), operation)
            is EmptyNode -> initial
        }

    return listFoldIndexed(this, 0, initial, operation)
}

fun <T : Any> Node<T>.reduce(operation: (acc: T, T) -> T): T = when (this) {
    is DataNode -> this.next.foldRight(this.value, operation)
    is EmptyNode -> throw Exception("Reduce can't be applied on the empty list")
}

fun <T : Any, R : Any> Node<T>.map(transform: (T) -> R): Node<R> =
    this.foldRight(EmptyNode() as Node<R>) { acc, value -> acc.addLast(transform(value)) }

fun <T : Any> Node<T>.filter(predicate: (T) -> Boolean): Node<T> =
    this.foldRight(EmptyNode() as Node<T>) { acc, value -> if (predicate(value)) acc.addLast(value) else acc }

fun <T : Any> Node<T>.drop(count: Int): Node<T> =
    this.foldIndexed(EmptyNode() as Node<T>) { index, acc, value -> if (index >= count) acc.addLast(value) else acc }

fun <T : Any> Node<T>.dropWhile(predicate: (T) -> Boolean): Node<T> =
    this.foldRight(EmptyNode() as Node<T>) { acc, value ->
        if (acc !is EmptyNode || !predicate(value)) acc.addLast(value) else acc
    }

fun <T : Any> Node<T>.take(count: Int): Node<T> =
    this.foldIndexed(EmptyNode() as Node<T>) { index, acc, value -> if (index < count) acc.addLast(value) else acc }


fun <T : Any> Node<T>.exists(predicate: (T) -> Boolean): Boolean =
    this.foldRight(false) { acc, value -> if (predicate(value)) true else acc }

fun <T : Any> Node<T>.forall(predicate: (T) -> Boolean): Boolean = TODO()
fun <T : Any> Node<T>.takeWhile(predicate: (T) -> Boolean): Node<T> = TODO()

