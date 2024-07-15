package com.kryptopass.hack.dynamic_programming

/*
Given an array of integers, find the subset of non-adjacent elements with the maximum sum.
Calculate the sum of that subset.
It is possible that the maximum sum is `0`, the case when all elements are negative.

Example
arr = [-2, 1, 3, -4, 5]
The following subsets with more than `1` element exist.
    Subset      Sum
    [-2, 3, 5]   6
    [-2, 3]      1
    [-2, -4]    -6
    [-2, 5]      3
    [1, -4]     -3
    [1, 5]       6
    [3, 5]       8
The maximum subset sum is `8`. Note that any individual element is a subset as well.
arr = [-2, -3, -1]
In this case, it is best to choose no element: return `0`.

Function Description
Complete the `maxSubsetSum` function in the editor below.
maxSubsetSum has the following parameter(s):
    - int arr[n]: an array of integers

Returns
    - int: the maximum subset sum

Input Format
The first line contains an integer, `n`.
The second line contains `n` space-separated integers `arr[i]`.

Constraints
    - 1 <= n <= 10^5
    - -10^4 <= arr[i] <= 10^4

Sample Input 0
5
3 7 4 6 5

Sample Output 0
13

Explanation 0
Our possible subsets are `[3, 4, 5]`, `[3, 4]`, `[3, 6]`, `[3, 5]`, `[7, 6]`, `[7, 5]`, and `[4, 5]`.
The largest subset sum is `13` from subset `[7, 6]`.

Sample Input 1
5
2 1 5 8 4

Sample Output 1
11

Explanation 1
Our subsets are `[2, 5, 4]`, `[2, 5]`, `[2, 8]`, `[2, 4]`, `[1, 8]`, `[1, 4]`, and `[5, 4]`.
The maximum subset sum is `11` from the first subset listed.

Sample Input 2
5
3 5 -7 8 10

Sample Output 2
15

Explanation 2
Our subsets are `[3, -7, 10]`, `[3, 8]`, `[3, 10]`, `[5, 8]`, `[5, 10]` and `[-7, 10]`.
The maximum subset sum is `15` from the fifth subset listed.
 */
fun main() {
    maxSubsetSum(intArrayOf(3, 7, 4, 6, 5)).also(::println)      // 13
    maxSubsetSum(intArrayOf(2, 1, 5, 8, 4)).also(::println)      // 11
    maxSubsetSum(intArrayOf(3, 5, -7, 8, 10)).also(::println)    // 15
    println()
    maxSubsetSumSpaceOptimized(intArrayOf(3, 7, 4, 6, 5)).also(::println)
    maxSubsetSumSpaceOptimized(intArrayOf(2, 1, 5, 8, 4)).also(::println)
    maxSubsetSumSpaceOptimized(intArrayOf(3, 5, -7, 8, 10)).also(::println)
}

// Time Complexity: O(n), where n is the size of the input array.
// Space Complexity: O(n), where n is the size of the input array.
fun maxSubsetSum(
    arr: IntArray
): Int {
    if (arr.isEmpty())
        return 0
    if (arr.size == 1)
        return maxOf(0, arr[0])

    val n = arr.size
    val dp = IntArray(n)

    dp[0] = maxOf(0, arr[0])
    dp[1] = maxOf(dp[0], arr[1])

    for (i in 2 until n) {
        dp[i] = maxOf(dp[i - 1], arr[i] + dp[i - 2])
    }

    return dp[n - 1]
}

// Time Complexity: same -> O(n)
// Space Complexity: O(1), track previous and current values.
fun maxSubsetSumSpaceOptimized(
    arr: IntArray
): Int {
    if (arr.isEmpty())
        return 0
    if (arr.size == 1)
        return maxOf(0, arr[0])

    var prev = maxOf(0, arr[0])
    var curr = maxOf(prev, arr[1])

    for (i in 2 until arr.size) {
        val current = maxOf(curr, arr[i] + prev)
        prev = curr
        curr = current
    }

    return curr
}