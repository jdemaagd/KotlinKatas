## Problem: Climbing N Stairs

```
A child is trying to climb a staircase. The maximum number of steps he can climb at a time is two;
that is he can climb either one step or two steps at a time.
If there are n steps in total, in how many different ways can he climb the staircase?

def f(n):
    table = array of size n+1
    
    if n == 1 or n == 2:
        return n
    
    for i in 3 to n:
        table[i] = table[i-1] + table[i-2]
        
    return table[n]

Counting Problem -> Decrease and Conquer -> Recurrence Equation -> Bottom-up DP
Time Complexity: O(n)
Space Complexity: O(1), do not need an array
```
