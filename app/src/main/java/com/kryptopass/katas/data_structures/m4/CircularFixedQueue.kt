package com.kryptopass.katas.data_structures.m4

class CircularFixedQueue<E> {

    private val capacity: Int
    private var front = -1
    private var rear = -1
    private val elements: Array<Any?>

    constructor(capacity: Int) {
        this.capacity = capacity
        this.elements = arrayOfNulls(capacity)
    }

    fun enqueue(element: E) {
        if (isFull()) throw QueueOverflowException()
        rear = (rear + 1) % capacity
        elements[rear] = element
        if (front == -1 ) front = rear
    }

    fun dequeue(): E {
        if (isEmpty()) throw QueueUnderflowException()
        val oldVal = elements[front]
        elements[front] = null
        if (front == rear) {
            front = -1
            rear = -1
        } else front = (front + 1) % capacity
        return oldVal as E
    }

    fun front() = try {
        elements[front] as E
    } catch (e: IndexOutOfBoundsException) {
        throw QueueUnderflowException();
    }

    fun rear() = try {
        elements[rear] as E
    } catch (e: IndexOutOfBoundsException) {
        throw QueueUnderflowException();
    }

    fun isEmpty() = front == -1

    fun isFull() = (rear + 1) % capacity == front

    override fun toString(): String {
        return elements.contentToString()
    }
}

fun main() {
    val animals = CircularFixedQueue<String>(10)
    println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")

    animals.enqueue("Lion")
    println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    animals.enqueue("Tiger")
    println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    animals.enqueue("Crocodile")
    println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    animals.enqueue("Cat")
    println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    animals.enqueue("Dog")
    println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    animals.enqueue("Cow")
    println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    animals.enqueue("Cangaroo")
    println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    animals.enqueue("Rat")
    println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    animals.enqueue("Bull")
    println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    animals.enqueue("Ox")
    println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")

    try {
        animals.enqueue("Zebra")
    } catch(e: QueueOverflowException) {
        println("Exception Expected!!!")
    }

    animals.dequeue()
    println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    animals.dequeue()
    println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    animals.dequeue()
    println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    animals.dequeue()
    println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    animals.dequeue()
    println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    animals.dequeue()
    println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    animals.dequeue()
    println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    animals.dequeue()
    println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    animals.dequeue()
    println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    animals.dequeue()
    println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")

    try {
        animals.dequeue()
    } catch (e: QueueUnderflowException) {
        println("Exception Expected!!!")
    }
}