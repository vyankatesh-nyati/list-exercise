package org.example

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IntegerListTest {
    @Test
    fun `should create the integer list with head pointing to null`() {
        val list = IntegerList()

        val head = list.getHead()

        assertEquals(null, head)
    }

    @Test
    fun `should able to add the integer in the list`() {
        val integerList = IntegerList()

        val addedInteger = integerList.add(4)

        assertEquals(4, addedInteger)
    }

    @Test
    fun `head should points to the newly added integer, on adding integer to empty list`() {
        val integerList = IntegerList()
        val expectedNode = IntegerNode(value = 4, next = null)

        integerList.add(4)

        assertThat(integerList.getHead()).usingRecursiveComparison().isEqualTo(expectedNode)
    }

    @Test
    fun `head should points to the first element of the list`() {
        val integerList = IntegerList()
        val expectedNode = IntegerNode(value = 4, next = IntegerNode(value = 5, next = IntegerNode(value = 6, null)))

        integerList.add(4)
        integerList.add(5)
        integerList.add(6)

        assertThat(integerList.getHead()).usingRecursiveComparison().isEqualTo(expectedNode)
    }

    @Test
    fun `should link the node to the prev node`() {
        val integerList = IntegerList()
        val expectedNode = IntegerNode(value = 4, next = IntegerNode(value = 5, next = null))

        integerList.add(4)
        integerList.add(5)

        assertThat(integerList.getHead()).usingRecursiveComparison().isEqualTo(expectedNode)
    }
}