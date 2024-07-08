package org.example

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ListOperationsTest {
    @Test
    fun `should return the integer list with square values for given integer list`() {
        val integerList = IntegerList()
        integerList.addLast(4)
        integerList.addLast(5)
        val expectedSquareValues = IntegerList()
        expectedSquareValues.addLast(16)
        expectedSquareValues.addLast(25)

        val squareValues = ListOperations.getSquareValues(integerList)

        assertThat(squareValues).usingRecursiveComparison().isEqualTo(expectedSquareValues)
    }

    @Test
    fun `should return the integer list with cube values for given integer list`() {
        val integerList = IntegerList()
        integerList.addLast(4)
        integerList.addLast(5)
        val expectedCubeValues = IntegerList()
        expectedCubeValues.addLast(64)
        expectedCubeValues.addLast(125)

        val cubeValues = ListOperations.getCubeValues(integerList)

        assertThat(cubeValues).usingRecursiveComparison().isEqualTo(expectedCubeValues)
    }
}