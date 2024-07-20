package com.kryptopass.dsa.dp

/*
The Tribonacci sequence Tn is defined as follows:
T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
Given n, return the value of Tn.
 */
fun main() {
    tribRecursive(4).also { println(it) } // 4
    tribRecursive(25).also { println(it) } // 1389537
    println()
    tribMemo(4).also { println(it) } // 4
    tribMemo(25).also { println(it) } // 1389537
    println()
    tribTab(4).also { println(it) } // 4
    tribTab(25).also { println(it) } // 1389537
    println()
    tribTabSpaceOptimized(4).also { println(it) } // 4
    tribTabSpaceOptimized(25).also { println(it) } // 1389537
}

// Step 1: recursive solution
// Time Complexity: O(3^n)
// Space Complexity: O(n)
fun tribRecursive(
    n: Int
): Int {
    if (n == 0)
        return 0

    if (n == 1 || n == 2)
        return 1

    return tribRecursive(n - 1) + tribRecursive(n - 2) + tribRecursive(n - 3)
}

// Step 2: memoization/top-down DP approach
// Time Complexity: O(n)
// Space Complexity: O(n)
fun tribMemo(
    n: Int
): Int {
    val memo = IntArray(n + 1) { -1 }

    fun helper(n2: Int): Int {
        if (n2 == 0)
            return 0

        if (n2 == 1 || n2 == 2)
            return 1

        if (memo[n2] != -1)
            return memo[n2]

        memo[n2] = helper(n2 - 1) + helper(n2 - 2) + helper(n2 - 3)

        return memo[n2]
    }

    return helper(n)
}

// Step 3: tabulation/bottom-up DP approach
// Time Complexity: O(n)
// Space Complexity: O(n)
fun tribTab(
    n: Int
): Int {
    if (n == 0)
        return 0

    if (n == 1 || n == 2)
        return 1

    val dp = IntArray(n + 1)
    dp[0] = 0
    dp[1] = 1
    dp[2] = 1

    for (i in 3..n)
        dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]

    return dp[n]
}

fun tribTabSpaceOptimized(
    n: Int
): Int {
    var zero = 0
    var one = 1
    var two = 1

    if (n <= 1)
        return n

    if (n == 2)
        return two

    for (i in 3..n) {
        val nxt = zero + one + two
        zero = one
        one = two
        two = nxt
    }

    return two
}