package m1

// NOTE: Count Instructions
fun main() {
    // 1 - assigning the value10 to x
    val x = 10
    // 3 - look for x, multiply x by 2, assign result to y
    val y = x * 2

    // 2 - assignment instruction, comparison instruction, 2 more after 1st iteration (i++ and i < y)
    for (i in 0..y) {
        // 2n (mod and comp) + 2n (concat and print) = 4n
        if (i % 2 == 0) {
            println("$i is Even")
        } else {
            println("$i is Odd")
        }
    }
}