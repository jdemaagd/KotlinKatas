package com.kryptopass.katas.dsa.d01

/*
You are given an array of Integers in which each subsequent value is not less than the previous
  value.
Write a function that takes this array as an input and returns a new array with the squares of
  each number sorted in ascending order.
 */
fun main() {
    bruteForceSquaredArray(intArrayOf(-4, -1, 0, 3, 10)).contentToString().also { println(it) }
    bruteForceSquaredArray(intArrayOf(-7, -3, 2, 3, 11)).contentToString().also { println(it) }

    twoPointerSquaredArray(intArrayOf(1, 2, 3, 4, 5)).contentToString().also { println(it) }
    twoPointerSquaredArray(intArrayOf(-5, -4, -2, 1, 9, 12)).contentToString().also { println(it) }
}

// Time complexity: sort + linear --> O(n) + O(n log n) --> O(n log n)
// Space complexity: O(n)
fun bruteForceSquaredArray(
    arr: IntArray
): IntArray {
    val result = IntArray(arr.size)

    for (i in arr.indices)
        result[i] = arr[i] * arr[i]

    result.sort()

    return result
}

// Time complexity: O(n)
// Space complexity: O(n)
fun twoPointerSquaredArray(
    arr: IntArray
): IntArray {
    val result = IntArray(arr.size)
    var start = 0
    var end = arr.size - 1

    for (k in arr.size - 1 downTo 0) {
        val startSquared = arr[start] * arr[start]
        val endSquared = arr[end] * arr[end]
        if (startSquared > endSquared) {
            result[k] = startSquared
            start++
        } else {
            result[k] = endSquared
            end--
        }
    }

    return result
}