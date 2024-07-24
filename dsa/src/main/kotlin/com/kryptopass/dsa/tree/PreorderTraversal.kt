package com.kryptopass.dsa.tree

/*
Iterative solution for Preorder Traversal of a Binary Tree
Given the root of a binary tree, return the preorder traversal of its nodes' values.
Recall: root, left, right
while stack is not empty:
    pop node from stack
    add node?.value to result array
    add right child node to stack
    add left child node to stack
Time Complexity: O(n), where n is number of nodes in tree
Space Complexity: O(h), where h is max height of tree
 */
fun main() {
    val root = TreeNode(1)
    root.right = TreeNode(2)
    root.right!!.left = TreeNode(3)
    preorderTraversal(root).let(::println)

    val root2 = TreeNode(10)
    root2.left = TreeNode(5)
    root2.right = TreeNode(15)
    root2.left!!.left = TreeNode(2)
    root2.left!!.right = TreeNode(7)
    root2.right!!.left = TreeNode(12)
    root2.right!!.right = TreeNode(17)
    preorderTraversal(root2).let(::println)
}

fun preorderTraversal(root: TreeNode?): List<Int> {
    if (root == null) {
        return emptyList()
    }

    val stack = mutableListOf<TreeNode>()
    val result = mutableListOf<Int>()
    stack.add(root)

    while (stack.isNotEmpty()) {
        val node = stack.removeAt(stack.size - 1)
        result.add(node.value)
        if (node.right != null) {
            stack.add(node.right!!)
        }
        if (node.left != null) {
            stack.add(node.left!!)
        }
    }

    return result
}