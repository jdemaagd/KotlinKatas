package com.kryptopass.hack.misc

/*
A prime number is a natural number greater than `1` that has no positive divisors other than `1` and itself.
Given `p` integers, determine the primality of each integer and return `Prime` or `Not prime` on new line.
Note: If possible come up with an `O(sqrt(n))` primality algorithm, or see what sort of optimizations
you can come up with for an `O(n)` algorithm. Be sure to check out the Editorial after submitting your code.

Function Description
Complete the primality function in the editor below.
primality has the following parameter(s):
- int n: an integer to test for primality

Returns
- string: `Prime` if `n` is prime, or `Not prime`

Input Format
The first line contains an integer, `p`, the number of integers to check for primality.
Each of the `p` subsequent lines contains an integer, `n`, the number to test.

Constraints
1 <= p <= 30
1 <= n <= 2 * 10^9

Sample Input
STDIN   Function
-----   --------
3       p = 3 (number of values to follow)
12      n = 12 (first number to check)
5       n = 5
7       n = 7

Sample Output
Not prime
Prime
Prime

Explanation
We check the following `p = 3` integers for primality:
- `n = 12` is divisible by numbers other than `1` and itself (i.e.: `2`, `3`, `4`, `6`),
   so we print `Not prime` on a new line.
- `n = 5` is only divisible `1` and itself, so we print `Prime` on a new line.
- `n = 7` is only divisible `1` and itself, so we print `Prime` on a new line.

HandleCases:
If n is less than or equal to 1, it's not prime
If n is 2 or 3, it is prime, since 2 and 3 are smallest prime numbers
If n is even and greater than 2, it's not prime
Check Divisibility:
Iterate from 5 to sqrt(n) (inclusive) and check for divisibility
Skip even numbers by incrementing by 6 (check i and i+2 in each step)
 */
fun main() {
    val p = readln().toInt()
    repeat(p) {
        val n = readln().toInt()
        primality(n).also(::println)
    }
}

// Time Complexity: O(sqrt(n)), worst case loop runs up to sqrt of `n`,
//                  number of iterations is approximately `sqrt(n) / 6`
// Space Complexity: O(1)
fun primality(n: Int): String {
    if (n <= 1) return "Not prime"
    if (n <= 3) return "Prime"
    if (n % 2 == 0 || n % 3 == 0) return "Not prime"

    var i = 5
    while (i * i <= n) {
        if (n % i == 0 || n % (i + 2) == 0) return "Not prime"
        i += 6
    }

    return "Prime"
}