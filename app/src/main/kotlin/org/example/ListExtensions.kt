package org.example

import org.example.Node.DataNode
import org.example.Node.EmptyNode

tailrec fun <T, R> Node<T>.fold(initial: R, operation: (acc: R, T) -> R): R = when (this) {
    is DataNode -> this.next.fold(operation(initial, this.value), operation)
    is EmptyNode -> initial
}

fun <T, R> Node<T>.foldIndexed(initial: R, operation: (index: Int, acc: R, T) -> R): R {
    tailrec fun listFoldIndexed(list: Node<T>, index: Int, initial: R, operation: (index: Int, acc: R, T) -> R): R =
        when (list) {
            is DataNode -> listFoldIndexed(list.next, index + 1, operation(index, initial, list.value), operation)
            is EmptyNode -> initial
        }

    return listFoldIndexed(this, 0, initial, operation)
}

fun <T> Node<T>.reduce(operation: (acc: T, T) -> T): T = when (this) {
    is DataNode -> this.next.fold(this.value, operation)
    is EmptyNode -> throw Exception("Reduce can't be applied on the empty list")
}

fun <T, R> Node<T>.map(transform: (T) -> R): Node<R> =
    this.fold(EmptyNode<R>() as Node<R>) { acc, value -> acc.addLast(transform(value)) }

fun <T> Node<T>.filter(predicate: (T) -> Boolean): Node<T> =
    this.fold(EmptyNode<T>() as Node<T>) { acc, value -> if (predicate(value)) acc.addLast(value) else acc }

fun <T> Node<T>.drop(count: Int): Node<T> =
    this.foldIndexed(EmptyNode<T>() as Node<T>) { index, acc, value -> if (index >= count) acc.addLast(value) else acc }

fun <T> Node<T>.dropWhile(predicate: (T) -> Boolean): Node<T> =
    this.fold(EmptyNode<T>() as Node<T>) { acc, value ->
        if (acc !is EmptyNode<T> || !predicate(value)) acc.addLast(value) else acc
    }

fun <T> Node<T>.take(count: Int): Node<T> =
    this.foldIndexed(EmptyNode<T>() as Node<T>) { index, acc, value -> if (index < count) acc.addLast(value) else acc }

fun <T> Node<T>.takeWhile(predicate: (T) -> Boolean): Node<T> = TODO()

fun <T> Node<T>.exists(predicate: (T) -> Boolean): Boolean = TODO()

fun <T> Node<T>.forall(predicate: (T) -> Boolean): Boolean = TODO()
