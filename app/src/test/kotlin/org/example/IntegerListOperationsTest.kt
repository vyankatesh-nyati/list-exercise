package org.example

import org.assertj.core.api.Assertions.assertThat
import org.example.IntegerListOperations.Companion.getCubeValues
import org.example.IntegerListOperations.Companion.getEvenValues
import org.example.IntegerListOperations.Companion.getMaxValue
import org.example.IntegerListOperations.Companion.getMinValue
import org.example.IntegerListOperations.Companion.getOddValues
import org.example.IntegerListOperations.Companion.getSquareValues
import org.example.IntegerListOperations.Companion.getSumOfElements
import org.example.Node.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class IntegerListOperationsTest {
    private fun setupIntegerList(numbers: List<Int>): Node<Int> {
        var list: Node<Int> = EmptyNode()
        numbers.forEach { list = list.addLast(it) }
        return list
    }

    @Test
    fun `should return the integer list with square values for given integer list`() {
        val integerList = setupIntegerList(listOf(4, 5))
        val expectedSquareValues = setupIntegerList(listOf(16, 25))

        val squareValues = getSquareValues(integerList)

        assertThat(squareValues).usingRecursiveComparison().isEqualTo(expectedSquareValues)
    }

    @Test
    fun `should return the integer list with cube values for given integer list`() {
        val integerList = setupIntegerList(listOf(4, 5))
        val expectedCubeValues = setupIntegerList(listOf(64, 125))

        val cubeValues = getCubeValues(integerList)

        assertThat(cubeValues).usingRecursiveComparison().isEqualTo(expectedCubeValues)
    }

    @Test
    fun `should return the integer list with odd values for the given integer list`() {
        val integerList = setupIntegerList(listOf(4, 5, 6, 7))
        val expectedList = setupIntegerList(listOf(5, 7))

        val oddValues = getOddValues(integerList)

        assertThat(oddValues).usingRecursiveComparison().isEqualTo(expectedList)
    }

    @Test
    fun `should return the integer list with even values for the given integer list`() {
        val integerList = setupIntegerList(listOf(4, 5, 6, 7))
        val expectedList = setupIntegerList(listOf(4, 6))

        val evenValues = getEvenValues(integerList)

        assertThat(evenValues).usingRecursiveComparison().isEqualTo(expectedList)
    }

    @Test
    fun `should return the sum of the all elements for the given integer list`() {
        val integerList = setupIntegerList(listOf(4, 5, 6, 7))

        val sumOfElements = getSumOfElements(integerList)

        assertEquals(22, sumOfElements)
    }

    @Test
    fun `should return the maximum value from the given list of elements`() {
        val integerList = setupIntegerList(listOf(4, 5, 6, 7))

        val maxValue = getMaxValue(integerList as DataNode)

        assertEquals(7, maxValue)
    }

    @Test
    fun `should return the minimum value from the given list of elements`() {
        val integerList = setupIntegerList(listOf(4, 5, 6, 7))

        val maxValue = getMinValue(integerList as DataNode)

        assertEquals(4, maxValue)
    }
}