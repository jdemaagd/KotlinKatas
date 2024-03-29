package com.kryptopass.katas.data_structures.m7

// NOTE: time complexity -> O(n log n)
fun <E : Comparable<E>> Array<E>.heapSort() {
    val middle = size / 2 - 1
    for (i in middle downTo 0) {
        heapify(this, size, i)
    }
    for (i in size - 1 downTo 0) {
        this[0] = this[i].also { this[i] = this[0] }
        heapify(this, i, 0)
    }
}

private fun <E : Comparable<E>> heapify(arr: Array<E>, heapSize: Int, root: Int) {
    var largest = root
    val leftNode = 2 * root + 1
    val rightNode = 2 * root + 2
    if (leftNode < heapSize && arr[leftNode] > arr[largest]) largest = leftNode
    if (rightNode < heapSize && arr[rightNode] > arr[largest]) largest = rightNode

    if (largest != root) {
        arr[root] = arr[largest].also { arr[largest] = arr[root] }
        heapify(arr, heapSize, largest)
    }
}

fun <E : Comparable<E>> MutableList<E>.heapSort() {
    val middle = size / 2 - 1
    for (i in middle downTo 0) {
        heapify(this, size, i)
    }
    for (i in size - 1 downTo 0) {
        this[0] = this[i].also { this[i] = this[0] }
        heapify(this, i, 0)
    }
}

private fun <E : Comparable<E>> heapify(
    arr: MutableList<E>, heapSize: Int, root: Int
) {
    var largest = root
    val leftNode = 2 * root + 1
    val rightNode = 2 * root + 2

    if (leftNode < heapSize && arr[leftNode] > arr[largest]) largest = leftNode
    if (rightNode < heapSize && arr[rightNode] > arr[largest]) largest = rightNode

    if (largest != root) {
        arr[root] = arr[largest].also { arr[largest] = arr[root] }
        heapify(arr, heapSize, largest)
    }
}

fun main() {
    val nums = arrayOf(2, 12, 89, 23, 76, 43, 12)
    nums.heapSort()
    println(nums.contentToString())

    val languages = mutableListOf("Kotlin", "Java", "C#", "R", "Python", "Scala", "Groovy", "C", "C++")
    languages.heapSort()
    println(languages)
}