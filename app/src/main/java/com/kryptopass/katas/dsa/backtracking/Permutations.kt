package com.kryptopass.katas.dsa.backtracking

/*
Given an array nums of distinct integers, return all the possible permutations.
You can return the answer in any order.
 */
fun main() {
    permutations(intArrayOf(1, 2, 3)).also { println(it) }
    permutations(intArrayOf(1, 2)).also { println(it) }
}

// NOTE: n! -> distinct permutations
// Time complexity: O(n! * n)
// Space complexity: O(n) -> maximum depth of recursion
//   n! * n -> do not count space of answer we return
fun permutations(
    nums: IntArray
): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    fun helper(index: Int) {
        if (index == nums.size - 1) {
            result.add(nums.toList())
            return
        }

        for (j in index until nums.size) {                      // loop all possible choices
            nums[index] = nums[j].also { nums[j] = nums[index] }
            helper(index + 1)
            nums[index] = nums[j].also { nums[j] = nums[index] }     // backtracking step
        }
    }

    helper(0)

    return result
}