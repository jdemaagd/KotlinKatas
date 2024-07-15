package com.kryptopass.dsa.backtracking

/*
Given an array of distinct integers candidates and a target integer target,
return a list of all unique combinations of candidates where the chosen numbers sum to target.
You may return the combinations in any order.
The same number may be chosen from candidates an unlimited number of times.
Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 */
fun main() {
    combinationSum(intArrayOf(2, 3, 6, 7), 7).also { println(it) }
}

fun combinationSum(
    candidates: IntArray,
    target: Int
): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val n = candidates.size

    fun backtrack(
        index: Int, path: MutableList<Int>, sum: Int
    ) {
        if (sum > target) return
        if (sum == target) {
            result.add(path.toList())
            return
        }
        for (i in index until n) {
            path.add(candidates[i])
            backtrack(i, path, sum + candidates[i])
            path.removeAt(path.size - 1)                // backtracking step
        }
    }

    backtrack(0, mutableListOf(), 0)

    return result
}