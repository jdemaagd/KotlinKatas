package ds.m6

import kotlin.math.sqrt

// NOTE: unsorted collection -> time complexity -> O(n)
fun <E> Array<E>.linearSearch(element: E): Int {
    for ((index, value) in this.withIndex()) {
        if (value == element) return index
    }
    return -1
}

// NOTE: unsorted collection -> time complexity -> O(n)
fun <E> Collection<E>.linearSearch(element: E): Int {
    for ((index, value) in this.withIndex()) {
        if (value == element) return index
    }
    return -1
}

fun <E : Comparable<E>> Array<E>.linearSearchInSortedArray(element: E): Int {
    for ((index, value) in this.withIndex()) {
        if (value == element) return index
        else if (value > element) return -1
    }
    return -1
}

fun <E : Comparable<E>> Collection<E>.linearSearchInSortedCollection(element: E): Int {
    for ((index, value) in this.withIndex()) {
        if (value == element) return index
        else if (value > element) return -1
    }
    return -1
}

// NOTE: sorted collection -> time complexity -> O(log n)
fun <E: Comparable<E>> Array<E>.binarySearch(element: E): Int {
    var left = 0
    var right = size - 1
    while (left <= right) {
        var mid = (left + right) / 2
        val midVal = this[mid]
        val compare = midVal.compareTo(element)

        if (compare < 0) left = mid + 1
        else if (compare > 0) right = mid - 1
        else return mid             // element found
    }
    return -1                       // element not found
}

// NOTE: sorted collection -> time complexity -> O(log n)
fun <E: Comparable<E>> List<E>.binarySearch(element: E): Int {
    var left = 0
    var right = size - 1
    while (left <= right) {
        var mid = (left + right) / 2
        val midVal = this[mid]
        val compare = midVal.compareTo(element)

        if (compare < 0) left = mid + 1
        else if (compare > 0) right = mid - 1
        else return mid             // element found
    }
    return -1                       // element not found
}

// NOTE: sorted collection -> time complexity -> O(log n)
fun <E: Comparable<E>> Array<E>.binarySearch(element: E, start: Int, end: Int): Int {
    var left = start
    var right = end - 1
    while (left <= right) {
        var mid = (left + right) / 2
        val midVal = this[mid]
        val compare = midVal.compareTo(element)

        if (compare < 0) left = mid + 1
        else if (compare > 0) right = mid - 1
        else return mid             // element found
    }
    return -1                       // element not found
}

// NOTE: sorted collection -> time complexity -> O(log n)
fun <E: Comparable<E>> List<E>.binarySearch(element: E, start: Int, end: Int): Int {
    var left = start
    var right = end - 1
    while (left <= right) {
        var mid = (left + right) / 2
        val midVal = this[mid]
        val compare = midVal.compareTo(element)

        if (compare < 0) left = mid + 1
        else if (compare > 0) right = mid - 1
        else return mid             // element found
    }
    return -1                       // element not found
}

// NOTE: optimal value of m could be √n
fun <E: Comparable<E>> Array<E>.jumpSearch(element: E): Int {
    val size = this.size
    var step = sqrt(size.toDouble()).toInt()
    var prev = 0

    while (this[step.coerceAtMost(size) - 1] < element) {
        prev = step
        step *= 2
        if (prev >= size.toInt()) return -1
    }

    while(this[prev] < element) {
        prev++
        if (prev == step.coerceAtMost(size)) return -1
    }

    if (this[prev] == element) {
        return prev
    }
    return -1
}

// NOTE: optimal value of m could be √n
fun <E: Comparable<E>> List<E>.jumpSearch(element: E): Int {
    val size = this.size
    var step = sqrt(size.toDouble()).toInt()
    var prev = 0

    while (this[step.coerceAtMost(size) - 1] < element) {
        prev = step
        step *= 2
        if (prev >= size.toInt()) return -1
    }

    while(this[prev] < element) {
        prev++
        if (prev == step.coerceAtMost(size)) return -1
    }

    if (this[prev] == element) return prev
    return -1
}

fun <E: Comparable<E>> Array<E>.exponentialSearch(element: E): Int {
    if (this[0] == element) return 0

    var i = 1
    val len = this.size
    while(i < len && this[i] <= element) i *= 2

    return this.binarySearch(element, i/2, Math.min(i, len))
}

fun <E: Comparable<E>> List<E>.exponentialSearch(element: E): Int {
    if (this[0] == element) return 0

    var i = 1
    val len = this.size
    while(i < len && this[i] <= element) i *= 2

    return this.binarySearch(element, i/2, Math.min(i, len))
}
