package com.kryptopass.dsa.tree

import java.util.LinkedList
import java.util.Queue

class BinaryTree {
    var root: TreeNode? = null

    fun insert(array: Array<Int?>): BinaryTree {
        if (array.isEmpty())
            return this

        var i = 0

        if (root == null) {
            if (array[0] == null) {
                return this
            } else {
                root = TreeNode(array[0]!!)
                i++
                if (i == array.size) return this
            }
        }

        val queue: Queue<TreeNode?> = LinkedList()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val current = queue.poll()

            if (current?.left == null) {
                if (array[i] != null) {
                    current?.left = TreeNode(array[i]!!)
                }
                i++
                if (i == array.size) return this
            } else {
                queue.add(current.left)
            }

            if (current?.right == null) {
                if (array[i] != null) {
                    current?.right = TreeNode(array[i]!!)
                }
                i++
                if (i == array.size) return this
            } else {
                queue.add(current.right)
            }
        }

        return this
    }
}