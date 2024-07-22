package com.kryptopass.hack.backtrack

/*
A 10 x 10 Crossword grid is provided to you,
along with a set of words (or names of places) which need to be filled into the grid.
Cells are marked either + or -. Cells marked with a - are to be filled with the word list.
The following shows an example crossword from the input `crossword` grid and the list of words to fit,
`words` = [POLAND, LHASA, SPAIN, INDIA]
Input                   Output
++++++++++              ++++++++++
+------+++              +POLAND+++
+++-++++++              +++H++++++
+++-++++++              +++A++++++
+++-----++              +++SPAIN++
+++-++-+++              +++A++N+++
++++++-+++              ++++++D+++
++++++-+++              ++++++I+++
++++++-+++              ++++++A+++
++++++++++              ++++++++++
POLAND;LHASA;SPAIN;INDIA

Function Description
Complete the crosswordPuzzle function in the editor below.
It should return an array of strings, each representing a row of the finished puzzle.
crosswordPuzzle has the following parameter(s):
- crossword: an array of 10 strings of length 10 representing the empty grid
- words: a string consisting of semicolon delimited strings to fit into crossword

Input Format
Each of the first 10 lines represents crossword[i], each of which has 10 characters, crossword[i][j].
The last line contains a string consisting of semicolon delimited words[i] to fit.

Constraints
- 1 <= |words| <= 10
- crossword[i][j] contains either + or -
- words[i] contains only capital English letters

Output Format
Position the words appropriately in the 10 x 10 grid, then return your array of strings for printing.

Sample Input 0
+-++++++++
+-++++++++
+-++++++++
+-----++++
+-+++-++++
+-+++-++++
+++++-++++
++------++
+++++-++++
+++++-++++
LONDON;DELHI;ICELAND;ANKARA

Sample Output 0
+L++++++++
+O++++++++
+N++++++++
+DELHI++++
+O+++C++++
+N+++E++++
+++++L++++
++ANKARA++
+++++N++++
+++++D++++

Sample Input 1
+-++++++++
+-++++++++
+-------++
+-++++++++
+-++++++++
+------+++
+-+++-++++
+++++-++++
+++++-++++
++++++++++
AGRA;NORWAY;ENGLAND;GWALIOR

Sample Output 1
+E++++++++
+N++++++++
+GWALIOR++
+L++++++++
+A++++++++
+NORWAY+++
+D+++G++++
+++++R++++
+++++A++++
++++++++++

Sample Input 2
++++++-+++
++------++
++++++-+++
++++++-+++
+++------+
++++++-+-+
++++++-+-+
++++++++-+
++++++++-+
++++++++-+
ICELAND;MEXICO;PANAMA;ALMATY

Sample Output 2
++++++I+++
++MEXICO++
++++++E+++
++++++L+++
+++PANAMA+
++++++N+L+
++++++D+M+
++++++++A+
++++++++T+
++++++++Y+
 */
fun main() {
    crosswordPuzzle(
        arrayOf(
            "+-++++++++",
            "+-++++++++",
            "+-++++++++",
            "+-----++++",
            "+-+++-++++",
            "+-+++-++++",
            "+++++-++++",
            "++------++",
            "+++++-++++",
            "+++++-++++"
        ),
        "LONDON;DELHI;ICELAND;ANKARA").joinToString("\n").let(::println)

    println()
    crosswordPuzzle(
        arrayOf(
            "+-++++++++",
            "+-++++++++",
            "+-------++",
            "+-++++++++",
            "+-++++++++",
            "+------+++",
            "+-+++-++++",
            "+++++-++++",
            "+++++-++++",
            "++++++++++"
        ),
        "AGRA;NORWAY;ENGLAND;GWALIOR"
    ).joinToString("\n").let(::println)

    println()
    crosswordPuzzle(
        arrayOf(
            "++++++-+++",
            "++------++",
            "++++++-+++",
            "++++++-+++",
            "+++------+",
            "++++++-+-+",
            "++++++-+-+",
            "++++++++-+",
            "++++++++-+",
            "++++++++-+"
        ),
        "ICELAND;MEXICO;PANAMA;ALMATY"
    ).joinToString("\n").let(::println)
}

