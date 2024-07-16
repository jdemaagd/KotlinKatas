package com.kryptopass.hack.warmup

/*
There is a new mobile game that starts with consecutively numbered clouds.
Some of the clouds are thunderheads and others are cumulus.
Player can jump on any cumulus cloud having a number that is equal to number of current cloud plus `1` or `2`.
The player must avoid the thunderheads.
Determine minimum number of jumps it will take to jump from starting position to last cloud.
It is always possible to win the game.
For each game, you will get an array of clouds numbered if they are safe or if they must be avoided.

Example
c = [0, 1, 0, 0, 0, 1, 0]
Index the array from `0...6`. Number on each cloud is its index in list so player must avoid clouds at indices `1` and `5`.
Player could follow these two paths: `0 -> 2 -> 4 -> 6` or `0 -> 2 -> 3 -> 4 -> 6`.
First path takes `3` jumps while second takes `4`. Return `3`.

Function Description
Complete the jumpingOnClouds function in the editor below.
jumpingOnClouds has the following parameter(s):
    - int c[n]: an array of binary integers

Returns
    - int: the minimum number of jumps required

Input Format
First line contains an integer `n`, the total number of clouds.
Second line contains `n` space-separated binary integers describing clouds `c[i]` where `0 <= i < n`.

Constraints
    - 2 <= n <= 100
    - c[i] is in {0, 1}
    - c[0] = c[n-1] = 0

Output Format
Print the minimum number of jumps needed to win the game.

Sample Input 0
7
0 0 1 0 0 1 0

Sample Output 0
4

Explanation 0
The player must avoid `c[2]` and `c[5]`.
The game can be won with a minimum of `4` jumps: `0 -> 1 -> 3 -> 4 -> 6`.

Sample Input 1
6
0 0 0 0 1 0

Sample Output 1
3

Explanation 1
The only thunderhead to avoid is `c[4]`.
 */
fun main() {
    val n = 7
    val c = arrayOf(0, 0, 1, 0, 0, 1, 0)
    jumpingClouds(n, c).also(::println)

    val n1 = 6
    val c1 = arrayOf(0, 0, 0, 0, 1, 0)
    jumpingClouds(n1, c1).also(::println)

    val n2 = 6
    val c2 = arrayOf(0, 0, 0, 0, 0, 0)
    jumpingClouds(n2, c2).also(::println)

    val n3 = 7
    val c3 = arrayOf(0, 1, 0, 0, 0, 1, 0)
    jumpingClouds(n3, c3).also(::println)
}

// Time Complexity: O(n), where n is the size of the array
// Space Complexity: O(1)
fun jumpingClouds(
    n: Int,
    c: Array<Int>
): Int {
    var jumps = 0

    var i = 0
    while (i < n - 1) {
        if (i + 2 < n && c[i + 2] == 0) {
            i += 2
        } else {
            i++
        }
        jumps++
    }

    return jumps
}