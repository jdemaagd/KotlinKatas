package com.kryptopass.hack.warmup

/*
There is a large pile of socks that must be paired by color.
Given an array of integers representing the color of each sock,
determine how many pairs of socks with matching colors there are.

Example n = 7, ar = [1, 2, 1, 2, 1, 3, 2]
There is one pair of color 1 and one of color 2.
There are three odd socks left, one of each color.
The number of pairs is 2.

Function Description
Complete the sockMerchant function in the editor below.
sockMerchant has the following parameter(s):
    - int n: the number of socks in the pile
    - int ar[n]: the colors of each sock

Returns
  - int: the number of pairs

Input Format
The first line contains an integer n, the number of socks represented in ar.
The second line contains n space-separated integers, ar[i], the colors of the socks in the pile.

Constraints
    - 1 <= n <= 100
    - 1 <= ar[i] <= 100 where 0 <= i < n

Sample Input
n = 9
ar = [10 20 20 10 10 30 50 10 20]

Sample Output
3
 */
fun main() {
    val n = 9
    val ar = arrayOf(10, 20, 20, 10, 10, 30, 50, 10, 20)
    sockMerchant(n, ar).also(::println)
    sockMerchant2(n, ar).also(::println)
}

// Time Complexity: O(n), where `n` is length of `ar`
// Space Complexity: O(n), where `n` is length of `ar` and all `n` socks are different
fun sockMerchant(
    n: Int,
    ar: Array<Int>
): Int {
    val unmatchedSocks = mutableSetOf<Int>()
    var pairs = 0

    for (color in ar) {
        if (unmatchedSocks.contains(color)) {
            pairs++
            unmatchedSocks.remove(color)
        } else {
            unmatchedSocks.add(color)
        }
    }

    return pairs
}

// Time Complexity: O(n), where `n` is length of `ar`
// Space Complexity: O(n), where `n` is length of `ar`
fun sockMerchant2(
    n: Int,
    ar: Array<Int>
): Int {
    val colorToCount = mutableMapOf<Int, Int>()
    var pairs = 0

    for (color in ar) {
        colorToCount[color] = colorToCount.getOrDefault(color, 0) + 1
    }

    for (count in colorToCount.values) {
        pairs += count / 2
    }

    return pairs
}