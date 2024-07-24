package com.kryptopass.dsa.tree

/*
Iterative solution for Inorder Traversal of a Binary Tree
Given the root of a binary tree, return the inorder traversal of its nodes' values.
Recall: left, root, right
1. keep going left as far as possible
2. come back to previous node before going right
3. after going right, go left again as much as possible
while curr points to a node OR stack is not empty: (we need to come back to root node)
    while curr points to a node:
        append curr to stack
        curr = curr?.left
    pop node from stack
    append node?.value to result array
    curr = curr?.right
Time Complexity: O(n), n is number of nodes in tree
Space Complexity: O(n), worst case when tree is skewed
 */
fun main() {
    val root = TreeNode(1)
    root.right = TreeNode(2)
    root.right!!.left = TreeNode(3)
    inorderTraversal(root).let(::println)

    val root2 = TreeNode(10)
    root2.left = TreeNode(5)
    root2.right = TreeNode(15)
    root2.left!!.left = TreeNode(2)
    root2.left!!.right = TreeNode(7)
    root2.right!!.left = TreeNode(12)
    root2.right!!.right = TreeNode(17)
    inorderTraversal(root2).let(::println)
}

fun inorderTraversal(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    val stack = mutableListOf<TreeNode>()
    var curr = root

    while (curr != null || stack.isNotEmpty()) {
        while (curr != null) {
            stack.add(curr)
            curr = curr.left
        }
        curr = stack.removeAt(stack.size - 1)
        result.add(curr.value)
        curr = curr.right
    }

    return result
}
