package com.kryptopass.kotlinkatas.data_structures.m6

// NOTE: write an algorithm to find kth largest element of an integer array
// sorted input array in descending order using bubble sort
// but, you can use a more efficient sorting algorithm
fun kthLargest(arr: Array<Int>, k: Int): Int {
    arr.descending()
    return arr[k - 1]
}
fun <E: Comparable<E>> Array<E>.descending() {
    val len = size
    for (i in 0 until (len - 1)) {
        for (j in 0 until (len - i - 1)) {
            if (this[j].compareTo(this[j + 1]) < 0) {
                val temp = this[j]
                this[j] = this[j + 1]
                this[j + 1] = temp
            }
        }
    }
}

// NOTE: write snippet which tells whether given array or list has a duplicate element or not
fun <E: Comparable<E>> Array<E>.hasDuplicate(): Boolean {
    for (i in indices) {
        for (j in (i + 1) until size) {
            if (this[i] == this[j]) {
                return true
            }
        }
    }
    return false
}


