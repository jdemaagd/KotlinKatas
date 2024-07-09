# Dynamic Programming

## Overview

- Dynamic programming is a method for solving complex problems where problems exhibit two
  characteristics
    - overlapping sub-problems
    - optimal substructure: optimal solution to a problem can be constructed from optimal solutions
      of its sub-problems
        - Fibonacci sequence is an example of optimal substructure
        - Tower of Hanoi is NOT an example of optimal substructure
- Memoization: Recursion plus Storage
- Tabulation: using tables to store the results of sub-problems

|       TopDown (Memoization)        |      BottomUp (Tabulation)       |
|:----------------------------------:|:--------------------------------:|
| starts with original/large problem | starts with smallest sub-problem |
|         recursive approach         |        iterative approach        |

## Patterns

- Fibonacci based
- Knapsack pattern
- Longest Common Subsequence
- Longest Increasing Subsequence
- Gap Strategy
- Partition Strategy
- Kadane's Algorithm

## Approach

- Start with a recursive solution
- Memoization / top-down approach
- Tabulation / bottom-up approach
- Space optimized tabulation approach
- Following these steps will help with mastering DP
    - and will help you solve new problems you have never encountered before

## Why does this Approach work?

- Writing recursive solution
    - helps to understanding subproblems
        - recursion inherently breaks down a problem into smaller subproblems
        - you will gain clear understanding of what these subproblems
        - which is essential for dynamic programming approach
    - also helps to understand the transition formula
        - the way recursive calls are made helps in identifying the transition formula
        - this formula is crucial for filling out the DP table in the bottom-up approach
    - helps to recognize the base conditions
        - base cases in recursion translate to initial conditions in DP table

## Identifying Dynamic Programming Problems

- You are asked to find an optimal solution
    - such as the `longest`, `maximum`, `minimum`, etc.
- Problem involves choices -> recursion
    - especially where choices involve 2 or more paths, there is high probability for overlapping
      subproblems
