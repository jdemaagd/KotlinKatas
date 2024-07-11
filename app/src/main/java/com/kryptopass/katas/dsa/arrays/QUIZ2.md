# QUIZ: Sorted Squared Array

## Question 1

```
Consider the following modified version of the Python function intended to square each element in a 
sorted array and return a new sorted array of these squares:
    def sorted_squared(array):
        new_array = [0]*len(array)
        for i in range(len(array) - 1):
            new_array[i] = array[i] ** 2
        new_array.sort()
        return new_array
An error has been introduced in this version of the function. What is it?

a. The for-loop incorrectly runs to len(array) - 1, 
   causing the last element of the array to not be squared.
b. Squaring the elements using **2 might result in integer overflow 
   if the array contains large numbers.
c. The sort() method is unnecessary because the array elements are squared, 
   so they will naturally remain in non-decreasing order.
d. The array new_array is initialized with zeros, 
   which can cause errors if the aray has fewer elements than expected.

Solution: a
```

## Question 2

```
Consider the following version of the Python function designed to square each element in a sorted 
array and return a new sorted array of these squares:
    def sorted_squared(array):
        new_array = [0]*len(array)
        for i in range(len(array)):
            new_array[i] = array[i] * array[i]
        return new_array.sort()
A mistake has been made in this function. Can you identify it?

a. Multiplying elements using array[i] * array[i] is incorrect; 
   it should use the exponentiation operator **.
b. The function should not return new_array.sort(), 
   as sort() returns None and does not return the sorted array. 
c. Initializing new_array with zeros is unnecessary and should be avoided.
d. There is no error; the function will work correctly as written.

Solution: b
```

## Question 3

```
Consider the following version of the Python function designed to square each element in a sorted 
array and return a new sorted array of these squares:
    def sorted_squared(array):
        new_array = []
        for i in range(len(array)):
            new_array[i] = array[i] ** 2
        new_array.sort()
        return new_array
A mistake has been made in this version of the function. Can you identify it?

a. The use of the exponentiation operator **2 is incorrect; 
   it should use the multiplication for better performance.
b. The array new_array should be initialized with a specific size 
   before elements can be assigned to indices.
c. The sort() method is unnecessary since the input array is already sorted.
d. The function is correct; it will execute without errors and produce the intended result.

Solution: b
```
