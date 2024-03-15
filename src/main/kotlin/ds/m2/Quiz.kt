package ds.m2

// NOTE: Create array of numbers between 0 and 500 that are multiples of 10
val multiplesOfTen = Array(51) { i -> i * 10 }

// NOTE: Create array with all even indexed numbers of given array
fun evenIndexedNumbers(arr: Array<Int>): IntArray {
    return arr.filterIndexed { index, _ ->
        index % 2 == 0
    }.toIntArray()
}

// NOTE: Write snippet to find transpose of matrix (flip column/row indices)
fun transpose(matrix: Array<IntArray>): Array<IntArray>? {
    var transpose: Array<IntArray>? = null

    // Considering it is a valid matrix
    val row = matrix.size

    if (row > 0) {
        val column = matrix[0].size

        if (column > 0) {
            transpose = Array(column) { IntArray(row) }
            for (i in 0 until row) {
                for (j in 0 until column) {
                    transpose[j][i] = matrix[i][j]
                }
            }
        }
    }

    return transpose
}

// NOTE: Write snippet to append elements of two arrays
val arr1 = arrayOf(10, 20, 30)
val arr2 = arrayOf(100, 200, 300)
val result = arr1 + arr2

// NOTE: Write snippet to convert wrapper typed array to a primitive array
val intArray = arrayOf(1, 2, 3, 4, 5)
val output = intArray.toIntArray()
val doubleArray = arrayOf(1.2, 3.5, 4.8, 9.0)
val output1 = doubleArray.toDoubleArray()

fun main() {
    println(multiplesOfTen.contentToString())
    println()

    val arr = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(evenIndexedNumbers(arr).contentToString())
    println()

    val matrix = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6)
    )
    println(transpose(matrix).contentDeepToString())
    println()

    println(result.contentToString())
    println()

    println(output.contentToString())
    println()
    println(output1.contentToString())
}