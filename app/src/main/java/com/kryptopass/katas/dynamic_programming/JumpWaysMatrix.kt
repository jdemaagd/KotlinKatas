package com.kryptopass.katas.dynamic_programming

fun main() {
    println(jumpWaysMatrix(3))
    println(jumpWaysMatrix(4))
}

/*
There is a one-dimensional axis. In one turn, you can take a jump of length 1 or 2.
Find the total number of distinct ways using which you can reach from 0th coordinate to n-th coordinate?

Example One
{
    "n": 3
}
Output: 3
There are 3 distinct ways in which you can move from 0 to 3.
1. 1 length jump + 1 length jump + 1 length jump.
2. 1 length jump + 2 length jump.
3. 2 length jump + 1 length jump.

Example Two
{
    "n": 4
}
Output: 5 -> There are 5 distinct ways in which you can move from 0 to 4.

Constraints
1 <= n <= 70
 */

/*
    Asymptotic complexity in terms of input number, `n`:
    Time: O(log(n))
    Auxiliary space: O(1)
    Total space: O(1)
 */
fun jumpWaysMatrix(
    n: Int
): Long {
    if (n == 0 || n == 1) return 1

    val coefficientMatrix = arrayOf(arrayOf(1L, 1L), arrayOf(1L, 0L))
    val powerMatrix = matrixExponentiation(coefficientMatrix, n - 1)

    return powerMatrix[0][0] + powerMatrix[0][1]
}

fun matrixExponentiation(
    matrix: Array<Array<Long>>, n: Int
): Array<Array<Long>> {
    var matrixCopy = matrix.copyOf()
    var powerMatrix = arrayOf(arrayOf(1L, 0L), arrayOf(0L, 1L))
    var num = n

    while (num != 0) {
        if (num and 1 != 0)
            powerMatrix = matrixMultiplication(powerMatrix, matrixCopy)

        matrixCopy = matrixMultiplication(matrixCopy, matrixCopy)
        num = num shr 1
    }

    return powerMatrix
}

fun matrixMultiplication(
    a: Array<Array<Long>>,
    b: Array<Array<Long>>
): Array<Array<Long>> {
    val c = Array(2) { Array(2) { 0L } }

    for (i in 0 until 2) {
        for (j in 0 until 2) {
            c[i][j] = 0L
            for (k in 0 until 2)
                c[i][j] += a[i][k] * b[k][j]
        }
    }

    return c
}