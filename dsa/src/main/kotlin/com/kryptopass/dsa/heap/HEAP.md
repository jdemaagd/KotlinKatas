# Heaps

## Binary Heaps

- Tree-based data structure where every node can have at most 2 children
- Binary heap is a complete binary tree
    - can be perfect binary tree
    - or almost complete binary tree
- Also satisfies the heap property
    - max heap: every parent node is larger than child node(s)
    - min heap: every parent node is smaller than child node(s)
- Parent to children -> 2n + 1, 2n + 2
- Child to parent -> floor((n - 1) / 2)
- [95, 50, 45, 21, 22, 30, 35, 19, 20, 15, 16, 25, 26, 34, 33]
- 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 -> indices for above array
- Range of leaves & internal nodes
    - leaves -> floor(n / 2) to  (n - 1)
    - internal nodes -> 0 to floor(n / 2) - 1

## Big-O Common Operations

| Operation             | Tree                         |
|-----------------------|------------------------------|
| Removal / Bubble down | T=O(log n): best, worst, avg |
|                       | S=O(1)                       |
| Insertion / Bubble up | T=O(log n): best, worst, avg |
|                       | S=O(1)                       |
| Searching             | T=O(n), S=O(1)               |
| Build heap from array | T=O(n), S=O(1)               |

## Build Max Heap

- Heapify Algorithm
    - requires that all elements in left & right subtrees follow the heap property
    - swap larger of the two children with the parent
    - repeat until the parent is larger than both children
- Build
    - given an array -> [4, 7, 3, 0, 9, 3, 2, 6]
        - build complete binary tree, top to bottom, left to right
        - now heapify internal nodes, bottom to top, right to left
        - note that leaf nodes already follow the heap property
        - max binary heap -> [9, 7, 3, 6, 4, 3, 2, 0]
    - T=O(n), S=O(1)
        - depends on max number of swaps
            - L0 -> n/8 nodes, can be max 3 swaps
            - L1 -> n/4 nodes, can be max 2 swap
            - L2 -> n/2 nodes, can be max 1 swap
            - L3 -> n nodes, leaf nodes do not need to be swapped
            - (n/2^0 * 0) + (n/2^1 * 1) + (n/2^2 * 2) + ... + (n/(2^log n) * log n)
- Insert: bubble/sift up
    - add element to the end of the array
    - compare to its parent & swap if it is larger
    - repeat until parent is larger than its children
    - T=O(log n), S=O(1)
        - depends on height of tree or max depth
        - O(d), where d is depth of tree
        - number of comparisons is `log n` and doing 1 comparison per level
- Remove (extract max/min): bubble/sift down
    - remove root node
    - replace with last node
    - heapify root node
    - T=O(log n), S=O(1)
        - depends on height of tree or max depth
        - O(d), where d is depth of tree
        - number of comparisons is `log n` and doing 1 comparison per level
- Peek
    - return root node value (array[0])
    - T=O(1), S=O(1)
