# Maximum Path Sum

## Problems

- Counting Problems
- Optimization Problems
- S -> E: best path to E
- S -> T: best path to T
- Any prefix of S -> E, say S -> T will also be optimal
- Knowing optimal substructure (path) to both my neighbors
- I can extend the path to include myself to compute
    - x + points in my cell
    - y + points in my cell
    - take the max of the two

## Pseudo Code

```
def maxPath(grid):
    table = 2D array of size grid
    table[0][0] = grid[0][0]
    
    m = grid.size
    n = grid[0].size

    for j in 1 to n - 1:
        table[0][j] = table[0][j-1] + grid[0][j]
    for i in 1 to m - 1:
        table[i][0] = table[i-1][0] + grid[i][0]
    
    for row in 1 to m - 1:
        for col in 1 to n - 1:
            table[row][col] = grid[row][col] + max(table[row-1][col], table[row][col-1])
            set pointer to cell with max value
    
    return table[m - 1][n - 1]

T(m,n) -> O(mn)
S(m,n) -> O(mn)
```
