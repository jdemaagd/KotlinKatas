package com.kryptopass.hack.tree

/*
For the purposes of this challenge, we define a BST to be a binary tree with following properties:
- `data` value of every node in a node's left subtree is less than the data value of that node
- `data` value of every node in a node's right subtree is greater than the data value of that node
- `data` value of every node is distinct
For example, (check-bst-example2.png) image on left below is a valid BST.
One on right fails on several counts:
- All of the numbers on the right branch from the root are not larger than the root.
- All of the numbers on the right branch from node 5 are not larger than 5.
- All of the numbers on the left branch from node 5 are not smaller than 5.
- The data value 1 is repeated.
Given the root node of a binary tree, determine if it is a binary search tree.

Function Description
Complete the function checkBST in the editor below.
It must return a boolean denoting whether or not the binary tree is a binary search tree.
checkBST has the following parameter(s):
- root: a reference to the root node of a tree to test

Input Format
You are not responsible for reading any input from stdin.
Hidden code stubs will assemble a binary tree and pass its root node to your function as an argument.

Constraints
- 0 <= data <= 10^4

Output Format
Your function must return a boolean true if the tree is a binary search tree.
Otherwise, it must return false.

Sample Input
check-bst-sample.png

Sample Output
Yes

Explanation
The tree in the diagram satisfies the ordering property for a Binary Search Tree, so we print Yes.
 */
fun main() {
    val root = Node(3)
    root.left = Node(2)
    root.right = Node(4)
    root.left?.left = Node(1)
    root.right?.right = Node(6)
    root.right?.left = Node(5)
    println(checkBST(root))
//    if (checkBST(root)) {
//        println("Yes")
//    } else {
//        println("No")
//    }

//    val root2 = Node(3)
//    root2.left = Node(2)
//    root2.right = Node(5)
//    root2.left?.left = Node(1)
//    root2.right?.left = Node(6)
//    root2.right?.right = Node(1)
//    if (checkBST(root2)) {
//        println("Yes")
//    } else {
//        println("No")
//    }
//
//    val root3 = Node(4)
//    root3.left = Node(2)
//    root3.right = Node(6)
//    root3.left?.left = Node(1)
//    root3.left?.right = Node(3)
//    root3.right?.left = Node(5)
//    root3.right?.right = Node(7)
//    if (checkBST(root3)) {
//        println("Yes")
//    } else {
//        println("No")
//    }

    // 1 2 4 3 5 6 7
}

fun checkBST(root: Node?): Boolean {
    return isBST(root, Int.MIN_VALUE, Int.MAX_VALUE)
}

fun isBST(node: Node?, min: Int, max: Int): Boolean {
    if (node == null) {
        return true
    }
    if (node.value <= min || node.value >= max) {
        return false
    }
    return isBST(node.left, min, node.value) && isBST(node.right, node.value, max)
}