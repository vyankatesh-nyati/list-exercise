package org.example

import org.example.Node.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NodeTest {
    @Test
    fun `should able to add the integer in the Empty list`() {
        val list = EmptyNode<Int>()
        val expectedList = DataNode(value = 4, next = EmptyNode())

        val latestList = list.addLast(4)

        assertEquals(expectedList, latestList)
    }

//    @Test
//    fun `head should points to the newly added integer, on adding integer to empty list`() {
//        val list = CustomList<Int>()
//        val expectedNode = Node(value = 4, next = null)
//
//        list.addLast(4)
//
//        assertThat(list.getHead()).usingRecursiveComparison().isEqualTo(expectedNode)
//    }
//
//    @Test
//    fun `head should points to the first element of the list`() {
//        val list = CustomList<Int>()
//        val expectedNode = Node(value = 4, next = Node(value = 5, next = Node(value = 6, null)))
//
//        list.addLast(4)
//        list.addLast(5)
//        list.addLast(6)
//
//        assertThat(list.getHead()).usingRecursiveComparison().isEqualTo(expectedNode)
//    }
//
//    @Test
//    fun `should link the node to the prev node`() {
//        val list = CustomList<Int>()
//        val expectedNode = Node(value = 4, next = Node(value = 5, next = null))
//
//        list.addLast(4)
//        list.addLast(5)
//
//        assertThat(list.getHead()).usingRecursiveComparison().isEqualTo(expectedNode)
//    }
}