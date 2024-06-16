package com.kryptopass.katas.dynamic_programming.m2

fun main() {
    println(wordBreak("leetcode", arrayListOf("leet", "code")))
    println(wordBreak("applepenapple", arrayListOf("apple", "pen")))
    println(wordBreak("catsandog", arrayListOf("cats", "dog", "sand", "and", "cat")))
}

/*
Word Break - https://leetcode.com/problems/word-break/
Given a non-empty string `s` and a dictionary `wordDict` containing a list of non-empty words,
determine if `s` can be segmented into a space-separated sequence of one or more dictionary words

Example 1:
Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:
Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".

Example 3:
Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false

Note:
- Same word in dictionary may be reused multiple times in segmentation
- You may assume dictionary does not contain duplicate words

Recurrence Equation:
f(i) = f(j) && wordDict.contains(s.substring(j, i))

Solution Reconstruction

Time complexity: O(n^2) -> consider string construction -> O(n^3)
Space complexity: O(n)
 */
fun wordBreak(
    s: String, wordDict: ArrayList<String>
): Boolean {
    val n = s.length
    val table = ArrayList<Boolean>(n + 1)

    // initialize table with false values
    for (i in 0..n) table.add(false)

    // base case
    table[0] = true

    // recursive/iterative cases
    for (i in 1..n) {
        for (j in 0 until i - 1) {
            if (table[j] && wordDict.contains(s.substring(j, i))) {
                table[i] = true
                break
            }
        }
    }

    return table[n]
}