package com.kryptopass.hack.hashmap

/*
Harold is a kidnapper who wrote a ransom note,
    but now he is worried it will be traced back to him through his handwriting.
He found a magazine and wants to know if he can cut out whole words from it and use them to create
    an untraceable replica of his ransom note.
The words in his note are case-sensitive and he must use only whole words available in the magazine.
He cannot use substrings or concatenation to create the words he needs.
Given the words in the magazine and the words in the ransom note,
    print `Yes` if he can replicate his ransom note exactly using whole words from the magazine;
    otherwise, print `No`.

Example
magazine = "attack at dawn"
note = "Attack at dawn"
The magazine has all the right words, but there is a case mismatch. The answer is `No`.

Function Description
Complete the checkMagazine function in the editor below.
It must print `Yes` if the note can be formed using the magazine, or `No`.
checkMagazine has the following parameters:
    - string magazine[m]: the words in the magazine
    - string note[n]: the words in the ransom note

Prints
    - string: either `Yes` or `No`, no return value is expected

Input Format
The first line contains two space-separated integers, `m` and `n`,
    the numbers of words in the `magazine` and the `note`, respectively.
The second line contains `m` space-separated strings, each `magazine[i]`.
The third line contains `n` space-separated strings, each `note[i]`.

Constraints
    - 1 <= m, n <= 30000
    - 1 <= length of magazine[i] and note[i] <= 5
    - Each word consists of English alphabetic letters (i.e., `a` to `z` and `A` to `Z`).

Sample Input 0
6 4
give me one grand today night
give one grand today

Sample Output 0
Yes

Sample Input 1
6 5
two times three is not four
two times two is four

Sample Output 1
No

Explanation 1
`two` only occurs once in the magazine

Sample Input 2
7 4
ive got a lovely bunch of coconuts
ive got some coconuts

Sample Output 2
No

Explanation 2
Harold's magazine is missing the word `some`
 */
fun main() {
    checkMagazine(
        arrayOf("give", "me", "one", "grand", "today", "night"),
        arrayOf("give", "one", "grand", "today")
    )
    checkMagazine(
        arrayOf("two", "times", "three", "is", "not", "four"),
        arrayOf("two", "times", "two", "is", "four")
    )
    checkMagazine(
        arrayOf("ive", "got", "a", "lovely", "bunch", "of", "coconuts"),
        arrayOf("ive", "got", "some", "coconuts")
    )
}

// Time Complexity: O(m + n),
//      where m is the number of words in the magazine
//      and n is the number of words in the note
// Space Complexity: O(u), where u is the number of unique words in the magazine
fun checkMagazine(
    magazine: Array<String>,
    note: Array<String>
) {
    // frequency of words in magazine
    val magazineMap = mutableMapOf<String, Int>()

    magazine.forEach {
        magazineMap[it] = magazineMap.getOrDefault(it, 0) + 1
    }

    for (word in note) {
        if (magazineMap.getOrDefault(word, 0) == 0) {
            println("No")   // word not found in magazine
            return
        }
        // decrement frequency of word in magazine
        magazineMap[word] = magazineMap[word]!! - 1
    }

    println("Yes")
}