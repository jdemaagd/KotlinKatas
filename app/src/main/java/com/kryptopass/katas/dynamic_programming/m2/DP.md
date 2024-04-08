# Dynamic Programming

## What is Dynamic Programming?

- Dynamic Programming is doing recursion without repetition
- Two Variants:
    - Memoization (Top Down)
    - Tabulation (Bottom Up) -> Class Focus

## Recursion Extension/optimization

- Level 1 -> combinatorial enumeration of given input,
    - e.g. permutations, combinations
    - time/space complexity: exponential
- Level 2 -> constraints combinatorial enumeration,
    - e.g. combination of certain sum/certain size (backtracking)
    - time/space complexity: exponential
- Level 3 -> compute single value (output from enumeration)
    - time/space complexity: polynomial
    - counting problem
    - decision problem
    - optimization problem
- Recursion -> focus on leftmost
- keep track of partial slate (sub-problem)

## Memoization Variant

- Top-Down Approach
    - Recursive
    - Uses call stack (aux space)
    - Random Access
    - May be able to skip sub-problems

## Tabulation Variant

- Bottom Up Approach
    - Iterative
    - Cache locally
    - Cannot skip sub-problems
