package com.kryptopass.katas.dsa.dynamic_programming

/*
Given an integer array `nums`, return `true` if you can partition the array into two subsets
such that the sum of the elements in both subsets is equal or `false` otherwise.
 */
fun main() {
    canPartition(intArrayOf(1, 5, 11, 5)).also(::println)     // true
    canPartition(intArrayOf(1, 2, 3, 5)).also(::println)      // false
    canPartition(intArrayOf(1, 2, 3, 4, 5, 6, 7)).also(::println)      // true
}

fun canPartition(nums: IntArray): Boolean {
    val n = nums.size
    var sumTotal = 0

    for (num in nums) {
        sumTotal += num
    }

    if (sumTotal % 2 != 0) {
        return false
    }

    val target = sumTotal / 2
    val prev = BooleanArray(target + 1)
    val curr = BooleanArray(target + 1)
    prev[0] = true
    curr[0] = true

    for (i in 1..n) {
        for (j in 1..target) {
            // pick
            curr[j] = if (nums[i - 1] <= j) {
                prev[j - nums[i - 1]]
            } else {
                false
            }
            curr[j] = curr[j] || prev[j]
        }

        prev.indices.forEach { index ->
            prev[index] = curr[index]
        }
    }

    return curr[target]
}
