package com.kryptopass.katas.dsa.`02_recursion`

fun main() {
    seq(4)
    println()

    println(sumInc(0, 5))
    println()
    println(sumDec(5))

    println()
    println(factorial(7))
    print(fibonacci(12))
    println()
}

fun seq(n: Int) {
    if (n == 0)
        return

    println(n)
    seq(n - 1)
    println(n)
}

// NOTE: 0 to n recursive approach
fun sumInc(start: Int, end: Int): Int {
    if (start == end)
        return end

    return start + sumInc(start + 1, end)
}

// NOTE: n to 0 recursive approach
fun sumDec(end: Int): Int {
    if (end == 0)
        return 0

    return end + sumDec(end - 1)
}

fun factorial(n: Int): Int {
    if (n == 0)
        return 1

    return n * factorial(n - 1)
}

fun fibonacci(n: Int): Int {
    if (n < 2)
        return n

    return fibonacci(n - 1) + fibonacci(n - 2)
}
