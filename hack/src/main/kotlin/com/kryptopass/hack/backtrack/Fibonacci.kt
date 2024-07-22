package com.kryptopass.hack.backtrack

/*
The Fibonacci sequence appears in nature all around us, in the arrangement of seeds in a sunflower
    and the spiral of a nautilus for example.
Sequence begins with `fibonacci(0) = 0` and `fibonacci(1) = 1` as its first and second elements.
After these first two elements, each subsequent element is equal to sum of previous two elements.
Programmatically:
    `fibonacci(0) = 0`
    `fibonacci(1) = 1`
    `fibonacci(n) = fibonacci(n-1) + fibonacci(n-2)`
Given `n`, return the `n-th` number in the Fibonacci sequence.

Example
n = 5
The Fibonacci sequence to `6` is f = `[0, 1, 1, 2, 3, 5, 8]`.
With zero-based indexing, `f[5] = 5`.

Function Description
Complete the recursive function `fibonacci` in the editor below.
fibonacci has the following parameter(s):
    - int n: the index of the sequence to return

Returns
    - int: the `n-th` element in the Fibonacci sequence

Input Format
The integer `n`.

Constraints
    - `0 <= n <= 30`

Sample Input
STDIN   Function
-----   --------
3       n = 3

Sample Output
2

Explanation
The Fibonacci sequence begins as follows:
    `fibonacci(0) = 0`
    `fibonacci(1) = 1`
    `fibonacci(2) = (0 + 1) = 1`
    `fibonacci(3) = (1 + 1) = 2`
    `fibonacci(4) = (1 + 2) = 3`
    `fibonacci(5) = (2 + 3) = 5`
    `fibonacci(6) = (3 + 5) = 8`
    ...
    In the sequence above, `fibonacci(3)` is `2`.
 */
fun main() {
    val n = readln().trim().toInt()
    fibMemo(n).also(::println)
}

// Time Complexity: O(2^n), makes 2 recursive calls
//                  recurrence relation -> T(n) = T(n-1) + T(n-2) + O(1)
// Space Complexity: O(n), where n is max depth of recursion stack
fun fibRecursive(
    n: Int
): Int {
    if (n < 2) {
        return n
    }

    return fibRecursive(n - 1) + fibRecursive(n - 2)
}

// Time Complexity: O(n), computed fibonacci numbers are cached
//                  and subsequent recursive calls are retrieved from cache
//                  since each Fibonacci number is computed only once,
//                  total number of computations is proportional to `n`
// Space Complexity: O(n), space required for the recursion stack
//                   space required to cache computed Fibonacci numbers
val memo = mutableMapOf<Int, Int>()
fun fibMemo(
    n: Int
): Int {
    memo[0] = 0
    memo[1] = 1

    if (memo.containsKey(n)) {
        return memo[n]!!
    }

    memo[n] = fibMemo(n - 1) + fibMemo(n - 2)
    return memo[n]!!
}