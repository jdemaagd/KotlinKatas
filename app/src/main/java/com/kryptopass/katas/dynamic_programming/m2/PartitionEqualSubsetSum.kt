package com.kryptopass.katas.dynamic_programming.m2

fun main() {
    println(partitionEqualSubsetSum(arrayListOf(1, 5, 11, 5)))
    println(partitionEqualSubsetSum(arrayListOf(1, 2, 3, 5)))
}

/*
Partition Equal Subset Sum
Given a non-empty array nums containing only positive integers,
find if the array can be partitioned into two subsets
such that the sum of elements in both subsets is equal

Example 1:
Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11]

Example 2:
Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets

Note:
1. Each of the array element will not exceed 100
2. The array size will not exceed 200
 */
fun partitionEqualSubsetSum(
    nums: ArrayList<Int>
): Boolean {
    val sum = nums.sum()
    if (sum % 2 != 0) return false

    val target = sum / 2
    val table = Array(nums.size + 1) { BooleanArray(target + 1) }

    // base case
    table[0][0] = true

    // recursive/iterative case
    for (i in 1..nums.size) {
        for (j in 0..target) {
            table[i][j] = table[i - 1][j]
            if (j >= nums[i - 1])
                table[i][j] = table[i][j] || table[i - 1][j - nums[i - 1]]
        }
    }

    return table[nums.size][target]
    // return table[n][t]
}