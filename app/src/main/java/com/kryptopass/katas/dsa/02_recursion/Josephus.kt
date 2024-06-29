package com.kryptopass.katas.dsa.`02_recursion`

/*
There are n friends that are playing a game.
The friends are sitting in a circle and are numbered from 1 to n in clockwise order.
More formally, moving clockwise from the ith friend brings you to the (i+1)th friend
  for 1 <= i < n, and moving clockwise from the nth friend brings you to the 1st friend.
The rules of the game are as follows:
    - Start at the 1st friend.
    - Count the next k friends in the clockwise direction including the friend you started at. The
      counting wraps around the circle and may count some friends more than once.
    - The last friend you counted leaves the circle and loses the game.
    - If there is still more than one friend in the circle, go back to step 2 starting from the
      friend immediately clockwise of the friend who just lost and repeat.
    - Else, the last friend in the circle wins the game.
Given the number of friends, n, and an integer k, return the winner of the game.
 */
fun main() {
    approach1(5, 2).also { println(it) }    // 3
    approach1(6, 5).also { println(it) }    // 1
    println()

    approach2(5, 2).also { println(it) }    // 3
    approach2(6, 5).also { println(it) }    // 1
    println()

    approach3(5, 2).also { println(it) }    // 3
    approach3(6, 5).also { println(it) }    // 1
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
