# HackerRank main for Kotlin

## main for TreeHeight

```kotlin 
fun main(args: Array<String>) {
    val n = readln().trim().toInt()
    val arr = readln().trim().split(" ").map { it.toInt() }.toIntArray()

    val bst = BinaryTree()
    for (i in 0 until n) {
        bst.insert(arr[i])
    }
    
    println(getHeight(bst.root))
}
```

## main for LCA

```kotlin
fun main(args: Array<String>) {
    val n = readln().trim().toInt()
    val arr = readln().trim().split(" ").map { it.toInt() }.toIntArray()
    
    val nodes = readln().trim().split(" ").map { it.toInt() }.toIntArray()
    
    val bst = BinaryTree()
    for (i in 0 until n) {
        bst.insert(arr[i])
    }
    
    val node = lca(bst.root, nodes[0], nodes[1])
    println(node?.value)
}
```

## main for 

## main for BalancedForest

```kotlin
fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val n = readLine()!!.trim().toInt()

        val c = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

        val edges = Array<Array<Int>>(n - 1, { Array<Int>(2, { 0 }) })

        for (i in 0 until n - 1) {
            edges[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
        }

        val result = balancedForest(c, edges)

        println(result)
    }
}
```
