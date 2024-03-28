package com.kryptopass.katas.data_structures.m7

// NOTE: performs a lil better than bubble/insertion sort
// but time complexity still -> O(n^2)
fun <E: Comparable<E>> Array<E>.insertionSort() {
    val len = size

    for (i in 1 until len) {
        var key = this[i]
        var j = i - 1;

        while(j >= 0 && this[j] > key) {
            this[j + 1] = this[j]
            j--
        }
        this[j + 1] = key
    }
}

fun <E: Comparable<E>> MutableList<E>.insertionSort() {
    val len = size

    for (i in 1 until len) {
        var key = this[i]
        var j = i - 1;

        while(j >= 0 && this[j] > key) {
            this[j + 1] = this[j]
            j--
        }
        this[j + 1] = key
    }
}

fun <E: Comparable<E>> List<E>.insertionSort(): List<E> {
    val len = size
    val resultList = toMutableList()

    for (i in 1 until len) {
        var key = resultList[i]
        var j = i - 1;

        while(j >= 0 && resultList[j] > key) {
            resultList[j + 1] = resultList[j]
            j--
        }
        resultList[j + 1] = key
    }

    return resultList
}

fun main() {
    val nums = arrayOf(2, 12, 89, 23, 76, 43, 12)
    nums.insertionSort()
    println(nums.contentToString())

    val languages = mutableListOf("Kotlin", "Java", "C#", "R", "Python", "Scala", "Groovy", "C", "C++")
    languages.insertionSort()
    println(languages)

    val nums1 = listOf(2, 12, 89, 23, 76, 43, 12)
    val result = nums1.insertionSort()
    println(nums1)
    println(result)
}