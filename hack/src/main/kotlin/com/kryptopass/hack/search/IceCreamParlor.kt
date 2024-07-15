package com.kryptopass.hack.search

/*
Each time Sunny and Johnny take a trip to Ice Cream Parlor, they pool their money to buy ice cream.
On any given day, the parlor offers a line of flavors. Each flavor has a cost associated with it.
Given the value of `money` and the `cost` of each flavor for `t` trips to the Ice Cream Parlor,
help Sunny and Johnny choose two distinct flavors such that they spend their entire pool of money during each visit.
ID numbers are the 1-based index number associated with a `cost`.
For each trip to the parlor, print the ID numbers for the two types of ice cream that Sunny
and Johnny purchase as two space-separated integers on a new line.
You must print the smaller ID first and the larger ID second.

Example:
cost = [2, 1, 3, 5, 6]
money = 5
They would purchase flavor ID's 1 and 3 for a cost of 2 + 3 = 5. Use 1-based indexing for your response.

Note:
Two ice creams having unique IDs i and j may have the same cost (i.e., cost[i] == cost[j]).
There will always be a unique solution.

Function Description:
Complete the function whatFlavors in the editor below.
whatFlavors has the following parameter(s):
- int cost[n]: an array of integers representing price for a flavor
- int money: the amount of money they have to spend

Prints:
- Print two space-separated integers denoting the respective indices for the two flavors they choose
  to purchase in ascending order.

Input Format:
The first line contains an integer, t, the number of trips to the ice cream parlor.
Each of the next t sets of 3 lines is as follows:
- The first line contains `money`.
- The second line contains an integer, `n`, the size of the array cost.
- The third line contains `n` space-separated integers denoting the `cost[i]`.

Constraints:
- 1 <= t <= 50
- 2 <= money <= 10^9
- 2 <= n <= 5 * 10^4
- 1 <= cost[i] <= 10^9

Sample Input:
STDIN       Function
-----       --------
2           t = 2
4           money = 4
5           cost[] size n = 5
1 4 5 3 2   cost = [1, 4, 5, 3, 2]
4           money = 4
4           cost[] size n = 4
2 2 4 3     cost = [2, 2, 4, 3]

Sample Output:
1 4
1 2

Explanation:
Sunny and Johnny make the following two trips to the parlor:
1. The first time, they pool together money = 4 dollars.
   There are five flavors available that day and flavors 1 and 4 have a total cost of 1 + 3 = 4.
2. The second time, they pool together money = 4 dollars.
   There are four flavors available that day and flavors 1 and 2 have a total cost of 2 + 2 = 4.
 */
fun main() {
    whatFlavors(arrayOf(1, 4, 5, 3, 2), 4)
    whatFlavors(arrayOf(2, 2, 4, 3), 4)
}

// Time Complexity: O(n), where `n` is the size of the `cost` array
//   loop: iterates over each element in the cost array exactly once -> O(n)
//   hashmap: both operations (lookup and insertion) -> O(1)
// Space Complexity: O(n), in worst case all elements from cost array could be stored in hashmap
fun whatFlavors(
    cost: Array<Int>,
    money: Int
) {
    val costMap = mutableMapOf<Int, Int>()

    for (i in cost.indices) {
        val complement = money - cost[i]

        if (costMap.containsKey(complement)) {
            val firstIndex = costMap[complement]!! + 1
            val secondIndex = i + 1
            print("${firstIndex.coerceAtMost(secondIndex)} ")
            print("${firstIndex.coerceAtLeast(secondIndex)}")
            println()

            return
        }

        costMap[cost[i]] = i
    }
}