package com.kryptopass.katas.dsa.dynamic_programming

/*
You are given an integer array cost where `cost[i]` is the cost of `ith` step on a staircase.
Once you pay the cost, you can either climb one or two steps.
You can either start from the step with index 0, or the step with index 1.
Return the minimum cost to reach the top of the floor.
 */
fun main() {
    minCostRecursive(intArrayOf(10, 15, 20)).also { println(it) } // 15
    minCostRecursive(intArrayOf(1, 100, 1, 1, 1, 100, 1, 1, 100, 1)).also { println(it) } // 6
    println()
    minCostMemo(intArrayOf(10, 15, 20)).also { println(it) } // 15
    minCostMemo(intArrayOf(1, 100, 1, 1, 1, 100, 1, 1, 100, 1)).also { println(it) } // 6
    println()
    minCostTab(intArrayOf(10, 15, 20)).also { println(it) } // 15
    minCostTab(intArrayOf(1, 100, 1, 1, 1, 100, 1, 1, 100, 1)).also { println(it) } // 6
    println()
    minTabSpaceOptimized(intArrayOf(10, 15, 20)).also { println(it) } // 15
    minTabSpaceOptimized(intArrayOf(1, 100, 1, 1, 1, 100, 1, 1, 100, 1)).also { println(it) } // 6
}

// Step 1: recursive solution
// Time Complexity: O(2^n), each call potentially leads to 2 more calls
// Space Complexity: O(n), recursive call stack
fun minCostRecursive(
    cost: IntArray
): Int {
    fun helper(index: Int): Int {
        if (index >= cost.size)
            return 0

        val one = cost[index] + helper(index + 1)
        val two = cost[index] + helper(index + 2)

        return minOf(one, two)
    }

    return minOf(helper(0), helper(1))
}

// Step 2: memoization/top-down DP approach
// Time Complexity: O(n), compute once and store for each n (index)
// Space Complexity: O(n), max depth recursive call stack is n
fun minCostMemo(
    cost: IntArray
): Int {
    val n = cost.size
    val array = IntArray(n) { -1 }

    fun helper(index: Int): Int {
        if (index >= n)
            return 0

        if (array[index] != -1)
            return array[index]

        val one = cost[index] + helper(index + 1)
        val two = cost[index] + helper(index + 2)
        array[index] = minOf(one, two)

        return array[index]
    }

    return minOf(helper(0), helper(1))
}

// Step 3: tabulation/bottom-up DP approach
// Time Complexity: O(n), compute once and store for each n (index)
// Space Complexity: O(n), store n + 1 elements in array
fun minCostTab(
    cost: IntArray
): Int {
    val n = cost.size
    val array = IntArray(n + 1) { -1 }

    array[0] = 0
    array[1] = 0

    for (i in 2..n) {
        val prevOne = cost[i - 1] + array[i - 1]
        val prevTwo = cost[i - 2] + array[i - 2]
        array[i] = minOf(prevOne, prevTwo)
    }

    return array[n]
}

// Step 4: tabulation with space optimization
// Time Complexity: O(n), compute once and store for each n (index)
// Space Complexity: O(1), store only 3 elements
fun minTabSpaceOptimized(
    cost: IntArray
): Int {
    var prev = 0
    var curr = 0

    for (i in 2..cost.size) {
        val next = minOf(cost[i - 1] + curr, cost[i - 2] + prev)
        prev = curr
        curr = next
    }

    return curr
}