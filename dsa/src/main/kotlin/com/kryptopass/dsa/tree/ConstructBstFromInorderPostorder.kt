package com.kryptopass.dsa.tree

/*
Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary
tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

Recall inorder: elements to left of root element are in left subtree
                and elements to right are in right subtree
Recall postorder: last element is always root of tree
 */
fun main() {
    val inorder1 = listOf(9, 3, 15, 20, 7)
    val postorder1 = listOf(9, 15, 7, 20, 3)
    val tree1 = buildTree3(inorder1, postorder1)
    printTree(tree1) // Output: [3, 9, 20, None, None, 15, 7]

    val inorder2 = listOf(-1)
    val postorder2 = listOf(-1)
    val tree2 = buildTree3(inorder2, postorder2)
    printTree(tree2) // Output: [-1]

}

fun buildTree3(
    inorder: List<Int>,
    postorder: List<Int>
): TreeNode? {
    val inorderMap = inorder.withIndex().associate { it.value to it.index }

    fun arrayToTree(
        inLeft: Int,
        inRight: Int,
        postLeft: Int,
        postRight: Int
    ): TreeNode? {
        if (inLeft > inRight || postLeft > postRight) {
            return null
        }

        val rootVal = postorder[postRight]
        val root = TreeNode(rootVal)
        val inRootIndex = inorderMap[rootVal] ?: return null

        val leftTreeSize = inRootIndex - inLeft

        root.left = arrayToTree(
            inLeft,
            inRootIndex - 1,
            postLeft,
            postLeft + leftTreeSize - 1
        )
        root.right = arrayToTree(
            inRootIndex + 1,
            inRight,
            postLeft + leftTreeSize,
            postRight - 1
        )

        return root
    }

    return arrayToTree(
        0,
        inorder.size - 1,
        0,
        postorder.size - 1
    )
}