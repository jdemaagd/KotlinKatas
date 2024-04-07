package com.kryptopass.katas.dynamic_programming

fun main() {
    println(fibTopDown(1))
    println(fibTopDown(2))
    println(fibTopDown(3))
    println(fibTopDown(4))
    println(fibTopDown(5))
    println(fibTopDown(6))
    println(fibTopDown(7))
    println(fibTopDown(8))
    println(fibTopDown(9))
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

fun fibTopDown(
    n: Int
): Int {
    if (memo.containsKey(n)) return memo[n]!!

    if (n == 0 || n == 1) return n

    memo[n] = fibTopDown(n - 1) + fibTopDown(n - 2)
    return memo[n]!!
}