package com.kryptopass.katas.dsa.d02

import kotlin.math.pow

fun main() {
    println(kthSymbol(3, 3))
    println(kthSymbol(4, 7))
}

// 0
// 0 1
// 0 1 1 0
// 0 1 1 0 1 0 0 1
// Time complexity: O(n)
// Space complexity: O(n)
fun kthSymbol(n: Int, k: Int): Int {
    if (n == 1)
        return 0

    val length = 2.0.pow(n - 1).toInt()
    val mid = length / 2
    return if (k <= mid) {
        kthSymbol(n - 1, k)
    } else {
        kthSymbol(n - 1, k - mid).let { 1 - it }
    }
}