// Time Complexity: O((2 * 100)^|words|), where words is number of words to be placed
//  Recursive Backtracking: each word tries every cell in 10 x 10 grid,
//  each position checks horizontal and vertical placements,
//  involves scanning the length of the word to ensure it fits correctly,
//  placing and removing a word involves scanning the length of the word as well,
//  worst case is exponential time complexity
// Space Complexity: O(|words|), recursive call stack, crossword grid, original character string
fun crosswordPuzzle(
    crossword: Array<String>,
    words: String
): Array<String> {
    val wordList = words.split(";")
    val crosswordArray = Array(10) { crossword[it].toCharArray() }
    solveCrossword(crosswordArray, wordList, 0)
    return Array(10) { String(crosswordArray[it]) }
}

fun canPlaceWordHorizontally(
    crossword: Array<CharArray>,
    word: String,
    row: Int,
    col: Int
): Boolean {
    if (col + word.length > 10 || (col > 0 && crossword[row][col - 1] != '+') ||
        (col + word.length < 10 && crossword[row][col + word.length] != '+')
    ) {
        return false
    }
    for (i in word.indices) {
        if (crossword[row][col + i] != '-' && crossword[row][col + i] != word[i]) {
            return false
        }
    }
    return true
}

fun canPlaceWordVertically(
    crossword: Array<CharArray>,
    word: String,
    row: Int,
    col: Int
): Boolean {
    if (row + word.length > 10 || (row > 0 && crossword[row - 1][col] != '+') ||
        (row + word.length < 10 && crossword[row + word.length][col] != '+')
    ) {
        return false
    }
    for (i in word.indices) {
        if (crossword[row + i][col] != '-' && crossword[row + i][col] != word[i]) {
            return false
        }
    }
    return true
}

// choose step
fun placeWordHorizontally(
    crossword: Array<CharArray>,
    word: String,
    row: Int,
    col: Int
): CharArray {
    val original = CharArray(word.length)
    for (i in word.indices) {
        original[i] = crossword[row][col + i]
        crossword[row][col + i] = word[i]
    }
    return original
}

// choose step
fun placeWordVertically(
    crossword: Array<CharArray>,
    word: String,
    row: Int,
    col: Int
): CharArray {
    val original = CharArray(word.length)
    for (i in word.indices) {
        original[i] = crossword[row + i][col]
        crossword[row + i][col] = word[i]
    }
    return original
}

// backtrack step
fun removeWordHorizontally(
    crossword: Array<CharArray>,
    original: CharArray,
    row: Int,
    col: Int
) {
    for (i in original.indices) {
        crossword[row][col + i] = original[i]
    }
}

// backtrack step
fun removeWordVertically(
    crossword: Array<CharArray>,
    original: CharArray,
    row: Int,
    col: Int
) {
    for (i in original.indices) {
        crossword[row + i][col] = original[i]
    }
}

// explores crossword grid
fun solveCrossword(
    crossword: Array<CharArray>,
    words: List<String>,
    index: Int
): Boolean {
    if (index == words.size) {
        return true
    }

    val word = words[index]
    for (row in 0 until 10) {
        for (col in 0 until 10) {
            if (canPlaceWordHorizontally(crossword, word, row, col)) {
                val original = placeWordHorizontally(crossword, word, row, col)
                if (solveCrossword(crossword, words, index + 1)) {
                    return true
                }
                removeWordHorizontally(crossword, original, row, col)
            }

            if (canPlaceWordVertically(crossword, word, row, col)) {
                val original = placeWordVertically(crossword, word, row, col)
                if (solveCrossword(crossword, words, index + 1)) {
                    return true
                }
                removeWordVertically(crossword, original, row, col)
            }
        }
    }

    return false
}
