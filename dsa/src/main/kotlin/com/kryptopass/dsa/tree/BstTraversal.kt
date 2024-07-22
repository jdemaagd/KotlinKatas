package com.kryptopass.dsa.tree

/*
Traverse BST
Write 4 instance methods for a Binary Search Tree class to traverse BST:
1. Method 1 :
   traverse tree breadth first and return an array that contains all values of BST
2. Method 2 :
   traverse tree depth first (in-order) and return an array that contains all values of BST
3. Method 3 :
   traverse tree depth first (pre-order) and return an array that contains all values of BST
4. Method 4 :
   traverse tree depth first (post-order) and return an array that contains all values of BST
 */
fun main() {
    val bst = BstTraversal()
    bst.root = Node(10)
    bst.root!!.left = Node(5)
    bst.root!!.right = Node(15)
    bst.root!!.left!!.left = Node(2)
    bst.root!!.left!!.right = Node(7)
    bst.root!!.right!!.left = Node(12)
    bst.root!!.right!!.right = Node(20)

    println("Breadth-First Search: ${bst.breadthFirst()}")  // [10, 5, 15, 2, 7, 12, 20]
    println("DFS In-Order: ${bst.dfsInOrder()}")            // [2, 5, 7, 10, 12, 15, 20]
    println("DFS Pre-Order: ${bst.dfsPreOrder()}")          // [10, 5, 2, 7, 15, 12, 20]
    println("DFS Post-Order: ${bst.dfsPostOrder()}")        // [2, 7, 5, 12, 20, 15, 10]
}

class BstTraversal {
    var root: Node? = null

    fun breadthFirst(): List<Int> {
        val result = mutableListOf<Int>()
        val queue = mutableListOf<Node>()
        if (root == null) {
            return result
        }

        queue.add(root!!)
        while (queue.isNotEmpty()) {
            val node = queue.removeAt(0)
            result.add(node.value)
            node.left?.let { queue.add(it) }
            node.right?.let { queue.add(it) }
        }

        return result
    }

    fun dfsInOrder(): List<Int> {
        val result = mutableListOf<Int>()
        if (root == null) {
            return result
        }

        fun traverse(node: Node?) {
            if (node == null) return
            node.left?.let { traverse(it) }
            result.add(node.value)
            node.right?.let { traverse(it) }
        }

        traverse(root)

        return result
    }

    fun dfsPreOrder(): List<Int> {
        val result = mutableListOf<Int>()
        if (root == null) {
            return result
        }

        fun traverse(node: Node?) {
            if (node == null) return
            result.add(node.value)
            node.left?.let { traverse(it) }
            node.right?.let { traverse(it) }
        }

        traverse(root)

        return result
    }

    fun dfsPostOrder(): List<Int> {
        val result = mutableListOf<Int>()
        if (root == null) {
            return result
        }

        fun traverse(node: Node?) {
            if (node == null) return
            node.left?.let { traverse(it) }
            node.right?.let { traverse(it) }
            result.add(node.value)
        }

        traverse(root)

        return result
    }
}