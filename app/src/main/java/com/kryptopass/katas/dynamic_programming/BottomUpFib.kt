package com.kryptopass.katas.dynamic_programming

fun main() {
    println(bottomUpFib(1))
    println(bottomUpFib(2))
    println(bottomUpFib(3))
    println(bottomUpFib(4))
    println(bottomUpFib(5))
    println(bottomUpFib(6))
    println(bottomUpFib(7))
    println(bottomUpFib(8))
    println(bottomUpFib(9))
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
fun bottomUpFib(n: Int): Int {
    val table = IntArray(n + 1)
    table[0] = 0
    table[1] = 1

    for (i in 2..n)
        table[i] = table[i - 1] + table[i - 2]

    return table[n]
}