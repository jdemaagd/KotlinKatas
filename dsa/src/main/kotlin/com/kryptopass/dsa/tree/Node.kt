package com.kryptopass.dsa.tree

data class Node(
    val value: Int?,
    var left: Node? = null,
    var right: Node? = null
)

class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
