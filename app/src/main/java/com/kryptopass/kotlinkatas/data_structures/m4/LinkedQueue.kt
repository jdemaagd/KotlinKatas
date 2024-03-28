package com.kryptopass.kotlinkatas.data_structures.m4

class LinkedQueue<E> {
    private var size = 0
    private var head: Node<E>? = null
    private var tail: Node<E>? = null

    private inner class Node<E> constructor(
        var prev: Node<E>?,
        var element: E,
        var next: Node<E>?
    )

    fun enqueue(element: E) {
        val t = tail
        val newNode = Node(t, element, null)
        tail = newNode
        if (t == null) {
            head = newNode
        } else {
            t.next = newNode
        }
        size++
    }

    fun dequeue(): E {
        head?.let {
            val next = it.next
            it.next = null
            head = next
            if (next == null) {
                tail = null
            } else {
                next.prev = null
            }
            size--
            return it.element
        } ?: throw QueueUnderflowException()
    }

    fun front(): E {
        head?.let {
            return it.element
        } ?: throw QueueUnderflowException()
    }

    fun rear(): E {
        tail?.let {
            return it.element
        } ?: throw QueueUnderflowException()
    }

    fun isEmpty() = size == 0

    override fun toString(): String {
        var curr = head
        return if (curr == null) "[]"
        else {
            val sb = StringBuilder()
            sb.append('[')
            while (curr != null) {
                sb.append(curr.element)
                curr = curr.next
                if (curr?.element == null) {
                    sb.append(']')
                } else {
                    sb.append(',').append(' ')
                }
            }
            sb.toString()
        }
    }
}

fun main() {
    val animals = LinkedQueue<String>()
    println("$animals - Empty? -- ${animals.isEmpty()}")

    animals.enqueue("Lion")
    println("$animals - Empty? -- ${animals.isEmpty()}")
    animals.enqueue("Tiger")
    println("$animals - Empty? -- ${animals.isEmpty()}")
    animals.enqueue("Crocodile")
    animals.enqueue("Cat")
    animals.enqueue("Dog")
    animals.enqueue("Cow")
    animals.enqueue("Cangaroo")
    animals.enqueue("Rat")
    animals.enqueue("Bull")
    println("$animals - Empty? -- ${animals.isEmpty()}")
    animals.enqueue("Ox")
    println("$animals - Empty? -- ${animals.isEmpty()}")
    animals.enqueue("Zebra")
    println("$animals - Empty? -- ${animals.isEmpty()}")
    animals.dequeue()
    println("$animals - Empty? -- ${animals.isEmpty()}")
    animals.dequeue()
    println("$animals - Empty? -- ${animals.isEmpty()}")
    animals.dequeue()
    println("$animals - Empty? -- ${animals.isEmpty()}")
    animals.dequeue()
    println("$animals - Empty? -- ${animals.isEmpty()}")

    println("Front element - ${animals.front()} - Empty? -- ${animals.isEmpty()}")
    println("Front element - ${animals.front()} - Empty? -- ${animals.isEmpty()}")
    println("Front element - ${animals.front()} - Empty? -- ${animals.isEmpty()}")
    animals.dequeue()
    println("Front element - ${animals.front()} - Empty? -- ${animals.isEmpty()}")
    println("Front element - ${animals.front()} - Empty? -- ${animals.isEmpty()}")
    animals.enqueue("Peacock")
    println("Front element - ${animals.front()} - Empty? -- ${animals.isEmpty()}")
    println("Front element - ${animals.front()} - Empty? -- ${animals.isEmpty()}")
    println("Rear element - ${animals.rear()} - Empty? -- ${animals.isEmpty()}")
    println("Rear element - ${animals.rear()} - Empty? -- ${animals.isEmpty()}")

    animals.dequeue()
    animals.dequeue()
    animals.dequeue()
    animals.dequeue()
    animals.dequeue()
    animals.dequeue()
    println("Front element - ${animals.front()} - Empty? -- ${animals.isEmpty()}")
    animals.dequeue()

    try {
        println("Front element - ${animals.front()} - Empty? -- ${animals.isEmpty()}")
    } catch (e: QueueUnderflowException) {
        println("Already empty!!!")
    }
}