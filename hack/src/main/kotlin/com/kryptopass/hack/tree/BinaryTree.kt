package com.kryptopass.hack.tree

class BinaryTree {
    var root: Node? = null

    fun insert(value: Int): BinaryTree {
        val node = Node(value)
        if (root == null) {
            root = node
            return this
        }
        var tree = root
        while (true) {
            if (value < tree!!.value) {
                if (tree.left == null) {
                    tree.left = node
                    return this
                }
                tree = tree.left
            } else {
                if (tree.right == null) {
                    tree.right = node
                    return this
                }
                tree = tree.right
            }
        }
    }
}