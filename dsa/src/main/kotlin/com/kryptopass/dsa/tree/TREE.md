# Trees

## Terms

- Child: can only have one parent
- Parent:
- Sibling: have same parent
- Edge: connection between nodes
- Leaf Node: node with no children

## Characteristics

- Rooted: tree has only one root node
- Acyclic: no cycles
- Directed: edges have direction down from parent to child
- Cannot be disconnected
- Each node can have only one parent, except root node

## Binary Trees

- Each node has at most 2 children
- Height of Node: number of edges on longest path from node to leaf
- Depth (Level): number of edges from node to root, max depth is height of tree
- Height balanced binary tree: depth of two subtrees of every node never differs by more than 1
    - skewed binary tree: computationally inefficient to perform operations
- Height of balanced binary tree is floor(log n)
    - height of binary tree is between `floor(log n)` and `n - 1`
    - log 4 = 2
    - log 8 = 3 -> 2^x = 8 -> x = 3
    - floor[log 5] = 2

## Proof

- log(N + 1) <= H + 1
    - ceiling[log(N + 1)] - 1 = H
- ceiling[log(N + 1)] = floor[log n] + 1
    - floor[log n] = H
- Geometric Progression: 1 + 2 + 4 + ... + 2^H = 2^(H + 1) - 1
- N <= 2^(H + 1) - 1
    - log(N + 1) <= H + 1
    - ceiling[log(N + 1) - 1] = H
- m = floor(log n)
    - m <= log n < m + 1
    - 2^m <= n < 2^(m + 1)
    - 2^m < n + 1 <= 2^(m + 1)
    - m < log(n + 1) <= m + 1
    - ceiling[log(n + 1)] = m + 1
    - floor[log n] = H

## Concepts

- Perfect Binary Tree: all levels are completely filled
- Almost Complete Binary Tree: last level is not completely filled
- Complete Binary Tree (heap): perfect binary tree, except last level, nodes filled left to right
- Full Tree: each node has 0 or exactly 2 children
- Range of Leaves: floor(n/2) to n - 1
- Range of Internal Nodes: 0 to floor(n/2) - 1

## Tree Traversal

- Visit every node exactly once
- BFS: level order traversal
- DFS: pre-order, in-order, post-order
