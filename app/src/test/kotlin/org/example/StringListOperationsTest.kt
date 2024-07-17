package org.example

import org.example.Node.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class StringListOperationsTest {
    @Test
    fun `should convert the list of string for empty list into list of uppercase string`() {
        val stringList = EmptyNode<String>()
        val expectedList = EmptyNode<String>()

        val uppercasedStringList = stringList.convertToUppercase()

        assertEquals(expectedList, uppercasedStringList)
    }

    @Test
    fun `should convert the list of string into list of uppercase string`() {
        val stringList = DataNode(value = "abc", next = DataNode(value = "xYz", next = EmptyNode()))
        val expectedList = DataNode(value = "ABC", next = DataNode("XYZ", next = EmptyNode()))

        val uppercasedStringList = stringList.convertToUppercase()

        assertEquals(expectedList, uppercasedStringList)
    }

    @Test
    fun `should convert the list of string for empty list into list of lowercase string`() {
        val stringList = EmptyNode<String>()
        val expectedList = EmptyNode<String>()

        val lowercasedStringList = stringList.convertToLowercase()

        assertEquals(expectedList, lowercasedStringList)
    }

    @Test
    fun `should convert the list of string into list of lowercase string`() {
        val stringList = DataNode(value = "ABC", next = DataNode(value = "XyZ", next = EmptyNode()))
        val expectedList = DataNode(value = "abc", next = DataNode("xyz", next = EmptyNode()))

        val lowercasedStringList = stringList.convertToLowercase()

        assertEquals(expectedList, lowercasedStringList)
    }

    @Test
    fun `should return the string list with only 3 character long values from string list`() {
        val stringList = DataNode(value = "aBCd", next = DataNode(value = "anv", next = EmptyNode()))
        val expectedList = DataNode(value = "anv", next = EmptyNode())

        val resultList = stringList.getNumberOfCharacterLong(number = 3)

        assertEquals(expectedList, resultList)
    }
}
