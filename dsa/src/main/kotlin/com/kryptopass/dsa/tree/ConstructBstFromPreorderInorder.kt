package com.kryptopass.dsa.tree

/*
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary
tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

Recall preorder: first element is always root of tree
Recall inorder: elements to left of root element are in left subtree
                and elements to right are in right subtree

Example 1: construct-example.png
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: preorder = [-1], inorder = [-1]
Output: [-1]

Constraints:
1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.
 */
fun main() {
    val preorder1 = listOf(3, 9, 20, 15, 7)
    val inorder1 = listOf(9, 3, 15, 20, 7)
    val tree1 = buildTree(preorder1, inorder1)
    val tree12 = buildTree2(preorder1, inorder1)
    printTree(tree1)  // [3, 9, 20, None, None, 15, 7]
    printTree(tree12)  // [3, 9, 20, None, None, 15, 7]

    val preorder2 = listOf(-1)
    val inorder2 = listOf(-1)
    val tree2 = buildTree(preorder2, inorder2)
    val tree22 = buildTree(preorder2, inorder2)
    printTree(tree2)  // [-1]
    printTree(tree22)  // [-1]
}

fun buildTree(
    preorder: List<Int>,
    inorder: List<Int>
): TreeNode? {
    val inorderMap = inorder.withIndex().associate { it.value to it.index }

    fun arrayToTree(
        preLeft: Int,
        preRight: Int,
        inLeft: Int,
        inRight: Int
    ): TreeNode? {
        if (preLeft > preRight || inLeft > inRight) {
            return null
        }

        val rootVal = preorder[preLeft]
        val root = TreeNode(rootVal)
        val inRootIndex = inorderMap[rootVal] ?: return null

        val leftTreeSize = inRootIndex - inLeft

        root.left = arrayToTree(
            preLeft + 1,
            preLeft + leftTreeSize,
            inLeft,
            inRootIndex - 1
        )
        root.right = arrayToTree(
            preLeft + leftTreeSize + 1,
            preRight,
            inRootIndex + 1,
            inRight
        )

        return root
    }

    return arrayToTree(
        0,
        preorder.size - 1,
        0,
        inorder.size - 1
    )
}

fun buildTree2(
    preorder: List<Int>,
    inorder: List<Int>
): TreeNode? {
    if (preorder.isEmpty() || inorder.isEmpty()) {
        return null
    }

    // First element of preorder is root
    val rootVal = preorder[0]
    val root = TreeNode(rootVal)

    val rootIndex = inorder.indexOf(rootVal)

    val leftInorder = inorder.subList(0, rootIndex)
    val rightInorder = inorder.subList(rootIndex + 1, inorder.size)

    val leftPreorder = preorder.subList(1, 1 + leftInorder.size)
    val rightPreorder = preorder.subList(1 + leftInorder.size, preorder.size)

    root.left = buildTree2(leftPreorder, leftInorder)
    root.right = buildTree2(rightPreorder, rightInorder)

    return root
}
