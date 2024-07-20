package com.kryptopass.hack.graph

import java.util.LinkedList
import java.util.Queue
import java.util.Scanner

/*
Determine minimum cost to provide library access to all citizens of Hackerland.
There are `n` cities numbered from `1` to `n`.
Currently there are no libraries and the cities are not connected.
Bidirectional roads may be built between any city pair listed in `cities`.
A citizen has access to a library if:
- Their city contains a library.
- They can travel by road from their city to a city containing a library.

Example
The following figure is a sample map of Hackerland where the dotted lines denote possible roads:
c_roads = 2
c_lib = 3
cities = [[1, 7], [1, 3], [1, 2], [2, 3], [5, 6], [6, 8]]
The cost of building any road is cc_road = 2 and the cost to build a library is c_lib = 3.
Build 5 roads at a cost of 5 * 2 = 10 and 2 libraries for a cost of 6.
One of the available roads in the cycle 1 -> 2 -> 3 -> 1 is not necessary.
There are `q` queries, where each query consists of a map of Hackerland and value of `c_lib` and `c_road`.
For each query, find the minimum cost to make libraries accessible to all the citizens.

Function Description
Complete the function roadsAndLibraries in the editor below.
roadsAndLibraries has the following parameters:
- int n: integer, the number of cities
- int c_lib: integer, the cost to build a library
- int c_road: integer, the cost to repair a road
- int cities[m][2]: each cities[i] contains two integers that represent cities that can be connected by a new road

Returns
- int: the minimal cost

Input Format
The first line contains a single integer, `q`, that denotes the number of queries.
The subsequent lines describe each query in the following format:
- First line contains 4 space-separated integers that describe respective values of `n`, `m`,
  `c_lib`, and `c_road`, the number of cities, number of roads, cost of a library and cost of a road.
- Each of the next `m` lines contains two space-separated integers, `u[i]` and `v[i]`, that describe
  a bidirectional road that can be built to connect cities `u[i]` and `v[i]`.

Constraints
- 1 <= q <= 10
- 1 <= n <= 10^5
- 0 <= m <= min((n * (n - 1)) / 2, 10^5)
- 1 <= c_road, c_lib <= 10^5
- 1 <= u[i], v[i] <= n
- Each road connects two distinct cities.

Sample Input
STDIN       Function
-----       --------
2           q = 2
3 3 2 1     n = 3, cities[] size m = 3, c_lib = 2, c_road = 1
1 2         cities = [[1, 2], [3, 1], [2, 3]]
3 1
2 3
6 6 2 5     n = 6, cities[] size m = 6, c_lib = 2, c_road = 5
1 3         cities = [[1, 3], [3, 4], [2, 4], [1, 2], [2, 3], [5, 6]]
3 4
2 4
1 2
2 3
5 6

Sample Output
4
12

Explanation
Perform the following `q = 2` queries:
1. HackerLand contains n = 3 cities and can be connected by m = 3 bidirectional roads.
   The price of building a library is c_lib = 2 and the price for repairing a road is c_road = 1.
   The cheapest way to make libraries accessible to all is to:
    - Build a library in city `1` at a cost of `x = 2`
    - Build the road between cities `1` and `2` at a cost of y = `1`
    - Build the road between cities `2` and `3` at a cost of y = `1`
   This gives a total cost of `2 + 1 + 1 = 4`. Note that the road between cities `3` and `1` does
   not need to be built because each is connected to city `2`.
2. In this scenario it is optimal to build a library in each city because the cost to build a library
   is less than the cost to build a road.
   There are `6` cities, so the total cost is ` 6 * 2 = 12`.
 */
fun main() {
    val scanner = Scanner(System.`in`)
    val q = scanner.nextInt()
    val results = mutableListOf<Long>()

    repeat(q) {
        val n = scanner.nextInt()
        val m = scanner.nextInt()
        val costLib = scanner.nextInt()
        val costRoad = scanner.nextInt()
        val cities = Array(m) { Array(2) { 0 } }
        for (i in 0 until m) {
            cities[i][0] = scanner.nextInt()
            cities[i][1] = scanner.nextInt()
        }
        results.add(roadsAndLibrariesBfs(n, costLib, costRoad, cities))
    }

    for (result in results) {
        println(result)
    }

//    roadsAndLibrariesBfs(3, 2, 1, arrayOf(
//        arrayOf(1, 2),
//        arrayOf(3, 1),
//        arrayOf(2, 3)
//    )).also(::println)
//    roadsAndLibrariesBfs(6, 2, 5, arrayOf(
//        arrayOf(1, 3),
//        arrayOf(3, 4),
//        arrayOf(2, 4),
//        arrayOf(1, 2),
//        arrayOf(2, 3),
//        arrayOf(5, 6)
//    )).also(::println)
}

// Time Complexity: O(n + m), where n is the number of cities and m is the number of roads
//    creating adjacency list for the graph -> O(m)
//    bfs traversal of the graph -> O(n + m)
// Space Complexity: O(n + m), where n is the number of cities and m is the number of roads
//    adjacency for the graph -> O(n + m)
//    visited array to keep track of visited cities -> O(n)
//    queue for bfs traversal -> O(n)
fun roadsAndLibrariesBfs(
    n: Int,
    costOfLib: Int,
    costOfRoad: Int,
    cities: Array<Array<Int>>
): Long {
    if (costOfLib <= costOfRoad) {
        // if library cost is less than or equal to road cost, build a library in each city
        return n.toLong() * costOfLib
    }

    // graph is built using an adjacency list where each city points to its neighboring cities
    val graph = Array(n + 1) { mutableListOf<Int>() }
    for (road in cities) {
        val u = road[0]
        val v = road[1]
        graph[u].add(v)
        graph[v].add(u)
    }

    val visited = BooleanArray(n + 1)
    var totalCost = 0L

    fun bfs(start: Int): Int {
        val queue: Queue<Int> = LinkedList()
        queue.add(start)
        visited[start] = true
        var count = 1

        while (queue.isNotEmpty()) {
            val city = queue.poll()
            for (neighbor in graph[city]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true
                    queue.add(neighbor)
                    count++
                }
            }
        }

        return count
    }

    for (city in 1..n) {
        if (!visited[city]) {
            val componentSize = bfs(city)
            totalCost += costOfLib + (componentSize - 1) * costOfRoad
        }
    }

    return totalCost
}