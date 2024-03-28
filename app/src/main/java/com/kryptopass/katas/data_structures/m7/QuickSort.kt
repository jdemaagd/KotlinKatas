package com.kryptopass.katas.data_structures.m7

// NOTE: time complexity -> O(n log n)
// in extreme worst case -> O(n2), but very especially if using random pivot
fun <E : Comparable<E>> Array<E>.quickSort() {
    quickSort(this, 0, size - 1)
}

private fun <E : Comparable<E>> quickSort(arr: Array<E>, low: Int, high: Int) {
    if (low < high) {
        val partitionIndex = partition(arr, low, high)

        quickSort(arr, low, partitionIndex - 1)
        quickSort(arr, partitionIndex + 1, high)
    }
}

private fun <E : Comparable<E>> partition(
    arr: Array<E>, low: Int, high: Int
): Int {
    val pivot = arr[high]
    var i = low - 1

    for (j in low until high) {
        if (arr[j] <= pivot) {
            i++
            arr[i] = arr[j].also { arr[j] = arr[i] }
        }
    }
    arr[i + 1] = arr[high].also { arr[high] = arr[i + 1] }

    return i + 1;
}

fun <E : Comparable<E>> MutableList<E>.quickSort() {
    quickSort(this, 0, size - 1)
}

private fun <E : Comparable<E>> quickSort(arr: MutableList<E>, low: Int, high: Int) {
    if (low < high) {
        val partitionIndex = partition(arr, low, high)

        quickSort(arr, low, partitionIndex - 1)
        quickSort(arr, partitionIndex + 1, high)
    }
}

private fun <E : Comparable<E>> partition(
    arr: MutableList<E>, low: Int, high: Int
): Int {
    val pivot = arr[high]
    var i = low - 1
    for (j in low until high) {
        if (arr[j] <= pivot) {
            i++
            arr[i] = arr[j].also { arr[j] = arr[i] }
        }
    }
    arr[i + 1] = arr[high].also { arr[high] = arr[i + 1] }

    return i + 1;
}

fun <E : Comparable<E>> List<E>.quickSort(): List<E> {
    val resultList = toMutableList()
    quickSort(resultList, 0, size - 1)

    return resultList
}

fun <E : Comparable<E>> Array<E>.quickDescending() {
    quickDescending(this, 0, size - 1)
}

private fun <E : Comparable<E>> quickDescending(
    arr: Array<E>, low: Int, high: Int
) {
    if (low < high) {
        val partitionIndex = descendingPartition(arr, low, high)

        quickDescending(arr, low, partitionIndex - 1)
        quickDescending(arr, partitionIndex + 1, high)
    }
}

private fun <E : Comparable<E>> descendingPartition(
    arr: Array<E>, low: Int, high: Int
): Int {
    val pivot = arr[high]
    var i = low - 1
    for (j in low until high) {
        if (arr[j] >= pivot) {
            i++
            arr[i] = arr[j].also { arr[j] = arr[i] }
        }
    }
    arr[i + 1] = arr[high].also { arr[high] = arr[i + 1] }

    return i + 1;
}

fun <E : Comparable<E>> MutableList<E>.quickDescending() {
    quickDescending(this, 0, size - 1)
}

private fun <E : Comparable<E>> quickDescending(
    arr: MutableList<E>, low: Int, high: Int
) {
    if (low < high) {
        val partitionIndex = descendingPartition(arr, low, high)

        quickDescending(arr, low, partitionIndex - 1)
        quickDescending(arr, partitionIndex + 1, high)
    }
}

private fun <E : Comparable<E>> descendingPartition(
    arr: MutableList<E>, low: Int, high: Int
): Int {
    val pivot = arr[high]
    var i = low - 1

    for (j in low until high) {
        if (arr[j] >= pivot) {
            i++
            arr[i] = arr[j].also { arr[j] = arr[i] }
        }
    }
    arr[i + 1] = arr[high].also { arr[high] = arr[i + 1] }

    return i + 1;
}

fun main() {
    val nums = arrayOf(2, 12, 89, 23, 76, 43, 12)
    nums.quickSort()
    println(nums.contentToString())

    val numbers = arrayOf(17, 12, 29, 21, 5, 7)
    numbers.quickSort()
    println(numbers.contentToString())

    val languages = mutableListOf("Kotlin", "Java", "C#", "R", "Python", "Scala", "Groovy", "C", "C++")
    languages.quickSort()
    println(languages)

    println()
    println("Descending Order")
    val numbers2 = arrayOf(2, 12, 89, 23, 76, 43, 12)
    numbers2.quickDescending()
    println(numbers2.contentToString())
    val list = arrayOf("Kotlin", "Java", "C", "C++", "R", "Python", "Matlab")
    list.quickDescending()
    println(list.contentToString())

    println()
    println("Immutable list sorting")
    val immutableLangs = listOf("Kotlin", "Java", "C#", "R", "Python", "Scala", "Groovy", "C", "C++")
    val sortedLangs = immutableLangs.quickSort()
    println(immutableLangs)
    println(sortedLangs)
}