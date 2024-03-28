package com.kryptopass.katas.data_structures.m7

// NOTE: time complexity -> O(n^2)
fun <E: Comparable<E>> Array<E>.bubbleSort() {
    val len = size

    for (i in 0 until (len - 1)) {
        for (j in 0 until (len - i - 1)) {
            if (this[j] > this[j + 1]) {
                val temp = this[j]
                this[j] = this[j + 1]
                this[j + 1] = temp
            }
        }
    }
}

fun <E: Comparable<E>> Array<E>.bubbleDescending() {
    val len = size

    for (i in 0 until (len - 1)) {
        for (j in 0 until (len - i - 1)) {
            if (this[j] < this[j + 1]) {
                val temp = this[j]
                this[j] = this[j + 1]
                this[j + 1] = temp
            }
        }
    }
}

fun <E: Comparable<E>> MutableList<E>.bubbleSort() {
    val len = size

    for (i in 0 until (len - 1)) {
        for (j in 0 until (len - i - 1)) {
            if (this[j] > this[j + 1]) {
                val temp = this[j]
                this[j] = this[j + 1]
                this[j + 1] = temp
            }
        }
    }
}

fun <E: Comparable<E>> List<E>.bubbleSort(): List<E> {
    val len = size
    val resultList = toMutableList()

    for (i in 0 until (len - 1)) {
        for (j in 0 until (len - i - 1)) {
            if (resultList[j] > resultList[j + 1]) {
                val temp = resultList[j]
                resultList[j] = resultList[j + 1]
                resultList[j + 1] = temp
            }
        }
    }

    return resultList
}

fun main() {
    val nums = arrayOf(2, 12, 89, 23, 76, 43, 12)
    nums.bubbleSort()
    println(nums.contentToString())
    nums.bubbleDescending()
    println(nums.contentToString())

    val languages = mutableListOf("Kotlin", "Java", "C#", "R", "Python", "Scala", "Groovy", "C", "C++")
    languages.bubbleSort()
    println(languages)

    val doubles = listOf(1.2, 2.6, 10.2, 3.5, 200.4, 34.54, 12.3)
    val sortedDoubles = doubles.bubbleSort()
    println("Doubles Before Sort - $doubles")
    println("Doubles After Sort - $sortedDoubles")
}