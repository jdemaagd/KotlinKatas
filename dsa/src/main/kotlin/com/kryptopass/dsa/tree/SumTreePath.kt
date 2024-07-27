package com.kryptopass.dsa.tree

/*
Sum root to leaf numbers
You are given the root of a binary tree containing digits from 0 to 9 only.
Each root-to-leaf path in the tree represents a number.
    For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers.
Test cases are generated so that the answer will fit in a 32-bit integer.
A leaf node is a node with no children.

Time Complexity: O(n)
Space Complexity: O(n), worst case for unbalanced tree
 */
fun main() {
    val tree = BinaryTree()
    tree.insert(arrayOf(1, 2, 3))
    println(sumNumbers(tree.root))  // 25
}

fun sumNumbers(root: TreeNode?): Int {
    fun dfs(node: TreeNode?, currentNumber: Int): Int {
        if (node == null) {
            return 0
        }

        val currNumber = currentNumber * 10 + node.value

        if (node.left == null && node.right == null) {
            return currNumber
        }

        val leftSum = dfs(node.left, currNumber)
        val rightSum = dfs(node.right, currNumber)

        return leftSum + rightSum
    }

    return dfs(root, 0)
}
