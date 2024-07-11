package com.kryptopass.katas.dsa.sorting

/*
Insertion Sort (Stable)
Given an array of integers, write a function that will take this array as input and
return the sorted array using Insertion sort.
Divide array into 2 parts, sorted & non-sorted
Take elements from non-sorted part one-by-one and insert into sorted part

Stable Sorting Algorithm:
Initial relative ordering is maintained between duplicates
 */
fun main() {
    insertionSort(intArrayOf(1, 2, 8, 3, 7)).also { println(it.toList()) }    // [1, 2, 3, 7, 8]
    insertionSort(intArrayOf(5, 4, 3, 2, 1)).also { println(it.toList()) }    // [1, 2, 3, 4, 5]
}

// Time Complexity: O(n^2)
// Space Complexity: O(1)
fun insertionSort(
    arr: IntArray
): IntArray {
    for (i in 1 until arr.size) {
        val key = arr[i]
        var j = i - 1

        while (j >= 0 && key < arr[j]) {
            arr[j + 1] = arr[j]
            j--
        }

        arr[j + 1] = key
    }

    return arr
}