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
