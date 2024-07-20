package com.kryptopass.hack.array

/*
Starting with -1 indexed array of zeros and a list of operations, for each operation add a value to
each the array element between two given indices, inclusive.
Once all operations have been performed, return the maximum value in the array.

Example
n = 10
queries = [[1, 5, 3], [4, 8, 7], [6, 9, 1]]
Queries are interpreted as follows:
    a b k
    1 5 3
    4 8 7
    6 9 1
Add the values of k between the indices a and b inclusive:
index->	 1 2 3  4  5 6 7 8 9 10
        [0,0,0, 0, 0,0,0,0,0, 0]
        [3,3,3, 3, 3,0,0,0,0, 0]
        [3,3,3,10,10,7,7,7,0, 0]
        [3,3,3,10,10,8,8,8,1, 0]
The largest value is `10` after all operations are performed.

Function Description
Complete the function arrayManipulation in the editor below.
arrayManipulation has the following parameters:
    - int n: the number of elements in the array
    - int queries[q][3]: a two-dimensional array of queries where each queries[i] contains three integers, a, b, and k.

Returns
    - int: the maximum value in the resultant array

Input Format
The first line contains two space-separated integers n and m, the size of the array and the number of operations.
Each of the next m lines contains three space-separated integers a, b, and k, the left index, right index, and summand.

Constraints
    3 <= n <= 10^7
    1 <= m <= 2 * 10^5
    1 <= a <= b <= n
    0 <= k <= 10^9

Sample Input
5 3
1 2 100
2 5 100
3 4 100

Sample Output
200

Explanation
After the first update list will be `100 100 0 0 0`.
After the second update list will be `100 200 100 100 100`.
After the third update list will be `100 200 200 200 100`.
The required answer will be `200`.
 */
fun main() {
    arrayManipulation(
        5,
        arrayOf(arrayOf(1, 2, 100), arrayOf(2, 5, 100), arrayOf(3, 4, 100))
    ).also { println(it) }

    arrayManipulation(
        10,
        arrayOf(arrayOf(1, 5, 3), arrayOf(4, 8, 7), arrayOf(6, 9, 1))
    ).also { println(it) }

    arrayManipulation(
        10,
        arrayOf(arrayOf(1, 5, 3), arrayOf(4, 8, 7), arrayOf(6, 9, 1), arrayOf(2, 5, 3))
    ).also { println(it) }
}

// Time Complexity: O(n + m), where m is size of queries array and n is initialized array size
// Space Complexity: O(n), where n is the initialized array size
fun arrayManipulation(
    n: Int,
    queries: Array<Array<Int>>
): Long {
    val arr = LongArray(n + 1)

    for (query in queries) {
        val a = query[0] - 1
        val b = query[1]
        val k = query[2].toLong()

        arr[a] += k
        if (b < n) {
            arr[b] -= k
        }
    }

    var max = 0L
    var current = 0L

    for (value in arr) {
        current += value
        if (current > max) {
            max = current
        }
    }

    return max
}