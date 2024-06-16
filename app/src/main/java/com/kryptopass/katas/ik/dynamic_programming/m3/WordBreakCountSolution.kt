package com.kryptopass.katas.dynamic_programming.m3

import com.kryptopass.katas.dynamic_programming.MOD

fun main() {
    val dict = arrayListOf("kick", "start", "kickstart", "is", "awe", "some", "awesome")
    val txt = "KickStartIsAwesome"
    println(workBreakCountSolution(dict, txt))
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
fun workBreakCountSolution(
    dict: ArrayList<String>, txt: String
): Int {
    val dictSet = HashSet<String>()

    for (i in dict.indices) dictSet.add(dict[i])

    val max = txt.length + 1

    val dp = IntArray(max) { -1 }

    return workBreakCountSolutionHelper(0, dictSet, txt, dp)
}

fun workBreakCountSolutionHelper(
    idx: Int, dict: HashSet<String>,
    txt: String, dp: IntArray
): Int {
    val len = txt.length

    if (idx == len) return 1
    if (dp[idx] != -1) return dp[idx]

    var result: Long = 0

    var segment = ""
    for (i in idx until len) {
        segment += txt[i]

        if (dict.contains(segment)) {
            val numOfArrangements = workBreakCountSolutionHelper(i + 1, dict, txt, dp)

            result += numOfArrangements.toLong()
            result %= MOD
        }
    }

    dp[idx] = result.toInt()

    return dp[idx]
}