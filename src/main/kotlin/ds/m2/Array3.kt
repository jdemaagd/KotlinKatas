package ds.m2

import java.util.*

// NOTE: Array Iteration
fun main(args: Array<String>) {
    val languages = arrayOf("Kotlin", "Java", "C", "C++", "C#", "JavaScript", "Python")

    for (i in languages.indices) {
        if (i % 2 == 0) {
            println(languages[i])
        } else {
            println(languages[i].uppercase(Locale.getDefault()))
        }
    }

    for ((index, value) in languages.withIndex()) {
        if (index % 2 == 0) {
            println("The element at $index is $value")
        } else {
            println("The element at $index is ${value.uppercase(Locale.getDefault())}")
        }
    }

    for (language in languages) {
        println("Language - $language")
    }

    languages.forEach { println("Language in Upper Case - ${it.uppercase(Locale.getDefault())}") }
}