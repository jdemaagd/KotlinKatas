package com.kryptopass.hack.backtrack

/*
We define super digit of an integer x using the following rules:
Given an integer, we need to find the super digit of the integer.
- if x has only 1 digit, then its super digit is x.
- Otherwise, the super digit of x is equal to the super digit of the sum of the digits of x.
For example, the super digit of 9875 will be calculated as:
super_digit(9875)       9 + 8 + 7 + 5 = 29
super_digit(29)         2 + 9 = 11
super_digit(11)         1 + 1 = 2
super_digit(2)          = 2

Example
n = 9875,
k = 4
The number p is created by concatenating the string n k times. In this case, p = 9875987598759875.
superDigit(p) = superDigit(9875987598759875) = 9 + 8 + 7 + 5 + 9 + 8 + 7 + 5 + 9 + 8 + 7 + 5 + 9 + 8 + 7 + 5 = 116
superDigit(p) = superDigit(116) = 1 + 1 + 6 = 8
superDigit(p) = superDigit(8) = 8
All of the digits of p sum to 116. The digits of 116 sum to 8. 8 is only one digit, so it's the super digit.

Function Description
Complete the function superDigit in the editor below.
It must return the calculated super digit as an integer.
superDigit has the following parameter(s):
- string n: a string representation of an integer
- int k: an integer, the times to concatenate n to make p

Returns
- int: the super digit n repeated k times

Input Format
The first line contains two space-separated integers, n and k.

Constraints
1 <= n <= 10^100000
1 <= k <= 10^5

Sample Input 0
148 3

Sample Output 0
3

Explanation 0
Here n = 148 and k = 3, so p = 148148148.
superDigit(p) = superDigit(148148148)
              = superDigit(1 + 4 + 8 + 1 + 4 + 8 + 1 + 4 + 8)
              = superDigit(39)
              = superDigit(3 + 9)
              = superDigit(12)
              = superDigit(1 + 2)
              = superDigit(3)
              = 3

Sample Input 1
9875 4

Sample Output 1
8

Sample Input 2
123 3

Sample Output 2
9

Explanation 2
Here n = 123 and k = 3, so p = 123123123.
superDigit(p) = superDigit(123123123)
              = superDigit(1 + 2 + 3 + 1 + 2 + 3 + 1 + 2 + 3)
              = superDigit(18)
              = superDigit(1 + 8)
              = superDigit(9)
              = 9
 */
fun main() {
    superDigit("148", 3).also(::println) // 3
    superDigit("9875", 4).also(::println) // 8
    superDigit("123", 3).also(::println) // 9
}

// Time Complexity: O(L + log base 10 (k * sum of digits of n)),
//   sumOfDigits: O(L), where L is the number of digits in n,
//   recursiveSuperDigit: O(log base 10 (k * sum of digits of n)),
// Space Complexity: O(log base 10 (k * sum of digits of n)),
//   recursion depth is proportional to number of digits in number being reduced,
//   each recursive call adds a constant amount of space
fun superDigit(
    n: String, k: Int
): Int {
    fun sumOfDigits(s: String): Long {
        var sum = 0L
        for (char in s) {
            sum += (char - '0')
        }
        return sum
    }

    val initialSum = sumOfDigits(n) * k

    fun recursiveSuperDigit(num: Long): Int {
        if (num < 10)
            return num.toInt()

        val nextSum = num.toString().fold(0L) { acc, char -> acc + (char - '0') }

        return recursiveSuperDigit(nextSum)
    }

    return recursiveSuperDigit(initialSum)
}