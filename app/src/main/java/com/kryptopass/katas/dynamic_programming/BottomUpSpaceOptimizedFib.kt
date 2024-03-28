package com.kryptopass.katas.dynamic_programming

fun main() {
    println(bottomUpSpaceOptimizedFib(1))
    println(bottomUpSpaceOptimizedFib(2))
    println(bottomUpSpaceOptimizedFib(3))
    println(bottomUpSpaceOptimizedFib(4))
    println(bottomUpSpaceOptimizedFib(5))
    println(bottomUpSpaceOptimizedFib(6))
    println(bottomUpSpaceOptimizedFib(7))
    println(bottomUpSpaceOptimizedFib(8))
    println(bottomUpSpaceOptimizedFib(9))
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
fun bottomUpSpaceOptimizedFib(n: Int): Int {
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