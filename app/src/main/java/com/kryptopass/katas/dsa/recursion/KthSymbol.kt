package com.kryptopass.katas.dsa.recursion

import kotlin.math.pow

/*
We build a table of `n` rows (1-indexed).
We start by writing 0 in the 1st row.
Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01,
  and each occurrence of 1 with 10.
For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110.
Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.
 */
fun main() {
    println(kthSymbol(3, 3))    // 1
    println(kthSymbol(4, 7))    // 0
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
