# PrintTree

## Problem Prompt
PROMPT:
  Given a string as input, your task is to write a program which parses the string and prints it out as a horizontal tree. If the string input is invalid, your program should print, "Invalid!" and exit.

- Individual elements are delimited with a comma followed by space (e.g., ", ")
- Individual groupings are designated with an open bracket [ and a close bracket ]
- Your program should accomplish this task in the most efficient way possible.
- Empty elements are valid.

``` 
  $ javac PrintTree.java
  $ java PrintTree "[1, 2, [A, B, C, [5^&, )()6, , 7], D, E] 3, 4]"
  1
  2
    A
    B
    C
      5^&
      )()6

      7
    D
    E
  3
  4

  $ java PrintTree "[1, 2, [A, B, C, [5, 6]]"
  Invalid!
```
