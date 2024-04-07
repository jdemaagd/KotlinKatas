# Counting Subsets of Size K

## Ways of choosing K elements from a set of N elements

- C(n, k) = C(n - 1, k) + C(n - 1, k - 1)
- Reference Pascal's Triangle
- Can we improve on time complexity?, cut down repeated work
- And improve on potential exponential time complexity?
- Recall: C(n, k) = n! / (k! * (n - k)!)

## Pseudo Code

```
def C(n, k):
    if k == 0 or k == n:
        return 1
        
    table = 2D array of size n + 1 by k + 1
    
    for row in 0 to n:              // initialize column 0 base case
        table[row][0] = 1
    
    for col in 0 to k:              // initialize diagonal base case
        table[col][col] = 1
        
    for row in 2 to n:
        for col in 1 to min(row, k):
            table[row][col] = table[row - 1][col] + table[row - 1][col - 1]
    
    return table[n][k]

T(n): O(nk)
S(n): O(nk), can we improve on space like we did for Fibonacci?
    we only need to track 2 layers at a time, so reuse space similar to Fibonacci
    O(k)
```
