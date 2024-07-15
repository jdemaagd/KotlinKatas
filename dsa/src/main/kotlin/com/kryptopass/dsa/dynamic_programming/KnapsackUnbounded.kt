package com.kryptopass.dsa.dynamic_programming

/*
Given a set of N items, each with a weight and a value,
  represented by the array wt and val respectively.
Also, a knapsack with weight limit W.
The task is to fill the knapsack in such a way that we can get the maximum profit.
Return the maximum profit.
Note: Each item can be taken `any number of times`.
 */
fun main() {
    unboundedKnapsackTab(
        3,
        intArrayOf(8, 2, 5),
        intArrayOf(2, 4, 9),
        8
    ).also { println(it) }       // 16
    unboundedKnapsackTab2(
        3,
        intArrayOf(8, 2, 5),
        intArrayOf(2, 4, 9),
        8
    ).also { println(it) }     // 16
}

// Time Complexity: O(n * W), n * W recursive calls
// Space Complexity: O(n * W), depth of recursion stack
fun unboundedKnapsackTab(
    N: Int,
    wt: IntArray,
    `val`: IntArray,
    W: Int
): Int {
    val tab2d = Array(N + 1) { IntArray(W + 1) }

    for (i in 1..N) {
        for (j in 1..W) {
            val exclude = tab2d[i - 1][j]
            var include = 0
            if (wt[i - 1] <= j) {
                include = `val`[i - 1] + tab2d[i][j - wt[i - 1]]
            }
            tab2d[i][j] = maxOf(exclude, include)
        }
    }

    return tab2d[N][W]
}

// Time Complexity: O(n * W), n * W cells in tabulation
// Space Complexity: O(W)
fun unboundedKnapsackTab2(
    N: Int,
    wt: IntArray,
    `val`: IntArray,
    W: Int
): Int {
    val tab2d = Array(N + 1) { IntArray(W + 1) { -1 } }

    for (j in 0..W) {
        tab2d[0][j] = 0
    }

    for (i in 0..N) {
        tab2d[i][0] = 0
    }

    for (i in 1..N) {
        for (j in 1..W) {
            val exclude = tab2d[i - 1][j]
            var include = 0
            if (wt[i - 1] <= j) {
                include = `val`[i - 1] + tab2d[i][j - wt[i - 1]]
            }
            tab2d[i][j] = maxOf(exclude, include)
        }
    }

    return tab2d[N][W]
}