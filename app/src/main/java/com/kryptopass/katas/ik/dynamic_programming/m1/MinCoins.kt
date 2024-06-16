package com.kryptopass.katas.dynamic_programming.m1

fun main() {
    println(minCoinsDP(arrayListOf(1, 3, 5), 9))
}

/*
Minimum Coins
Given a variety of coin types defining a currency system,
find the minimum number of coins required to express a given amount of money.
Assume infinite supply of coins of every type.

Example
{
    "coins": [1, 3, 5],
    "value": 9
}
Output: 3
Here are all the unique ways to express 9 as a sum of coins 1, 3 and 5:
1, 1, 1, 1, 1, 1, 1, 1, 1
1, 1, 1, 1, 1, 1, 3
1, 1, 1, 1, 5
1, 1, 1, 3, 3
1, 3, 5
3, 3, 3
Last two ways use the minimal number of coins, 3.

Notes
There will be no duplicate coin types in the input.

Constraints:
1 <= number of coin types <= 10^2
1 <= coin value <= 10^2
1 <= amount of money to express <= 10^4
 */

/*
    Asymptotic complexity in terms of `n` = size of the input array and `value`:
    Time: O(n^value)
    Auxiliary space: O(value)
    Total space: O(n + value)
 */
fun minCoins(
    coins: ArrayList<Int>, value: Int
): Int {
    if (value == 0) return 0

    var globalMin = 100005
    for (i in coins.indices) {
        if (coins[i] <= value) {
            val localMin = minCoins(coins, value - coins[i])
            if (localMin + 1 < globalMin) globalMin = localMin + 1
        }
    }

    return globalMin
}

/*
    Asymptotic complexity in terms of `n` =  size of the input array and `value`:
    Time: O(n * value)
    Auxiliary space: O(value)
    Total space: O(n + value)
 */
fun minCoinsDP(
    coins: List<Int>, value: Int
): Int {
    val dp = IntArray(value + 1) { Int.MAX_VALUE }

    dp[0] = 0

    val n = coins.size
    for (i in 1..value)
        for (j in 0 until n)
            if (i >= coins[j] && 1 + dp[i - coins[j]] < dp[i])
                dp[i] = 1 + dp[i - coins[j]]

    return dp[value]
}