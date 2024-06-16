# Minimum Cost Stair Climbing

## Claim

- fn = f(n - 1) + f(n - 2)
- exponential in `n`
- Given a path S -> D
- If we know this is min-cost path, from S to D
- Then any prefix of this path is also min-cost path
- We see that this has optimal substructure property
- f(i) -> value of the min-cost path from S to i
- Total number of sub-problems would be ~n

## Pseudo Code

```
def minCost(n, costArr):
    table = 1D Array of size n + 2
    table[0] = 0
    table[1] = costArr[0]
    
    for i in range(2, n + 1):
        table[i] = costArr[i - 1] + min(table[i - 1], table[i - 2])
        store pointer to cell with min value
        
    return table[n + 1]
    
T(n) -> O(n)
S(n) -> O(n)
```
