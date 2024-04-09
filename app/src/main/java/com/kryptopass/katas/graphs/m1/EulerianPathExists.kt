package com.kryptopass.katas.graphs.m1

fun main() {
    println(
        checkIfEulerianPathExists(
            4,
            arrayListOf(
                arrayListOf(0, 1),
                arrayListOf(1, 2),
                arrayListOf(1, 3),
                arrayListOf(2, 0),
                arrayListOf(3, 2)
            )
        )
    )

    println(
        checkIfEulerianPathExists(
            5,
            arrayListOf(
                arrayListOf(0, 3),
                arrayListOf(1, 2),
                arrayListOf(1, 3),
                arrayListOf(3, 2),
                arrayListOf(4, 1),
                arrayListOf(4, 2)
            )
        )
    )
}

/*
Check If Eulerian Path Exists

Given an undirected connected graph, check if there exists any eulerian path in it
The Eulerian Path is a path in the graph that visits every edge exactly once
(allowing for revisiting vertices)

Example One
    1 -- 0
    | \  |
    |  \ |
    3 -- 2
{
    "n": 4,
    "edges": [
        [0, 1],
        [1, 2],
        [1, 3],
        [2, 0],
        [3, 2]
    ]
}

Output: true -> For example, the graph has an Eulerian Path, [1, 2, 0, 1, 3, 2]

Example Two
    3 --- 2 - 4
    | \   \   |
    |  \   \  |
    2      1
{
    "n": 5,
    "edges": [
        [0, 3],
        [1, 2],
        [1, 3],
        [3, 2],
        [4, 1],
        [4, 2]
    ]
}

Output: false

Notes
1. The graph has `n` vertices, with each vertex having a distinct value from 0 to n - 1
2. Edges are given as a list of lists where each inner list has exactly two elements
   Each list [X, Y] represents an undirected edge from X to Y
3. The list won't contain any duplicate edges i.e. if [X, Y] is present,
   then there will be no other occurrence of [X, Y] or [Y, X]

Constraints
1 <= n <= 10^3
0 <= value of each vertex <= n - 1
0 <= number of edges <= (n * (n - 1)) / 2
The graph won't contain self loops.
 */

/*
    Asymptotic complexity in terms of the number of vertices ( = `n`) and number of edges ( = `e`):
    Time: O(n + e)
    Auxiliary space: O(n)
    Total space: O(n + e)
*/

/*
    Given list of arrays representing each edge, i.e. [0, 1], [1, 3], etc.
    And the number of vertices, `n`, what do we know about eulerian path?
    If it is an Eulerian Cycle, it is an Eulerian Path
    And if number of vertices with odd degree is 0 or 2, then it is an Eulerian Path
    CODE: create degree list from `n`, representing the vertices of the graph
          iterate through the edges, and increment the degree of each vertex
          if the number of vertices with odd degree is 0 it is an Eulerian Cycle and therefore an Eulerian Path
          if the number of vertices with odd degree is 2 it is an Eulerian Path
 */
fun checkIfEulerianPathExists(
    n: Int, edges: ArrayList<ArrayList<Int>>
): Boolean {
    val degrees = ArrayList<Int>(n)
    for (i in 0 until n)
        degrees.add(0)

    for (i in edges.indices) {
        degrees[edges[i][0]]++
        degrees[edges[i][1]]++
    }

    for (i in 0 until degrees.size)
        println("Vertex: $i, having: ${degrees[i]}")

    var oddCount = 0
    for (i in 0 until n)
        if (degrees[i] % 2 != 0)
            oddCount++

    return oddCount == 0 || oddCount == 2
}