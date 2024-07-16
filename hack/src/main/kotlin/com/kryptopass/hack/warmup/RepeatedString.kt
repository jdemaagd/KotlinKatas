package com.kryptopass.hack.warmup

/*
There is a string, `s`, of lowercase English letters that is repeated infinitely many times.
Given an integer, `n`, find and print the number of letter `a`'s in the first `n` letters of the infinite string.

Example
s = `abcac`
n = 10
The substring we consider is `abcacabcac`, the first `10` characters of the infinite string.
There are `4` occurrences of `a` in the substring.
 */
fun main() {
    repeatedString("abcac", 10).also(::println) // 4
}

// Time Complexity: O(m), where m is the length of the string
// Space Complexity: O(m)
fun repeatedString(
    s: String,
    n: Long
): Long {
    val count = s.count { it == 'a' }
    val multiples = n / s.length
    val left = n % s.length
    val leftCount = s.take(left.toInt()).count { it == 'a' }

    return multiples * count + leftCount
}