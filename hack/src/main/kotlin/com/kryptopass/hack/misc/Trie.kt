package com.kryptopass.hack.misc

class TrieNode {
    val children = arrayOfNulls<TrieNode>(2)
}

class Trie {
    private val root = TrieNode()

    fun insert(number: Int) {
        var current = root
        for (i in 31 downTo 0) {
            val bit = (number shr i) and 1
            if (current.children[bit] == null) {
                current.children[bit] = TrieNode()
            }
            current = current.children[bit]!!
        }
    }

    fun getMaxXor(number: Int): Int {
        var current = root
        var maxXor = 0
        for (i in 31 downTo 0) {
            val bit = (number shr i) and 1
            val oppositeBit = bit xor 1
            if (current.children[oppositeBit] != null) {
                maxXor = maxXor or (1 shl i)
                current = current.children[oppositeBit]!!
            } else {
                current = current.children[bit]!!
            }
        }
        return maxXor
    }
}