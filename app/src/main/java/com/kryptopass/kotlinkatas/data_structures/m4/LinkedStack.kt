package com.kryptopass.kotlinkatas.data_structures.m4

class LinkedStack<E> {
    private var size = 0
    private var head: Node<E>? = null
    private var tail: Node<E>? = null

    private inner class Node<E> constructor(
        var prev: Node<E>?,
        var element: E,
        var next: Node<E>?
    )

    fun push(element: E) {
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

    fun pop(): E {
        tail?.let {
            val prev = it.prev
            it.prev = null
            tail = prev
            if (prev == null) {
                head = null
            } else {
                prev.next = null
            }
            size--
            return it.element
        } ?: throw StackUnderflowException()
    }

    fun peek(): E {
        tail?.let {
            return it.element
        } ?: throw StackUnderflowException()
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
    val animals = LinkedStack<String>()
    println("$animals - Empty? -- ${animals.isEmpty()}")

    animals.push("Lion")
    println("$animals - Empty? -- ${animals.isEmpty()}")

    animals.push("Tiger")
    println("$animals - Empty? -- ${animals.isEmpty()}")

    animals.push("Crocodile")
    animals.push("Cat")
    animals.push("Dog")
    animals.push("Cow")
    animals.push("Kangaroo")
    animals.push("Rat")
    animals.push("Bull")

    println("$animals - Empty? -- ${animals.isEmpty()}")
    animals.push("Ox")
    println("$animals - Empty? -- ${animals.isEmpty()}")
    animals.push("Zebra")
    println("$animals - Empty? -- ${animals.isEmpty()}")
    animals.pop()
    println("$animals - Empty? -- ${animals.isEmpty()}")
    animals.pop()
    println("$animals - Empty? -- ${animals.isEmpty()}")
    animals.pop()
    println("$animals - Empty? -- ${animals.isEmpty()}")
    animals.pop()
    println("$animals - Empty? -- ${animals.isEmpty()}")
    animals.pop()
    println("$animals - Empty? -- ${animals.isEmpty()}")
    animals.pop()
    println("$animals - Empty? -- ${animals.isEmpty()}")
    animals.pop()
    println("$animals - Empty? -- ${animals.isEmpty()}")
    animals.pop()
    println("$animals - Empty? -- ${animals.isEmpty()}")
    animals.pop()
    println("$animals - Empty? -- ${animals.isEmpty()}")
    animals.pop()
    println("$animals - Empty? -- ${animals.isEmpty()}")
    animals.pop()
    println("$animals - Empty? -- ${animals.isEmpty()}")

    try {
        animals.pop()
        println("$animals - Empty? -- ${animals.isEmpty()}")
    } catch (ex: StackUnderflowException) {
        println("Exception expected!!!")
    }

    animals.push("Buffalo")
    animals.push("Peacock")

    println("Peek element - ${animals.peek()}")
    println("Peek element - ${animals.peek()}")
    println("Peek element - ${animals.peek()}")
    println("Peek element - ${animals.peek()}")
    println("Peek element - ${animals.peek()}")
    println("Peek element - ${animals.peek()}")
    animals.pop()

    println("Peek element - ${animals.peek()}")
    println("Peek element - ${animals.peek()}")
    println("Peek element - ${animals.peek()}")
    animals.pop()

    try {
        println("Peek element - ${animals.peek()}")
    } catch (e: StackUnderflowException) {
        println("Empty Stack!!!")
    }
}