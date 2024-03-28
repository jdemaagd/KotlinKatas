package com.kryptopass.kotlinkatas.dynamic_programming

fun main() {
    println(topDownFib(1))
    println(topDownFib(2))
    println(topDownFib(3))
    println(topDownFib(4))
    println(topDownFib(5))
    println(topDownFib(6))
    println(topDownFib(7))
    println(topDownFib(8))
    println(topDownFib(9))
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
    Auxiliary space: O(n)
    Total space: O(n)
 */
val memo = HashMap<Int, Int>()

fun topDownFib(n: Int): Int {
    if (memo.containsKey(n)) return memo[n]!!

    if (n == 0 || n == 1) return n

    memo[n] = topDownFib(n - 1) + topDownFib(n - 2)
    return memo[n]!!
}