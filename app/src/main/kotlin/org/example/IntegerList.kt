package org.example

class IntegerList {
    private var head: IntegerNode? = null

    fun getHead(): IntegerNode? = head

    fun addLast(i: Int): Int {
        val integerNode = IntegerNode(i, next = null)

        if (head == null) {
            head = integerNode
            return i
        }

        var current = head
        while (current?.next != null) {
            current = current.next
        }
        current?.next = integerNode

        return i
    }
}
