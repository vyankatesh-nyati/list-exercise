package org.example

import org.example.Node.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NodeTest {
    @Test
    fun `should able to add the integer in the Empty list`() {
        val list = EmptyNode<Int>()
        val expectedList = DataNode(value = 4, next = EmptyNode())

        val latestList = list.insert(4)

        assertEquals(expectedList, latestList)
    }

    @Test
    fun `should able to add the integer in the Non Empty list`() {
        val list = DataNode(value = 4, next = EmptyNode())
        val expectedList = DataNode(value = 4, next = DataNode(value = 5, next = EmptyNode()))

        val latestList = list.insert(5)

        assertEquals(expectedList, latestList)
    }
}