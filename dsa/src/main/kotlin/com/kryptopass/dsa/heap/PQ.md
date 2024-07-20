# Priority Queue

## Properties

- Each element has a priority associated with it
- Typically, Priority Queues are implemented with a Heap
- Can be implemented in other ways but Heap is more efficient
- Every node has a value as well as a priority
- And we heapify based on the priority
- Max Priority Queue: highest priority element is dequeued first
- Min Priority Queue: lowest priority element is dequeued first

## Big-O Common Operations

| Operation                | Tree                         |
|--------------------------|------------------------------|
| Removal (Dequeue)        | T=O(log n): best, worst, avg |
|                          | S=O(1)                       |
| Insertion (Enqueue)      | T=O(log n): best, worst, avg |
|                          | S=O(1)                       |
| Peek at max/min priority | T,S = O(1)                   |
