package com.kryptopass.katas.dynamic_programming.m3

fun main() {
    println(equalSubsetPartition(arrayListOf(10, -3, 7, 2, 1, 3)))
    // [false, false, true, false, false, true]
}

/*
Equal Subset Partition
Given an array `s` of `n` integers, partition it into two non-empty subsets, `s1` and `s2`,
such that the sum of all elements in `s1` is equal to the sum of all elements in `s2`.
Return a boolean array of size `n`
where i-th element is 1 if i-th element of `s` belongs to `s1` and 0 if it belongs to `s2`.

Example
{
    "s": [10, -3, 7, 2, 1, 3]
}
Output: [1, 1, 0, 0, 0, 1]
There are multiple partitionings where `s1` sums up to 10 and `s2` sums up to 10;
they are all correct answers:
s1 = [ 10 , -3 , 3 ] and s2 = [ 7 , 2 , 1 ] (Sample output)
s1 = [ 7 , 2 , 1 ] and s2 = [ 10 , -3 , 3 ]
s1 = [10] and s2 = [-3, 3, 7, 2, 1]
s1 = [-3, 3, 7, 2, 1] and s2 = [10]
s1 = [10, -3, 2, 1] and s2 = [7, 3]
s1 = [7, 3] and s2 = [10, -3, 2, 1].

Notes
Any valid answer will be accepted.
If such partitioning is not possible, return an empty array.

Constraints:
1 <= n <= 100
-100 <= elements in s <= 100
 */

/*
    Asymptotic complexity in terms of the length of `s`, `n`:
    Time: O(2^n * n)
    Auxiliary space: O(n)
    Total space: O(n)
 */
fun equalSubsetPartition(
    s: ArrayList<Int>
): ArrayList<Boolean> {
    val found = booleanArrayOf(false)

    val subset = ArrayList<Boolean>(s.size)
    for (i in 0 until s.size) subset.add(false)

    equalSubsetPartitionHelper(subset, s, 0, found)
    if (!found[0]) subset.clear()

    return subset
}

fun equalSubsetPartitionHelper(
    vis: ArrayList<Boolean>,
    s: ArrayList<Int>, idx: Int,
    found: BooleanArray
) {
    if (idx == s.size) {
        found[0] = validator(s, vis)
        return
    }

    if (!found[0]) equalSubsetPartitionHelper(vis, s, idx + 1, found)

    if (!found[0]) {
        vis[idx] = true
        equalSubsetPartitionHelper(vis, s, idx + 1, found)
        vis[idx] = found[0]
    }
}

fun validator(
    v: ArrayList<Int>,
    subsets: ArrayList<Boolean>
): Boolean {
    var sum1 = 0
    var sum2 = 0
    val sz = subsets.count { it }
    val n = v.size

    if (sz == 0 || sz == n || subsets.size != n)
        return false

    for (i in 0 until n)
        if (!subsets[i]) sum1 += v[i]
        else if (subsets[i]) sum2 += v[i]
        else return false

    return sum1 == sum2
}