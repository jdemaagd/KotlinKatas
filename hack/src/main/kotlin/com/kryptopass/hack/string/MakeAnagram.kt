package com.kryptopass.hack.string

/*
A student is taking a cryptography class and has found anagrams to be very useful.
Two strings are anagrams of each other if first string's letters can be rearranged to form second string.
In other words, both strings must contain the same exact letters in the same exact frequency.
For example, `bacdc` and `dcbac` are anagrams, but `bacdc` and `dcbad` are not.
The student decides on an encryption scheme that involves two large strings.
Encryption is dependent on minimum number of character deletions required to make two strings anagrams.
Determine this number. Given two strings, `a` and `b`, that may or may not be of the same length,
determine the minimum number of character deletions required to make `a` and `b` anagrams.
Any characters can be deleted from either of the strings.

Example
a = `cde`
b = `dcf`
Delete `e` from `a` and `f` from `b` so that remaining strings are `cd` and `dc` which are anagrams.
This takes `2` character deletions.

Function Description
Complete the `makeAnagram` function in the editor below.
makeAnagram has the following parameter(s):
- string a: a string
- string b: another string

Returns
- int: the minimum number of deletions needed

Input Format
The first line contains a single string, `a`.
The second line contains a single string, `b`.

Constraints
- 1 <= |a|, |b| <= 10^4
- The strings `a` and `b` consist of lowercase English alphabetic letters, ascii[a-z].

Sample Input
cde
abc

Sample Output
4

Explanation
Delete `e` from `cde` and `f` from `abc` to make both strings anagrams.
1. Remove `d` and `e` from `cde` to get `c`.
2. Remove `a` and `b` from `abc` to get `c`.
It takes `4` deletions to make both strings anagrams.
 */
fun main() {
    makeAnagram("cde", "abc").also { println(it) }
}

// Time complexity: O(n + m), where n and m are lengths of strings a and b
// Space complexity: O(1), space for frequency arrays is constant
fun makeAnagram(
    a: String,
    b: String
): Int {
    val frequencyA = IntArray(26) { 0 }
    val frequencyB = IntArray(26) { 0 }

    // count frequencies in string a
    for (char in a) {
        frequencyA[char - 'a']++
    }

    // count frequencies in string b
    for (char in b) {
        frequencyB[char - 'a']++
    }

    // calculate number of deletions (difference in frequencies)
    var deletions = 0
    for (i in 0 until 26) {
        deletions += kotlin.math.abs(frequencyA[i] - frequencyB[i])
    }

    return deletions
}