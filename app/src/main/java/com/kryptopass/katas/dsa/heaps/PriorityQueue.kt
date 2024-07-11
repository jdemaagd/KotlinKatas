package com.kryptopass.katas.dsa.heaps

/*
Priority Queue Construction
Implement a Priority Queue as a min Binary Heap.
The Priority Queue class should support the following functions:
    - Enqueue to insert an element
    - Dequeue to extract the element with the highest priority
      (the lowest numerical priority is treated as highest priority)
 */
fun main() {
    val pq = PriorityQueue()
    pq.enqueue(4, 1)
    pq.enqueue(7, 3)
    pq.enqueue(3, 2)
    pq.enqueue(0, 4)
    pq.enqueue(9, 0)
    pq.enqueue(3, 2)
    pq.enqueue(2, 3)
    pq.enqueue(6, 1)

    println(pq.dequeue().value) // 9
    println(pq.dequeue().value) // 4
    println(pq.dequeue().value) // 6
    println(pq.dequeue().value) // 7
    println(pq.dequeue().value) // 3
    println(pq.dequeue().value) // 3
    println(pq.dequeue().value) // 2
    println(pq.dequeue().value) // 0
}

class Node(
    val value: Int,
    val priority: Int
)

class PriorityQueue {
    val data = mutableListOf<Node>()

    fun dequeue(): Node {
        val minElement = data[0]
        val last = data.removeAt(data.size - 1)
        if (data.isNotEmpty()) {
            data[0] = last
            bubbleDown()
        }
        return minElement
    }

    fun enqueue(value: Int, priority: Int): PriorityQueue {
        val node = Node(value, priority)
        data.add(node)
        bubbleUp()
        return this
    }

    private fun bubbleDown() {
        var idx = 0
        val length = data.size
        val element = data[0]

        while (true) {
            val leftChildIdx = 2 * idx + 1
            val rightChildIdx = 2 * idx + 2
            var leftChild: Node? = null
            var rightChild: Node?
            var smallest: Int? = null

            if (leftChildIdx < length) {
                leftChild = data[leftChildIdx]
                if (leftChild.priority < element.priority) {
                    smallest = leftChildIdx
                }
            }

            if (rightChildIdx < length) {
                rightChild = data[rightChildIdx]
                if ((smallest == null && rightChild.priority < element.priority) ||
                    (smallest != null && rightChild.priority < leftChild!!.priority)) {
                    smallest = rightChildIdx
                }
            }

            if (smallest == null) {
                break
            }

            data[idx] = data[smallest]
            data[smallest] = element
            idx = smallest
        }
    }

    private fun bubbleUp() {
        var idx = data.size - 1
        val element = data[idx]

        while (idx > 0) {
            val parentIdx = (idx - 1) / 2
            val parent = data[parentIdx]
            if (element.priority >= parent.priority) {
                break
            }
            data[idx] = parent
            data[parentIdx] = element
            idx = parentIdx
        }
    }
}