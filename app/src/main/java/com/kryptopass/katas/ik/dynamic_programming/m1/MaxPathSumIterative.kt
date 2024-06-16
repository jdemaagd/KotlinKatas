package com.kryptopass.katas.dynamic_programming.m1

fun main() {
    println(
        maxPathSumIterativeSpaceOptimized(
            arrayListOf(arrayListOf(4, 5, 8), arrayListOf(3, 6, 4), arrayListOf(2, 4, 7))
        )
    )

    println(
        maxPathSumIterativeSpaceOptimized(
            arrayListOf(arrayListOf(1, -4, 3), arrayListOf(4, -2, 2))
        )
    )
}

/*
Maximum Path Sum
Given a two-dimensional grid of numbers.
Find a path from top-left corner to bottom-right corner,
which maximizes the sum of all numbers along its path.
You can only move either down or right from your current position.

Example One
{
    "grid": [
        [4, 5, 8],
        [3, 6, 4],
        [2, 4, 7]
    ]
}
Output: 28 -> The path 4 -> 5 -> 8 -> 4 -> 7 maximizes the sum.
Every other path from top left to bottom right has sum less than 28.

Example Two
{
    "grid": [
        [1, -4, 3],
        [4, -2, 2]
    ]
}
Output: 5 -> The path 1 -> 4 -> -2 -> 2 maximizes the sum.
Note that there can be negative values in the grid as well.

Constraints:
1 <= number of rows <= 300
1 <= number of columns <= 300
-10^4 <= numbers in the grid <= 10^4
 */

/*
    Asymptotic complexity in terms of the number of row, `n` and the number of columns, `m`:
    Time: O(n * m)
    Auxiliary space: O(n * m)
    Total space: O(n * m)
 */
fun maxPathSumIterative(
    grid: ArrayList<ArrayList<Int>>
): Int {
    val n = grid.size
    val m = grid[0].size
    val dp = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (i == 0 && j == 0) {
                dp[i][j] = grid[i][j]
            } else if (j == 0) {
                dp[i][j] = dp[i - 1][j] + grid[i][j]
            } else if (i == 0) {
                dp[i][j] = dp[i][j - 1] + grid[i][j]
            } else {
                dp[i][j] = maxOf(dp[i][j - 1], dp[i - 1][j]) + grid[i][j]
            }
        }
    }

    return dp[n - 1][m - 1]
}

/*
    Asymptotic complexity in terms of the number of row, `n` and the number of columns, `m`:
    Time: O(n * m)
    Auxiliary space: O(m)
    Total space: O(n * m)
 */
fun maxPathSumIterativeSpaceOptimized(
    grid: ArrayList<ArrayList<Int>>
): Int {
    val n = grid.size
    val m = grid[0].size
    val prevRow = IntArray(m)
    val curRow = IntArray(m)

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (i == 0 && j == 0) {
                curRow[j] = grid[i][j]
            } else if (j == 0) {
                curRow[j] = prevRow[j] + grid[i][j]
            } else if (i == 0) {
                curRow[j] = curRow[j - 1] + grid[i][j]
            } else {
                curRow[j] = maxOf(curRow[j - 1], prevRow[j]) + grid[i][j]
            }
        }

        for (j in 0 until m)
            prevRow[j] = curRow[j]
    }

    return curRow[m - 1]
}