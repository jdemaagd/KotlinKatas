package com.kryptopass.katas.dynamic_programming.m1

fun main() {
    println(jumpWaysTopDown(3))
    println(jumpWaysTopDown(4))
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
fun jumpWaysTopDown(
    n: Int
): Long {
    val memo = MutableList(n + 1) { -1L }
    return countWays(n, memo)
}

fun countWays(
    n: Int, memo: MutableList<Long>
): Long {
    if (n == 0 || n == 1) return 1L

    if (memo[n] != -1L) return memo[n]

    memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo)
    return memo[n]
}
