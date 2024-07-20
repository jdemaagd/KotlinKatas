# QUIZ 4: Monotonic Array

## Question 1

```
Consider the following Python function intended to determine if a given array is monotonic 
(either entirely non-increasing or non-decreasing):
    def monotonic_array(array):
        first = array[0]
        last = array[len(array)-1]
        if first > last:
            for i in range(len(array)-1):
                if array[i] < array[i+1]:
                    return False
        elif first == last:
            for i in range(len(array)-1):
                if array[i] != array[i+1]:
                    return False
        else:
            for i in range(len(array)-1):
                if array[i] < array[i+1]:
                    return False
        return True
An error has been introduced in this modified version of the function. What is the error?

a. The code incorrectly checks for array[i] < array[i+1] in both the first increasing 
   and the else (increasing) conditions, which should check for decreasing in the else condition.
b. Checking first == last to determine if elements are not equal is 
   not a valid way to define a monolithic sequence.
c. The loop for i in range(len(array)-1) will fail to execute properly 
   if the input array contains only one element, leading to incorrect results.
d. There is no error in the logic; the function will execute correctly 
   for determining if the array is monotonic.

Solution: a
```

## Question 2

```
Consider the following modified version of the Python function intended to determine if a given 
array is monotonic (either entirely non-increasing or non-decreasing):
    def monotonic_array(array):
        first = array[0]
        last = array[len(array)-1]
        if first > last:
            for i in range(len(array)-1):
                if array[i] < array[i+1]:
                    return False
        elif first == last:
            for i in range(len(array)-1):
                if array[i] != array[i+1]:
                    return False
        else:
            for i in range(len(array)-1):
                if array[i] < array[i+1]:  
                    return False
        return True
An error has been introduced in this version of the function. What is the error?

a. Using first == last as a condition to check for non-equality among all elements 
   does not accurately identify monotonic sequences where all elements are equal.
b. The condition if array[i] < array[i+1] in the else block is incorrect 
   for a non-decreasing sequence; it should check for elements that decrease.
c. The if and else conditions improperly handle the check for non-increasing sequences 
   because they use the same comparison logic.
d. There is an off-by-one error in the loop which can cause 
   the last element of the array to not be checked properly.

Solution: b
```

## Question 3

```
Consider the following version of the Python function designed 
to determine if a given array is monotonic:
    def monotonic_array(array):
        first = array[0]
        last = array[len(array)-1]
        if first > last:
            for i in range(len(array)-1):
                if array[i] <= array[i+1]:  # Error introduced here
                    return False
        elif first == last:
            for i in range(len(array)-1):
                if array[i] != array[i+1]:
                    return False
        else:
            for i in range(len(array)-1):
                if array[i] >= array[i+1]:  # Error introduced here
                    return False
        return True
An error has been introduced in this version of the function. What is the error?

a. The loop structure should not be based on the comparison of the first and last elements,
   as it does not reliably indicate the overall trend of the array.
b. The elif block suggesting all elements are equal when first == last is misleading, 
   as it could imply a monotonic sequence even if intermediate elements vary.
c. There is a logical error in using <= and >= as these operators are incorrect 
   for determining strict increases or decreases in the sequence.
d. The conditional checks if array[i] <= array[i+1] and if array[i] >= array[i+1] incorrectly 
   return False for equal adjacent elements, which is acceptable in a monotonic sequence.

Solution: d
```
