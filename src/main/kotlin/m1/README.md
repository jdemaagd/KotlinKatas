# A Walk Through - Data Structures & Algorithms

## Analyzing with time complexity

## Analyzing with space complexity

## Complexity of an Algorithm

- Best case analysis: defines minimum time required by algorithm to produce output, also represented as Omega (Ω)
- Average case analysis: defines average time required by an algorithm to produce output for different sized input, also
  represented as Theta notation (θ)
- Worst case analysis: defines maximum time required by an algorithm to produce output, also represented as a Big O
  notation (O)

## Asymptotic Behavior

- Consider only those factors that change based on input
    - f(n) = 3n + 5 can be considered f(n) = n
    - f(n) = 5 can be considered f(n) = 1
    - f(n) = n2 + 3n + 5 can be considered f(n) = n2
- Summarize the asymptotic behavior of an algorithm as follows
    - Any program that doesn't have any loop has f(n) = 1
    - Any program with one for loop has f(n) = n
    - Any program with one nested for loop (for loop inside another for loop) has f(n) = n2.
