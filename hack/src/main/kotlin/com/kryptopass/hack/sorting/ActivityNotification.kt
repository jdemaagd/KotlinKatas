package com.kryptopass.hack.sorting

/*
Hackerland National Bank has a simple policy for warning clients about possible fraudulent account activity.
If the amount spent by a client on a particular day is greater than or equal to 2x the client's
median spending for a trailing number of days, they send the client a notification about potential fraud.
The bank doesn't send the client any notifications until they have at least
that trailing number of prior days' transaction data.
Given the number of trailing days d and a client's total daily expenditures for a period of n days,
determine the number of times the client will receive a notification over all n days.

Example
expenditure = [10, 20, 30, 40, 50]
d = 3
On the first three days, they just collect spending data. At day 4, trailing expenditures are [10, 20, 30].
The median is 20 and the day's expenditure is 40. Because 40 >= 2 * 20, there will be a notice.
The next day, trailing expenditures are [20, 30, 40] and the expenditures are 50.
This is less than 2 * 30 so no notice will be sent. Over the period, there was one notice sent.
Note: The median of a list of numbers can be found by first sorting the numbers in ascending.
If there is an odd number of values, the middle one is picked. If there is an even number of values,
the median is then defined to be the average of the two middle values.

Function Description
Complete the function activityNotifications in the editor below.
activityNotifications has the following parameter(s):
- int expenditure[n]: daily expenditures
- int d: the look-back days for median spending

Returns
- int: the number of notices sent

Input Format
The first line contains two space-separated integers n and d, the number of days of transaction data,
and the number of trailing days' data used to calculate median spending.
The second line contains n space-separated non-negative integers where each integer i denotes expenditure[i].

Constraints
1 <= n <= 2 x 10^5
1 <= d <= n
0 <= expenditure[i] <= 200

Output Format

Sample Input 0
STDIN                   Function
-----                   --------
9 5                     expenditure[] size n = 9, d = 5
2 3 4 2 3 6 8 4 5       expenditure = [2, 3, 4, 2, 3, 6, 8, 4, 5]

Sample Output 0
2

Explanation 0
Determine the total number of notifications the client receives over a period of n = 9 days.
For the first five days, the customer receives no notifications because the bank has insufficient transaction data:
notification = 0
On the sixth day, the bank has d = 5 days of prior transaction data, {2, 3, 4, 2, 3}, and median = 3 dollars.
The client spends 6 dollars, which triggers a notification because 6 >= 2 x median: notifications = 0 + 1 = 1
On the seventh day, the bank has d = 5 days of prior transaction data, {3, 4, 2, 3, 6}, and median = 3 dollars.
The client spends 8 dollars, which triggers a notification because 8 >= 2 x median: notifications = 1 + 1 = 2
On the eighth day, the bank has d = 5 days of prior transaction data, {4, 2, 3, 6, 8}, and median = 4 dollars.
The client spends 4 dollars, which does not trigger a notification because 4 < 2 x median: notifications = 2
On the ninth day, the bank has d = 5 days of prior transaction data, {2, 3, 6, 8, 4}, and a median = 4 dollars.
The client spends 5 dollars, which does not trigger a notification because 5 < 2 x median: notifications = 2

Sample Input 1
5 4
1 2 3 4 4

Sample Output 1
0

Explanation 1
There are 4 days of data required so the first day a notice might go out is day 5.
Our trailing expenditures are [1, 2, 3, 4] with a median of 2.5.
The client spends 4 which is less than 2 * 2.5 so no notification is sent.
 */
fun main() {
    activityNotifications(arrayOf(10, 20, 30, 40, 50), 3).also(::println)
    activityNotifications(arrayOf(2, 3, 4, 2, 3, 6, 8, 4, 5), 5).also(::println)
    activityNotifications(arrayOf(1, 2, 3, 4, 4), 4).also(::println)
}

// Time Complexity: O(n), array initialization -> O(d), sliding window processing -> O(1),
// Space Complexity: O(1)
fun activityNotifications(
    expenditure: Array<Int>,
    d: Int
): Int {
    val maxExpenditure = 200
    val count = IntArray(maxExpenditure + 1)
    var notifications = 0

    fun findMedian(): Double {
        var sum = 0
        val mid1 = (d / 2)
        val mid2 = (d / 2) + 1

        var median1 = -1
        var median2 = -1

        for (i in count.indices) {
            sum += count[i]
            if (median1 == -1 && sum >= mid1) {
                median1 = i
            }
            if (sum >= mid2) {
                median2 = i
                break
            }
        }
        return if (d % 2 == 0) {
            (median1 + median2) / 2.0
        } else {
            median2.toDouble()
        }
    }

    for (i in 0 until d) {
        count[expenditure[i]]++
    }

    for (i in d until expenditure.size) {
        val median = findMedian()
        if (expenditure[i] >= 2 * median) {
            notifications++
        }

        count[expenditure[i]]++
        count[expenditure[i - d]]--
    }

    return notifications
}