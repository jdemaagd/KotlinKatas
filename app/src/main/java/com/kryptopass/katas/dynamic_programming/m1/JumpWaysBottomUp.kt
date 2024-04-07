package com.kryptopass.katas.dynamic_programming.m1

import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    println(jumpWaysBottomUp(3))
    println(jumpWaysBottomUp(4))
}

/*
There is a one-dimensional axis. In one turn, you can take a jump of length 1 or 2.
Find the total number of distinct ways using which you can reach from 0th coordinate to n-th coordinate?

Example One
{
    "n": 3
}
Output: 3
There are 3 distinct ways in which you can move from 0 to 3.
1. 1 length jump + 1 length jump + 1 length jump.
2. 1 length jump + 2 length jump.
3. 2 length jump + 1 length jump.

Example Two
{
    "n": 4
}
Output: 5 -> There are 5 distinct ways in which you can move from 0 to 4.

Constraints
1 <= n <= 70
 */

/*
    Asymptotic complexity in terms of input number, `n`:
    Time: O(n)
    Auxiliary space: O(n)
    Total space: O(n)
 */
fun jumpWaysBottomUp(
    n: Int
): Long {
    val table = LongArray(n + 1)
    table[0] = 1
    table[1] = 1

    for (i in 2..n)
        table[i] = table[i - 1] + table[i - 2]

    return table[n]
}

/*
    Asymptotic complexity in terms of input number, `n`:
    Time: O(n)
    Auxiliary space: O(1)
    Total space: O(1)
 */
fun jumpWaysMemoizationSpaceOptimized(
    n: Int
): Long {
    val dp = LongArray(3)
    dp[0] = 1
    dp[1] = 1

    for (i in 2..n)
        dp[i % 3] = dp[(i - 1) % 3] + dp[(i - 2) % 3]

    return dp[n % 3]
}

/*
    Asymptotic complexity in terms of input number, `n`:
    Time: O(log(n))
    Auxiliary space: O(1)
    Total space: O(1)
 */
fun jumpWaysClosedForm(
    n: Int
): Long {
    val sqrt5 = sqrt(5.0)

    val fibN = ((1 + sqrt5) / 2).pow(n + 1) - ((1 - sqrt5) / 2).pow(n + 1)

    return (fibN / sqrt5).toLong()
}