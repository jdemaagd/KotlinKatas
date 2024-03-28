# Dynamic Programming

## Identify if it is an optimization problem

- maximization
- minimization
- optimization

## Come up with recurrence equation

- via decrease/divide & conquer
- requires property of optimal substructure
- any optimal solution -> c1 + c2 + c3 + ... + ck = a

## Identify all possible sub-problems

- 0, ..., a - 2, a - 1, a -> a + 1 distinct sub-problems

## Identify dependencies

- to decide what order to compute sub-problems in
- is there a directed acyclic graph (DAG)?
    - is topological sort order to build up solutions possible
- Vertex -> each sub-problem

## Identify data structure to store sub-problem solutions

- typically a table of size a + 1
- table[i] = solution to sub-problem of size i = f(i)

## Write up Dynamic Programming Algorithm

## Optimal Substructure

- look at last piece of problem
- break problem into smaller sub-problems
- do not think about overall complexity of problem
- delegate smaller sub-problem and so on until problem is trivial
