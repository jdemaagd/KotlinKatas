# Dynamic Programming

## Intro

- Name invented by Richard Bellman in the 1950s
- Nothing dynamic about problems we will tackle
- Programming meant scheduling or planning in 1950s
- Working definition: recursion without repetition

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

## Quiz: The Tribonacci sequence Tn is defined as follows:

```
T0 = 0, T1 = 1, T2 = 1
Tn = Tn-1 + Tn-2 + Tn-3
Consider the following recursive code which implements the mathematical definition:
    int nthtibonacci(int n) {
        if n == 0 or n == 1:
            return n
        if n == 2 
            return 1
        return nthtibonacci(n - 1) + nthtibonacci(n - 2) + nthtibonacci(n - 3)
    }


What is the running time complexity of this implementation?

Linear
Quadratic
Some higher-order polynomial in n
Some exponential in n                   CHECK
```

## [TopDown vs BottomUp](https://www.shiksha.com/online-courses/articles/difference-between-top-down-and-bottom-up-parsing-blogId-158057)

- TopDown
    - recursive
    - starts at highest level of parse tree and works its way down to leaves
- BottomUp
    - iterative
    - starts with input tokens (leaves of parse tree) and builds up to start symbol of grammar
