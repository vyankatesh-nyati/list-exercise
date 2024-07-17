package org.example

data class Node<T>(val value: T, var next: Node<T>? = null)
