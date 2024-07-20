package com.kryptopass.hack.misc

/*
Union-Find Data Structure:
Find: Determine which subset a particular element is in.
      This can be used to determine if two elements are in the same subset.
      Implements path compression to flatten the tree.
Union: Join two subsets into a single subset.
       Implements union by size to keep the tree balanced and updates `maxSize`.
Path Compression: A technique used in the find operation to make the tree flat,
                  improving the time complexity.
Union by Size/Rank: A technique used in the union operation to keep the tree shallow,
                    improving the time complexity.

Largest Friend Circle:
Keep track of the size of each set (friend circle) and update the size when two sets are united.
 */
class DisjointSetUnion {
    // Space Complexity: O(2q), in worst case
    private val parent = mutableMapOf<Int, Int>()
    private val size = mutableMapOf<Int, Int>()
    var maxSize = 1
        private set

    // Time Complexity: O(α(n)), where α(n) is the inverse Ackermann function,
    // which grows extremely slowly and is effectively constant for all practical purposes,
    // with path compression has an amortized time
    private fun find(x: Int): Int {
        if (parent[x] != x) {
            parent[x] = find(parent[x]!!) // Path compression
        }
        return parent[x]!!
    }

    // Time Complexity: O(α(n)), where α(n) is the inverse Ackermann function
    fun union(x: Int, y: Int) {
        val rootX = find(x)
        val rootY = find(y)

        if (rootX != rootY) {
            // Union by size
            if (size[rootX]!! < size[rootY]!!) {
                parent[rootX] = rootY
                size[rootY] = size[rootY]!! + size[rootX]!!
                maxSize = maxOf(maxSize, size[rootY]!!)
            } else {
                parent[rootY] = rootX
                size[rootX] = size[rootX]!! + size[rootY]!!
                maxSize = maxOf(maxSize, size[rootX]!!)
            }
        }
    }

    // Time Complexity: O(1)
    fun add(x: Int) {
        if (x !in parent) {
            parent[x] = x
            size[x] = 1
        }
    }
}