package com.kryptopass.dsa.backtracking

/*
Given an integer array nums that may contain duplicates, return all possible subsets (power set).
The solution set must not contain duplicate subsets.
Return the solution in any order.
 */
fun main() {
    subsetsWithDuplicates(intArrayOf(1, 2, 2)).also { println(it) }
    subsetsWithDuplicates(intArrayOf(1, 3, 3, 7)).also { println(it) }
}

// Time complexity -> O(n * 2^n)
// Space complexity -> O(n) -> space on recursion stack
fun subsetsWithDuplicates(
    nums: IntArray
): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    nums.sort()

    fun backtrack(
        index: Int, subset: MutableList<Int>
    ) {
        var i = index
        if (i == nums.size) {
            result.add(subset.toList())
            return
        }
        // include
        subset.add(nums[i])
        backtrack(i + 1, subset)
        subset.removeAt(subset.size - 1)    // backtracking step
        // exclude
        while (i < nums.size - 1 && nums[i] == nums[i + 1]) {
            i++
        }
        backtrack(i + 1, subset)
    }

    backtrack(0, mutableListOf())
    return result
}