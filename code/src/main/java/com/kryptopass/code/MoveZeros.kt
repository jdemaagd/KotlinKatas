package com.kryptopass.code

/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of
the non-zero elements.
Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]

Constraints:
1 <= nums.length <= 10^4
2^31 <= nums[i] <= 2^31 - 1
 */
fun main() {
    val nums = intArrayOf(0, 1, 0, 3, 12)
    moveZeroes(nums)
    nums.contentToString().also { println(it) }

    val nums2 = intArrayOf(0)
    moveZeroes(nums2)
    nums2.contentToString().also { println(it) }
}

fun moveZeroes(nums: IntArray) {
    var lastNonZeroFoundAt = 0
    for (i in nums.indices) {
        if (nums[i] != 0) {
            nums[lastNonZeroFoundAt++] = nums[i]
        }
    }

    for (i in lastNonZeroFoundAt until nums.size) {
        nums[i] = 0
    }
}