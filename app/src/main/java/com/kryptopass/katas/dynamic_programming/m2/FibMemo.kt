package com.kryptopass.katas.dynamic_programming.m2

fun main() {
    for (i in 0..11) println(fibMemo(i))
}

val memo = HashMap<Int, Int>()

fun fibMemo(n: Int): Int {
    if (memo.containsKey(n)) return memo[n]!!

    if (n == 0 || n == 1) return n

    memo[n] = fibMemo(n - 1) + fibMemo(n - 2)

    return memo[n]!!
}