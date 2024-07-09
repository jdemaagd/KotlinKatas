package com.kryptopass.katas.dsa.backtracking

/*
Write a program to solve a Sudoku puzzle by filling the empty cells.
A sudoku solution must satisfy all the following rules:
    Each of the digits 1-9 must occur exactly once in each row.
    Each of the digits 1-9 must occur exactly once in each column.
    Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

Example -> see example.png

Constraints:
    board.length == 9
    board[i].length == 9
    board[i][j] is a digit or '.'.
    It is guaranteed that the input board has only one solution.
 */
fun main() {
    val board = arrayOf(
        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )
    solveSudoku(board)

    for (row in board) {
        println(row.joinToString(" "))
    }
}

/*
Time Complexity Analysis -> 𝑂(1), board is fixed size
    # operations is bounded by 9^(# empty cells) -> 9^81
Space Complexity Analysis -> 𝑂(1), no n to track
    max depth of recursion stack can be at most 81
 */
fun solveSudoku(
    board: Array<CharArray>
) {
    fun isValid(row: Int, col: Int, num: Char): Boolean {
        for (x in 0 until 9) {
            if (board[x][col] == num || board[row][x] == num) { // check row and column
                return false
            }

            // calculations to see board in a 3 x 3 sub-grid
            val r = 3 * (row / 3) + x / 3
            val c = 3 * (col / 3) + x % 3
            if (board[r][c] == num) {
                return false
            }
        }

        return true // valid `num`
    }

    fun fillBoard(): Boolean {
        for (row in 0 until 9) {
            for (col in 0 until 9) {
                if (board[row][col] == '.') {                   // identify next empty cell
                    for (num in '1'..'9') {
                        if (isValid(row, col, num)) {
                            board[row][col] = num               // choose step
                            if (fillBoard()) return true        // valid Sudoku board
                            board[row][col] = '.'               // backtracking step
                        }
                    }
                    return false    // need to backtrack, no numbers (1 - 9) were valid
                }
            }
        }
        return true // valid Sudoku board
    }

    fillBoard()
}
