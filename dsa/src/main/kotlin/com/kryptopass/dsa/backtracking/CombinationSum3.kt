package com.kryptopass.dsa.backtracking

/*
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
    Only numbers 1 through 9 are used.
    Each number is used at most once.
Return a list of all possible valid combinations.
The list must not contain the same combination twice, and the combinations may be returned in any order.

Example 1:
Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.

Example 2:
Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.

Example 3:
Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9],
  the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1,
  there are no valid combination.

Constraints:
    2 <= k <= 9
    1 <= n <= 60
 */
fun main() {
    combinationSum(3, 7).also { println(it) }
    combinationSum(3, 9).also { println(it) }
    combinationSum(4, 1).also { println(it) }
}

/*
Time Complexity Analysis -> 𝑂((9/𝑘) * 𝑘)
1. Backtracking Function
   a. Number of Combinations
      each number from `1` to `9` can either be included or excluded, leading to a total of 2^9
        potential combinations (without considering constraints like `k` and `n`)
        however, actual number of valid combinations will be less due to these constraints
      number of valid combinations is influenced by constraints `k` (size of combination)
        and `n` (target sum)
   b. Depth of Recursion
      depth of recursion is bounded by `k` because each combination must have exactly `k` elements
      at each level, we iterate over numbers from current number to `9`, leading to a time
        complexity proportional to number of ways we can pick `k` numbers from set `{1, 2, ..., 9}`
   c. Combinatorial Complexity
      combinatorial aspect of this problem is akin to selecting `k` elements from `9`, which can be
        represented by the binomial coefficient (9/𝑘)
      this binomial coefficient gives number of ways to choose `k` elements from `9` options without
        regard to order

Space Complexity Analysis -> 𝑂((9/𝑘) * 𝑘)
1. Space for res
   `res` list stores all valid combinations
   maximum space required for this is proportional to number of valid combinations 𝑂((9/𝑘)),
     with each combination having size `k`
2. Space for Recursion
   recursion depth is bounded by `k` because we can only have `k` elements in each combination
   at each level of recursion, `curr` list can store up to `k` elements -> 𝑂(𝑘)
3. Overall Space Complexity
   dominant term is 𝑂((9/𝑘) * 𝑘) because it covers both storage of results
     and maximum depth of the recursion stack
 */
fun combinationSum(
    k: Int,
    n: Int
): List<List<Int>> {
    val res = mutableListOf<List<Int>>()

    fun backtrack(number: Int, curr: MutableList<Int>, currSum: Int) {
        if (currSum == n && curr.size == k) {
            res.add(curr.toList())
            return
        }
        if (currSum > n || curr.size == k) {
            return
        }

        for (x in number until 10) {
            curr.add(x)
            backtrack(x + 1, curr, currSum + x)
            curr.removeAt(curr.size - 1)        // backtracking step
        }
    }

    backtrack(1, mutableListOf(), 0)

    return res
}