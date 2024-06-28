package com.kryptopass.katas.dsa.d08

/*
n-queens puzzle is problem of placing n queens on an n x n chessboard such that no two queens attack each other
Given an integer n, return all distinct solutions to the n-queens puzzle.
You may return the answer in any order.
Each solution contains a distinct board configuration of the n-queens' placement,
where 'Q' and '.' both indicate a queen and an empty space, respectively.

Example 1
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

Example 2
Input: n = 1
Output: [["Q"]]

Constraints:
    1 <= n <= 9

Observations:
1. only one queen per row
2. checking row by row, so only need to check col up to current row
   and left/right diagonals up to current row
 */
fun main() {
    println(solveNQueens(4))
    println(solveNQueens(1))
}

/*
Time Complexity Analysis -> 𝑂(𝑛!), worst case
1. Recursive Backtracking
   for each row, we try to place a queen in each column, there are `n` columns, and for each column,
     we call recursive function to place next queen in next row
   worst case, recursive function will explore all possible placements of queens in the grid, this
     exploration resembles a full permutation of placing `n` queens on the board, which can be
     visualized as trying every combination of placing `n` queens in `n` rows,
     leading to a branching factor of `n`
   hence, max # of recursive calls can be approximated as 𝑂(𝑛!)
     first row has `n` choices
     second row has `n-1` choices (since one column is already occupied by the first queen)
     third row has `n-2` choices, and so on, leading to `n * (n-1) * (n-2) * ... * 1 = n!`
2. Checking Validity
   `isValid` function checks column and diagonals for conflicts
   checking column and each diagonal involves a linear scan up to the current row -> 𝑂(𝑛)
   `isValid` is called for each cell in each row,
     complexity of checking validity for one full board configuration is 𝑂(𝑛^2)

Space Complexity Analysis -> 𝑂(𝑛^2 + 𝑛 * 𝑛!)
1. Board Storage
   board is an `n x n` grid, represented by a 2D array of characters -> 𝑂(𝑛^2) space
2. Recursion Stack
   depth of recursion stack can go up to `n`, as we place one queen per row
   space used by recursion stack is 𝑂(𝑛)
3. Auxiliary Lists
   `res` list stores all the valid solutions, number of solutions can vary, but in worst case,
     there are 𝑂(𝑛!) solutions, and each solution requires 𝑂(𝑛) space to store board configuration
   space complexity for storing solutions is 𝑂(𝑛 * 𝑛!)
4. Temporary Variables
   `convertBoard` and loops within `isValid` and `positionNextQueen` use temporary variables,
   but their space usage is negligible compared to board and recursion stack
 */
fun solveNQueens(n: Int): List<List<String>> {
    val res = mutableListOf<List<String>>()
    val board = Array(n) { CharArray(n) { '.' } }

    fun convertBoard(board: Array<CharArray>): List<String> {
        return board.map { String(it) }
    }

    // check if placing a queen at (row, col) is valid
    fun isValid(row: Int, col: Int, board: Array<CharArray>): Boolean {
        // check column up to this row
        for (x in 0 until row) {
            if (board[x][col] == 'Q') return false
        }

        // check top left diagonal
        var r = row
        var c = col
        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q') return false
            r--
            c--
        }

        // check top right diagonal
        r = row
        c = col
        while (r >= 0 && c < n) {
            if (board[r][c] == 'Q') return false
            r--
            c++
        }

        return true
    }

    fun positionNextQueen(board: Array<CharArray>, row: Int) {
        if (row == n) {
            res.add(convertBoard(board))
            return
        }

        for (col in 0 until n) {
            if (isValid(row, col, board)) {
                board[row][col] = 'Q'
                positionNextQueen(board, row + 1)
                board[row][col] = '.' // backtracking step
            }
        }
    }

    positionNextQueen(board, 0)

    return res
}