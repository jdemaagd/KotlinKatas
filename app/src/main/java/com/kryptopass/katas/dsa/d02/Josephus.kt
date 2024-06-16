package com.kryptopass.katas.dsa.d02

fun main() {
    approach1(5, 2).also { println(it) }
    approach1(6, 5).also { println(it) }
    println()

    approach2(5, 2).also { println(it) }
    approach2(6, 5).also { println(it) }
    println()

    approach3(5, 2).also { println(it) }
    approach3(6, 5).also { println(it) }
    println()
}

// Time Complexity: O(n^2)
// Space complexity: O(n)
fun approach1(n: Int, k: Int): Int {
    val arr = (1..n).toMutableList()

    fun helper(arr1: MutableList<Int>, startIndex: Int): Int {
        if (arr1.size == 1)
            return arr1[0]

        val indexToRemove = (startIndex + k - 1) % arr1.size
        arr1.removeAt(indexToRemove)
        return helper(arr1, indexToRemove)
    }

    return helper(arr, 0)
}

// using solution to sub-problem to solve original problem
// Time Complexity: O(n)
// Space complexity: O(n)
fun approach2(n: Int, k: Int): Int {
    fun josephus(n1: Int): Int {
        if (n1 == 1)
            return 0
        return (josephus(n1 - 1) + k) % n1
    }

    return josephus(n) + 1
}

// improve space complexity of recursive call stack
// Time Complexity: O(n)
// Space complexity: O(1)
fun approach3(n: Int, k: Int): Int {
    var survivor = 0
    for (i in 2..n)
        survivor = (survivor + k) % i

    return survivor + 1
}