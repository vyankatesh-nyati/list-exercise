package org.example

import org.example.Node.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ListExtensionsKtTest {
    @Test
    fun `should accumulates value on performing operation for the given list`() {
        val intList = DataNode(value = 4, next = DataNode(value = 5, next = DataNode(value = 6, next = EmptyNode())))

        val result = intList.fold(0) { acc: Int, i: Int -> acc + i }

        assertEquals(15, result)
    }

    @Test
    fun `should accumulates value on performing operation with index for the given list`() {
        val intList = DataNode(value = 4, next = DataNode(value = 5, next = DataNode(value = 6, next = EmptyNode())))

        val result = intList.foldIndexed(0) { index: Int, acc: Int, i: Int -> acc + i + index }

        assertEquals(18, result)
    }

    @Test
    fun `should accumulates value on performing operation for the given list considering the first element as a initial value`() {
        val intList = DataNode(value = 4, next = DataNode(value = 5, next = DataNode(value = 6, next = EmptyNode())))

        val result = intList.reduce { acc: Int, i: Int -> acc + i }

        assertEquals(15, result)
    }

    @Test
    fun `should return the transformed value list for the given list on applying map`() {
        val intList = DataNode(value = 4, next = DataNode(value = 5, next = DataNode(value = 6, next = EmptyNode())))
        val expectedList =
            DataNode(value = 16, next = DataNode(value = 25, next = DataNode(value = 36, next = EmptyNode())))

        val result = intList.map { it * it }

        assertEquals(expectedList, result)
    }

    @Test
    fun `should return the filtered list for the given list`() {
        val intList = DataNode(value = 4, next = DataNode(value = 5, next = DataNode(value = 6, next = EmptyNode())))
        val expectedList = DataNode(value = 4, next = DataNode(value = 6, next = EmptyNode()))

        val result = intList.filter { it % 2 == 0 }

        assertEquals(expectedList, result)
    }

    @Test
    fun `should return the remaining list on performing drop on the list`() {
        val integerList =
            DataNode(value = 4, next = DataNode(value = 5, next = DataNode(value = 6, next = EmptyNode())))
        val expectedList = DataNode(value = 6, next = EmptyNode())

        val remainingList = integerList.drop(2)

        assertEquals(expectedList, remainingList)
    }

    @Test
    fun `should return empty list for the drop count greater than the length of the list`() {
        val integerList =
            DataNode(value = 4, next = DataNode(value = 5, next = DataNode(value = 6, next = EmptyNode())))
        val expectedList = EmptyNode<Int>()

        val remainingList = integerList.drop(5)

        assertEquals(expectedList, remainingList)
    }

    @Test
    fun `should drop the element of the list until the given condition returns false for the first time`() {
        val integerList =
            DataNode(value = 4, next = DataNode(value = 5, next = DataNode(value = 6, next = EmptyNode())))
        val expectedList = DataNode(value = 5, next = DataNode(value = 6, next = EmptyNode()))

        val remainingList = integerList.dropWhile { it < 5 }

        assertEquals(expectedList, remainingList)
    }

    @Test
    fun `should return the list with the first n elements on performing take on the list`() {
        val integerList =
            DataNode(value = 4, next = DataNode(value = 5, next = DataNode(value = 6, next = EmptyNode())))
        val expectedList = DataNode(value = 4, next = DataNode(value = 5, next = EmptyNode()))

        val remainingList = integerList.take(2)

        assertEquals(expectedList, remainingList)
    }

    @Test
    fun `should return whole list for the take count greater than the length of the list`() {
        val integerList =
            DataNode(value = 4, next = DataNode(value = 5, next = DataNode(value = 6, next = EmptyNode())))

        val remainingList = integerList.take(5)

        assertEquals(integerList, remainingList)
    }
}