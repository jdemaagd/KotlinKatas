package com.kryptopass.katas.dsa.`08_backtracking`

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

    // Print the solved board
    for (row in board) {
        println(row.joinToString(" "))
    }
}

/*
Time Complexity Analysis -> 𝑂(9^81), worst case, due to combinatorial explosion of trying every
  possible number in every cell, effective pruning reduces this significantly in practice
1. Recursive Backtracking
   each cell (empty cell `.`) can potentially take any digit from `1` to `9`
   worst-case could be making up to `9` choices for each of `81` cells on board
2. Pruning by `isValid` function
   `isValid` function helps in pruning search space by rejecting invalid numbers for a given cell,
     which significantly reduces actual number of recursive calls
   although this pruning is substantial, it doesn't change theoretical worst-case complexity
3. Practical Performance
   practical complexity is much lower than 𝑂(9^81) due to effectiveness of pruning early
   however, in worst-case scenario (such as having to try many combinations
     before finding a valid solution or proving no solution exists), complexity remains exponential

Space Complexity Analysis -> 𝑂(1)
1. Recursion Stack
   depth of recursion stack can go up to the number of cells, which is 81.
   therefore, space complexity due to recursion stack is 𝑂(81) = 𝑂(1)
2. Storage for the Board
   board itself takes 𝑂(81) = 𝑂(1) space as it's fixed in size (9x9 grid)
3. Auxiliary Space for `isValid` function
   `isValid` function does not use any additional space that scales with input size,
     so it doesn't contribute to space complexity
 */
fun solveSudoku(
    board: Array<CharArray>
) {
    fun isValid(
        row: Int,
        col: Int,
        num: Char
    ): Boolean {
        for (x in 0 until 9) {
            if (board[x][col] == num || board[row][x] == num) { // check row and column
                return false
            }

            // calculate start row and column index for 3x3 sub-box
            val r = 3 * (row / 3) + x / 3
            val c = 3 * (col / 3) + x % 3
            if (board[r][c] == num) { // check 3x3 sub-box
                return false
            }
        }

        return true // valid `num`
    }

    fun helper(): Boolean {
        for (row in 0 until 9) {
            for (col in 0 until 9) {
                if (board[row][col] == '.') { // identify next empty cell
                    for (num in '1'..'9') {
                        if (isValid(row, col, num)) {
                            board[row][col] = num // place number in cell

                            if (helper()) {
                                return true
                            }

                            board[row][col] = '.' // backtracking step
                        }
                    }
                    return false // require backtrack, no numbers were valid (1-9)
                }
            }
        }
        return true // valid Sudoku board
    }

    helper()
}
