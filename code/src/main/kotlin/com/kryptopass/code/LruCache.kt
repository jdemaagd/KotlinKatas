package com.kryptopass.code

/*
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
Implement the LRUCache class:
- LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
- int get(int key) Return the value of the key if the key exists, otherwise return -1.
- void put(int key, int value) Update the value of the key if the key exists.
                               Otherwise, add the key-value pair to the cache.
If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 */
fun main() {
    val cache = LRUCache<Int, Int>(3)

    cache.put(1, 1)
    cache.put(2, 2)
    cache.put(3, 3)
    cache.get(1).also { println(it) }    // 1
    cache.get(2).also { println(it) }    // 2
    cache.get(3).also { println(it) }    // 3

    cache.put(4, 4)
    cache.get(1).also { println(it) }    // null
    cache.get(4).also { println(it) }    // 4

    cache.put(5, 5)
    cache.get(2).also { println(it) }    // null
    cache.get(3).also { println(it) }    // 3
    cache.get(4).also { println(it) }    // 4
    cache.get(5).also { println(it) }    // 5
}

class LRUCache<K, V>(private val capacity: Int) {

    // capacity: number of buckets to start with
    // 0.75f: resizes when it is 75% full
    // true: access order (helps with LRU Cache), when entry is accessed, moved to end of list
    // false: insertion order
    private val cache = object : LinkedHashMap<K, V>(capacity, 0.75f, true) {
        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<K, V>?): Boolean =
            size > capacity
    }

    // Time Complexity -> O(1), lookup by key
    // Space Complexity -> O(1), capacity
    fun get(key: K): V? = cache[key]

    // Time Complexity -> O(1), lookup by key
    // Space Complexity -> O(1), capacity
    fun put(key: K, value: V) {
        cache[key] = value
    }
}