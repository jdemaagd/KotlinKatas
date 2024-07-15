# Recursion

## Basics

- Foundation for many algorithms such as backtracking, dynamic programming, greedy, divide & conquer
- Function calling itself until a base or terminating condition is met
- Use Cases: can problem be divided into smaller sub-problems and can solving sub-problem(s) help in
  solving original problem

## Recursive Leap of Faith

- Understand the problem -> print 3 2 1 1 2 3
- Identify the sub-problem -> print 2 1 1 2
- Trust & Faith -> trust recursive call will correctly solve smaller version of the problem
- Link original problem & sub-problem -> 3 `2 1 1 2` 3
- Base condition -> for 0, return

## Recursion Tree/Call Stack

- Memory has to be allocated for each function call
    - local variables
    - function arguments
    - return address

## Iteration

- Space complexity is better than recursion as it does not use space on the call stack
- Only has an ascending phase, no descending phase as in recursion

## Base Condition

- Last valid input -> if n is 1, return 1
- First invalid input -> if n < 1, return

## Recurrence Relation

- Expresses solution of a problem as a function of smaller instances of the same problem
- Factorial -> f(n) = n * f(n - 1)
- Fibonacci -> f(n) = f(n - 1) + f(n - 2)
- Tower of Hanoi -> f(n) = 2 * f(n - 1) + 1
- Josephus -> f(n, k) = (f(n - 1, k) + k - 1) % n + 1
- k-th symbol in Grammar -> f(n, k) = f(n - 1, (k + 1) / 2)

## Complexity Analysis

- Time complexity -> count of nodes * work done per node
    - (leaf nodes * work done per leaf node) + (non-leaf nodes * work done per non-leaf node)
- Space complexity -> depth of recursion tree

## Josephus problem


