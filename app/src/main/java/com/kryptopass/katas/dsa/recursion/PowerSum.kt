package com.kryptopass.katas.dsa.recursion

import kotlin.math.pow

/*
Let's define a peculiar type of array in which each element is either an integer or another peculiar array.
Assume that a peculiar array is never empty.
Write a function that will take a peculiar array as its input and find the sum of its elements.
If an array is an element in the peculiar array you have to convert it to its equivalent value
so that you can sum it with the other elements.
Equivalent value of an array is the sum of its elements raised to the number which represents how far nested it is.
For e.g. [2, 3[4, 1, 2]] = 2 + 3 + (4 + 1 + 2) ^ 2
[1, 2, [7, [3, 4], 2]] = 1 + 2 + (7 + (3 + 4) ^ 3 + 2) ^ 2
 */
fun main() {
    powerSum(arrayOf(2, 3, arrayOf(4, 1, 2))).also { println(it) }                      // 54
    powerSum(arrayOf(1, 2, arrayOf(7, arrayOf(3, 4), 2))).also { println(it) }          // 123907
    powerSum(arrayOf(1, 2, arrayOf(3, 4), arrayOf(arrayOf(2)))).also { println(it) }    // 116
}

// Time complexity: O(n), where n is total elements in main and sub arrays
// Space complexity: O(d), where d is maximum depth of call stack
fun powerSum(
    list: Any,
    power: Int = 1
): Int {
    var sum = 0
    for (i in list as Array<*>) {
        sum += if (i is Array<*>) {
            powerSum(i, power + 1)
        } else {
            i as Int
        }
    }

    return sum.toDouble().pow(power).toInt()
}