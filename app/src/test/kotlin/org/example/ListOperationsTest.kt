package org.example

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ListOperationsTest {
    private fun setupIntegerList(numbers: List<Int>): IntegerList {
        val integerList = IntegerList()
        numbers.forEach { integerList.addLast(it) }
        return integerList
    }

    @Test
    fun `should return the integer list with square values for given integer list`() {
        val integerList = setupIntegerList(listOf(4, 5))
        val expectedSquareValues = setupIntegerList(listOf(16, 25))
        val squareValues = ListOperations.getSquareValues(integerList)

        assertThat(squareValues).usingRecursiveComparison().isEqualTo(expectedSquareValues)
    }

    @Test
    fun `should return the integer list with cube values for given integer list`() {
        val integerList = setupIntegerList(listOf(4, 5))
        val expectedCubeValues = setupIntegerList(listOf(64, 125))

        val cubeValues = ListOperations.getCubeValues(integerList)

        assertThat(cubeValues).usingRecursiveComparison().isEqualTo(expectedCubeValues)
    }

    @Test
    fun `should return the integer list with odd values for the given integer list`() {
        val integerList = setupIntegerList(listOf(4, 5, 6, 7))
        val expectedList = setupIntegerList(listOf(5, 7))

        val oddValues = ListOperations.getOddValues(integerList)

        assertThat(oddValues).usingRecursiveComparison().isEqualTo(expectedList)
    }

    @Test
    fun `should return the integer list with even values for the given integer list`() {
        val integerList = setupIntegerList(listOf(4, 5, 6, 7))
        val expectedList = setupIntegerList(listOf(4, 6))

        val evenValues = ListOperations.getEvenValues(integerList)

        assertThat(evenValues).usingRecursiveComparison().isEqualTo(expectedList)
    }

    @Test
    fun `should return the sum of the all elements for the given integer list`() {
        val integerList = setupIntegerList(listOf(4, 5, 6, 7))

        val sumOfElements = ListOperations.getSumOfElements(integerList)

        assertEquals(22, sumOfElements)
    }

    @Test
    fun `should return the maximum value from the given list of elements`() {
        val integerList = setupIntegerList(listOf(4, 5, 6, 7))

        val maxValue = ListOperations.getMaxValue(integerList)

        assertEquals(7, maxValue)
    }

    @Test
    fun `should return null for the max value if the list is empty`() {
        val integerList = setupIntegerList(listOf())

        val maxValue = ListOperations.getMaxValue(integerList)

        assertEquals(null, maxValue)
    }
}