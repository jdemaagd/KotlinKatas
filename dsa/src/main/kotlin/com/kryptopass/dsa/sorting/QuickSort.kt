package com.kryptopass.dsa.sorting

/*
Quick Sort
Given an array of integers, write a function that will take this array as input and
return the sorted array using Quick sort.

Divide & Conquer Algorithm:
Select a pivot element from the array
All elements less than pivot are moved to left of pivot
All elements greater than pivot are moved to right of pivot
Use 2 pointers (`i' & `j`) at end and at next index past pivot
increment `i' until arr[i] > pivot
decrement `j' until arr[j] < pivot
swap arr[i] and arr[j]
repeat until i >= j
swap arr[i] and pivot
Recursively apply quick sort to left and right sub-arrays
 */
fun main() {
    quickSort(intArrayOf(1, 2, 8, 3, 7)).also { println(it.joinToString()) }
    quickSort(intArrayOf(6, 3, 1, 9, 5)).also { println(it.joinToString()) }
    quickSort(intArrayOf(14, 22, 12, 18, 19, 11, 8, 13, 9)).also { println(it.joinToString()) }
}

// Time Complexity: O(n log n), assumption that pivot is median
//     worst case, pivot is always smallest or largest element -> O(n^2)
// Space Complexity: O(log n), recursive call only on lower sized array
fun quickSort(
    array: IntArray,
    left: Int = 0,
    right: Int = array.size - 1
): IntArray {
    var start = left
    var end = right

    while (start < end) {
        val pivotIdx = partition(array, start, end)

        if (pivotIdx - start < end - pivotIdx) {
            quickSort(array, start, pivotIdx - 1)
            start = pivotIdx + 1
        } else {
            quickSort(array, pivotIdx + 1, end)
            end = pivotIdx - 1
        }
    }

    return array
}

fun partition(
    array: IntArray,
    start: Int,
    end: Int
): Int {
    val middle = (start + end) / 2
    array[start] = array[middle].also { array[middle] = array[start] }

    val pivot = array[start]
    var i = start + 1
    var j = end

    while (i <= j) {
        while (i <= j && array[i] <= pivot) {
            i++
        }
        while (i <= j && array[j] > pivot) {
            j--
        }
        if (i < j) {
            array[i] = array[j].also { array[j] = array[i] }
        }
    }

    array[start] = array[j].also { array[j] = array[start] }

    return j
}