# Count Unique Paths

## Some Problems

|    First Step    |      Strategy      |          Next Step          |      Algorithm      | Memoization |
|:----------------:|:------------------:|:---------------------------:|:-------------------:|:-----------:|
|                  |                    | Recurrence Equation fib(n)  | Dynamic Programming |  1D Array   |
| Counting Problem | Decrease & Conquer | Recurrence Equation fib(n)  | Dynamic Programming |  1D Array   |
|                  |                    | Recurrence Equation C(n, k) | Dynamic Programming |  2D Array   |
| Counting Problem | Decrease & Conquer | Recurrence Equation 2 args  | Dynamic Programming |  2D Array   |

- NOTE: Efficient Implementation with no repeated work
    - reduced Time Complexity down from Exponential to Linear time
    - with Space Tradeoff to cache/store repeated work

## Problem: Count Unique Paths in a Grid

- Given: A `2D` grid with `m` rows and `n` columns,
- count the number of unique paths starting in the top-left corner,
- and ending in the bottom-right corner of the grid.
- All moves must either go right or down.
- Top-left corner is (0, 0) and bottom-right corner is (m - 1, n - 1).
- Total number of moves: (m - 1) + (n - 1) = m + n - 2

## How many sub-problems?

- f(m - 1, n - 1) -> number of unique paths to (m - 1, n - 1) from (0, 0)
- f(m - 1, n - 1) = f(m - 2, n - 1) + f(m - 1, n - 2)
- Number of unique sub-problems: m * n
- If we can use topological sort, row by row
    - we would have the cells immediately above and to the left cached/stored
    - and we can add these up and cache/store new result
- Base Cases: would lie in 0th column and 0th row

## Pseudo Code Bottom Up Dynamic Approach

```
def countPaths(m, n):
    table = 2D array of size m x n
    
    # base case, column 0
    for i from 0 to m - 1:
        table[i][0] = 1
    
    # base case, row 0
    for j from 0 to n - 1:
        table[0][j] = 1
        
    # topological sort, row by row
    for row from 1 to m - 1:
        for col from 1 to n - 1:
            table[row][col] = table[row - 1][col] + table[row][col - 1]
            
    return table[m - 1][n - 1]

T(m, n) = O(m * n)
S(m, n) = O(m * n) -> O(m) or O(n) if we optimize space
We can optimize space as before by reusing space
```
