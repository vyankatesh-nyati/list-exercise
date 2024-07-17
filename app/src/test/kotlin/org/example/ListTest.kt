package org.example

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ListTest {
    @Test
    fun `should create the integer list with head pointing to null`() {
        val list = List<Int>()

        val head = list.getHead()

        assertEquals(null, head)
    }

    @Test
    fun `should able to add the integer in the list`() {
        val list = List<Int>()

        val addedInteger = list.addLast(4)

        assertEquals(4, addedInteger)
    }

    @Test
    fun `head should points to the newly added integer, on adding integer to empty list`() {
        val list = List<Int>()
        val expectedNode = Node(value = 4, next = null)

        list.addLast(4)

        assertThat(list.getHead()).usingRecursiveComparison().isEqualTo(expectedNode)
    }

    @Test
    fun `head should points to the first element of the list`() {
        val list = List<Int>()
        val expectedNode = Node(value = 4, next = Node(value = 5, next = Node(value = 6, null)))

        list.addLast(4)
        list.addLast(5)
        list.addLast(6)

        assertThat(list.getHead()).usingRecursiveComparison().isEqualTo(expectedNode)
    }

    @Test
    fun `should link the node to the prev node`() {
        val list = List<Int>()
        val expectedNode = Node(value = 4, next = Node(value = 5, next = null))

        list.addLast(4)
        list.addLast(5)

        assertThat(list.getHead()).usingRecursiveComparison().isEqualTo(expectedNode)
    }
}