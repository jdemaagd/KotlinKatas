package com.kryptopass.dsa.tree

import java.util.LinkedList
import java.util.Queue

fun printTree(node: TreeNode?) {
    if (node == null)
        println("[]")

    val result = mutableListOf<Int?>()
    val queue: Queue<TreeNode?> = LinkedList<TreeNode?>()
    queue.add(node)

    while (queue.isNotEmpty()) {
        val current = queue.poll()
        if (current != null) {
            result.add(current.value)
            queue.add(current.left)
            queue.add(current.right)
        } else {
            result.add(null)
        }
    }

    while (result.isNotEmpty() && result.last() == null) {
        result.removeAt(result.size - 1)
    }

    println(result)
}
