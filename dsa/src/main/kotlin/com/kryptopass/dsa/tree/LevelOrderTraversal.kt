package com.kryptopass.dsa.tree

import java.util.LinkedList
import java.util.Queue

/*
Level Order Traversal
Write a function that takes root of a binary tree, and returns level order traversal of its nodes'
values. (i.e., from left to right, level by level). Initially write an instance method for BST class
to insert the values given as an array into the Binary tree (from left to right, level by level).
Each value in the array which is not null is to be made a node and added to the tree.
(See examples below). Then write the function mentioned first.

Pseudocode:
while queue is not empty:
    dequeue
    if not left:
        if value not null:
            insert
            i++
    if left:
        enqueue
    if not right:
        if value not null:
            insert
            i++
    if right:
        enqueue

Time Complexity: O(n)
Space Complexity: O(n)
 */
fun main() {
    // val tree = BinaryTree()
    // tree.insert(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11))
    val root = VNode(1)
    root.left = VNode(2)
    root.right = VNode(3)
    root.left?.left = VNode(4)
    root.left?.right = VNode(5)
    root.right?.left = VNode(6)
    root.right?.right = VNode(7)
    root.left?.left?.left = VNode(8)
    root.left?.left?.right = VNode(9)
    root.left?.right?.left = VNode(10)
    root.left?.right?.right = VNode(11)
    levelOrderTraversal(root).let(::println)

    // val tree2 = BinaryTree()
    // tree2.insert(arrayOf(10, 5, 15, 2, 7, 12, 17))
    val root2 = VNode(10)
    root2.left = VNode(5)
    root2.right = VNode(15)
    root2.left?.left = VNode(2)
    root2.left?.right = VNode(7)
    root2.right?.left = VNode(12)
    root2.right?.right = VNode(17)
    levelOrderTraversal(root2).let(::println)
}

fun levelOrderTraversal(root: VNode?): List<List<Int>> {
    if (root == null) return emptyList()

    val output = mutableListOf<List<Int>>()
    val queue: Queue<VNode> = LinkedList()
    queue.add(root)

    while (queue.isNotEmpty()) {
        val length = queue.size
        val currLevelValues = mutableListOf<Int>()
        for (i in 0 until length) {
            val curr = queue.poll()
            currLevelValues.add(curr.value)
            curr.left?.let { queue.add(it) }
            curr.right?.let { queue.add(it) }
        }
        output.add(currLevelValues)
    }

    return output
}