package com.kryptopass.katas.dsa.`12_dynamic_programming_knapsack`

/*
You are given an integer array `nums` and an integer `target`.
You want to build an `expression` out of nums by adding one of the symbols `+` and `-` before each
    integer in nums and then concatenate all the integers.
For example, if `nums = [2, 1]`, you can add a `+` before `2` and a `-` before `1` and concatenate
    them to build the expression `+2-1`.
Return the number of different `expressions` that you can build, which evaluates to `target`.
 */
fun main() {
    findTarget(intArrayOf(1, 1, 1, 1, 1), 3).also(::println) // 5
    findTarget(intArrayOf(1), 1).also(::println) // 1
    findTarget(intArrayOf(1, 2, 3, 4, 5), 3).also(::println) // 3
    findTarget(intArrayOf(1, 2, 3, 4, 5), 10).also(::println) // 0
}

fun findTarget(nums: IntArray, target: Int): Int {
    val n = nums.size
    val summation = nums.sum()
    val dp = Array(n) { IntArray(2 * summation + 1) }

    fun helper(index: Int, sumNums: Int): Int {
        if (index < 0) {
            return if (sumNums == target) 1 else 0
        }
        if (dp[index][sumNums + summation] != 0) {
            return dp[index][sumNums + summation]
        }

        val negative = helper(index - 1, sumNums + -1 * nums[index])
        val positive = helper(index - 1, sumNums + nums[index])
        dp[index][sumNums + summation] = negative + positive
        return dp[index][sumNums + summation]
    }

    return helper(n - 1, 0)

}
