# QUIZ: Josephus Problem, Approach 3

## Question 1

```
Consider the following Python function intended to solve the Josephus problem, 
determining the survivor in a sequence where players are systematically eliminated:
    def findTheWinner(n, k):
        survivor = 1
        for i in range(2, n+1):
            survivor = (survivor + k) % i
        return survivor + 1
An error has been introduced in this modified version of the function. What is the error?

a. Initializing survivor to 1 instead of 0 disrupts the correct base for zero-based indexing, 
   leading to an incorrect result.
b. The formula (survivor + k) % i should use i + 1 in the modulo operation 
   to correctly account for the current number of players.
c. The loop starting from 2 to n + 1 improperly adjusts the range, 
   missing the correct initial condition for the survivor calculation.
d. Returning survivor + 1 at the end is unnecessary and can lead to an index 
   that is out of bounds for the given problem setup.

Solution: a
```

## Question 2

```
Consider this modified version of the Python function intended to solve the Josephus problem, 
where players are eliminated cyclically:
    def findTheWinner(n, k):
        survivor = 0
        for i in range(2, n):  
            survivor = (survivor + k) % i
        return survivor + 1
An error has been introduced in this version of the function. What is the error?

a. The initialization of survivor should be 1 to accurately 
   reflect the first participant's position.
b. The loop range for i in range(2, n) incorrectly omits the final participant, 
   as it should iterate up to n + 1 to include all players.
c. Using (survivor + k) % i without adjusting k 
   for zero-based indexing can lead to incorrect eliminations.
d. Returning survivor + 1 at the end of the function is correct but unnecessary, 
   as the survivor should already be indexed properly.

Solution: b
```

## Question 3

```
Consider this altered version of the Python function intended to solve the Josephus problem, 
determining the winner in a sequence where players are eliminated based on a cyclic pattern:
    def findTheWinner(n, k):
        survivor = 0
        for i in range(2, n+1):
            survivor = (survivor + k + 1) % i  
        return survivor + 1

a. The initialization of survivor to 0 is correct, but adding 1 in the modulo calculation
   misrepresents the k-th elimination step.
b. The formula should include a decrement by 1 in the modulo operation to correctly 
   align the survivors with zero-based indexing.
c. Adding 1 in the expression (survivor + k + 1) % i incorrectly shifts each elimination cycle 
   forward by one, leading to an incorrect elimination sequence.
d. Returning survivor + 1 at the end adjusts for one-based indexing, 
   which is incorrect since the survivor calculation already accounts for zero-based indexing.

Solution: c
```
