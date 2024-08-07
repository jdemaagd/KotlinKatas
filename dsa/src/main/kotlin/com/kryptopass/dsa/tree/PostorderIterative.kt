package com.kryptopass.dsa.tree

/*
Iterative solution for Postorder Traversal of a Binary Tree
Given the root of a binary tree, return the postorder traversal of its nodes' values.
Recall: left, right, root
while stack:
    curr = 1
    visited = false
    if curr AND visited:
        append curr?.value to result array
    else:
        append curr to stack, True to visited
        append curr?.right to stack, False to visited
        append curr?.left to stack, False to visited
Time Complexity: O(n), where n is number of nodes in tree
Space Complexity: O(h), where h is max height of tree, height determines stack usage
 */
fun main() {
    val root = TreeNode(1)
    root.right = TreeNode(2)
    root.right!!.left = TreeNode(3)
    postorderTraversal(root).let(::println)

    val root2 = TreeNode(10)
    root2.left = TreeNode(5)
    root2.right = TreeNode(15)
    root2.left!!.left = TreeNode(2)
    root2.left!!.right = TreeNode(7)
    root2.right!!.left = TreeNode(12)
    root2.right!!.right = TreeNode(17)
    postorderTraversal(root2).let(::println)
}

fun postorderTraversal(root: TreeNode?): List<Int> {
    if (root == null) {
        return emptyList()
    }

    val stack = mutableListOf<Pair<TreeNode, Boolean>>()
    val result = mutableListOf<Int>()
    stack.add(Pair(root, false))        // stack: Pair (node, visited)

    while (stack.isNotEmpty()) {
        val (curr, visited) = stack.removeAt(stack.size - 1)
        if (visited) {
            result.add(curr.value)
        } else {
            stack.add(Pair(curr, true))
            if (curr.right != null) {
                stack.add(Pair(curr.right!!, false))
            }
            if (curr.left != null) {
                stack.add(Pair(curr.left!!, false))
            }
        }
    }

    return result
}