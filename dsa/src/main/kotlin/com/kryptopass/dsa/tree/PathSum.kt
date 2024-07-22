package com.kryptopass.dsa.tree

/*
Given the root of a binary tree and an integer targetSum,
return all root-to-leaf paths where the sum of the node values in the path equals targetSum.
Each path should be returned as a list of the node values, not node references.
A root-to-leaf path is a path starting from the root and ending at any leaf node.
A leaf is a node with no children.
NOTE: `return all root-to-leaf paths` is strong indication of backtracking
Time Complexity: O(n * h), where n is number of nodes and h is max height
    O(n^2) in worst case, where tree is skewed
Space Complexity: O(h), where h is the height of the tree
 */
fun main() {
    val root = Node(5)
    root.left = Node(4)
    root.right = Node(8)
    root.left?.left = Node(11)
    root.left?.left?.left = Node(7)
    root.left?.left?.right = Node(2)
    root.right?.left = Node(13)
    root.right?.right = Node(4)
    root.right?.right?.left = Node(5)
    root.right?.right?.right = Node(1)
    pathSum(root, 22).also(::println)

    val root2 = Node(7)
    root2.left = Node(3)
    root2.right = Node(6)
    root2.left?.left = Node(6)
    root2.left?.right = Node(5)
    root2.right?.left = Node(1)
    root2.right?.right = Node(4)
    root2.left?.right?.right = Node(5)
    root2.right?.right?.left = Node(2)
    root2.right?.right?.right = Node(3)
    pathSum(root2, 20).also(::println)
}

fun pathSum(
    root: Node?,
    target: Int
): List<List<Int>> {
    val res = mutableListOf<List<Int>>()

    fun helper(node: Node?, curr: MutableList<Int>, rem: Int) {
        if (node == null) {
            return
        }

        curr.add(node.value)                    // choose step

        if (rem == node.value && node.left == null && node.right == null) {
            res.add(ArrayList(curr))            // one solution found
        } else {
            helper(node.left, curr, rem - node.value)
            helper(node.right, curr, rem - node.value)
        }

        curr.removeAt(curr.size - 1)        // backtracking step
    }

    helper(root, mutableListOf(), target)

    return res
}