package com.kryptopass.katas.ik.recursion.graphs.m1

fun main() {
    println(
        checkIfEulerianCycleExists(
            5,
            arrayListOf(
                arrayListOf(0, 1),
                arrayListOf(0, 2),
                arrayListOf(1, 3),
                arrayListOf(3, 0),
                arrayListOf(3, 2),
                arrayListOf(4, 3),
                arrayListOf(4, 0)
            )
        )
    )
    println(
        checkIfEulerianCycleExists(
            6,
            arrayListOf(
                arrayListOf(0, 4),
                arrayListOf(0, 5),
                arrayListOf(1, 2),
                arrayListOf(2, 3),
                arrayListOf(3, 1),
                arrayListOf(4, 3)
            )
        )
    )
}

/*
Check if there exists any eulerian cycle in a given undirected connected graph
The Euler cycle is a path in the graph that visits every edge exactly once
and starts and finishes at the same vertex

Example One
    2 --- 0
     \  / | \
      \/  |  1
     / \  | /
    4 --- 3
{
    "n": 5,
    "edges": [
        [0, 1],
        [0, 2],
        [1, 3],
        [3, 0],
        [3, 2],
        [4, 3],
        [4, 0]
    ]
}

Output:
    true -> For example, the graph has an Eulerian Cycle, [2, 0, 1, 3, 0, 4, 3, 2]

Example Two
    0 --- 4 --- 3
    |           | \
    |           |  1
    |           | /
    5           2
{
"n": 6,
    "edges": [
        [0, 4],
        [0, 5],
        [1, 2],
        [2, 3],
        [3, 1],
        [4, 3],
    ]
}

Output
    false

Notes:
1. The graph has `n` vertices, with each vertex having a distinct value from 0 to n - 1
2. Edges are given as a list of lists where each inner list has exactly two elements
   Each list [X, Y] represents an undirected edge from X to Y
3. The list won't contain any duplicate edges i.e. if [X, Y] is present,
   then there will be no other occurrence of [X, Y] or [Y, X]

Constraints
1 <= n <= 10^3
0 <= value of each vertex <= n - 1
0 <= number of edges <= (n * (n - 1)) / 2
The graph won't contain self loops
 */

/*
    Asymptotic complexity in terms of the number of vertices ( = `n`) and number of edges ( = `e`):
    Time: O(n + e)
    Auxiliary space: O(n)
    Total space: O(n + e)
*/

/* Conclusion
    Given list of arrays representing each edge, i.e. [0, 1], [1, 3], etc.
    And the number of vertices, `n`, what do we know about eulerian cycle?
    The degrees of all vertices must be even
    CODE: create degree list from `n`, representing the vertices of the graph
          iterate through the edges, and increment the degree of each vertex
          if the degree of any vertex is odd, we know it is NOT an eulerian cycle!
 */
fun checkIfEulerianCycleExists(
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

    for (i in 0 until n)
        // NOTE: NOT Eulerian cycle as vertex is odd
        if (degrees[i] % 2 != 0)
            return false

    return true
}