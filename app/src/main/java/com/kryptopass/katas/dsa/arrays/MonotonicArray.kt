package com.kryptopass.katas.dsa.arrays

/*
An array is monotonic if it is either monotone increasing or monotone decreasing.
An array is monotone increasing if all its elements from left to right are non-decreasing.
An array is monotone decreasing if all its elements from left to right are non-increasing.
Given an integer array return true if the given array is monotonic, or false otherwise.
 */
fun main() {
    monotonicArray(intArrayOf(1, 2, 2, 3)).also { println(it) }     // true
    monotonicArray(intArrayOf(6, 5, 4, 4)).also { println(it) }     // true
    monotonicArray(intArrayOf(1, 3, 2)).also { println(it) }        // false
    monotonicArray(intArrayOf()).also { println(it) }               // true
    monotonicArray(intArrayOf(11)).also { println(it) }             // true
    monotonicArray(intArrayOf(1, 1, 1, 1)).also { println(it) }     // true
}

// Time complexity: O(n)
// Space complexity: O(1)
fun monotonicArray(
    arr: IntArray
): Boolean {
    val n = arr.size
    if (n == 0 || n == 1)
        return true

    val first = arr[0]
    val last = arr[n - 1]

    if (first > last) {                     // monotonic decreasing or not monotonic
        for (k in 0 until n - 1)
            if (arr[k] < arr[k + 1])
                return false
    } else if (first < last) {              // monotonic increasing or not monotonic
        for (k in 0 until n - 1)
            if (arr[k] > arr[k + 1])
                return false
    } else {                                // monotonic, all values are equal
        for (k in 0 until n - 1)
            if (arr[k] != arr[k + 1])
                return false
    }

    return true
}