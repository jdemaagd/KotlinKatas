package com.kryptopass.katas.dsa.dynamic_programming

/*
In Fibonacci sequence, each subsequent term is obtained by adding the preceding 2 terms
This is true for all the numbers except the first 2 numbers of the Fibonacci series
  as they do not have 2 preceding numbers
The first 2 terms in the Fibonacci series is `0` and `1` -> F(n) = F(n - 1) + F(n - 2) for n > 1
Write a function that finds `F(n)` given `n` where `n` is an integer greater than equal to 0
For the first term n = 0
 */
fun main() {
    fibRecursive(0).also { println(it) }  // 0
    fibRecursive(1).also { println(it) }  // 1
    fibRecursive(2).also { println(it) }  // 1
    fibRecursive(3).also { println(it) }  // 2
    fibRecursive(4).also { println(it) }  // 3
    fibMemo(5).also { println(it) }  // 5
    fibMemo(6).also { println(it) }  // 8
    fibTab(7).also { println(it) }  // 13
    fibTab(8).also { println(it) }  // 21
    fibSpaceOptimized(9).also { println(it) }  // 34
    fibSpaceOptimized(10).also { println(it) }  // 55
    fibSpaceOptimized(11).also { println(it) }  // 89
}

// Step 1: start with recursive solution
// Time Complexity: O(2^n)
//   each call branches into 2 calls almost n times
//   or looking each level -> 2^0 + 2^1 + 2^2 + ... + 2^(n - 1) = 2^n - 1
// Space Complexity: O(n)
//   recursive call stack will take order of n
//   max depth of the call stack is n
fun fibRecursive(
    n: Int
): Int {
    if (n < 2)
        return n

    return fibRecursive(n - 1) + fibRecursive(n - 2)
}

var memo = HashMap<Int, Int>().apply {
    put(0, 0)
    put(1, 1)
}

// Step 2: memoization/top-down approach
// Time Complexity: O(n), n operations, retrieve every next value from hash/dict
// Space Complexity: O(n), hash table stores order of n, recursion call stack is order of n
fun fibMemo(
    n: Int
): Int {
    if (n in memo)
        return memo[n]!!

    memo[n] = fibMemo(n - 1) + fibMemo(n - 2)
    return memo[n]!!
}

// Step 3: tabulation/bottom-up approach
// Time Complexity: O(n), n operations
// Space Complexity: O(n), 1d table array of size n
fun fibTab(
    n: Int
): Int {
    val tab1d = IntArray(n + 1)

    if (n > 0)
        tab1d[1] = 1

    var count = 1
    while (count < n) {
        count += 1
        tab1d[count] = tab1d[count - 1] + tab1d[count - 2]
    }

    return tab1d[n]
}

// Step 4: space optimized tabulation
// Time Complexity: O(n), n operations
// Space Complexity: O(1), only 2 variables
fun fibSpaceOptimized(
    n: Int
): Int {
    if (n < 2)
        return n

    var prev = 0
    var curr = 1

    var counter = 1
    while (counter < n) {
        val nxt = prev + curr
        counter += 1
        prev = curr
        curr = nxt
    }

    return curr
}