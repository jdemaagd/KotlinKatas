package com.kryptopass.katas.dynamic_programming

fun main() {
    println(nChooseRRecursive(5, 3))
    println(nChooseRRecursive(3, 5))
}

/*
N Choose R
Consider you have n distinct elements,
find the number of ways through which you can choose exactly r number of elements out of those.

Example One
{
    "n": 5,
    "r": 3
}
Output: 10
There is a set of 5 elements {1, 2, 3, 4, 5}. You need to pick a subset of size 3.
Eligible subsets are {1, 2, 3}, {1, 2, 4}, {1, 2, 5}, {1, 3, 4}, {1, 3, 5}, {1, 4, 5}, {2, 3, 4},
{2, 3, 5}, {2, 4, 5}, {3, 4, 5}. There are 10 subsets of size 3.

Example Two
{
    "n": 3,
    "r": 5
}
Output: 0
There is a set of 3 elements {1, 2, 3}. You need to pick a subset of size 5.
Which is not possible, that's why the answer is 0.

Notes
Here the answer can be very big, find it modulo 10^9 + 7.

Constraints:
0 <= n, r <= 1000
 */

/*
    Asymptotic complexity in terms of, `n` and, `r`:
    * Time: O(n * r).
    * Auxiliary space: O(n * r).
    * Total space: O(n * r).
 */
fun nChooseRRecursive(n: Int, r: Int): Int {
    //com.kryptopass.dp.getTABLE2D = Array(n + 1) { Array(r + 1) { -1 } }
    TABLE2D = ArrayList(n + 1)
    for (i in 0..n) TABLE2D.add(ArrayList(r + 1))
    for (i in 0..n) for (j in 0..r) TABLE2D[i].add(-1)

    return nChooseRRecursiveHelper(n, r)
}

fun nChooseRRecursiveHelper(n: Int, r: Int): Int {
    if (r > n) return 0
    if (n == r || r == 0) return 1

    if (TABLE2D[n][r] != -1) return TABLE2D[n][r]

    TABLE2D[n][r] = (nChooseRRecursiveHelper(n - 1, r) + nChooseRRecursiveHelper(n - 1, r - 1)) % MOD

    return TABLE2D[n][r]
}