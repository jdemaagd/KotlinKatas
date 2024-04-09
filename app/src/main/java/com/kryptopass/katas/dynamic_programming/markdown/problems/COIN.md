# Step 6: Last Step: Dynamic Programming Algorithm

## Greedy Strategy

```
Coin Change Problem
You work as a cashier spending your day giving back change to customers (only coins).
You need to use the fewest coins possible whenever you give change.
Given coins of different denominations, e.g. [1, 2, 5]
and a total amount of money, e.g. 11, 
Compute the fewest number of coins that you need to make up that amount.

Take largest denomination until we get really, really close to the target amount
coins = [1, 5, 7]
amount = 10
Greedy -> 7, 1, 1, 1 -> 10 (4 coins)
But -> 5, 5 -> 10 (2 coins)
Need to prove it will work (Proof) as it is deceptive

Maximization, Minimization, Optimization Problems -> Indicator to use Dynamic Programming
```

## Pseudo Code

```
def coinChange(a, coins):
    table = 1D Array of size a + 1
    table[0] = 0    # base case
    initialize rest of table with some INF value
    
    for i in 1 to a:
        # minValue = INF
        for c in 0 to coins.size:
            if i - c >= 0:
                table[i] = min(table[i], table[i - c])
                # create pointer to previous sub-problem if we want to trace back path
        # table[i] = minValue + 1
    return table[a]

T(a, k) -> O(a * k)
S(a, k) -> O(a)
```

## Recurrence Equation

```
Let f(a) = fewest coins to construct amount a
coins = [c1, c2, c3, ..., ck]
f(a - c1)
f(a - c2)
...
f(a - ck)

f(a) = min/k(f(a - ck)) + 1
```
