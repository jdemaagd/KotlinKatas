package com.kryptopass.dsa.tree

import java.util.*
import kotlin.collections.ArrayList

/*
Given root of binary tree, return bottom-up level order traversal of its nodes' values.
(i.e., from left to right, level by level from leaf to root).

Time complexity: O(n)
Space complexity: O(n)
 */
fun main() {
    val tree = insertLevelOrder2(arrayOf(1, 2, 3, 4, 5, null, 6), 0)
    val result = levelOrderBottomUp(tree)
    printTree2(result)  // Output: [[4, 5, 6], [2, 3], [1]]
}

fun levelOrderBottomUp(root: VNode?): List<List<Int>> {
    if (root == null) {
        return emptyList()
    }

    val result = LinkedList<List<Int>>()
    val queue: Queue<VNode> = LinkedList()
    queue.add(root)

    while (queue.isNotEmpty()) {
        val levelSize = queue.size
        val levelNodes = ArrayList<Int>()

        for (i in 0 until levelSize) {
            val node = queue.poll()
            levelNodes.add(node.value)

            node.left?.let { queue.add(it) }
            node.right?.let { queue.add(it) }
        }

        result.addFirst(levelNodes)
    }

    return result
}

fun insertLevelOrder2(arr: Array<Int?>, i: Int): VNode? {
    if (i < arr.size) {
        val node = arr[i]?.let { VNode(it) }
        node?.left = insertLevelOrder2(arr, 2 * i + 1)
        node?.right = insertLevelOrder2(arr, 2 * i + 2)
        return node
    }
    return null
}

fun printTree2(result: List<List<Int>>) {
    result.forEach { println(it) }
}

