package ds.m1

fun main() {
    // 1: can be found in first iteration, example of best case
    // 38: since it's somewhere in middle of input, we can get result in approximately n/2 iterations (average case)
    // 81: since it's last item of input array, result will come at the nth iteration (worst case)
    // 102: since it isn't present, the result will be produced at the nth iteration (worst case)

    val target = 97
    var input = intArrayOf(1, 5, 67, 56, 38, 97, 34, 50, 81)

    find(input, target)
}

private fun find(
    input: IntArray, item: Int
) {
    for (i in input.indices) {
        if (input[i] == item) {
            print("Item found at index - $i")
        }
    }
}