package com.kryptopass.hack.linked_lists

import java.util.Scanner

/*
Given the pointer to the head of a linked list and an integer to insert at a certain position,
create a new node with the given integer as its `data` attribute,
insert this node at the desired position and return the head node.
A position of 0 indicates head, a position of 1 indicates one node away from the head and so on.
The head pointer given may be null meaning that the initial list is empty.

Example
head refers to the first node in the list 1 -> 2 -> 3
data = 4
position = 2
insert a node at position 2 with data = 4. The new list is 1 -> 2 -> 4 -> 3

Function Description
Complete the function insertNodeAtPosition in the editor below.
It must return a reference to the head node of your finished list.
insertNodeAtPosition has the following parameter(s):
head: a SinglyLinkedListNode pointer to the head of the list
data: an integer value to insert as data in your new node
position: an integer position to insert the new node, zero based indexing

Returns
SinglyLinkedListNode pointer: a reference to the head of the revised list

Input Format
The first line contains an integer n, the number of elements in the linked list.
Each of the next n lines contains an integer SinglyLinkedListNode[i].data.
The next line contains an integer data, the data of the node that is to be inserted.
The last line contains an integer position.

Constraints
1 <= n <= 1000
1 <= SinglyLinkedListNode[i].data <= 1000, where SinglyLinkedListNode[i] is the ith element of the linked list.
0 <= position <= n

Sample Input
3       count of elements in linked list
16      first element
13      second element
7       third element
1       data to insert
2       position to insert

Sample Output
16 13 1 7

Explanation
The initial linked list is 16 -> 13 -> 7
Insert 1 at position 2 which currently has 7 in it.
The updated linked list is 16 -> 13 -> 1 -> 7
 */
fun main() {
    val scanner = Scanner(System.`in`)

    val list = SinglyLinkedList()

    val n = scanner.nextInt()
    for (i in 0 until n) {
        val nodeData = scanner.nextInt()
        list.insertNode(nodeData)
    }

    val data = scanner.nextInt()
    val position = scanner.nextInt()

    val updatedHead = insertNodeAtPosition(list.head, data, position)

    printSinglyLinkedList(updatedHead, " ")
}

// Time Complexity: O(n), in worst case where n is length of list
// Space Complexity: O(1)
fun insertNodeAtPosition(
    list: SinglyLinkedListNode?,
    data: Int,
    position: Int
): SinglyLinkedListNode? {
    val newNode = SinglyLinkedListNode(data)

    // insert at head of list
    if (position == 0) {
        newNode.next = list
        return newNode
    }

    // traverse to position before insertion point
    var current = list
    var currentPosition = 0

    while (currentPosition < position - 1 && current != null) {
        current = current.next
        currentPosition++
    }

    // insert new node
    if (current != null) {
        newNode.next = current.next
        current.next = newNode
    }

    return list
}

class SinglyLinkedListNode(
    nodeData: Int
) {
    var data: Int
    var next: SinglyLinkedListNode?

    init {
        data = nodeData
        next = null
    }
}

class SinglyLinkedList {
    var head: SinglyLinkedListNode?
    var tail: SinglyLinkedListNode?

    init {
        head = null
        tail = null
    }

    fun insertNode(nodeData: Int) {
        var node = SinglyLinkedListNode(nodeData)

        if (head == null) {
            head = node
        } else {
            tail?.next = node
        }

        tail = node
    }
}

fun printSinglyLinkedList(
    head: SinglyLinkedListNode?,
    sep: String
) {
    var node = head;

    while (node != null) {
        print(node.data)
        node = node.next

        if (node != null) {
            print(sep)
        }
    }
}