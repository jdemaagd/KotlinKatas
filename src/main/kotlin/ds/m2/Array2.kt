package ds.m2

import java.util.*

fun main() {
    val languages = arrayOf("Kotlin", "Java", "C", "C++", "C#", "JavaScript")

    for (i in languages.indices) {
        if (i % 2 == 0) {
            println(languages[i])
        } else {
            println(languages[i].uppercase(Locale.getDefault()))
        }
    }
    println()

    for ((index, value) in languages.withIndex()) {
        if (index % 2 == 0) {
            println("The element at $index is $value")
        } else {
            println("The element at $index is ${value.uppercase(Locale.getDefault())}")
        }
    }
    println()

    for (language in languages) {
        println("Language - $language")
    }
    println()

    languages.forEach {
        println("Language in Upper Case - ${it.uppercase(Locale.getDefault())}")
    }
    println()

    languages[1] = "Swift"
    languages[4] = "Objective-C"
    println("Newly updated languages are - ${languages.contentToString()}")
    println()

    languages.set(5, "TypeScript")
    //languages.set(6, "Dart")
    println("Newly updated languages are - ${languages.contentToString()}")
}