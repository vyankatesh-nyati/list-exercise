package org.example

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ListOperationsTest {
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

    private fun setupIntegerList(numbers: List<Int>): IntegerList {
        val integerList = IntegerList()
        numbers.forEach { integerList.addLast(it) }
        return integerList
    }
}