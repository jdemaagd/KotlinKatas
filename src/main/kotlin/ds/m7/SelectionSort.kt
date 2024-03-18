package ds.m7

// NOTE: time complexity -> O(n^2)
fun <E: Comparable<E>> Array<E>.selectionSort() {
    val len = size

    // Find the minimum value of the array
    for (i in 0 until (len - 1)) {
        // Getting the index where minimum value is present
        var minIndex = i
        for (j in (i + 1) until len) {
            if (this[j] < this[minIndex]) minIndex = j
        }

        // We got the minimum element, now swap that to first element
        val temp = this[minIndex]
        this[minIndex] = this[i]
        this[i] = temp
    }
}

fun <E: Comparable<E>> MutableList<E>.selectionSort() {
    val len = size

    // Find the minimum value of the array
    for (i in 0 until (len - 1)) {
        // Getting the index where minimum value is present
        var minIndex = i
        for (j in (i + 1) until len) {
            if (this[j] < this[minIndex]) minIndex = j
        }

        // We got the minimum element, now swap that to first element
        val temp = this[minIndex]
        this[minIndex] = this[i]
        this[i] = temp
    }
}

fun <E: Comparable<E>> List<E>.selectionSort(): List<E> {
    val len = size
    val resultList = toMutableList()

    // Find the minimum value of the array
    for (i in 0 until (len - 1)) {
        // Getting the index where minimum value is present
        var minIndex = i
        for (j in (i + 1) until len) {
            if (resultList[j] < resultList[minIndex]) minIndex = j
        }

        // We got the minimum element, now swap that to first element
        val temp = resultList[minIndex]
        resultList[minIndex] = resultList[i]
        resultList[i] = temp
    }

    return resultList
}

fun main() {
    val nums = arrayOf(2, 12, 89, 23, 76, 43, 12)
    nums.selectionSort()
    println(nums.contentToString())

    val languages = mutableListOf("Kotlin", "Java", "C#", "R", "Python", "Scala", "Groovy", "C", "C++")
    languages.selectionSort()
    println(languages)

    val nums1 = listOf(2, 12, 89, 23, 76, 43, 12)
    val result = nums1.selectionSort()
    println(nums1)
    println(result)
}