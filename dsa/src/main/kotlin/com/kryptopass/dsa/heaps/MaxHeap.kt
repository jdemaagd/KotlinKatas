package com.kryptopass.dsa.heaps

/*
Max Heap Construction
Write a max Heap Class that supports the following:
    - Building a Max heap from an input array
    - Inserting integers in the Heap
    - Removing the Heap’s maximum / root value
    - Peeking at the Heap’s maximum / root value
The Heap is to be represented in the form of an array.
 */
fun main() {
    val heap = MaxBinaryHeap()
    heap.buildHeap(mutableListOf(4, 7, 3, 0, 9, 3, 2, 6))
    heap.printHeap()           // [9, 7, 3, 6, 4, 3, 2, 0]
    println(heap.peek())       // 9

    heap.extractMax()
    heap.printHeap()           // [7, 6, 3, 0, 4, 3, 2]
    println(heap.peek())       // 7
}

class MaxBinaryHeap {
    private val heap = mutableListOf<Int>()

    fun buildHeap(
        array: MutableList<Int>
    ): MaxBinaryHeap {
        val length = array.size
        val lastParentIndex = length / 2 - 1
        for (i in lastParentIndex downTo 0) {
            bubbleDown(array, i)
        }
        heap.addAll(array)
        return this
    }

    fun extractMax(): Int {
        val max = heap[0]
        val last = heap.removeAt(heap.size - 1)
        if (heap.isNotEmpty()) {
            heap[0] = last
            bubbleDown(heap, 0)
        }
        return max
    }

    fun insert(value: Int): MaxBinaryHeap {
        heap.add(value)
        bubbleUp()
        return this
    }

    fun peek(): Int {
        return heap[0]
    }

    fun printHeap() {
        println(heap)
    }

    private fun bubbleDown(
        array: MutableList<Int>,
        idx: Int
    ) {
        var index = idx
        val length = array.size
        val current = array[index]

        while (true) {
            val leftChildIdx = 2 * index + 1
            val rightChildIdx = 2 * index + 2
            var largest: Int? = null

            if (leftChildIdx < length) {
                val leftChild = array[leftChildIdx]
                if (leftChild > current) {
                    largest = leftChildIdx
                }
            }

            if (rightChildIdx < length) {
                val rightChild = array[rightChildIdx]
                if ((largest == null && rightChild > current) || (largest != null && rightChild > array[largest])) {
                    largest = rightChildIdx
                }
            }

            if (largest == null) {
                break
            } else {
                array[index] = array[largest].also { array[largest] = array[index] }
                index = largest
            }
        }
    }

    private fun bubbleUp() {
        var idx = heap.size - 1
        val value = heap[idx]

        while (idx > 0) {
            val parentIdx = (idx - 1) / 2
            val parentValue = heap[parentIdx]
            if (value <= parentValue) {
                break
            }
            heap[parentIdx] = value.also { heap[idx] = parentValue }
            idx = parentIdx
        }
    }
}