package com.kryptopass.dsa.dp

/*
You are climbing a staircase
It takes n steps to reach the top
Each time you can either climb 1 or 2 steps.
In how many distinct ways can you climb to the top?

Identify DP problem:
Choice: at each step, we can take 1 or 2 steps
Notice overlapping subproblems
Application of Fibonacci
 */
fun main() {
    climbStairsRecursive(2).also(::println) // 2
    climbStairsRecursive(3).also(::println) // 3
    climbStairsRecursive(4).also(::println) // 5
    climbStairsMemo(5).also(::println) // 8
    climbStairsMemo(6).also(::println) // 13
    climbStairsMemo(7).also(::println) // 21
    climbStairsTab(8).also(::println) // 34
    climbStairsTab(9).also(::println) // 55
    climbStairsSpaceOptimized(10).also(::println) // 89
    climbStairsSpaceOptimized(11).also(::println) // 144
    climbStairs(12).also(::println) // 233
    climbStairs(13).also(::println) // 377
}

// NOTE: Time/Space Complexity is same as Fibonacci Sequence

// Step 1: start with recursive solution
fun climbStairsRecursive(
    n: Int
): Int {
    if (n < 3)
        return n

    return climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2)
}

// Step 2: memoization/top-down approach
fun climbStairsMemo(
    n: Int
): Int {
    val memo = mutableMapOf<Int, Int>()

    memo[0] = 0
    memo[1] = 1
    memo[2] = 2

    fun helper(n: Int): Int {
        if (n in memo)
            return memo[n]!!

        memo[n] = helper(n - 1) + helper(n - 2)
        return memo[n]!!
    }

    return helper(n)
}

// Step 3: tabulation/bottom-up approach
fun climbStairsTab(
    n: Int
): Int {
    if (n == 0 || n == 1)
        return 1

    val dp = IntArray(n + 1)

    dp[0] = 1
    dp[1] = 1

    for (i in 2..n)
        dp[i] = dp[i - 1] + dp[i - 2]

    return dp[n]
}

// Step 4: space optimized tabulation
fun climbStairsSpaceOptimized(
    n: Int
): Int {
    if (n == 0 || n == 1)
        return 1

    var curr = 1
    var prev = 1

    for (i in 2..n) {
        val nxt = curr + prev
        prev = curr
        curr = nxt
    }

    return curr
}

fun climbStairs(
    n: Int
): Int {
    if (n < 3)
        return n

    fun helper(first: Int, second: Int, n2: Int, curr: Int): Int {
        val nxt = first + second
        return if (curr == n2) nxt else helper(second, nxt, n2, curr + 1)
    }

    return helper(1, 2, n, 3)
}