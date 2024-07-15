# QUIZ: Two Pointer Squared Array

## Question 1

```
Consider the following Python function intended to square each element in a sorted array 
and then return a new array with these squares in sorted order:
    def sorted_squared(array):
        i = 0
        j = len(array) - 1
        new_array = [0] * len(array)
        for k in reversed(range(len(array))):
            sq_i = array[i]**2
            sq_j = array[j]**2
            if sq_i > sq_j:
                new_array[k] = sq_i
                i += 1
            else:
                new_array[k] = sq_i
                j -= 1
        return new_array
An error has been introduced in this modified version of the function. What is the error?

a. The condition if sq_i > sq_j is incorrect and 
   should compare the original values of i and j instead.
b. The code assigns sq_i to new_array[k] in both if and 
   else blocks instead of sq_j in the else block.
c. The use of reversed(range(len(array))) is unnecessary and complicates the code.
d. The variable i should not be incremented inside the loop; 
   it should be fixed to start at the smallest element.

Solution: b
```

## Question 2

```
Consider the following modification to the Python function intended to square each element in a 
sorted array and return a new sorted array of these squares:
    def sorted_squared(array):
        i = 0
        j = len(array) - 1
        new_array = [0] * len(array)
        for k in reversed(range(len(array))):
            if array[i] < array[j]:
                new_array[k] = array[i] ** 2
                i += 1
            else:
                new_array[k] = array[j] ** 2
                j -= 1
        return new_array
An error has been introduced in this version of the function. What is the error?

a. Comparing array[i] with array[j] directly can lead to incorrect placements of squared values in 
   new_array since it does not consider the absolute values which matter when the input array 
   contains negative numbers.
b. Incrementing i and decrementing j should be conditioned upon the squared comparisons, 
   not the values of array[i] and array[j].
c. The return statement incorrectly assumes the array is sorted after squaring, 
   which might not always be the case.
d. The array new_array should use list comprehension for initialization to improve code readability.

Solution: a
```

## Question 3

```
Consider the following version of the Python function designed to square each element in a sorted 
array and return a new sorted array of these squares:
    def sorted_squared(array):
        i = 0
        j = len(array) - 1
        new_array = [0] * len(array)
        for k in reversed(range(len(array))):
            sq_i = array[i]**2
            sq_j = array[j]**2
            if sq_i > sq_j:
                new_array[k] = sq_i
                i += 2
            else:
                new_array[k] = sq_j
                j -= 1
        return new_array
A mistake has been made in this function. What is it?

a. The loop increments i by 2 instead of 1, 
   causing the function to potentially skip elements in the array.
b. The use of **2 for squaring might lead to overflow errors with very large input values.
c. The sorted order is not maintained properly 
   due to the inconsistent increment and decrement of i and j.
d. There is no error; the function will execute correctly as intended.

Solution: a
```
