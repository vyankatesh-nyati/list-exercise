package org.example

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CustomListOperationsTest {
    private fun setupIntegerList(numbers: List<Int>): CustomList<Int> {
        val list = CustomList<Int>()
        numbers.forEach { list.addLast(it) }
        return list
    }

    @Test
    fun `should return the integer list with square values for given integer list`() {
        val integerList = setupIntegerList(listOf(4, 5))
        val expectedSquareValues = setupIntegerList(listOf(16, 25))

        val squareValues = integerList.getSquareValues()

        assertThat(squareValues).usingRecursiveComparison().isEqualTo(expectedSquareValues)
    }

    @Test
    fun `should return the integer list with cube values for given integer list`() {
        val integerList = setupIntegerList(listOf(4, 5))
        val expectedCubeValues = setupIntegerList(listOf(64, 125))

        val cubeValues = integerList.getCubeValues()

        assertThat(cubeValues).usingRecursiveComparison().isEqualTo(expectedCubeValues)
    }

    @Test
    fun `should return the integer list with odd values for the given integer list`() {
        val integerList = setupIntegerList(listOf(4, 5, 6, 7))
        val expectedList = setupIntegerList(listOf(5, 7))

        val oddValues = integerList.getOddValues()

        assertThat(oddValues).usingRecursiveComparison().isEqualTo(expectedList)
    }

    @Test
    fun `should return the integer list with even values for the given integer list`() {
        val integerList = setupIntegerList(listOf(4, 5, 6, 7))
        val expectedList = setupIntegerList(listOf(4, 6))

        val evenValues = integerList.getEvenValues()

        assertThat(evenValues).usingRecursiveComparison().isEqualTo(expectedList)
    }

    @Test
    fun `should return the sum of the all elements for the given integer list`() {
        val integerList = setupIntegerList(listOf(4, 5, 6, 7))

        val sumOfElements = integerList.getSumOfElements()

        assertEquals(22, sumOfElements)
    }

    @Test
    fun `should return the maximum value from the given list of elements`() {
        val integerList = setupIntegerList(listOf(4, 5, 6, 7))

        val maxValue = integerList.getMaxValue()

        assertEquals(7, maxValue)
    }

    @Test
    fun `should return null for the max value if the list is empty`() {
        val integerList = setupIntegerList(listOf())

        val maxValue = integerList.getMaxValue()

        assertEquals(null, maxValue)
    }

    @Test
    fun `should return the minimum value from the given list of elements`() {
        val integerList = setupIntegerList(listOf(4, 5, 6, 7))

        val maxValue = integerList.getMinValue()

        assertEquals(4, maxValue)
    }

    @Test
    fun `should return null for the min value if the list is empty`() {
        val integerList = setupIntegerList(listOf())

        val maxValue = integerList.getMinValue()

        assertEquals(null, maxValue)
    }
}