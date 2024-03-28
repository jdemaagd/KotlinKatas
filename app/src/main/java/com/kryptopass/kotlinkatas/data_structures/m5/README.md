# Working with Map

## Hashing

- Map operations are slower, as Map cannot address any entry directly
- Map converts keys into a specific type to make it possible for direct addressing
- The conversion happens by applying an algorithm called **hashing**
- We can define hashing as an algorithm that maps data of arbitrary size to data of a fixed size
- The result (fixed-size data) from a hashing algorithm is called a **hash code** or **hash value**
- With hashing technique, we can perform any operation in a faster way (that is, *O(1)* complexity)

## Hash Collision

- As hash values for different keys can be the same, we call this a **hash collision**
- Highly recommended to create your hash function in such a way that the hash value generated should have as few
  collisions as possible
- As we found that multiple keys can have same hash value, we need to support multiple entries to be stored in a single
  bucket
- To make this possible, entries with same hash value are chained among themselves using *LinkedList*

## Scenario: school of n students (250)

- Base case:
    - if hash function is able to generate n unique hash values, then there is no hash collision and no chaining
    - each student will get a unique bucket
    - search will be in O(1)
    - delete will also be in O(1)
- Average case:
    - if hash function generates a hash value that collides with other keys equally among student_id instances
    - then there are 10 buckets
    - each containing a chain of n/10 students (25 here)
    - search will be n/10 times (25 times) slower than best case
- Worst case:
    - if hash function generates same hash value for all student_id instances
    - then all students will be chained under a single bucket
    - so both search and delete operations will be of O(n)
