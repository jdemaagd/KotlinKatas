package com.kryptopass.dsa.sorting

/*
Bubble Sort
Given an array of integers, write a function that will take this array as input and
return the sorted array using Bubble sort.
First pass: largest element bubbles up to the end of the array
Second pass: second-largest element bubbles up to the second last position
Continue this process until the array is sorted
 */
fun main() {
    bubbleSort(intArrayOf(1, 2, 8, 3, 7)).also { println(it.joinToString(", ")) }
    bubbleSort2(intArrayOf(1, 2, 8, 3, 7)).also { println(it.joinToString(", ")) }
}

// Time Complexity: O(n^2)
// Space Complexity: O(1)
fun bubbleSort(
    arr: IntArray
): IntArray {
    val n = arr.size

    for (i in 0 until n) {
        for (j in 0 until n - i - 1) {
            if (arr[j] > arr[j + 1]) {
                arr[j] = arr[j + 1].also { arr[j + 1] = arr[j] }
            }
        }
    }

    return arr
}

fun bubbleSort2(
    arr: IntArray
): IntArray {
    var isSorted = false
    var trackPass = 0

    while (!isSorted) {
        isSorted = true
        for (i in 0 until arr.size - 1 - trackPass) {
            if (arr[i] > arr[i + 1]) {
                arr[i] = arr[i + 1].also { arr[i + 1] = arr[i] }
                isSorted = false
            }
        }
        trackPass++
    }

    return arr
}