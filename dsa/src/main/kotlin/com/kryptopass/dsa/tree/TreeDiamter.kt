package com.kryptopass.dsa.tree

/*
Diameter of binary tree
Write function which takes in root of binary tree and returns length of diameter of tree.
Diameter of binary tree is length of longest path between any two nodes in tree.
It is not necessary for this path to pass through root of tree.
Length of path between two nodes is number of edges between them.
Recall: height of node is # edges on longest path between that node and leaf node.
Height of leaf node is 0.
Height of null node is -1.
Diameter at node is height(left) + height(right) + 1 + 1.
Height of node is max(height(left), height(right)) + 1.

max_diameter = 0
dfs {
    if null:
        return -1

    left_height = dfs(left)
    right_height = dfs(right)

    diameter = left_height + right_height + 2
    max_diameter = max(diameter, max_diameter)

    return max(left_height, right_height) + 1
}
return max_diameter

Time Complexity: O(n)
Space Complexity: O(n), worst case for unbalanced tree
 */
fun main() {
    val tree = BinaryTree()
    tree.insert(arrayOf(1, 7, 8, null, null, 2, 5, 3, null, null, 6, 4, 10, null, null, null, null, null, 9))
    println(diameterOfTree(tree.root))  // 6
}

fun diameterOfTree(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }

    var maxDiameter = 0

    fun dfs(node: TreeNode?): Int {
        if (node == null) {
            return -1
        }

        val leftHeight = dfs(node.left)
        val rightHeight = dfs(node.right)

        val diameter = leftHeight + rightHeight + 2
        maxDiameter = maxOf(maxDiameter, diameter)

        return maxOf(leftHeight, rightHeight) + 1
    }

    dfs(root)

    return maxDiameter
}
