package com.kryptopass.katas.data_structures.m9.basics

import java.util.*

// NOTE: lazy delegate allows you to initialize a variable in a lazy manner
// when it's first used, but once it's initialized,
// it always returns the same value, and never calls the block again
val immutableRandomValue: String by lazy {
    getRandomValue()
}

fun getRandomValue(): String {
    val rand = Random().nextInt()
    return "Value $rand"
}

fun main() {
    println("getRandomValue() will return different values at each call")
    println("1. ${getRandomValue()}")
    println("2. ${getRandomValue()}")

    println("\nHowever, immutableRandomValue will return the same value at each call")
    println("1. $immutableRandomValue")
    println("2. $immutableRandomValue")
}