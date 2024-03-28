package com.kryptopass.katas.data_structures.m6

// NOTE: find all occurrences of a pattern from a text using any pattern matching algorithm
// KMP: most efficient for pattern searching -> O(m) + O(k) = O(n + k)
fun knuthMorrisPrattSearch(text: String, pattern: String): Int {
    val prefixArr = preparePrefixArray(pattern)
    val textLen = text.length
    val patternLen = pattern.length
    var patternIndex = 0
    var textIndex = 0

    while ((textIndex < textLen) and (patternIndex < patternLen)) {
        if (pattern[patternIndex] == text[textIndex]) {
            textIndex++
            patternIndex++
        } else {
            if (patternIndex != 0) patternIndex = prefixArr[patternIndex - 1]
            else textIndex++
        }
        if (patternIndex == patternLen) {
            // We found the pattern
            return textIndex - patternIndex
        }
    }
    return -1
}

fun preparePrefixArray(pattern: String): IntArray {
    val patternLen = pattern.length
    val arr = IntArray(patternLen)
    var index = 0
    var i = 1

    while(i < patternLen) {
        if (pattern[i] == pattern[index]) {
            arr[i] = index + 1
            index++
            i++
        } else {
            if (index != 0) index = arr[index - 1]
            else {
                arr[i] = 0
                i++
            }
        }
    }

    return arr
}

fun main(args:Array<String>) {
    println(knuthMorrisPrattSearch("Hello Kotlin!!", "Ko"))
    println(knuthMorrisPrattSearch("Hello Kotlin!!", "Kos"))
    println(knuthMorrisPrattSearch("Hello", "el"))
    println(knuthMorrisPrattSearch("Hello Kotlin", "owel"))
    println(knuthMorrisPrattSearch("Hello", "lo"))
    println(knuthMorrisPrattSearch("Hello", "llw"))
    println(knuthMorrisPrattSearch("Hello", "llo"))
}