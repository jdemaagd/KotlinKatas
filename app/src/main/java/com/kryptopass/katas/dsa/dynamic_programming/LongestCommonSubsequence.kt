package com.kryptopass.katas.dsa.dynamic_programming

/*
Given two strings text1 and text2, return the length of their longest common subsequence.
If there is no common subsequence, return 0.
A subsequence of a string is a new string generated from the original string with some characters
    (can be none) deleted without changing the relative order of the remaining characters.
For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.
 */
fun main() {
    longestCommonSubsequenceRecursive("abcdef", "acef").also(::println)  // 4
    longestCommonSubsequenceRecursive("abcdef", "rabc").also(::println)  // 3
    longestCommonSubsequenceRecursive("abc", "abc").also(::println)  // 3
    println()
    longestCommonSubsequenceMemo("abcdef", "acef").also(::println)  // 4
    longestCommonSubsequenceMemo("abcdef", "rabc").also(::println)  // 3
    longestCommonSubsequenceMemo("abc", "abc").also(::println)  // 3
    println()
    longestCommonSubsequenceTab("pqrst", "prt").also(::println)  // 3
    longestCommonSubsequenceTab("abcdef", "acef").also(::println)  // 4
    longestCommonSubsequenceTab("abcdef", "rabc").also(::println)  // 3
    println()
    longestCommonSubsequenceSpaceOptimized("abcdef", "acef").also(::println)  // 4
    longestCommonSubsequenceSpaceOptimized("abcdef", "rabc").also(::println)  // 3
    longestCommonSubsequenceSpaceOptimized("abc", "abc").also(::println)  // 3
}

// Step 1: Recursion
// Time Complexity: O(2^(n + m)) -> 2 * 2 * 2 * ... (n + m) times
// Space Complexity: O(n + m)
fun longestCommonSubsequenceRecursive(
    text1: String, text2: String
): Int {
    val n = text1.length
    val m = text2.length

    fun helper(nIndex: Int, mIndex: Int): Int {
        if (nIndex > n - 1 || mIndex > m - 1) {
            return 0
        }

        return if (text1[nIndex] == text2[mIndex]) {
            1 + helper(nIndex + 1, mIndex + 1)
        } else {
            maxOf(helper(nIndex + 1, mIndex), helper(nIndex, mIndex + 1))
        }
    }

    return helper(0, 0)
}

// Step 2: memoization/top-down approach
// Time Complexity: O(n * m) -> n * m subproblems
// Space Complexity: O(n * m) + O(n + m), memo table + recursion stack, -> O(n * m)
fun longestCommonSubsequenceMemo(
    text1: String, text2: String
): Int {
    val n = text1.length
    val m = text2.length
    val memo = Array(n) { IntArray(m) { -1 } }

    fun helper(nIndex: Int, mIndex: Int): Int {
        if (nIndex > n - 1 || mIndex > m - 1) {
            return 0
        }

        if (memo[nIndex][mIndex] != -1) {
            return memo[nIndex][mIndex]
        }

        memo[nIndex][mIndex] = if (text1[nIndex] == text2[mIndex]) {
            1 + helper(nIndex + 1, mIndex + 1)
        } else {
            maxOf(helper(nIndex + 1, mIndex), helper(nIndex, mIndex + 1))
        }

        return memo[nIndex][mIndex]
    }

    return helper(0, 0)
}

// Step 3: tabulation/bottom-up approach
// Time Complexity: O(n * m) -> n * m subproblems
// Space Complexity: O(n * m) -> memo table
fun longestCommonSubsequenceTab(
    text1: String, text2: String
): Int {
    val n = text1.length
    val m = text2.length
    val tab2d = Array(n + 1) { IntArray(m + 1) }

    for (i in 1..n) {
        for (j in 1..m) {
            tab2d[i][j] = if (text1[i - 1] == text2[j - 1]) {
                1 + tab2d[i - 1][j - 1]
            } else {
                maxOf(tab2d[i - 1][j], tab2d[i][j - 1])
            }
        }
    }

    return tab2d[n][m]
}

// Step 4: space optimized tabulation
// Time Complexity: O(n * m) -> n * m subproblems
// Space Complexity: O(m) -> memo table
fun longestCommonSubsequenceSpaceOptimized(
    text1: String, text2: String
): Int {
    val n = text1.length
    val m = text2.length

    val prev = IntArray(m + 1)
    val curr = IntArray(m + 1)

    for (i in 1..n) {
        for (j in 1..m) {
            curr[j] = if (text1[i - 1] == text2[j - 1]) {
                1 + prev[j - 1]
            } else {
                maxOf(prev[j], curr[j - 1])
            }
        }
        prev.indices.forEach { prev[it] = curr[it] }
    }

    return curr[m]
}
