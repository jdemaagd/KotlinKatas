package com.kryptopass.katas.dsa.dynamic_programming

/*
You are provided with a set of N items, each with a specified weight and value.
Your objective is to pack these items into a backpack with a weight limit of W,
  maximizing the total value of items in the backpack.
Specifically, you have two arrays: val[0..N-1], representing the values of the items,
  and wt[0..N-1], indicating their weights.
Additionally, you have a weight limit W for the backpack.
The challenge is to determine the most valuable combination of items
  where the total weight does not exceed W.
Note that each item is unique and indivisible,
  meaning it must be either taken as a whole or left entirely.

Identify DP
choices: recursion (include/exclude)
optimal solution: maximize value that can be added to knapsack
 */
fun main() {
    knapsackRecursive(
        50,
        intArrayOf(10, 20, 30),
        intArrayOf(60, 100, 120),
        3
    ).also { println(it) }  // 220
    knapsackRecursive(8, intArrayOf(8, 2, 5), intArrayOf(2, 3, 9), 3).also { println(it) }  // 12
    println()
    knapsackMemo(
        50,
        intArrayOf(10, 20, 30),
        intArrayOf(60, 100, 120),
        3
    ).also { println(it) }  // 220
    knapsackMemo(8, intArrayOf(8, 2, 5), intArrayOf(2, 3, 9), 3).also { println(it) }  // 12
    println()
    knapsackTab(
        50,
        intArrayOf(10, 20, 30),
        intArrayOf(60, 100, 120),
        3
    ).also { println(it) }  // 220
    knapsackTab(8, intArrayOf(8, 2, 5), intArrayOf(2, 3, 9), 3).also { println(it) }  // 12
    println()
    knapsackTabSpaceOptimized(
        50,
        intArrayOf(10, 20, 30),
        intArrayOf(60, 100, 120),
        3
    ).also { println(it) }  // 220
    knapsackTabSpaceOptimized(
        8,
        intArrayOf(8, 2, 5),
        intArrayOf(2, 3, 9),
        3
    ).also { println(it) }  // 12
}

// Step 1: recursive solution
// Time Complexity: O(2^n), each item has 2 choices (include or exclude) n times
// Space Complexity: O(n), recursive call stack space
fun knapsackRecursive(
    W: Int,
    wt: IntArray,
    `val`: IntArray,
    n: Int
): Int {
    fun helper(index: Int, remWeight: Int): Int {
        if (index > n - 1 || remWeight == 0) {
            return 0
        }

        val exclude = helper(index + 1, remWeight)
        var include = 0
        if (wt[index] <= remWeight) {
            include = `val`[index] + helper(index + 1, remWeight - wt[index])
        }

        return maxOf(exclude, include)
    }

    return helper(0, W)
}

// Step 2: memoization/top-down DP approach
// Time Complexity: O(n * W), n items and W weight, max upper bound
// Space Complexity: O(n * W), memoization table
fun knapsackMemo(
    W: Int,
    wt: IntArray,
    `val`: IntArray,
    n: Int
): Int {
    val mem2d = Array(n) { IntArray(W + 1) { -1 } }

    fun helper(index: Int, remWeight: Int): Int {
        if (index > n - 1 || remWeight == 0) {
            return 0
        }

        if (mem2d[index][remWeight] != -1) {
            return mem2d[index][remWeight]
        }

        val exclude = helper(index + 1, remWeight)
        var include = 0
        if (wt[index] <= remWeight) {
            include = `val`[index] + helper(index + 1, remWeight - wt[index])
        }

        mem2d[index][remWeight] = maxOf(exclude, include)

        return mem2d[index][remWeight]
    }

    return helper(0, W)
}

// Step 3: tabulation/bottom-up DP approach
// Time Complexity: O(n * W), n items and W weight
// Space Complexity: O(n * W), tabulation table
fun knapsackTab(
    W: Int,
    wt: IntArray,
    `val`: IntArray,
    n: Int
): Int {
    val tab2d = Array(n + 1) { IntArray(W + 1) }

    for (i in 1..n) {
        for (j in 1..W) {
            val exclude = tab2d[i - 1][j]
            var include = 0
            if (wt[i - 1] <= j) {
                include = `val`[i - 1] + tab2d[i - 1][j - wt[i - 1]]
            }
            tab2d[i][j] = maxOf(exclude, include)
        }
    }

    return tab2d[n][W]
}

// Step 4: space-optimized tabulation
// Time Complexity: O(n * W), n items and W weight
// Space Complexity: O(W), tabulation table
fun knapsackTabSpaceOptimized(
    W: Int,
    wt: IntArray,
    `val`: IntArray,
    n: Int
): Int {
    val prev = IntArray(W + 1)
    val curr = IntArray(W + 1)

    for (i in 1..n) {
        for (j in 1..W) {
            val exclude = prev[j]
            var include = 0
            if (wt[i - 1] <= j) {
                include = `val`[i - 1] + prev[j - wt[i - 1]]
            }
            curr[j] = maxOf(exclude, include)
        }
        prev.indices.forEach { prev[it] = curr[it] }
    }

    return curr[W]
}