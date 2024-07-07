package com.kryptopass.katas.dsa.`13_dynamic_programming_lcs`

/*
Given two strings word1 and word2,
return the minimum number of operations required to convert word1 to word2.
You have the following three operations permitted on a word:
    - Insert a character
    - Delete a character
    - Replace a character
 */
fun main() {
    minDistanceRecursive("horse", "ros").also(::println)  // 3
    minDistanceRecursive("intention", "execution").also(::println)  // 5
    minDistanceRecursive("table", "bel").also(::println)  // 3
    println()
    minDistanceMemo("horse", "ros").also(::println)  // 3
    minDistanceMemo("intention", "execution").also(::println)  // 5
    minDistanceMemo("table", "bel").also(::println)  // 3
    println()
    minDistanceTab("horse", "ros").also(::println)  // 3
    minDistanceTab("intention", "execution").also(::println)  // 5
    minDistanceTab("table", "bel").also(::println)  // 3
    println()
    minDistanceSpaceOptimized("horse", "ros").also(::println)  // 3
    minDistanceSpaceOptimized("intention", "execution").also(::println)  // 5
    minDistanceSpaceOptimized("table", "bel").also(::println)  // 3
}

// Step 1: recursive solution
// Time Complexity: O(3^(m + n)), where m and n are the lengths of the two strings
// Space Complexity: O(m + n)
fun minDistanceRecursive(
    word1: String, word2: String
): Int {
    fun numberOfOperations(nIndex: Int, mIndex: Int): Int {
        if (nIndex > word1.length - 1 && mIndex > word2.length - 1) {
            return 0
        }
        if (nIndex > word1.length - 1) {
            return word2.length - mIndex
        }
        if (mIndex > word2.length - 1) {
            return word1.length - nIndex
        }

        if (word1[nIndex] == word2[mIndex]) {
            return numberOfOperations(nIndex + 1, mIndex + 1)
        }

        val insert = 1 + numberOfOperations(nIndex, mIndex + 1)
        val delete = 1 + numberOfOperations(nIndex + 1, mIndex)
        val replace = 1 + numberOfOperations(nIndex + 1, mIndex + 1)

        return minOf(insert, delete, replace)
    }

    return numberOfOperations(0, 0)
}

// Step 2: memoization/top-down approach
// Time Complexity: O(m * n), where m and n are the lengths of the two strings
// Space Complexity: O(m * n)
fun minDistanceMemo(
    word1: String, word2: String
): Int {
    val n = word1.length
    val m = word2.length
    val memo = Array(n) { IntArray(m) { -1 } }

    fun numberOfOperations(nIndex: Int, mIndex: Int): Int {
        if (nIndex > word1.length - 1 && mIndex > word2.length - 1) {
            return 0
        }
        if (nIndex > word1.length - 1) {
            return word2.length - mIndex
        }
        if (mIndex > word2.length - 1) {
            return word1.length - nIndex
        }

        if (memo[nIndex][mIndex] != -1) {
            return memo[nIndex][mIndex]
        }

        if (word1[nIndex] == word2[mIndex]) {
            memo[nIndex][mIndex] = numberOfOperations(nIndex + 1, mIndex + 1)
            return memo[nIndex][mIndex]
        }

        val insert = 1 + numberOfOperations(nIndex, mIndex + 1)
        val delete = 1 + numberOfOperations(nIndex + 1, mIndex)
        val replace = 1 + numberOfOperations(nIndex + 1, mIndex + 1)

        memo[nIndex][mIndex] = minOf(insert, delete, replace)

        return memo[nIndex][mIndex]
    }

    return numberOfOperations(0, 0)
}

// Step 3: tabulation/bottom-up approach
// Time Complexity: O(m * n), where m and n are the lengths of the two strings
// Space Complexity: O(m * n)
fun minDistanceTab(
    word1: String, word2: String
): Int {
    val n = word1.length
    val m = word2.length
    val tab2d = Array(n + 1) { IntArray(m + 1) }

    for (i in 0..n) {
        tab2d[i][0] = i
    }

    for (j in 0..m) {
        tab2d[0][j] = j
    }

    for (i in 1..n) {
        for (j in 1..m) {
            if (word1[i - 1] == word2[j - 1]) {
                tab2d[i][j] = tab2d[i - 1][j - 1]
            } else {
                val replace = 1 + tab2d[i - 1][j - 1]
                val delete = 1 + tab2d[i - 1][j]
                val insert = 1 + tab2d[i][j - 1]
                tab2d[i][j] = minOf(delete, replace, insert)
            }
        }
    }

    return tab2d[n][m]
}

// Step 4: space optimized tabulation
// Time Complexity: O(m * n), where m and n are the lengths of the two strings
// Space Complexity: O(m)
fun minDistanceSpaceOptimized(
    word1: String, word2: String
): Int {
    val n = word1.length
    val m = word2.length
    val prev = IntArray(m + 1)
    val curr = IntArray(m + 1)

    for (j in 0..m) {
        prev[j] = j
    }

    for (i in 1..n) {
        curr[0] = i
        for (j in 1..m) {
            if (word1[i - 1] == word2[j - 1]) {
                curr[j] = prev[j - 1]
            } else {
                val replace = 1 + prev[j - 1]
                val delete = 1 + prev[j]
                val insert = 1 + curr[j - 1]
                curr[j] = minOf(delete, replace, insert)
            }
        }
        prev.indices.forEach { j -> prev[j] = curr[j] }
    }

    return prev[m]
}
