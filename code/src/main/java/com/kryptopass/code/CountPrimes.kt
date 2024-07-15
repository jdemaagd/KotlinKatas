package com.kryptopass.code

import kotlin.math.sqrt

/*
Count the number of prime numbers less than a non-negative number, n.

Example 1:
Input: n = 10
Output: 4

Example 2:
Input: n = 0
Output: 0

Example 3:
Input: n = 1
Output: 0

Constraints:
0 <= n <= 5 * 10^6
 */
fun main() {
    countPrimes(10).also { println(it) }
    countPrimes(0).also { println(it) }
    countPrimes(1).also { println(it) }
    countPrimes(100).also { println(it) }
}

fun countPrimes(n: Int): Int {
    if (n < 2) return 0

    // set all numbers as prime initially
    val isPrime = BooleanArray(n) { true }
    isPrime[0] = false
    isPrime[1] = false

    for (i in 2..sqrt(n.toDouble()).toInt()) {
        if (isPrime[i]) {
            // if there is any multiple of i then it is not prime
            for (j in i * i until n step i) {
                isPrime[j] = false
            }
        }
    }

    return isPrime.count { it }
}