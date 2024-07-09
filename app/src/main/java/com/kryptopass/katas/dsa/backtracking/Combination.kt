package com.kryptopass.katas.dsa.backtracking

/*
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
You may return the answer in any order.
combinations -> nCk -> n! / (k! * (n-k)!)
given n = 4, k = 2 -> C -> 4! / (2! (4 - 2)!) = 6
 */
fun main() {
    combination(4, 2).also { println(it) }
}

// Time complexity: k * nCk -> O(n! / (k! * (n-k)!))
// Space complexity: O(k) -> space on recursive call stack
fun combination(n: Int, k: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    fun backtrack(start: Int, path: MutableList<Int>) {
        if (path.size == k) {
            result.add(path.toList())
            return
        }
        val need = k - path.size
        for (i in start..n - need + 1) {
            path.add(i)
            backtrack(i + 1, path)
            path.removeAt(path.size - 1)    // backtracking step
        }
    }

    backtrack(1, mutableListOf())
    return result
}