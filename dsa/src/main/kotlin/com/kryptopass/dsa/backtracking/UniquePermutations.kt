package com.kryptopass.dsa.backtracking

/*
Given a collection of numbers, nums, that might contain duplicates,
return all possible unique permutations in any order.
 */
fun main() {
    uniquePermutations(intArrayOf(1, 1, 2)).also { println(it) }
}

// Time complexity: O(n! * n)
// Space complexity: O(n) -> maximum depth of recursion
fun uniquePermutations(
    nums: IntArray
): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    fun permutations(index: Int) {
        if (index == nums.size - 1) {
            result.add(nums.toList())
            return
        }

        val map = mutableMapOf<Int, Int>()
        for (j in index until nums.size) {
            if (nums[j] !in map) {
                map[nums[j]] = 1
                nums[index] = nums[j].also { nums[j] = nums[index] }
                permutations(index + 1)
                nums[index] = nums[j].also { nums[j] = nums[index] }     // backtracking step
            }
        }
    }

    permutations(0)

    return result
}