package com.kryptopass.hack.backtrack

/*
Davis has a number of staircases in his house and he likes to climb each staircase 1, 2, or 3 steps at a time.
Being a very precocious child, he wonders how many ways there are to reach the top of the staircase.
Given the respective heights for each of the s staircases in his house,
find and print the number of ways he can climb each staircase, modulo `10^10 + 7` on a new line.

Example
n = 5
The staircase has 5 steps. Davis can step on the following sequences of steps:
1 1 1 1 1
1 1 1 2
1 1 2 1
1 2 1 1
2 1 1 1
1 2 2
2 2 1
2 1 2
1 1 3
1 3 1
3 1 1
2 3
3 2
There are 13 possible ways he can take these `5` steps and `13 modulo 10^10 + 7 = 13`.

Function Description
Complete the stepPerms function in the editor below.
stepPerms has the following parameter(s):
- int n: the number of stairs in the staircase

Returns
- int: the number of ways Davis can climb the staircase, modulo `10^10 + 7`

Input Format
The first line contains a single integer, `s`, the number of staircases in his house.
Each of the following `s` lines contains a single integer, `n`, the height of staircase `i`.

Constraints
1 <= s <= 5
1 <= n <= 36

Subtasks
1 <= n <= 20 for 50% of the maximum score.

Sample Input
STDIN Function
----- --------
3     s = 3 (number of staircases)
1     first staircase n = 1
3     second n = 3
7     third n = 7

Sample Output
1
4
44

Explanation
Let's calculate the number of ways of climbing the first two of the Davis' `3` staircases:
1. The first staircase only has n = `1` step, so there is only one way for him to climb it (i.e., by jumping `1` step).
   Thus, we print `1` on a new line.
2. The second staircase has n = `3` steps and he can climb it in any of the four following ways:
    1. 1 -> 1 -> 1
    2. 1 -> 2
    3. 2 -> 1
    4. 3
    Thus, we print `4` on a new line.

Dynamic Programming
1. Optimal substructure: problem can be broken down into smaller subproblems which can be solved independently
2. Overlapping Subproblems: subproblems are not independent and overlap, meaning same subproblems are solved multiple times
3. Recursive Definition: recursive way to define solution in terms of solutions to smaller subproblems
Use Cases
1. Fibonacci Sequence
2. Knapsack Problem
3. Shortest Path in a Graph
4. Climb Stairs (Davis' Staircase)

5
35
30
33
36
20

1132436852
53798080
334745777
2082876103
121415
 */

const val MOD = 10000000007

fun main() {
    val s = readln().trim().toInt()

    for (sItr in 1..s) {
        val n = readln().trim().toInt()

        stepPerms(n).let(::println)
    }
}

// Time Complexity: O(n), where n is the number of stairs in the staircase
//      base cases: (n == 0, n == 1, n == 2, n == 3) -> O(1), constant operations
//      array initialization: O(n)
//      loop to fill dp array: O(n), 4 to n
// Space Complexity: O(n), for dp array
fun stepPerms(n: Int): Long {
    if (n == 0) return 1
    if (n == 1) return 1
    if (n == 2) return 2
    if (n == 3) return 4

    val dp = LongArray(n + 1)
    dp[0] = 1
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4

    for (i in 4..n) {
        dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % MOD
    }

    return dp[n]
}
