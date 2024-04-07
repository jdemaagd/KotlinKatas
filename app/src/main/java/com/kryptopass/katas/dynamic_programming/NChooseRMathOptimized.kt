package com.kryptopass.katas.dynamic_programming

fun main() {
    println(nChooseRMathOptimized(5, 3))
    println(nChooseRMathOptimized(3, 5))
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
    Asymptotic complexity in terms of, `n`:
    Time: O(n)
    Auxiliary space: O(1)
    Total space: O(1)
 */
fun nChooseRMathOptimized(n: Int, r: Int): Int {
    if (r > n) return 0
    if (r == n || r == 0) return 1

    var facN = 1
    var facR = 1
    var facNR = 1
    var factorial = 1

    for (i in 1..n) {
        factorial = ((factorial.toLong() * i) % MOD).toInt()
        if (i == n) facN = factorial
        if (i == r) facR = factorial
        if (i == n - r) facNR = factorial
    }

    val invFacR = exponentiate(facR, MOD - 2)
    val invFacNR = exponentiate(facNR, MOD - 2)
    val result = (facN.toLong() * ((invFacR.toLong() * invFacNR) % MOD)) % MOD

    return result.toInt()
}

fun exponentiate(v: Int, p: Int): Int {
    var ret = 1
    var tempV = v.toLong()
    var tempP = p

    while (tempP != 0) {
        if (tempP % 2 == 1) ret = ((ret.toLong() * tempV) % MOD).toInt()

        tempV = (tempV * tempV) % MOD
        tempP /= 2
    }

    return ret
}