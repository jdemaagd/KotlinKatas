package com.kryptopass.katas.data_structures.m8

import kotlin.math.sqrt
import kotlin.collections.mapIndexedNotNull

fun main() {
    // (1..100).count { it.isPrime }.also(::println)

    getPrimesUpTo(100).also(::println)
}

val Int.isPrime: Boolean
    get() {
        for (i in 2..this / 2) {
            if (this % i == 0) return false
        }
        return true
    }

fun getPrimesUpTo(
    n: Int
): List<Int> {
    if (n < 2) return emptyList()

    // Initialize a boolean array where index represents the number
    val isPrime = BooleanArray(n + 1) { true }
    isPrime[0] = false
    isPrime[1] = false

    for (i in 2..sqrt(n.toDouble()).toInt()) {
        if (isPrime[i]) {
            for (j in i * i..n step i) {
                isPrime[j] = false
            }
        }
    }

    var primes = mutableListOf<Int>()

    // Option 1
    // primes = isPrime.withIndex().filter { it.value }.map { it.index }.toMutableList()

    // Option 2
//    isPrime.forEachIndexed { index, value ->
//        if (value) primes.add(index)
//    }

    // Option 3
//    for (index in isPrime.indices) {
//        if (isPrime[index]) {
//            primes.add(index)
//        }
//    }

    // Option 4
    // primes = isPrime.indices.mapNotNull { index -> if (isPrime[index]) index else null }.toMutableList()

    // Option 5
    primes = isPrime.foldIndexed(mutableListOf<Int>()) { index, acc, value ->
        if (value) acc.add(index)
        acc
    }

    return primes

    // primes = isPrime.filterIndexed { index, value -> value }.map { it.index }
    // primes = isPrime.mapIndexedNotNull { index, prime -> if (prime) index else null }
}