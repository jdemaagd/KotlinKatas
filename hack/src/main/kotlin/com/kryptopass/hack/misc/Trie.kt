package com.kryptopass.hack.misc

class TrieNode {
    val children = arrayOfNulls<TrieNode>(2)
}

class Trie {
    private val root = TrieNode()

    // Time Complexity: O(n * 32), where n is size of array
    // each number takes O(32) time to insert
    fun insert(num: Int) {
        var node = root
        for (i in 31 downTo 0) {
            val bit = (num shr i) and 1
            if (node.children[bit] == null) {
                node.children[bit] = TrieNode()
            }
            node = node.children[bit]!!
        }
    }

    // Time Complexity: O(m * 32), where m is the number of queries
    // each query takes O(32) time to find maximum XOR
    fun getMaxXor(num: Int): Int {
        var node = root
        var maxXor = 0
        for (i in 31 downTo 0) {
            val bit = (num shr i) and 1
            val oppositeBit = bit xor 1
            if (node.children[oppositeBit] != null) {
                maxXor = maxXor or (1 shl i)
                node = node.children[oppositeBit]!!
            } else {
                node = node.children[bit]!!
            }
        }
        return maxXor
    }
}