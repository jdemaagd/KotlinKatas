package com.kryptopass.katas.dynamic_programming.m1

import com.kryptopass.katas.dynamic_programming.TABLE1D

fun main() {
    println(minCostClimbingStairsRecursiveMemo(arrayListOf(1, 1, 2)))
    println(minCostClimbingStairsRecursiveMemo(arrayListOf(3, 4)))
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
    Time: O(2^n)
    Auxiliary space: O(n)
    Total space: O(n)
 */
fun minCostClimbingStairsRecursiveMemo(
    cost: ArrayList<Int>
): Int {
    // dp.addAll(MutableList(cost.size + 1) { 0 })
    TABLE1D = ArrayList<Int>(cost.size + 1)
    for (i in 0..cost.size + 1) TABLE1D.add(-1)

    // TODO: incorrect result -> -1, -1
    return minCostClimbingStairsRecursiveMemoHelper(cost.size, cost)
}

fun minCostClimbingStairsRecursiveMemoHelper(
    n: Int, cost: ArrayList<Int>
): Int {
    if (n < 2) return 0

    if (TABLE1D[n] != -1) return TABLE1D[n]

    val costN1 = minCostClimbingStairsRecursiveMemoHelper(n - 1, cost) + cost[n - 1]

    val costN2 = minCostClimbingStairsRecursiveMemoHelper(n - 2, cost) + cost[n - 2]

    return TABLE1D[n].also { TABLE1D[n] = minOf(costN1, costN2) }
}