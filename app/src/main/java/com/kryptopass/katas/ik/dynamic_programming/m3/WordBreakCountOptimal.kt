package com.kryptopass.katas.dynamic_programming.m3

import com.kryptopass.katas.dynamic_programming.MOD

fun main() {
    val dict = arrayListOf("kick", "start", "kickstart", "is", "awe", "some", "awesome")
    val txt = "kickstartisawesome"
    println(workBreakCountOptimal(dict, txt))
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
    Time complexity: O(len^3 + dictionaryCount * max_len)
    Auxiliary space: O(len)
    Total space: O(len + dictionaryCount * max_len)
 */
fun workBreakCountOptimal(
    dict: ArrayList<String>, txt: String
): Int {
    val root = TrieNode()

    for (i in dict.indices) insert(root, dict[i])

    val max = txt.length + 1

    val dp = IntArray(max) { -1 }

    return workBreakCountOptimalHelper(0, txt, dp, root)
}

fun insert(
    root: TrieNode, k: String
) {
    var tmp = root
    val l = k.length

    for (i in 0 until l) {
        val idx = k[i] - 'a'
        if (tmp.child[idx] == null)
            tmp.child[idx] = TrieNode()

        tmp = tmp.child[idx]!!
    }

    tmp.isEnd = true
}

fun workBreakCountOptimalHelper(
    idx: Int, txt: String,
    dp: IntArray, root: TrieNode
): Int {
    val len = txt.length

    if (idx == len) return 1
    if (dp[idx] != -1) return dp[idx]

    var result: Long = 0

    var segment = root
    for (i in idx until len) {
        if (segment.child[txt[i] - 'a'] != null) {
            segment = segment.child[txt[i] - 'a']!!
        } else {
            break
        }

        if (segment.isEnd) {
            val numOfArrangements = workBreakCountOptimalHelper(i + 1, txt, dp, root)
            result += numOfArrangements
            result %= MOD
        }
    }

    dp[idx] = result.toInt()

    return dp[idx]
}

class TrieNode {
    var isEnd: Boolean = false
    var child: Array<TrieNode?> = arrayOfNulls(26)
}