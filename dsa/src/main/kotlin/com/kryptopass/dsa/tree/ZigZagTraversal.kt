package com.kryptopass.dsa.tree

import java.util.*
import kotlin.collections.ArrayList

/*
Given root of a binary tree, return the zigzag level order traversal of its nodes' values.
(i.e., from left to right, then right to left for the next level and alternate between).

Time Complexity: O(n)
Space Complexity: O(n)
 */
fun main() {
    val root = VNode(1)
    root.left = VNode(2)
    root.right = VNode(3)
    root.left?.left = VNode(4)
    root.left?.right = VNode(5)
    root.right?.right = VNode(6)

    val result = zigzagLevelOrder(root)
    println(result) // Output: [[1], [3, 2], [4, 5, 6]]
}

fun zigzagLevelOrder(root: VNode?): List<List<Int>> {
    if (root == null) {
        return emptyList()
    }

    val result = ArrayList<List<Int>>()
    val queue: Queue<VNode> = LinkedList()
    queue.add(root)
    var leftToRight = true

    while (queue.isNotEmpty()) {
        val levelSize = queue.size
        val levelNodes = LinkedList<Int>()

        for (i in 0 until levelSize) {
            val node = queue.poll()

            if (leftToRight) {
                levelNodes.add(node.value)
            } else {
                levelNodes.addFirst(node.value)
            }

            node.left?.let { queue.add(it) }
            node.right?.let { queue.add(it) }
        }

        result.add(levelNodes)
        leftToRight = !leftToRight
    }

    return result
}
