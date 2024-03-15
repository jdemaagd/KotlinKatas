package ds.m2

fun isValidMatrix(
    arr: Array<Array<*>>
): Boolean {
    var isValid = true
    var sizeOfRow = arr[0].size

    // Can be optimized more by iterating from 1st index instead of 0th
    for (row in arr) {
        if (sizeOfRow != row.size) {
            isValid = false
            break
        }
    }

    return isValid
}

fun add(
    a: Array<DoubleArray>,
    b: Array<DoubleArray>
): Array<DoubleArray> {
    val m = a.size
    val n = a[0].size
    val c = Array(m) { DoubleArray(n) }

    for (i in 0 until m)
        for (j in 0 until n)
            c[i][j] = a[i][j] + b[i][j]

    return c
}

fun multiply(
    a: Array<DoubleArray>,
    b: Array<DoubleArray>
): Array<DoubleArray> {
    val m1 = a.size
    val n1 = a[0].size
    val m2 = b.size
    val n2 = b[0].size

    if (n1 != m2) throw RuntimeException("Illegal matrix dimensions.")
    val c = Array(m1) { DoubleArray(n2) }

    for (i in 0 until m1)
        for (j in 0 until n2)
            for (k in 0 until n1)
                c[i][j] += a[i][k] * b[k][j]

    return c
}