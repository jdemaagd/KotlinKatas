package com.kryptopass.katas.dsa.sorting

/*
Merge Sort (Stable)
Given an array of integers, write a function that will take this array as input and
return the sorted array using Merge sort.

Divide & Conquer Algorithm:
Divide: split array in half until size of array is 1
Conquer: merge sorted arrays

Stable Sorting Algorithm:
Initial relative ordering is maintained between duplicates
 */
fun main() {
    mergeSort(intArrayOf(1, 2, 8, 3, 7)).also { println(it.joinToString(", ")) }
}

// Time Complexity: O(n log n),
//     in each level visit n elements -> levels * n
//     num of levels -> 2^0 + 2^1 + 2^2 + ... + 2^k
//     n / 2^x, n / 2^x = 1, n = 2^x, x = log n
// Space Complexity: O(log n + n) -> O(n)
fun mergeSort(
    nums: IntArray
): IntArray {
    if (nums.size <= 1) {
        return nums
    }

    val mid = nums.size / 2
    val left = nums.copyOfRange(0, mid)
    val right = nums.copyOfRange(mid, nums.size)

    val leftSorted = mergeSort(left)
    val rightSorted = mergeSort(right)

    return merge(leftSorted, rightSorted)
}

// Time Complexity: O(n + m)
// Space Complexity: O(n + m)
fun merge(
    left: IntArray,
    right: IntArray
): IntArray {
    val result = IntArray(left.size + right.size)
    var leftPointer = 0
    var rightPointer = 0
    var resultPointer = 0

    while (leftPointer < left.size && rightPointer < right.size) {
        if (left[leftPointer] < right[rightPointer]) {
            result[resultPointer++] = left[leftPointer++]
        } else {
            result[resultPointer++] = right[rightPointer++]
        }
    }

    while (leftPointer < left.size) {
        result[resultPointer++] = left[leftPointer++]
    }

    while (rightPointer < right.size) {
        result[resultPointer++] = right[rightPointer++]
    }

    return result
}