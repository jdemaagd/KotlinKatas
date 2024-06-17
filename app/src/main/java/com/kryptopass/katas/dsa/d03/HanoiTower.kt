package com.kryptopass.katas.dsa.d03

/*
Tower of Hanoi:
We have three rods and N disks.
The objective of the puzzle is to move the entire stack to another rod.
Initially, these discs are in the rod 1.
You need to print all the steps of discs movement so that all the discs reach the 3rd rod.
Also, find & return the total moves.

Note: The discs are arranged such that the top disc is numbered 1 and the bottom-most disc is numbered N.
Also, all the discs have different sizes and a bigger disc cannot be put on the top of a smaller disc.
You can only move 1 disk at a time.
 */
fun main() {
    println(hanoiTower(3, 1, 3, 2))
}

// Time Complexity: O(2^n) -> 2^n - 1 moves -> 2^n
//   1 disk: 1 move
//   2 disks: 3 moves
//   3 disks: 7 moves
//   4 disks: 15 moves
//   T(n) = 2 * T(n - 1) + 1
//        = 2 [2 * T(n - 2) + 1] + 1
//        = 2 [2 * [2 * T(n - 3) + 1] + 1] + 1
// Space Complexity: O(n) -> recursive call stack
fun hanoiTower(
    n: Int, src: Int, dest: Int, aux: Int
): Int {
    var count = 0

    fun helper(
        disks: Int, srcRod: Int, destRod: Int, auxRod: Int
    ) {
        if (disks == 1) {
            println("move disk $disks from rod $srcRod to rod $destRod")
            count++
            return
        }
        helper(disks - 1, srcRod, auxRod, destRod)    // swap dest and aux rods
        println("move disk $disks from rod $srcRod to rod $destRod")
        count++
        helper(disks - 1, auxRod, destRod, srcRod)    // swap src and aux rods
    }

    helper(n, src, dest, aux)

    return count
}
