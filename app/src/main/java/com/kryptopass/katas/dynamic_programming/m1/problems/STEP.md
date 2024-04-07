# Dynamic Programming Steps

## Identify if it is an optimization problem

- maximization
- minimization
- optimization

## Come up with a recurrence equation

- via decrease/divide & conquer
- requires property of optimal substructure
- any optimal solution -> c1 + c2 + c3 + ... + ck = a

## Identify all the different possible sub-problems

- 0, ..., a - 2, a - 1, a -> a + 1 distinct sub-problems

## Identify dependencies

- so that we can decide what order to compute sub-problems in
- do we have a directed acyclic graph (DAG)?
    - we can use topological sort order to build up the solutions?
- Vertex -> each sub-problem

## Identify the data structure to store the sub-problem solutions

- typically a table of size a + 1
- table[i] = solution to sub-problem of size i = f(i)

## Write up the Dynamic Programming Algorithm

## NOTE on Optimal Substructure

- allows us to look at the last piece of the problem
- allowing us to break our problem into smaller sub-problems
- we do not have to think about the overall complexity of the problem
- we can delegate the smaller sub-problem and so on until the problem is trivial
