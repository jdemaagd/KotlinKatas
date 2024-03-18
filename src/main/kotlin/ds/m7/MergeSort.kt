package ds.m7

// NOTE: time complexity -> O(n log n)
fun <E : Comparable<E>> Array<E>.mergeSort(): Array<E> {
    if (size <= 1) return this

    val middle = size / 2
    val left = copyOfRange(0, middle)
    val right = copyOfRange(middle, size)

    return merge(this, left.mergeSort(), right.mergeSort())
}

private fun <E : Comparable<E>> merge(
    arr: Array<E>,
    left: Array<E>,
    right: Array<E>
): Array<E> {
    val leftArrSize = left.size
    val rightArrSize = right.size
    var leftArrIndex = 0
    var rightArrIndex = 0
    var index = 0

    while (leftArrIndex < leftArrSize && rightArrIndex < rightArrSize) {
        if (left[leftArrIndex] <= right[rightArrIndex]) {
            arr[index] = left[leftArrIndex]
            leftArrIndex++
        } else {
            arr[index] = right[rightArrIndex]
            rightArrIndex++
        }
        index++
    }

    while (leftArrIndex < leftArrSize) {
        arr[index] = left[leftArrIndex]
        leftArrIndex++
        index++
    }

    while (rightArrIndex < rightArrSize) {
        arr[index] = right[rightArrIndex]
        rightArrIndex++
        index++
    }

    return arr
}

fun <E : Comparable<E>> MutableList<E>.mergeSort(): MutableList<E> {
    if (size <= 1) return this

    val middle = size / 2
    val left = subList(0, middle)
    val right = subList(middle, size)

    return merge(left.mergeSort(), right.mergeSort())
}

private fun <E : Comparable<E>> merge(
    left: MutableList<E>,
    right: MutableList<E>
): MutableList<E> {
    val leftArrSize = left.size
    val rightArrSize = right.size
    var leftArrIndex = 0
    var rightArrIndex = 0
    val list: MutableList<E> = mutableListOf()

    while (leftArrIndex < leftArrSize && rightArrIndex < rightArrSize) {
        if (left[leftArrIndex] <= right[rightArrIndex]) {
            list.add(left[leftArrIndex])
            leftArrIndex++
        } else {
            list.add(right[rightArrIndex])
            rightArrIndex++
        }
    }

    while (leftArrIndex < leftArrSize) {
        list.add(left[leftArrIndex])
        leftArrIndex++
    }

    while (rightArrIndex < rightArrSize) {
        list.add(right[rightArrIndex])
        rightArrIndex++
    }

    return list
}

fun main() {
    val nums = arrayOf(2, 12, 89, 23, 76, 43, 12)
    nums.mergeSort()
    println(nums.contentToString())

    val languages = mutableListOf("Kotlin", "Java", "C#", "R", "Python", "Scala", "Groovy", "C", "C++")
    val sortedLanguages = languages.mergeSort()
    println(languages)
    println(sortedLanguages)
}