package com.kryptopass.dsa.sorting

/*
Radix Sort
Given an array of non-negative integers, write a function that will take this array as input and
return the sorted array using Radix sort.
Sort based on units place, then tens place, then hundreds place, and so on.

Use counting sort (Stable)
Comparison based sorting algorithms -> O(n log n), best we can do w/o knowing anything about input
Numbers to sort lie between 0 and k (0 - 9), k is small
Count occurrence of each digit in input (frequency array) -> O(n)
Perform cumulative sum of frequency array -> O(k), where k is in range of digits (0 - 9)
Iterate given array in reverse, place elements in output array based on cumulative sum -> O(n)
Improved time complexity -> O(n + k) -> O(n)
Space complexity -> O(n + k) -> O(n)

Stable Sorting Algorithm:
Initial relative ordering is maintained between duplicates
 */
fun main() {
    radixSort(intArrayOf(7, 3, 2, 5, 1, 6)).also { println(it.toList()) }
    radixSort(intArrayOf(123, 78, 63, 19, 5)).also { println(it.toList()) }
    radixSort(intArrayOf(384, 73, 374, 183, 65, 247, 185)).also { println(it.toList()) }
}

// Time Complexity: O(d * (n + k))
//     where d is number of digits in the largest number
// Space Complexity: O(n + k)
fun radixSort(
    array: IntArray
): IntArray {
    if (array.isEmpty()) return intArrayOf()

    val greatestNumber = array.maxOrNull()!!
    val numberOfDigits = greatestNumber.toString().length

    for (i in 0 until numberOfDigits) {
        countingSort(array, i)
    }

    return array
}

fun countingSort(
    array: IntArray,
    place: Int
) {
    val output = IntArray(array.size)
    val temp = IntArray(10) { 0 }
    val digitPlace = Math.pow(10.0, place.toDouble()).toInt()

    for (num in array) {
        val digit = (num / digitPlace) % 10
        temp[digit]++
    }

    for (i in 1 until 10) {
        temp[i] += temp[i - 1]
    }

    for (j in array.size - 1 downTo 0) {
        val currDigit = (array[j] / digitPlace) % 10
        temp[currDigit]--
        val insertPosition = temp[currDigit]
        output[insertPosition] = array[j]
    }

    array.indices.forEach { array[it] = output[it] }
}