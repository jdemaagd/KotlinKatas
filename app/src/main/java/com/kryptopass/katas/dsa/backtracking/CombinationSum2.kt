package com.kryptopass.katas.dsa.backtracking

/*
Given a collection of candidate numbers (`candidates`) and a target number (`target`),
find all unique combinations in `candidates` where the candidate numbers sum to `target`.
Each number in `candidates` may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
    [
        [1,1,6],
        [1,2,5],
        [1,7],
        [2,6]
    ]

Example 2:
Input: candidates = [2,5,2,1,2], target = 5
Output:
    [
        [1,2,2],
        [5]
    ]

Constraints:
    1 <= candidates.length <= 100
    1 <= candidates[i] <= 50
    1 <= target <= 30

Combination Sum 1               vs      Combination Sum 2
distinct candidates                     candidates may have duplicates
use candidate multiple times            use candidate only once
 */
fun main() {
    combinationSum2(intArrayOf(10, 1, 2, 7, 6, 1, 5), 8).also { println(it) }
    combinationSum2(intArrayOf(2, 5, 2, 1, 2), 5).also { println(it) }
    combinationSum2(intArrayOf(2, 3, 4, 3, 5), 8).also { println(it) }
}

/*
Time Complexity Analysis -> 𝑂(𝑛 * 2^𝑛)
1. Sorting Step
   sorting candidates array has time complexity of 𝑂(𝑛 log 𝑛), where 𝑛 is length of `candidates`
2. Backtracking Step
   explores each subset of `candidates` array to check if it sums up to the target
   complexity of backtracking depends on how many subsets are explored
   # of combinations: worst case, where every combination of elements needs to be explored,
     number of possible subsets is 2𝑛 (excluding duplicates handled by myHash)
     each subset can be of size up to 𝑛, leading to 𝑂(𝑛 * 2^𝑛) combinations
   avoiding duplicates: `myHash` ensures that duplicates are skipped within same level of recursion
     however, optimization does not change exponential nature of backtracking process significantly
3. Overall Time Complexity
   combining sorting step and backtracking step, total time complexity is: 𝑂(𝑛 log 𝑛 + 𝑛 * 2^𝑛)
   as 𝑛 * 2^𝑛 dominates 𝑛 log 𝑛, the overall time complexity is: 𝑂(𝑛 * 2^𝑛)

Space Complexity Analysis -> 𝑂(𝑛 * 2^𝑛)
1. Space for `result`
   `result` list stores valid combinations
   worst case, it could store up to 𝑂(2^𝑛) combinations,
     each of which can be of size 𝑂(𝑛), leading to 𝑂(𝑛 * 2𝑛) space for storing results
2. Space for Recursion
   recursion depth can go up to 𝑛, and at each level
   the `curr` list can store up to 𝑛 elements
   hence, recursion stack and `curr` list require 𝑂(𝑛) space at each level,
     leading to 𝑂(𝑛^2) space for recursion
   however, because recursion call stack itself is 𝑂(𝑛),
     this does not add significantly to the dominant space complexity
3. Space for `myHash`
   used to track duplicates and its space complexity at each level is 𝑂(𝑛)
   however, its space usage does not significantly affect overall complexity
     as it is reused at each level of recursion
4. Overall Space Complexity
   space `result` dominates -> 𝑂(𝑛 * 2^𝑛)
 */
fun combinationSum2(
    candidates: IntArray,
    target: Int
): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    candidates.sort()
    val n = candidates.size

    fun backtrack(
        index: Int,
        currSum: Int,
        curr: MutableList<Int>
    ) {
        if (currSum == target) {            // found match
            result.add(curr.toList())
            return
        }
        if (currSum > target) return
        if (index > n - 1) return

        // track elements in current level of recursion
        val myHash = mutableMapOf<Int, Int>()
        for (j in index until n) {
            if (candidates[j] !in myHash) {     // skip duplicates
                myHash[candidates[j]] = 1
                curr.add(candidates[j])
                backtrack(j + 1, currSum + candidates[j], curr)
                curr.removeAt(curr.lastIndex)   // backtracking step
            }
        }
    }

    backtrack(0, 0, mutableListOf())

    return result
}