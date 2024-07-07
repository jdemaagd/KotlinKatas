package com.kryptopass.katas.dsa.`08_backtracking`

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
    sudokuBoxSolver(board)

    for (row in board) {
        println(row.joinToString(" "))
    }
}

fun sudokuBoxSolver(board: Array<CharArray>) {
    val boxes = Array(9) { mutableMapOf<Char, Boolean>() }
    val rows = Array(9) { mutableMapOf<Char, Boolean>() }
    val cols = Array(9) { mutableMapOf<Char, Boolean>() }

    fun getBox(row: Int, col: Int): Int {
        val newCol = col / 3
        val newRow = (row / 3) * 3
        return newCol + newRow
    }

    for (i in 0 until 9) {
        for (j in 0 until 9) {
            if (board[i][j] != '.') {
                val value = board[i][j]
                val x = getBox(i, j)
                boxes[x][value] = true
                rows[i][value] = true
                cols[j][value] = true
            }
        }
    }

    fun isValid(
        box: Map<Char, Boolean>,
        row: Map<Char, Boolean>,
        col: Map<Char, Boolean>,
        num: Char
    ): Boolean {
        return !(num in box || num in row || num in col)
    }

    fun backtrack(r: Int, c: Int): Boolean {
        if (r == 9) return true
        if (board[r][c] == '.') {
            val boxId = getBox(r, c)
            val box = boxes[boxId]
            val row = rows[r]
            val col = cols[c]
            for (num in '1'..'9') {
                if (isValid(box, row, col, num)) {
                    board[r][c] = num
                    box[num] = true
                    row[num] = true
                    col[num] = true
                    if (c == 8) {
                        if (backtrack(r + 1, 0)) return true
                    } else {
                        if (backtrack(r, c + 1)) return true
                    }
                    box.remove(num)
                    row.remove(num)
                    col.remove(num)
                    board[r][c] = '.'
                }
            }
            return false
        } else {
            if (c == 8) {
                if (backtrack(r + 1, 0)) return true
            } else {
                if (backtrack(r, c + 1)) return true
            }
        }
        return false
    }

    backtrack(0, 0)
}