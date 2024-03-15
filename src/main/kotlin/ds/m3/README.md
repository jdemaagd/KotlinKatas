# Linked Lists

## Getting Started with LinkedList

- Address problem of insertion time with ArrayList where when array is full we need to create larger array and copy all
  elements from old array to new array
- Data structure that is linear in nature and all elements establish a link to their next element
- Along with a value, each element in a LinkedList is responsible for holding reference of next element
- As all elements hold multiple things in them, generally they're all objects and are called node instead of element
- The first node is called the head of `LinkedList`
- The last node has a null reference as there's no next node
- All nodes in a `LinkedList` are not stored in a contiguous memory location

## Understanding a Singly LinkedList

- A Singly Linked List has a node containing the data and, at most, one reference pointing to the next node

## Understanding a Doubly LinkedList

- Addresses performance issue of getting previous node
- Store previous node reference of every node in the same way we store the next node reference
- Operations can be performed much faster because of the previous node's storage

## Understanding a Circular LinkedList

- LinkedList whose head and tail are connected
- Could be Singly or Doubly LinkedList

## Conclusion

- Choose `LinkedList` over arrays or vectors when you need more insertion or deletion operations compared to fetch (index)
  operation
- If you need more fetch (index) operations, you should choose arrays or vectors over a `LinkedList`
- NOTE: Blockchain, is implemented with `LinkedList`
