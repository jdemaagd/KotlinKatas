package com.kryptopass.katas.dynamic_programming.m3

import com.kryptopass.katas.dynamic_programming.MOD

fun main() {
    val dict = arrayListOf("kick", "start", "kickstart", "is", "awe", "some", "awesome")
    val txt = "kickstartisawesome"
    println(workBreakCount(dict, txt))
}

/*
Word Break Count
Given a dictionary of words and a string txt,
find the number of ways the string can be broken down into the dictionary words.
Return the answer modulo 10^9 + 7.

Example
{
    "dictionary": ["kick", "start", "kickstart", "is", "awe", "some", "awesome"],
    "txt": "kickstartisawesome"
}
Output: 4
Here are all four ways to break down the string into the dictionary words:
kick start is awe some
kick start is awesome
kickstart is awe some
kickstart is awesome
4 % 1000000007 = 4 so the correct output is 4.

Constraints:
1. 1 <= number of words in the dictionary <= 2 * 10^5
2. 1 <= length of any dictionary word <= 10^2
3. 1 <= length of the string txt <= 2 * 10^3
4. Dictionary words and the string txt all consist of lowercase latin characters only
   (no whitespace, in particular).
 */

/*
    Asymptotic complexity in terms of `dictionaryCount` =  of words in the dictionary
    and `len` = length of the given input string `txt`:
    Time complexity: O(dictionaryCount * len * 2^len)
    Auxiliary space: O(len)
    Total space: O(len + dictionaryCount * max_len)
 */
fun workBreakCount(
    dict: ArrayList<String>, txt: String
): Int {
    val arrangements = intArrayOf(0)
    val prefix = ""

    wordBreakCountHelper(txt, dict, prefix, arrangements)

    return arrangements[0]
}

fun wordBreakCountHelper(
    txt: String, dict: ArrayList<String>,
    trailingPrefix: String, arrangements: IntArray
) {
    val len = txt.length

    if (len == 0) {
        arrangements[0]++
        if (arrangements[0] >= MOD) arrangements[0] %= MOD

        return
    }

    for (i in txt.indices) {
        val segment = txt.substring(0, i + 1)

        if (dict.contains(segment)) {
            val newPrefix = "$trailingPrefix$segment "
            val newSegment = txt.substring(i + 1, txt.length)

            wordBreakCountHelper(newSegment, dict, newPrefix, arrangements)
        }
    }
}