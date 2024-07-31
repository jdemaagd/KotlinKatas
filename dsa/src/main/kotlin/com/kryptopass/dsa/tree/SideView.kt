package com.kryptopass.dsa.tree

import java.util.LinkedList
import java.util.Queue

/*
Left/Right View of binary tree
1. Given the root of a binary tree, imagine yourself standing on the right side of it,
   return the values of the nodes you can see ordered from top to bottom.
2. Given the root of a binary tree, imagine yourself standing on the left side of it,
   return the values of the nodes you can see ordered from top to bottom.

Time Complexity: O(n)
Space Complexity: O(n/2) = O(n)
 */
fun main() {
    val tree = BinaryTree()
    tree.insert(arrayOf(
        7, 11, 1, null, 7, 2, 8, null, null, null, 3, null, null, 5, null
        // 7, 11, 1, 7, 2, 8, 3, 5
    ))
    // printTree(tree.root).also { println(it) } // [7, 11, 1, 7, 2, 8, 3, 5]
    //println(leftView(tree.root))          // [7, 11, 7, 3, 5]

    val node = Node(7)

    node.left = Node(11)
    node.right = Node(1)

    node.left!!.left = null
    node.left!!.right = Node(7)
    node.right!!.left = Node(2)
    node.right!!.right = Node(8)

    node.left?.right?.left = null
    node.left?.right?.right = null
    node.right!!.left?.left = null
    node.right!!.left?.right = Node(3)
    node.right!!.right?.left = null
    node.right!!.right?.right = null

    node.right?.left?.right?.left = Node(5)
    node.right?.left?.right?.right = null

    leftView(node).also(::println)          // [7, 11, 7, 3, 5]
    rightView(node).also(::println)         // [7, 1, 8, 3, 5]
}

fun rightView(root: Node?): List<Int?> {
    if (root == null)
        return emptyList()

    val right = mutableListOf<Int?>()
    val queue: Queue<Node> = LinkedList()
    queue.add(root)

    while (queue.isNotEmpty()) {
        val length = queue.size
        for (i in 1..length) {
            val current = queue.poll()
            if (i == length) {
                right.add(current.value)
            }
            current.left?.let { queue.add(it) }
            current.right?.let { queue.add(it) }
        }
    }

    return right
}


fun leftView(root: Node?): List<Int?> {
    if (root == null)
        return emptyList()

    val left = mutableListOf<Int?>()
    val queue: Queue<Node> = LinkedList()
    queue.add(root)

    while (queue.isNotEmpty()) {
        val length = queue.size
        for (i in 1..length) {
            val current = queue.poll()
            if (i == 1) {
                left.add(current?.value)
            }
            current.left?.let { queue.add(it) }
            current.right?.let { queue.add(it) }
        }
    }

    return left
}
