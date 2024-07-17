package org.example

import org.example.Node.*
import org.example.StringListOperations.Companion.convertToLowercase
import org.example.StringListOperations.Companion.convertToUppercase
import org.example.StringListOperations.Companion.getIntegerListWithStringLength
import org.example.StringListOperations.Companion.getNumberOfCharacterLong
import org.example.StringListOperations.Companion.getStringByConcatenating
import org.example.StringListOperations.Companion.getStringByConcatenatingFirstCharacter
import org.example.StringListOperations.Companion.getSumValueOfStringLength
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class StringListOperationsTest {
    @Test
    fun `should convert the list of string for empty list into list of uppercase string`() {
        val stringList = EmptyNode<String>()
        val expectedList = EmptyNode<String>()

        val uppercasedStringList = convertToUppercase(stringList)

        assertEquals(expectedList, uppercasedStringList)
    }

    @Test
    fun `should convert the list of string into list of uppercase string`() {
        val stringList = DataNode(value = "abc", next = DataNode(value = "xYz", next = EmptyNode()))
        val expectedList = DataNode(value = "ABC", next = DataNode("XYZ", next = EmptyNode()))

        val uppercasedStringList = convertToUppercase(stringList)

        assertEquals(expectedList, uppercasedStringList)
    }

    @Test
    fun `should convert the list of string for empty list into list of lowercase string`() {
        val stringList = EmptyNode<String>()
        val expectedList = EmptyNode<String>()

        val lowercasedStringList = convertToLowercase(stringList)

        assertEquals(expectedList, lowercasedStringList)
    }

    @Test
    fun `should convert the list of string into list of lowercase string`() {
        val stringList = DataNode(value = "ABC", next = DataNode(value = "XyZ", next = EmptyNode()))
        val expectedList = DataNode(value = "abc", next = DataNode("xyz", next = EmptyNode()))

        val lowercasedStringList = convertToLowercase(stringList)

        assertEquals(expectedList, lowercasedStringList)
    }

    @Test
    fun `should return the string list with only 3 character long values from string list`() {
        val stringList = DataNode(value = "aBCd", next = DataNode(value = "anv", next = EmptyNode()))
        val expectedList = DataNode(value = "anv", next = EmptyNode())

        val resultList = getNumberOfCharacterLong(list = stringList, number = 3)

        assertEquals(expectedList, resultList)
    }

    @Test
    fun `should return the integer list with string length from string list`() {
        val stringList = DataNode(value = "aBCd", next = DataNode(value = "anv", next = EmptyNode()))
        val expectedList = DataNode(value = 4, next = DataNode(value = 3, next = EmptyNode()))

        val integerListWithStringLength = getIntegerListWithStringLength(stringList)

        assertEquals(expectedList, integerListWithStringLength)
    }

    @Test
    fun `should return the sum value of all the string lengths from string list`() {
        val stringList = DataNode(value = "aBCd", next = DataNode(value = "anv", next = EmptyNode()))

        val sumValueOfStringLength = getSumValueOfStringLength(stringList)

        assertEquals(7, sumValueOfStringLength)
    }

    @Test
    fun `should return the single string by concatenating all values with separator`() {
        val stringList = DataNode(value = "aBCd", next = DataNode(value = "anv", next = EmptyNode()))

        val stringByConcatenating = getStringByConcatenating(list = stringList, seperator = " ")

        assertEquals("aBCd anv", stringByConcatenating)
    }

    @Test
    fun `should return the single string by concatenating the first character from values from string list`() {
        val stringList =
            DataNode(value = "abc", next = DataNode(value = "bcd", next = DataNode(value = "cde", next = EmptyNode())))

        val stringByConcatenating = getStringByConcatenatingFirstCharacter(stringList)

        assertEquals("abc", stringByConcatenating)
    }
}
