package com.kryptopass.katas.data_structures.m6

import kotlin.math.pow

// NOTE: time complexity varies from O(m + n) to O(m * n)
fun rabinKarpSearch(text: String, pattern: String): Int {
    val patternLen = pattern.length
    val textLen = text.length - patternLen
    val patternHash = hash(pattern)
    var subText = text.substring(0, patternLen)
    var subTextHash = hash(subText)
    var isFound = false
    if ((patternHash == subTextHash) and (subText == pattern)) return 0

    for (i in 1..textLen) {
        subTextHash = rolledHash(text[i - 1], text[i + patternLen - 1], subTextHash, patternLen)
        if ((patternHash == subTextHash) and (text.substring(i, i + patternLen) == pattern)) return i
    }
    return -1
}

private fun hash(input: String): Long {
    var result = 0L
    input.forEachIndexed { index, char ->
        result += (char.code.toDouble() * Math.pow(97.0, index.toDouble())).toLong()
    }
    return result
}

private fun rolledHash(oldChar: Char, newChar: Char, oldHash: Long, patternLen: Int): Long {
    return (((oldHash - oldChar.code.toLong()) / 97)
            + newChar.toDouble() * 97.0.pow((patternLen - 1).toDouble())).toLong()
}

fun main(args: Array<String>) {
    // Testing Hash function
    println(hash("hello"))
    val output: Long = 104L + 101L * 97L + 108L * 97L * 97L + 108L * 97L * 97L * 97L + 111L * 97L * 97L * 97L * 97L
    println(output)

    // Testing rolled Hash function
    println(hash("he"))
    val output1: Long = 104L + 101L * 97L
    println(output1)
    println(hash("el"))
    println(rolledHash('h', 'l', hash("he"), 2))
    val output2: Long = 101L + 108L * 97L
    println(output2)

    println(rabinKarpSearch("Hello", "el"))
    println(rabinKarpSearch("Hello Kotlin", "owel"))
    println(rabinKarpSearch("Hello", "lo"))
    println(rabinKarpSearch("Hello", "llw"))
    println(rabinKarpSearch("Hello", "llo"))
}