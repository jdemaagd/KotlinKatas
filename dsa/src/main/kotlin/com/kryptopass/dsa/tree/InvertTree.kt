package com.kryptopass.dsa.tree

import java.util.*
import kotlin.collections.ArrayList

/*
Invert Binary Tree
Given the root of a binary tree, invert the tree, and return its root.
Invert means swap every left node for its corresponding right node / get mirror image.
BFS: Iterative
while queue.length:
    dequeue
    swap left and right
    if left: enqueue left
    if right: enqueue right
Time Complexity: O(n)
Space Complexity: O(n)
DFS: Recursive
Base Case: if root is None, return
Recursive Case: swap left and right
Time Complexity: O(n)
Space Complexity: O(max depth) = O(height)
 */
fun main() {
    // val tree = insertLevelOrder(arrayOf(4, 2, 7, 1, 3, 6, 9), null, 0)
    val root = VNode(4)
    root.left = VNode(2)
    root.right = VNode(7)
    root.left?.left = VNode(1)
    root.left?.right = VNode(3)
    root.right?.left = VNode(6)
    root.right?.right = VNode(9)

    printTree2(invertIterative(root))  // Output: [4, 7, 2, 9, 6, 3, 1]
    printTree2(invertRecursive(root))  // Output: [4, 2, 7, 1, 3, 6, 9], back to original
    println()

    // val tree2 = insertLevelOrder(arrayOf(1, 2, 7, 4, 5, null, 7), null, 0)
    val root2 = VNode(1)

    root2.left = VNode(2)
    root2.right = VNode(7)

    root2.left?.left = VNode(4)
    root2.left?.right = VNode(5)
    root2.right?.left = null
    root2.right?.right = VNode(7)

    printTree2(invertIterative(root2))  // Output: [1, 7, 2, 7, null, 5, 4]
    printTree2(invertRecursive(root2))  // Output: [1, 2, 7, 4, 5, null, 7], back to original
}

fun invertIterative(root: VNode?): VNode? {
    if (root == null) {
        return null
    }

    val queue: Queue<VNode> = LinkedList()
    queue.add(root)

    while (queue.isNotEmpty()) {
        val current = queue.poll()
        val temp = current.left
        current.left = current.right
        current.right = temp

        current.left?.let { queue.add(it) }
        current.right?.let { queue.add(it) }
    }

    return root
}

fun invertRecursive(node: VNode?): VNode? {
    if (node == null) {
        return null
    }

    val temp = node.left
    node.left = node.right
    node.right = temp

    invertRecursive(node.left)
    invertRecursive(node.right)

    return node
}

fun insertLevelOrder(arr: Array<Int?>, root: VNode?, i: Int): VNode? {
    if (i < arr.size) {
        val temp = if (arr[i] != null) VNode(arr[i]!!) else null
        root?.left = insertLevelOrder(arr, root?.left, 2 * i + 1)
        root?.right = insertLevelOrder(arr, root?.right, 2 * i + 2)
        return temp
    }
    return root
}

fun printTree2(root: VNode?) {
    if (root == null) {
        println("[]")
        return
    }

    val queue: Queue<VNode> = LinkedList()
    queue.add(root)
    val result = ArrayList<Int?>()

    while (queue.isNotEmpty()) {
        val node = queue.poll()
        if (node != null) {
            result.add(node.value)
            queue.add(node.left)
            queue.add(node.right)
        } else {
            result.add(null)
        }
    }

    println(result.filterNotNull())
}
