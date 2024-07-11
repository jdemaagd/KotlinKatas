# QUIZ: Josephus Problem, Approach 2

## Question 1

```
Consider the following Python function intended to solve the Josephus problem, where the task is 
to find the safe position in a circle of n people eliminated every k-th person until one remains:
    def findTheWinner(n, k):
        def josephus(n):
            if n == 1:
                return 1  
            #recursive case
            return (josephus(n-1) + k) % n
        return josephus(n)
An error has been introduced in this modified version of the function. What is the error?

a. The recursive call (josephus(n-1) + k) % n does not properly account 
   for the zero-based nature of Python lists.
b. There should be no recursive case when n == 1; the function should immediately return the result.
c. The base case of the recursive function josephus incorrectly 1 instead of 0.
d. The function does not adjust the final result to account 
   for the zero-based indexing used in Python.

Solution: c
```

## Question 2

```
Consider this modified version of the Python function intended to solve the Josephus problem, 
determining the safe position in a sequence of eliminations:
    def findTheWinner(n, k):
        def josephus(n):
            if n == 1:
                return 0
            return (josephus(n - 1) + k - 1) % n
        return josephus(n) + 1
Find the error:

a. Subtracting 1 from k in the recursive formula (josephus(n - 1) + k - 1) % n introduces an error 
   by incorrectly shifting the start of each counting cycle backward by one position, 
   which disrupts the correct elimination sequence.
b. The base case should check for n == 0 instead of n == 1 to align with zero-based indexing 
   used in recursive calculations.
c. The modulo (josephus(n - 1) + k - 1) % n is unnecessary 
   because the values of k are always less than n.
d. Returning josephus(n) + 1 at the end of the function is incorrect 
   as it could potentially index outside the range of players.

Solution: a
```

## Question 3

```
Consider this variation of the Python function intended to solve the Josephus problem, 
determining the winner in a sequence where players are systematically eliminated:
    def findTheWinner(n, k):
        def josephus(n):
            if n == 1:
                return 0
            return (josephus(n - 1) + k) % (n - 1)
        return josephus(n) + 1
An error has been introduced in this version of the function. What is the error?

a. The recursive formula (josephus(n - 1) + k) % (n - 1) uses n - 1 instead of n 
   for the modulo operation, potentially causing incorrect cyclic behavior.
b. The modulus operation % (n - 1) is incorrectly used, 
   which may lead to an infinite loop due to a zero modulus if n becomes 1.
c. The recursive formula should include an additional +1 adjustment to account 
   for zero-based indexing in Python.
d. Returning josephus(n) + 1 at the end is incorrect as it could produce an index 
   that is out of bounds for the given problem setup.

Solution: a
```
