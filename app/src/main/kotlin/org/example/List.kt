package org.example

class List<T> {
    private var head: Node<T>? = null

    fun getHead(): Node<T>? = head

    fun addLast(i: T): T {
        val node = Node(i, next = null)

        if (head == null) {
            head = node
            return i
        }

        var current = head
        while (current?.next != null) {
            current = current.next
        }
        current?.next = node

        return i
    }
}
