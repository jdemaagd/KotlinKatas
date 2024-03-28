package com.kryptopass.kotlinkatas.data_structures.m6

fun main() {
    val languages = arrayOf("Kotlin", "Java", "Scala", "JavaScript", "C#")
    println("Java is at - ${languages.linearSearch("Java")}")
    println("Scala is at - ${languages.linearSearch("Scala")}")

    val students = arrayListOf("Chanse", "Rivu", "Siddappa", "Chanse")
    println("Siddappa is at - ${students.linearSearch("Siddappa")}")

    val uniqueStudents = setOf("Chanse", "Rivu", "Siddappa", "Chanse")
    println("Siddappa is at - ${uniqueStudents.linearSearch("Siddappa")}")

    println("==========Binary Search==========")
    val numbers = arrayOf(1, 45, 67, 234, 678, 5678, 34567, 909090)
    println("1 is at - ${numbers.binarySearch(1)}")
    println("45 is at - ${numbers.binarySearch(45)}")
    println("67 is at - ${numbers.binarySearch(67)}")
    println("234 is at - ${numbers.binarySearch(234)}")
    println("678 is at - ${numbers.binarySearch(678)}")
    println("5678 is at - ${numbers.binarySearch(5678)}")
    println("34567 is at - ${numbers.binarySearch(34567)}")
    println("909090 is at - ${numbers.binarySearch(909090)}")
    println("4 is at - ${numbers.binarySearch(4)}")

    println("==========Jump Search==========")
    println("1 is at - ${numbers.jumpSearch(1)}")
    println("45 is at - ${numbers.jumpSearch(45)}")
    println("67 is at - ${numbers.jumpSearch(67)}")
    println("234 is at - ${numbers.jumpSearch(234)}")
    println("678 is at - ${numbers.jumpSearch(678)}")
    println("5678 is at - ${numbers.jumpSearch(5678)}")
    println("34567 is at - ${numbers.jumpSearch(34567)}")
    println("909090 is at - ${numbers.jumpSearch(909090)}")
    println("5 is at - ${numbers.jumpSearch(5)}")

    println("==========Exponential Search==========")
    println("1 is at - ${numbers.exponentialSearch(1)}")
    println("45 is at - ${numbers.exponentialSearch(45)}")
    println("67 is at - ${numbers.exponentialSearch(67)}")
    println("234 is at - ${numbers.exponentialSearch(234)}")
    println("678 is at - ${numbers.exponentialSearch(678)}")
    println("5678 is at - ${numbers.exponentialSearch(5678)}")
    println("34567 is at - ${numbers.exponentialSearch(34567)}")
    println("909090 is at - ${numbers.exponentialSearch(909090)}")
    println("5 is at - ${numbers.exponentialSearch(5)}")
}
