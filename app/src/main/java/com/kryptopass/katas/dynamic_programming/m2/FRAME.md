# Dynamic Programming Framework

## Steps

- Do you need recursion?
    - f(n) = f(n - 1) + f(n - 2)
    - f(i) = f(i - 1) + f(i - 2)
    - 0 <= i <= n
    - decrease & conquer
- Do you need Dynamic Programming?
    - do u have overlapping sub-problems?
- Implementation of DP
    - base case(s)
        - do not fit into recursive/recurrence equation
        - typically 0 or 1 or both
    - 1D table of size n+1
    - table[n] initialize to 0
    - recurrence equation from 2 to n
        - table[i] = table[i - 1] + table[i - 2]
    - return table[n]
- Time/Space Complexity -> O(n)
- Extensions/Follow-Up
    - consider optimizations - reuse space (table might not be needed)
    - reconstruct solution -> decision/optimization problems
