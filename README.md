# PrintTree
  This repository is the source code for PrintTree, a solution which intakes a given string of potentially nested arrays and prints them in horizontal tree format.

## Problem Prompt
PROMPT:
  Given a string as input, your task is to write a program which parses the string and prints it out as a horizontal tree. If the string input is invalid, your program should print, "Invalid!" and exit.

- Individual elements are delimited with a comma followed by space (e.g., ", ")
- Individual groupings are designated with an open bracket [ and a close bracket ]
- Your program should accomplish this task in the most efficient way possible.
- Empty elements are valid.

``` 
  $ javac PrintTree.java
  $ java PrintTree "[1, 2, [A, B, C, [5^&, )()6, , 7], D, E], 3, 4]"
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

## Assumptions
- The input string will always be enclosed in brackets.
- Empty lists are assumed to contain one empty element.
- Empty branches and deeply-indented leaves are valid.

## Complexity && Efficiency
This algorithm runs in `O(n * l)` time complexity, where `n` represents the total number of elements in the input string and `l` represents the deepest level of any element in the tree. The for-loop in `printTree()` iterates through every character in the string and an inner for-loop loops and adds spaces for each level an element is in. In the worst case scenario, every element in the string is on the deepest level, putting the growth rate at `n * l`.

The space complexity is `O(n * l)`. We store each element we need to print in a buffer followed by spaces for each level the element is in. In the worst case scenario, every element is on the deepest level.

Remember that when calculating growth complexity you drop constants and non-dominant terms.

## Setup
This is implemented in Java. For the full problem prompt, see the Prompt section below. In order to run this code, you will need minimum Java 7 installed.

1. Clone this repository and `cd` into it.
```
$ git clone [URL]
$ cd [DIR]
```

2. Compile the Java program.
```
$ make 
```

3. Run the Java program with your input string as an argument.
```
$ java PrintTree "[1, 2, 3]"
```

4. To clean up build files, use the Makefile recipe.
```
$ make clean
```

### Test Cases
```
######## CASE 1 ########
INPUT:
[1, 2, [A, B, C, [5^&, )()6, , 7], D, E], 3, 4]

OUTPUT:
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

######## CASE 2 ########
INPUT:
[1, 2, 3, [A], 4]

OUTPUT:
1
2
3
  A
4

######## CASE 3 ########
INPUT:
[1, 2, 3

OUTPUT:
Invalid!

######## CASE 4 ########
INPUT:
[A, B, 2, C{123, D]

OUTPUT:
A
B
2
C{123
D

######## CASE 5 ########
INPUT:
[A, B, [1, 2, [Herp, derp]]

OUTPUT:
Invalid!

######## CASE 6 ########
INPUT:
[[, ], [A, B]]

OUTPUT:


  A
  B

######## CASE 7 ########
INPUT:
[[1, 3], [A, B]]

OUTPUT:
  1
  3
  A
  B

######## CASE 8 ########
INPUT:
[[[[A]]]]

OUTPUT:
      A

######## CASE 9 ########
INPUT:
[A, B, C, [[[1], 2], 3]]

OUTPUT:
A
B
C
      1
    2
  3

######## CASE 10 ########
INPUT:
[A, B, [1, 2, [Herp, derp]]]

OUTPUT:
A
B
  1
  2
    Herp
    Derp

######## CASE 11 ########
INPUT:
[[], [], A, B]

OUTPUT:
  

A
B

######## CASE 12 ######## 
INPUT:
[][[[]][]][]

OUTPUT:
Invalid!

######## CASE 13 ######## 
INPUT:
&[A, B, C]

OUTPUT:
Invalid!

######## CASE 14 ######## 
INPUT:
[A, B, C]&

OUTPUT:
Invalid!

```

