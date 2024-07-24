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
//    val tree = BinaryTree()
//    tree.insert(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11))
//    levelOrderTraversal(tree.root).let(::println)
//
//    val tree2 = BinaryTree()
//    tree2.insert(arrayOf(10, 5, 15, 2, 7, 12, 17))
//    levelOrderTraversal(tree2.root).let(::println)
}

fun levelOrderTraversal(root: TreeNode?): List<List<Int>> {
    if (root == null) return emptyList()

    val output = mutableListOf<List<Int>>()
    val queue: Queue<TreeNode> = LinkedList()
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