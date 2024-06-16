package com.kryptopass.katas.dynamic_programming.m2

fun main() {
    println(
        uniquePathsWithObstacles(
            arrayListOf(
                arrayListOf(0, 0, 0), arrayListOf(0, 1, 0), arrayListOf(0, 0, 0)
            )
        )
    )

    println(
        uniquePathsWithObstacles(
            arrayListOf(arrayListOf(0, 1), arrayListOf(0, 0))
        )
    )
}

/*
Unique Paths II - https://leetcode.com/problems/unique-paths-ii/
A robot is located in the top-left corner of an m x n grid (marked 'Start' in the diagram below)
The robot can only move either down or right at any point in time
The robot is trying to reach the bottom-right corner of the grid
(marked 'Finish' in the diagram below)
Now consider if some obstacles are added to the grids
How many unique paths would there be?
An obstacle and space is marked as 1 and 0 respectively in the grid

Example 1:
Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above
There are two ways to reach the bottom-right corner
    1. Right -> Right -> Down -> Down
    2. Down -> Down -> Right -> Right

Example 2:
Input: obstacleGrid = [[0,1],[0,0]]
Output: 1

Note: m and n will be at most 100

1. f(m - 1, n - 1) = f(m - 2, n - 1) + f(m - 1, n - 2)
2. f(i, j) = f(i - 1, j) + f(i, j - 1)
   f(i - 1, j) = f(i - 2, j) + f(i - 1, j - 1)
   f(i, j - 1) = f(i - 1, j - 1) + f(i, j - 2)
   we see repeated sub-problems, so we can use DP, realizing we have an optimal substructure
3. Tabulation: 2 parameters -> 2D table of size m rows and n columns
   base cases

Constraints:
m == obstacleGrid.length
n == obstacleGrid[i].length
1 <= m, n <= 100
obstacleGrid[i][j] is 0 or 1
 */
fun uniquePathsWithObstacles(
    grid: ArrayList<ArrayList<Int>>
): Int {
    val n = grid.size
    val m = grid[0].size
    val table = Array(n) { IntArray(m) }

    // base cases
    table[0][0] = 1                                                        // top left corner cell
    for (col in 1 until m)                                            // first row
        table[0][col] = if (grid[0][col] == 1) 0 else table[0][col - 1]
    for (row in 1 until n)                                            // first column
        table[row][0] = if (grid[row][0] == 1) 0 else table[row - 1][0]

    // recursive/iterative cases
    for (row in 1 until n)
        for (col in 1 until m)
            table[row][col] =
                if (grid[row][col] == 1) 0 else table[row - 1][col] + table[row][col - 1]

    return table[n - 1][m - 1]
}