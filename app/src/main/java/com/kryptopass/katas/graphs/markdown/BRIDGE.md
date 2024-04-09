# Problem definition Seven Bridges of Königsberg

## Can one walk across the 7 bridges without crossing the same bridge twice?

- In 1736, Prussian Empire was precursor to modern state of Germany
- Königsberg was capital of Prussia, that became important trading center.
    - Pregel River flowed through heart of the city, allowing ships to sail to middle of the city
    - With all the money coming from trade, residents used some of it to build 7 bridges across the
      river
- Mayor sends letter to famous mathematician Leonhard Euler,
    - asking if it was possible to walk across all 7 bridges without crossing the same bridge twice

## Graph

- Vertex
- Edge
- Path
- Cycle

## Degree

- Edges connected to a vertex
- Sum of degrees of all vertices
    - Undirected -> 2 * number of edges
    - Directed -> Out-degree + In-degree

## Eulerian cycle

- Cycle that uses every edge exactly once and starts and ends at the same vertex
- Eulerian path
    - Cycle that uses every edge exactly once,
    - But starts at one vertex and ends at another
- Eulerian cycle is an eulerian path
- But Eulerian path is not necessarily an Eulerian cycle
- Note: Hamiltonian cycle is a cycle that visits every vertex exactly once
    - this is a very different problem
    - empty hard problem: no known formula time algorithm
    - i.e. traveling salesman problem
