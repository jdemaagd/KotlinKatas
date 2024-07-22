# Binary Search Tree

## Overview

- Every node has at most 2 children
- Sorted in a particular way
    - left child < parent < right child
    - equality defined specifically by bst
        - left <= parent < right OR left < parent <= right

## Big O of Common Operations

|        | Tree                             |
|--------|----------------------------------|
| Insert | T=O(log n) best, avg, O(n) worst |
|        | S=O(1), iterative                |
|        | S=O(log n), recursive            |
| Search | T=O(log n) best, avg, O(n) worst |
|        | S=O(1), iterative                |
|        | S=O(log n), recursive            |
| Delete | T=O(log n) best, avg, O(n) worst |
|        | S=O(1), iterative                |
|        | S=O(log n), recursive            |

## Traversals

- BFS (level order) -> [20, 13, 40, 10, 13, 43, 8, 11, 41]
    - queue: [~~20~~, ~~13~~, ~~40~~, ~~10~~, ~~13~~, ~~43~~, ~~8~~, ~~11~~, ~~41~~]
        - while queue is not empty -> dequeue, push to array, enqueue left, enqueue right
    - array: [20, 13, 40, 10, 13, 43, 8, 11, 41]
    - Time Complexity: O(n), visit every node once
    - Space Complexity: O(n), size of array is `n` or O(w), where `w` is the width of tree
- DFS (depth first)
    - in order: process left node, current node, right node
        - [8, 10, 11, 13, 13, 20, 40, 41, 43] -> ascending order
    - pre order: process current node, left node, right node
        - [20, 13, 10, 8, 11, 13, 40, 43, 41]
    - post order: process left node, right node, current node
        - [8, 11, 10, 13, 13, 41, 43, 40, 20]
    - fun traverse (node):
        - if left node: traverse(left)
        - array.push(node)
        - if right node: traverse(right)
    - Time Complexity: O(n), visit every node once
    - Space Complexity: O(n), array of size `n` or O(d), where `d` is depth of tree (call stack)
