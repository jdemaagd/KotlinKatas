package com.kryptopass.hack.greedy

/*
Absolute difference is positive difference between two values `a` and `b`,
    is written `|a - b|` or `|b - a|` and they are equal.
If `a = 3` and `b = 2`, `|3 - 2| = |2 - 3| = 1`.
Given an array of integers, find minimum absolute difference between any two elements in the array.

Example arr = |-2, 2, 4|
There are `3` pairs of numbers: |-2, 2|, |-2, 4| and |2, 4|.
The absolute differences for these pairs are |(-2) - 2| = 4, |(-2) - 4| = 6 and |2 - 4| = 2.
The minimum absolute difference is `2`.

Function Description
Complete the `minimumAbsoluteDifference` function in the editor below.
It should return an integer that represents minimum absolute difference between any pair of elements.
minimumAbsoluteDifference has the following parameter(s):
    arr: an array of integers

Returns
    int: the minimum absolute difference found

Input Format
The first line contains a single integer `n`, the size of `arr`.
The second line contains `n` space-separated integers `arr[i]`.

Constraints
    2 <= n <= 10^5
    -10^9 <= arr[i] <= 10^9

Sample Input 0
3
3 -7 0

Sample Output 0
3

Explanation 0
The first line of input is the number of array elements. The array, `arr = [3, -7, 0]`
There are three pairs to test: `(3, -7)`, `(3, 0)` and `(-7, 0)`.
The absolute differences for these pairs are `10`, `3` and `7`.
Remember that the order of values in the subtraction does not influence the result.
The smallest absolute difference is `3`.

Sample Input 1
10
-59 -36 -13 1 -53 -92 -2 -96 -54 75

Sample Output 1
1

Explanation 1
Then smallest absolute difference is |-54 - -53| = 1.

Sample Input 2
5
1 -3 71 68 17

Sample Output 2
3

Explanation 2
The smallest absolute difference is |71 - 68| = 3.
 */
fun main() {
    val arr = arrayOf(3, -7, 0)
    println(minDiff(arr)) // 3

    val arr1 = arrayOf(-59, -36, -13, 1, -53, -92, -2, -96, -54, 75)
    println(minDiff(arr1)) // 1

    val arr2 = arrayOf(1, -3, 71, 68, 17)
    println(minDiff(arr2)) // 3
}

// Time Complexity: O(n log n),
//   sorting using comparison-based sorting algorithm -> O(n log n)
//   loop iterates through the array once -> O(n), sort is dominant term
// Space Complexity: O(n), with standard library (TimSort)
//   could be O(1) if we assume in-place sorting
fun minDiff(
    arr: Array<Int>
): Int {
    if (arr.size < 2)
        throw IllegalArgumentException("Array must have at least two elements")

    arr.sort()

    var minDifference = Int.MAX_VALUE

    for (i in 1 until arr.size) {
        val difference = kotlin.math.abs(arr[i] - arr[i - 1])
        if (difference < minDifference) {
            minDifference = difference
        }
    }

    return minDifference
}