package com.kryptopass.katas.dsa.`05_backtracking`

/*
Given an integer array of unique elements, return all possible subsets (power set).
The solution set must not contain duplicate subsets.
Return the solution in any order.
 */
fun main() {
    subsets(intArrayOf(1, 2, 3)).also { println(it) }
    subsets(intArrayOf(1, 8, 7)).also { println(it) }
}

// Time complexity -> O(n * 2^n)
//    2^n subsets * for each subset calling function n times
// Space complexity: O(n) -> space on recursion stack
fun subsets(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    fun backtrack(
        arr: IntArray, index: Int, subset: MutableList<Int>
    ) {
        if (index == arr.size) {
            result.add(subset.toList())
            return
        }
        backtrack(arr, index + 1, subset)       // exclude
        subset.add(arr[index])                        // include
        backtrack(arr, index + 1, subset)
        subset.removeAt(subset.size - 1)        // backtracking step
    }

    backtrack(nums, 0, mutableListOf())
    return result
}