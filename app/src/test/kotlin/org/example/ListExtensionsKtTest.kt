package org.example

import org.example.Node.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ListExtensionsKtTest {
    @Test
    fun `should return the remaining list on performing drop on the list`() {
        val integerList = DataNode(value = 4, next = DataNode(value = 5, next = DataNode(value = 6, next = EmptyNode())))
        val expectedList = DataNode(value = 6, next = EmptyNode())

        val remainingList = integerList.drop(2)

        assertEquals(expectedList, remainingList)
    }

    @Test
    fun `should return empty list for the drop count greater than the length of the list`() {
        val integerList = DataNode(value = 4, next = DataNode(value = 5, next = DataNode(value = 6, next = EmptyNode())))
        val expectedList = EmptyNode<Int>()

        val remainingList = integerList.drop(5)

        assertEquals(expectedList, remainingList)
    }
}