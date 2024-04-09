# Even Degree

## Eulerian Cycle

- Possible for graph to have an Eulerian cycle even if it is disconnected
- All edges of the graph must belong to the same connected component
- All vertices must have even degree
- If the degree of any vertex is odd, the graph cannot have an Eulerian cycle
- A -> B <==> not(B) -> not(A)

## Königsberg Problem

- Knowing that every vertex must have even degree
- The graph modeled for the Königsberg problem is not an Eulerian cycle
- Every vertex has an odd degree

## Conclusion

- Given a connected graph, look at number of vertices with odd degree
- If that number is greater than 2, then there cannot exist an Eulerian cycle/path
- if that number is exactly 2, then there exists an Eulerian path
    - where journey starts from either of the two vertices with odd degree
- if that number is 0, then there exists an Eulerian cycle
    - the required journey can start at any vertex
