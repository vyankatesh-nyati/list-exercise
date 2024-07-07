package org.example

class IntegerList {
    private var head: IntegerNode? = null

    fun getHead(): IntegerNode? = head

    fun add(i: Int): Int {
        if (head == null) head = IntegerNode(i, next = null)
        return i
    }
}
