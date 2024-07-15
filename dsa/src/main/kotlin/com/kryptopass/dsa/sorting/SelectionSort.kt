package com.kryptopass.dsa.sorting

/*
Selection Sort
Given an array of integers, write a function that will take this array as input and
return the sorted array using Selection sort.
In each pass, identify the smallest element and put it towards the front
 */
fun main() {
    selectionSort(intArrayOf(1, 2, 8, 3, 7)).also { println(it.joinToString(", ")) }
    selectionSort(intArrayOf(5, 4, 3, 2, 1)).also { println(it.joinToString(", ")) }
    selectionSort(intArrayOf(5, 7, 1, 3, 2)).also { println(it.joinToString(", ")) }
}

// Time Complexity: O(n^2)
// Space Complexity: O(1)
fun selectionSort(
    arr: IntArray
): IntArray {
    val n = arr.size

    for (i in 0 until n) {
        var minIndex = i
        for (j in i + 1 until n) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j
            }
        }
        arr[i] = arr[minIndex].also { arr[minIndex] = arr[i] }
    }

    return arr
}