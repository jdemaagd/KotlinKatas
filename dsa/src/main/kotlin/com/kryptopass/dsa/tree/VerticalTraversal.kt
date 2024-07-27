package com.kryptopass.dsa.tree

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/*
Vertical Order traversal of a Binary Tree
Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
For each node at position (row, col), its left and right children will be at positions
(row + 1, col - 1) and (row + 1, col + 1) respectively.
The root of the tree is at (0, 0).
The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column
index starting from the leftmost column and ending on the rightmost column.
There may be multiple nodes in the same row and same column.
In such a case, sort these nodes by their values.
Return the vertical order traversal of the binary tree.

Time Complexity: O(n log n)
    bfs traversal -> O(n)
    sorting columns -> O(n log n)
Space Complexity: O(n)
 */
fun main() {
    val root = VNode(1)
    root.left = VNode(2)
    root.right = VNode(3)
    root.left?.left = VNode(4)
    root.left?.right = VNode(5)
    root.right?.left = VNode(6)
    root.right?.right = VNode(7)

    val result = verticalOrderTraversal(root)
    println(result) // Output: [[4], [2], [1, 5, 6], [3], [7]]
}

fun verticalOrderTraversal(root: VNode?): List<List<Int>> {
    if (root == null) {
        return emptyList()
    }

    val columnTable = HashMap<Int, MutableList<Pair<Int, Int>>>()
    val queue: Queue<Triple<VNode?, Int, Int>> = LinkedList()
    queue.add(Triple(root, 0, 0))

    while (queue.isNotEmpty()) {
        val (node, row, col) = queue.poll()

        if (node != null) {
            columnTable.computeIfAbsent(col) { ArrayList() }.add(Pair(row, node.value))
            queue.add(Triple(node.left, row + 1, col - 1))
            queue.add(Triple(node.right, row + 1, col + 1))
        }
    }

    val sortedColumns = columnTable.keys.sorted()
    val result = ArrayList<List<Int>>()

    for (col in sortedColumns) {
        val columnNodes = columnTable[col]!!
        columnNodes.sortWith(compareBy({ it.first }, { it.second }))
        val columnValues = columnNodes.map { it.second }
        result.add(columnValues)
    }

    return result
}

data class VNode(val value: Int, var left: VNode? = null, var right: VNode? = null)
