# QUIZ: Kth Symbol

## Question 1

```
Consider the following Python function intended to find the k-th symbol in an imaginary grammar 
sequence where each symbol is recursively defined:
    def kth_symbol(n, k):
        if n == 1:
            return 0
        length = 2 ** (n - 1)
        mid = length // 2
        if k <= mid:
            return kth_symbol(n - 1, k)
        else:
            return int(not kth_symbol(n - 1, k))
An error has been introduced in this modified version of the function. What is the error?

a. There is no error; the function will execute correctly as intended 
   for the recursive grammar sequence.
b. The use of int(not kth_symbol(n - 1, k)) in the else block is incorrect; 
   it should compute the negation after adjusting for the k index.
c. The calculation of mid using integer division may lead to incorrect results 
   when length is an odd number.
d. The conditional if k <= mid fails to handle the case where k is exactly mid + 1, 
   which may be the most critical point in the sequence.

Solution: b
```

## Question 2

```
Here's another version of the Python function for determining the k-th symbol in the sequence:
    def kth_symbol(n, k):
        if n == 1:
            return 0
        length = 2 ** (n - 1)
        mid = length // 2
        if k <= mid:
            return kth_symbol(n, k)  
        else:
            return int(not kth_symbol(n - 1, k - mid))
An error has been introduced in this version of the function. What is the error?

a. The recursive call kth_symbol(n, k) incorrectly repeats with the same n value, 
   leading to infinite recursion.
b. The else block uses int(not kth_symbol(n - 1, k - mid)) when it should use bitwise negation.
c. The initialization of mid using length // 2 might not correctly handle cases 
   where length is an odd number.
d. There should be additional handling for the case where n == 1 and k != 1 to properly return 0.

Solution: a
```

## Question 3

```
Consider this revised version of the Python function intended to find the k-th symbol 
in an imaginary grammar sequence:
    def kth_symbol(n, k):
        if n == 1:
            if k == 1:
                return 0
            else:
                return 1  
        length = 2 ** (n - 1)
        mid = length // 2
        if k <= mid:
            return kth_symbol(n - 1, k)
        else:
            return int(not kth_symbol(n - 1, k - mid))
An error has been introduced in this version of the function. What is the error?

a. The condition if k == 1 should return 0 for any valid k 
   when n == 1 since the sequence always starts with 0 at n = 1.
b. The addition of an else return of 1 when n == 1 and k != 1 
   contradicts the established pattern that the base sequence starts with a 0.
c. The function erroneously introduces an alternative outcome for the base case 
   which should always result in 0, not 1.
d. The recursive logic in return int(not kth_symbol(n - 1, k - mid)) should not include int(), 
   which could complicate the logical negation.

Solution: c
```
