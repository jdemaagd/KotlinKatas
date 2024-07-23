package com.kryptopass.hack.sorting

/*
In an array, the elements at indices i and j (where i < j) form an inversion if a[i] > a[j].
In other words, inverted elements arr[i] and arr[j] are considered to be "out of order".
To correct an inversion, we can swap adjacent elements.

Example
arr = [2, 4, 1]
To sort the array, we must perform the following two swaps to correct the inversions: swap-inversions.png
The sort has two inversions: (4, 1) and (2, 1).
Given an array arr, return the number of inversions to sort the array.

Function Description
Complete the function countInversions in the editor below.
countInversions has the following parameter(s):
- int arr[n]: an array of integers to sort

Returns
- int: the number of inversions

Input Format
The first line contains an integer d, the number of datasets.
Each of the next d pairs of lines is as follows:
- The first line contains an integer n, the number of elements in arr.
- The second line contains n space-separated integers arr[i].

Constraints
1 <= d <= 15
1 <= n <= 10^5
1 <= arr[i] <= 10^7

Sample Input
STDIN       Function
-----       --------
2           d = 2
5           arr[] size n = 5 for the first dataset
1 1 1 2 2   arr = [1, 1, 1, 2, 2]
5           arr[] size n = 5 for the second dataset
2 1 3 1 2   arr = [2, 1, 3, 1, 2]

Sample Output
0
4

Explanation
We sort the following d = 2 datasets:
1. arr = [1, 1, 1, 2, 2] is already sorted, so there are no inversions.
2. arr = [2, 1, 3, 1, 2] -> arr = [1, 2, 3, 1, 2] -> arr = [1, 1, 2, 3, 2] -> arr = [1, 1, 2, 2, 3]
We performed a total of 1 + 2 + 1 = 4 swaps to correct the inversions.
 */
fun main() {
    countInversions(arrayOf(1, 1, 1, 2, 2)).also(::println)
    countInversions(arrayOf(2, 1, 3, 1, 2)).also(::println)
}

// Time Complexity: O(n log n), where n is the number of elements in the array
// Space Complexity: O(n)
fun countInversions(
    arr: Array<Int>
): Long {
    return mergeSort(arr, 0, arr.size - 1)
}

// Time Complexity: O(n log n), array is repeatedly divided into two halves
// Space Complexity: O(log n), recursive call stack, array is divided into two halves
fun mergeSort(
    arr: Array<Int>,
    left: Int,
    right: Int
): Long {
    if (left >= right) {
        return 0
    }
    val mid = (left + right) / 2
    var count = mergeSort(arr, left, mid)
    count += mergeSort(arr, mid + 1, right)
    count += mergeCountInversions(arr, left, mid, right)

    return count
}

// Time Complexity: O(n), where n is the number of elements in the array
// Space Complexity: O(n), worst case for auxiliary space
fun mergeCountInversions(
    arr: Array<Int>,
    left: Int,
    mid: Int,
    right: Int
): Long {
    val leftArray = arr.sliceArray(left..mid)
    val rightArray = arr.sliceArray(mid + 1..right)

    var i = 0
    var j = 0
    var k = left
    var inversions = 0L

    while (i < leftArray.size && j < rightArray.size) {
        if (leftArray[i] <= rightArray[j]) {
            arr[k++] = leftArray[i++]
        } else {
            arr[k++] = rightArray[j++]
            inversions += (leftArray.size - i)
        }
    }

    while (i < leftArray.size) {
        arr[k++] = leftArray[i++]
    }

    while (j < rightArray.size) {
        arr[k++] = rightArray[j++]
    }

    return inversions
}