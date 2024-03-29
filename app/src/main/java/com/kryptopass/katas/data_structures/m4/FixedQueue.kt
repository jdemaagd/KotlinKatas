package com.kryptopass.katas.data_structures.m4

class FixedQueue<E> {

    private val elements: Array<Any?>
    private var size = 0

    constructor(capacity: Int) {
        this.elements = arrayOfNulls(capacity)
    }

    fun enqueue(element: E) {
        if (size == elements.size) {
            throw QueueOverflowException()
        }
        elements[size++] = element
    }

    fun dequeue(): E {
        if (size == 0) throw QueueUnderflowException()
        val oldVal = elements[0]
        elements[0] = null
        System.arraycopy(elements, 1, elements, 0, --size)
        return oldVal as E
    }

    fun front() = try {
        elements[0] as E
    } catch (e: IndexOutOfBoundsException) {
        throw QueueUnderflowException();
    }

    fun rear() = try {
        elements[size - 1] as E
    } catch (e: IndexOutOfBoundsException) {
        throw QueueUnderflowException();
    }

    fun isEmpty() = size == 0

    fun isFull() = size == elements.size

    override fun toString(): String {
        if (size == 0) return "[]"
        val length = size - 1
        val builder = StringBuilder(size * 16)
        builder.append('[')
        for (i in 0 until length) {
            builder.append(elements[i])
            builder.append(", ")
        }
        builder.append(elements[length])
        builder.append(']')
        return builder.toString()
    }
}

fun main() {
    val animals = FixedQueue<String>(10)
    println("$animals - Empty? -- ${animals.isEmpty()} - Full? -- ${animals.isFull()}")

    animals.enqueue("Lion")
    println("$animals - Empty? -- ${animals.isEmpty()} - Full? -- ${animals.isFull()}")

    animals.enqueue("Tiger")
    println("$animals - Empty? -- ${animals.isEmpty()} - Full? -- ${animals.isFull()}")

    animals.enqueue("Crocodile")
    animals.enqueue("Cat")
    animals.enqueue("Dog")
    animals.enqueue("Cow")
    animals.enqueue("Cangaroo")
    animals.enqueue("Rat")
    animals.enqueue("Bull")
    println("$animals - Empty? -- ${animals.isEmpty()} - Full? -- ${animals.isFull()}")
    animals.enqueue("Ox")
    println("$animals - Empty? -- ${animals.isEmpty()} - Full? -- ${animals.isFull()}")

    try {
        animals.enqueue("Zebra")
    } catch(e: QueueOverflowException) {
        println("Exception Expected!!!")
    }

    animals.dequeue()
    println("$animals - Empty? -- ${animals.isEmpty()} - Full? -- ${animals.isFull()}")

    animals.dequeue()
    println(animals)
    animals.dequeue()
    println(animals)
    animals.dequeue()
    println(animals)
    animals.dequeue()
    println(animals)
    animals.dequeue()
    println(animals)
    animals.dequeue()
    println(animals)
    animals.dequeue()
    println(animals)
    animals.dequeue()
    println(animals)
    animals.dequeue()
    println(animals)

    try {
        animals.dequeue()
    } catch(e: QueueUnderflowException) {
        println("FixedQueue is already empty!!!")
    }
}