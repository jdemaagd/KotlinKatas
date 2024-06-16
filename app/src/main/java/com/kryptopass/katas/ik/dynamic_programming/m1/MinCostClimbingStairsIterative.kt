package com.kryptopass.katas.dynamic_programming.m1

fun main() {
    println(minCostClimbingStairsDP(arrayListOf(1, 1, 2)))
    println(minCostClimbingStairsDP(arrayListOf(3, 4)))
}

/*
Min Cost Climbing Stairs
There are n stairs indexed 0 to n – 1.
Each stair has a cost associated with it.
After paying the cost, it's allowed either to climb one or two steps further.
It's allowed to either start from the step with index 0, or the step with index 1.
Given the cost array, find the minimum cost to reach the top of the floor.
cost[i] represents the cost of i-th stair.

Example One
{
    "cost": [1, 1, 2]
}
Output: 1
There are 5 ways to reach the top floor.
step 0 → step 1 → step 2 → top floor.
step 0 → step 1 → top floor.
step 0 → step 2 → top floor.
step 1 → step 2 → top floor.
step 1 → top floor.
Here, the last way(step 1 → top floor) will provide the most optimal cost 1.

Example Two
{
    "cost": [3, 4]
}
Output: 3

Constraints:
2 <= length of the input array <= 1000
0 <= cost[i] <= 999, for all i.
 */

/*
    Asymptotic complexity in terms of the length of input array `cost`, ( = `n`):
    Time: O(n)
    Auxiliary space: O(1)
    Total space: O(1)
 */
fun minCostClimbingStairsSpaceOptimized(
    cost: ArrayList<Int>
): Int {
    val n = cost.size
    var prev = 0
    var prevPrev = 0
    var curr = 0

    for (i in 2..n) {
        curr = minOf(prev + cost[i - 1], prevPrev + cost[i - 2])
        prevPrev = prev
        prev = curr
    }

    return curr
}

/*
    Asymptotic complexity in terms of the length of input array `cost`, ( = `n`):
    Time: O(n)
    Auxiliary space: O(n)
    Total space: O(n)
 */
fun minCostClimbingStairsDP(
    cost: ArrayList<Int>
): Int {
    val n = cost.size

    val dp = IntArray(n + 1)
    dp[0] = 0
    dp[1] = 0

    for (i in 2..n)
        dp[i] = minOf(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2])

    return dp[n]
}