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
    val lruCache = LRUCacheUtil(3)
    lruCache.put(1, 1)
    lruCache.put(2, 2)
    lruCache.put(3, 3)
    lruCache.get(1).also { println(it) }    // 1
    lruCache.get(2).also { println(it) }    // 2
    lruCache.get(3).also { println(it) }    // 3

    lruCache.put(4, 4)
    lruCache.get(1).also { println(it) }    // -1
    lruCache.get(4).also { println(it) }    // 4

    lruCache.put(5, 5)
    lruCache.get(2).also { println(it) }    // -1
    lruCache.get(3).also { println(it) }    // 3
    lruCache.get(4).also { println(it) }    // 4
    lruCache.get(5).also { println(it) }    // 5
}

class LRUCacheUtil(private val capacity: Int) {
    private val map = LinkedHashMap<Int, Int>(capacity, 0.75f, true)

    fun get(key: Int): Int = map[key] ?: -1

    fun put(key: Int, value: Int) {
        if (map.size == capacity && !map.containsKey(key)) {
            val eldestKey = map.entries.iterator().next().key
            map.remove(eldestKey)
        }
        map[key] = value
    }
}