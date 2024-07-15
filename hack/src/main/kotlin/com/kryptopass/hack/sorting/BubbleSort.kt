package com.kryptopass.hack.sorting

/*
Consider the following version of Bubble Sort:
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n - 1; j++) {
        // Swap adjacent elements if they are in decreasing order
        if (a[j] > a[j + 1]) {
            swap(a[j], a[j + 1]);
        }
    }
}
Given an array of integers, sort the array in ascending order using the Bubble Sort algorithm above.
Once sorted, print the following three lines:
    - Array is sorted in numSwaps swaps, `numSwaps` where is the number of swaps that took place.
    - First Element: firstElement, where `firstElement` is the first element in the sorted array.
    - Last Element: lastElement, where `lastElement` is the last element in the sorted array.
Hint: add a variable that keeps a running tally of all swaps that occur during execution

Example
a = [6, 4, 1]
swap    a
0       [6, 4, 1]
1       [4, 6, 1]
2       [4, 1, 6]
3       [1, 4, 6]
The steps of the bubble sort are shown above. It took 3 swaps to sort the array. Output is:
Array is sorted in 3 swaps.
First Element: 1
Last Element: 6

Function Description
Complete the function countSwaps in the editor below.
countSwaps has the following parameter(s):
    int a[n]: an array of integers to sort

Prints
Print the three lines required, then return. No return value is expected.

Input Format
The first line contains an integer, n, the size of the array a.
The second line contains n space-separated integers a[i].

Constraints
2 <= n <= 600
1 <= a[i] <= 2 x 10^6

Sample Input 0
STDIN       Function
-----       --------
3           a[] size n = 3
1 2 3       a = [1, 2, 3]

Sample Output 0
Array is sorted in 0 swaps.
First Element: 1
Last Element: 3

Explanation 0
The array is already sorted, so 0 swaps take place.

Sample Input 1
3
3 2 1

Sample Output 1
Array is sorted in 3 swaps.
First Element: 1
Last Element: 3

Explanation 1
The array is not sorted, and its initial values are: {3, 2, 1}. The following 3 swaps take place:
1. {3, 2, 1} -> {2, 3, 1}
2. {2, 3, 1} -> {2, 1, 3}
3. {2, 1, 3} -> {1, 2, 3}
At this point the array is sorted and the three lines are printed.
 */
fun main() {
    countSwaps(arrayOf(3, 2, 1))
    println()
    countSwaps(arrayOf(1, 2, 3))
    println()
    countSwaps(arrayOf(6, 4, 1))
}

// Time Complexity: O(n^2), where n is the number of elements in the array
//   outer loop runs n times, inner loop runs n - 1 times,
//   n * (n - 1) = n^2 - n -> O(n^2)
// Space Complexity: O(1), array is sorted in place
//   determined by amount of extra space it uses beyond input array
//   algorithm uses a few extra variables (`n`, `swap`, `i`, `j`),
//   this space does not depend on size of input array and is therefore considered constant
fun countSwaps(
    arr: Array<Int>
) {
    val n = arr.size
    var swap = 0

    for (i in 0 until n) {
        for (j in 0 until n - 1) {
            if (arr[j] > arr[j + 1]) {
                arr[j] = arr[j + 1].also { arr[j + 1] = arr[j] }
                swap++
            }
        }
    }

    println("Array is sorted in $swap swaps.")
    println("First Element: ${arr.first()}")
    println("Last Element: ${arr.last()}")
}