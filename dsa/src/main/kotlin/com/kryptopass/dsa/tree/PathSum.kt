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
    val root = TreeNode(5)
    root.left = TreeNode(4)
    root.right = TreeNode(8)
    root.left?.left = TreeNode(11)
    root.left?.left?.left = TreeNode(7)
    root.left?.left?.right = TreeNode(2)
    root.right?.left = TreeNode(13)
    root.right?.right = TreeNode(4)
    root.right?.right?.left = TreeNode(5)
    root.right?.right?.right = TreeNode(1)
    pathSum(root, 22).also(::println)

    val root2 = TreeNode(7)
    root2.left = TreeNode(3)
    root2.right = TreeNode(6)
    root2.left?.left = TreeNode(6)
    root2.left?.right = TreeNode(5)
    root2.right?.left = TreeNode(1)
    root2.right?.right = TreeNode(4)
    root2.left?.right?.right = TreeNode(5)
    root2.right?.right?.left = TreeNode(2)
    root2.right?.right?.right = TreeNode(3)
    pathSum(root2, 20).also(::println)
}

fun pathSum(
    root: TreeNode?,
    target: Int
): List<List<Int>> {
    val res = mutableListOf<List<Int>>()

    fun helper(node: TreeNode?, curr: MutableList<Int>, rem: Int) {
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