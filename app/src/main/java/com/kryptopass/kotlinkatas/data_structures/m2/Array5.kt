package com.kryptopass.kotlinkatas.data_structures.m2

// NOTE: Array Update
fun main(args: Array<String>) {
    val languages = arrayOf("Kotlin", "Java", "C", "C++", "C#", "JavaScript", "Python")

    languages[1] = "Swift"
    languages[4] = "Objective-C"
    println("Newly updated languages are - ${languages.contentToString()}")

    println()
    languages.set(5, "TypeScript")
    languages.set(6, "Dart")
    println("Newly updated languages are - ${languages.contentToString()}")
}