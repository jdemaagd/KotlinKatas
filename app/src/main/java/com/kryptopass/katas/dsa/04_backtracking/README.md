# BackTracking

## Overview

- Algorithmic technique to find solutions to problems that involve many possible paths
- Solutions are built step-by-step via recursion
- If a path does not lead to a solution as it violates some constraints, that path is abandoned
- Controlled recursion where we make changes in place via pass-by-reference

## Compared to Recursion

- Controlled recursion and state of the problem is changed/reverted in place
    - paths that do not lead to a solution are pruned/abandoned
- Input is passed by reference, and we are not making a copy of the input

## Blueprint/Framework

- Recursion with base condition
    - if problem is solved, return, save, or print solution
- Loop through possible choices(paths) -> when we have multiple choices
    - if valid choice
        - make a choice
        - make recursive call
        - abandon/prune/revert the choice (making change in place) -> backtracking step

## Use Cases

- NOT for optimization problems (dynamic programming)
- If a problem requires you to explore every possible path
- There are multiple solutions to a problem, and you want all of them

## NOTE

- Backtracking is a brute-force technique
- It's more optimized than normal brute-force because of backtracking
