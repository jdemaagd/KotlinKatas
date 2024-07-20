package com.kryptopass.hack.misc

/*
You will be given a list of 32 bit unsigned integers.
Flip all the bits (`1 -> 0` and `0 -> 1`) and return the result as an unsigned integer.

Example
n = 9 base 10
9 base 10 = 1001 base 2. We're working with 32 bits, so:
0000 0000 0000 0000 0000 0000 0000 1001 base 2 = 9 base 10
1111 1111 1111 1111 1111 1111 1111 0110 base 2 = 4294967286 base 10
Return 4294967286.

Function Description
Complete the flippingBits function in the editor below.
flippingBits has the following parameter(s):
- int n: an integer

Returns
- int: the unsigned decimal integer result

Input Format
The first line of the input contains `q`, the number of queries.
Each of the next `q` lines contain an integer, `n`, to process.

Constraints
1 <= q <= 100
0 <= n <= 2^32

Sample Input 0
3
2147483647
1
0

Sample Output 0
2147483648
4294967294
4294967295

Explanation 0
01111111111111111111111111111111 base 2 = 2147483647 base 10
10000000000000000000000000000000 base 2 = 2147483648 base 10
00000000000000000000000000000001 base 2 = 1 base 10
11111111111111111111111111111110 base 2 = 4294967294 base 10
00000000000000000000000000000000 base 2 = 0 base 10
11111111111111111111111111111111 base 2 = 4294967295 base 10

Sample Input 1
2
4
123456

Sample Output 1
4294967291
4294843839

Explanation 1
00000000000000000000000000000100 base 2 = 4 base 10
11111111111111111111111111111011 base 2 = 4294967291 base 10
00000000000000011110001001000000 base 2 = 123456 base 10
11111111111111100001110110111111 base 2 = 4294843839 base 10

Sample Input 2
3
0
802743475
35601423

Sample Output 2
4294967295
3492223820
4259365872

Explanation 2
00000000000000000000000000000000 base 2 = 0 base 10
11111111111111111111111111111111 base 2 = 4294967295 base 10
00101111110111011010001001100011 base 2 = 802743475 base 10
1100001100100010010111011101100 base 2 = 3492223820 base 10
00000010001010101111100110111111 base 2 = 35601423 base 10
11010011101110010000000000000000 base 2 = 4259365872 base 10

XOR vs NOT
XOR `exclusive OR` compares corresponding bits of two operands
    and returns 1 if bits are different, and 0 if they are same
NOT `bitwise complement` inverts all bits of its operand
 */
fun main() {
    val numbers = arrayOf(2147483647, 1, 0)
    for(i in 0 until 3) {
        flippingBits(numbers[i]).also(::println)
    }
    println()
    val numbers1 = arrayOf(4, 123456)
    for(i in 0 until 2) {
        flippingBits(numbers1[i]).also(::println)
    }
    println()
    val numbers2 = arrayOf(0, 802743475, 35601423)
    for(i in 0 until 3) {
        flippingBits(numbers2[i]).also(::println)
    }

    println()
    val queries = listOf(2147483647, 1, 0, 4, 123456, 0, 802743475, 35601423)
    val results = processQueries(queries)
    results.forEach { println(it) }

    println()
    flippingBits(9).also(::println)
}

// Time Complexity: O(1)
// Space Complexity: O(1)
fun flippingBits(n: Int): Long {
    // performs a bitwise XOR operation between `n.toLong()` and `0xFFFFFFFFL`
    return n.toLong() xor 0xFFFFFFFFL
}

// `inv()` function performs a bitwise NOT operation on `Long`
// `and 0xFFFFFFFFL` ensures that result is within 32 bits by applying a bitwise AND
// with 0xFFFFFFFFL (a 32-bit mask with all bits set to 1)
fun flippingBits2(n: Int): Long {
    return n.toLong().inv() and 0xFFFFFFFFL
}

fun processQueries(queries: List<Int>): List<Long> {
    return queries.map { flippingBits2(it) }
}