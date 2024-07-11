package com.kryptopass.katas.dsa.backtracking

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
0. filling row by row
1. only one queen per row
2. check col up to current row (cols above row)
3. check top-left diagonal
4. check top-right diagonal
 */
fun main() {
    solveNQueens(4).also(::println)
    solveNQueens(1).also(::println)
    solveNQueens(3).also(::println)
}

/*
Time Complexity Analysis -> 𝑂(𝑛!)
    row 1 -> n
    row 2 -> n - 2
    row 3 -> n - 4
    upper bound can be taken as n!
    notice that it's not n^n because of pruning
    we're not filling queens in all the positions in all the rows
    whenever we encounter a scenario that is not valid, we prune that branch
Space Complexity Analysis -> 𝑂(𝑛^2)
    as we build solutions we have to hold state of board (n x n)
    we know that every row will have only 1 queen
    so recursive call stack will take the order of n
    we take the dominant term which is n^2 over n
NOTE: space used just to return output is not counted as auxiliary space and not counted in space complexity
 */
fun solveNQueens(
    n: Int
): List<List<String>> {
    val res = mutableListOf<List<String>>()
    // NOTE: board is edited in place
    val board = Array(n) { CharArray(n) { '.' } }

    // convert board to list of strings, each row is concatenated to a string
    fun convertBoard(): List<String> {
        return board.map { String(it) }
    }

    // check if placing a queen at (row, col) is valid
    fun isValid(row: Int, col: Int): Boolean {
        // check column up to this row
        for (x in 0 until row) {
            if (board[x][col] == 'Q') return false
        }

        // check top left diagonal
        var r = row
        var c = col
        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q') return false
            r--     // decrement row as we're moving up
            c--     // decrement col as we're moving left
        }

        // check top right diagonal
        r = row
        c = col
        while (r >= 0 && c < n) {
            if (board[r][c] == 'Q') return false
            r--     // decrement row as we're moving up
            c++     // increment col as we're moving right
        }

        return true
    }

    fun positionNextQueen(row: Int) {
        if (row == n) {
            res.add(convertBoard())
            return
        }

        for (col in 0 until n) {
            if (isValid(row, col)) {
                board[row][col] = 'Q'                    // choose step
                positionNextQueen(row + 1)   // recursive call

                // when we get back from recursive call we have a solution
                // so backtrack (revert choice) as we want all possible solutions
                board[row][col] = '.'
            }
        }
    }

    positionNextQueen(0)

    return res
}