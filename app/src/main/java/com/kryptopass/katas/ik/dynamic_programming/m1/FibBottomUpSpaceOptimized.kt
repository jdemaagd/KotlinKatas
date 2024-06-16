package com.kryptopass.katas.dynamic_programming.m1

fun main() {
    println(fibBottomUpSpaceOptimized(1))
    println(fibBottomUpSpaceOptimized(2))
    println(fibBottomUpSpaceOptimized(3))
    println(fibBottomUpSpaceOptimized(4))
    println(fibBottomUpSpaceOptimized(5))
    println(fibBottomUpSpaceOptimized(6))
    println(fibBottomUpSpaceOptimized(7))
    println(fibBottomUpSpaceOptimized(8))
    println(fibBottomUpSpaceOptimized(9))
}

/*
Fibonacci Number
Given a number n, find the n-th Fibonacci Number.

Example
{
    "n": 2
}
Output: 1 -> 2nd Fibonacci Number is the sum of the 0th and 1st Fibonacci Number = 0 + 1 = 1.

Notes
In mathematics, the Fibonacci numbers, commonly denoted Fn, form a sequence,
called the Fibonacci sequence, such that each number is the sum of the two preceding ones,
starting from 0 and 1. That is, F(0) = 0, F(1) = 1 and F(n) = F(n − 1) + F(n − 2) for n > 1.

Constraints:
0 <= n <= 46
 */

/*
    Asymptotic complexity in terms of input integer, `n`:
    Time: O(n)
    Auxiliary space: O(1)
    Total space: O(1)
 */
fun fibBottomUpSpaceOptimized(
    n: Int
): Int {
    if (n == 0) return 0

    var prevPrev = 0
    var prev = 1

    for (i in 2..n) {
        val curr = prevPrev + prev
        prevPrev = prev
        prev = curr
    }

    return prev
}