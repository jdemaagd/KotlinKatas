package com.kryptopass.hack.array

/*
A left rotation operation on an array shifts each of the array's elements `1` unit to the left.
For example, if `2` left rotations are performed on array `[1, 2, 3, 4, 5]`,
    then the array would become `[3, 4, 5, 1, 2]`.
Note that the lowest index item moves to the highest index in a rotation.
This is called a circular array.
Given an array `a` of `n` integers and a number, `d`, perform `d` left rotations on the array.
Return the updated array to be printed as a single line of space-separated integers.

Function Description
Complete the function rotLeft in the editor below.
rotLeft has the following parameter(s):
    - int a[n]: the array to rotate
    - int d: the number of rotations

Returns
    - int a[n]: the rotated array

Input Format
The first line contains two space-separated integers `n` and `d`, the size of `a` and the number of left rotations.
The second line contains `n` space-separated integers, each an `a[i]`.

Constraints
    1 <= n <= 10^5
    1 <= d <= n
    1 <= a[i] <= 10^6

Sample Input
5 4
1 2 3 4 5

Sample Output
5 1 2 3 4

Explanation
When we perform `d = 4` left rotations, the array undergoes the following sequence of changes:
[1, 2, 3, 4, 5] -> [2, 3, 4, 5, 1] -> [3, 4, 5, 1, 2] -> [4, 5, 1, 2, 3] -> [5, 1, 2, 3, 4]
 */
fun main() {
    rotLeft(arrayOf(1, 2, 3, 4, 5), 4).also { println(it.joinToString(" ")) }
}

// Time Complexity: O(n), where n is the size of the array
// Space Complexity: O(n), where n is the size of the array
fun rotLeft(
    a: Array<Int>,
    d: Int
): Array<Int> {
    val n = a.size
    val result = Array(n) { 0 }

    for (i in a.indices) {
        val newIndex = (i + n - d) % n
        result[newIndex] = a[i]
    }

    return result
}