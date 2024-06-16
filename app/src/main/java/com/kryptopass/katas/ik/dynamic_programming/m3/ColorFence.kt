package com.kryptopass.katas.dynamic_programming.m3

import com.kryptopass.katas.dynamic_programming.MOD
import com.kryptopass.katas.dynamic_programming.TABLE2D

fun main() {
    println(colorFence(3, 2))
    println(colorFence(3, 7))
}

/*
Color the Fence
There is a fence with `n` posts and there are `k` different colors
Find number of ways fence can be painted, where
    - every post must be painted with exactly one color
    - three or more consecutive posts are not painted with same color
The answer can be very large (return answer modulo 10^9 + 7)

Example One
{
    "n": 3,
    "k": 2
}
Output: 6
{
    Color1-Color1-Color2, Color1-Color2-Color1, Color1-Color2-Color2, Color2-Color1-Color1,
    Color2-Color1-Color2, Color2-Color2-Color1
}.
These are the possible ways of coloring the fence

Example Two
{
    "n": 3,
    "k": 7
}
Output: 336

Constraints:
1 <= n <= 10^5
1 <= k <= 10^9
 */

/*
    Asymptotic complexity in terms of `n`:
    Time: O(n)
    Auxiliary space: O(1)
    Total space: O(1)
 */
fun colorFence(
    n: Int, k: Int
): Int {
    TABLE2D = ArrayList(2)
    for (i in 0 until 2) {
        TABLE2D.add(ArrayList(3))
        for (j in 0 until 3)
            TABLE2D[i].add(0)
    }

    TABLE2D[0][0] = 0
    TABLE2D[0][1] = k
    TABLE2D[0][2] = k

    for (i in 2..n) {
        TABLE2D[1][0] = TABLE2D[0][2]
        TABLE2D[1][1] = ((k - 1).toLong() * TABLE2D[0][2].toLong() % MOD).toInt()
        TABLE2D[1][2] = (TABLE2D[0][1] + TABLE2D[1][1]) % MOD

        TABLE2D[0][0] = TABLE2D[1][0]
        TABLE2D[0][1] = TABLE2D[1][1]
        TABLE2D[0][2] = TABLE2D[1][2]
    }

    return TABLE2D[0][2]
}