package com.kryptopass.katas.dynamic_programming.m1

import com.kryptopass.katas.dynamic_programming.MOD

fun main() {
    println(uniquePathsRecursive(3, 2))
    println(uniquePathsRecursive(4, 1))
}

/*
Unique Paths
Given a grid of size n x m and a robot initially staying at the top-left position,
return the number of unique paths for the robot to reach the bottom-right corner of the grid.
The robot is allowed to move either down or right at any point in time.

Example One
{
    "n": 3,
    "m": 2
}
Output: 3
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
Right -> Down -> Down
Down -> Down -> Right
Down -> Right -> Down

Example Two
{
    "n": 4,
    "m": 1
}
Output: 1
From the top-left corner, there is only one way to reach bottom-right corner:
Down -> Down -> Down

Notes
Return the answer modulo 10^9 + 7.

Constraints:
1 <= n, m <= 10^3
 */

/*
    Asymptotic complexity in terms of the size of the grid, `n` * `m`:
    Time: O(n * m)
    Auxiliary space: O(n * m)
    Total space: O(n * m)
 */
fun uniquePathsRecursive(
    n: Int, m: Int
): Int {
    val dp = Array(n + 1) { Array(m + 1) { -1 } }
    return uniquePathsRecursiveHelper(n, m, dp)
}

fun uniquePathsRecursiveHelper(
    n: Int, m: Int, dp: Array<Array<Int>>
): Int {
    if (dp[n][m] != -1) return dp[n][m]

    val result: Int = if (n == 1 && m == 1) {
        1
    } else if (n == 1) {
        uniquePathsRecursiveHelper(n, m - 1, dp)
    } else if (m == 1) {
        uniquePathsRecursiveHelper(n - 1, m, dp)
    } else {
        (uniquePathsRecursiveHelper(n, m - 1, dp) % MOD +
                uniquePathsRecursiveHelper(n - 1, m, dp) % MOD) % MOD
    }

    dp[n][m] = (result % MOD)

    return dp[n][m]
}