package com.kryptopass.code

import java.util.LinkedList
import java.util.Queue

/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a
space-separated sequence of one or more dictionary words.
Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:
Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.

Example 2:
Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
 */
fun main() {
    wordBreak("applepenapple", listOf("apple", "pen")).also { println(it) }
    wordBreak("catsandog", listOf("cats", "dog", "sand", "and", "cat")).also { println(it) }
}

fun wordBreak(s: String, wordDict: List<String>): Boolean {
    val wordSet = wordDict.toSet()
    val queue: Queue<Int> = LinkedList()
    val visited = BooleanArray(s.length)

    queue.add(0)
    while (queue.isNotEmpty()) {
        val startIndex = queue.poll()

        if (visited[startIndex]) continue

        for (endIndex in startIndex + 1..s.length) {
            if (s.substring(startIndex, endIndex) in wordSet) {
                queue.add(endIndex)
                if (endIndex == s.length) return true
            }
        }
    }

    return false
}