package ds.m6

//  NOTE: O(m * n), where m is pattern length and n is text length
fun naivePatternSearch(text: String, pattern: String): Int {
    var retVal = -1
    val patternLen = pattern.length
    val textLen = text.length - patternLen
    for (i in 0..textLen) {
        var isFound = true
        for (j in 0 until patternLen) {
            if (text[i + j] != pattern[j]) {
                isFound = false
                break
            }
        }
        if (isFound) {
            retVal = i
            break
        }
    }
    return retVal
}

fun main(args: Array<String>) {
    println(naivePatternSearch("Hello World!!", "abc"))
    println(naivePatternSearch("Hello World!!", "Hel"))
    println(naivePatternSearch("Hello World!!", "elo"))
    println(naivePatternSearch("Hello World!!", "el"))
    println(naivePatternSearch("Hello World!!", "wo"))
    println(naivePatternSearch("Hello World!!", "Wo"))
    println(naivePatternSearch("Hello World!!", "Wod"))
    println(naivePatternSearch("Hello World!!", "!!"))
}