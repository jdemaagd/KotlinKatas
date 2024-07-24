package com.kryptopass.dsa.tree

/*
Construct BST
Design a Binary Search Tree class that supports following:
1.Insert a value
2.Remove a value
  method should remove first occurrence of a value
  a. leaf node
  b. node with one child
  c. node with two children
3.Find a value
  if value is found it should return node with value else return false
 */
fun main() {
    val bst = BinarySearchTree()
    bst.insert(10)
        .insert(5)
        .insert(15)
        .insert(2)
        .insert(5)
        .insert(13)
        .insert(22)
    bst.find(15).also { println(it?.value) }    // 15
    bst.find(99).also { println(it?.value) }    // null, not found
    bst.remove(10)
    bst.find(10).also { println(it?.value) }    // null, just removed
}

class BinarySearchTree {
    var root: TreeNode? = null

    fun insert(value: Int): BinarySearchTree {
        val node = TreeNode(value)
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

    fun find(value: Int): TreeNode? {
        var tree = root
        while (tree != null) {
            tree = when {
                value < tree.value -> tree.left
                value > tree.value -> tree.right
                else -> return tree
            }
        }
        return null
    }

    fun remove(
        value: Int,
        current: TreeNode? = root,
        parent: TreeNode? = null
    ): Boolean {
        var currentNode = current
        var parentNode = parent

        if (currentNode == null) {
            return false
        }

        while (currentNode != null) {
            when {
                value < currentNode.value -> {
                    parentNode = currentNode
                    currentNode = currentNode.left
                }

                value > currentNode.value -> {
                    parentNode = currentNode
                    currentNode = currentNode.right
                }

                else -> {
                    // Node with two children
                    if (currentNode.left != null && currentNode.right != null) {
                        currentNode.value = getMin(currentNode.right!!)
                        remove(currentNode.value, currentNode.right, currentNode)
                    } else if (parentNode == null) {
                        // Node is the root
                        root = when {
                            currentNode.left != null -> currentNode.left
                            currentNode.right != null -> currentNode.right
                            else -> null
                        }
                    } else if (currentNode == parentNode.left) {
                        parentNode.left = currentNode.left ?: currentNode.right
                    } else if (currentNode == parentNode.right) {
                        parentNode.right = currentNode.left ?: currentNode.right
                    }
                    break
                }
            }
        }
        return true
    }

    private fun getMin(node: TreeNode): Int {
        var currentNode = node
        while (currentNode.left != null) {
            currentNode = currentNode.left!!
        }
        return currentNode.value
    }
}