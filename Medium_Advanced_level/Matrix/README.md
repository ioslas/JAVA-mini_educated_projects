# JAVA Matrix
![Language](https://img.shields.io/badge/Language-Java-blue)
![Version](https://img.shields.io/badge/Version-1.0-orange)
![Status](https://img.shields.io/badge/Status-In_Progress-yellow)

## Module
This module supports and implements **basic principles and operations** of one of the most *fundamental* data structure (especially in **Linear Algebra**) called **Matrix**. 

This project is divided into **3 folders**, each containing self-contained (*one-shot*).<br> 
This split is based on the **type of Matrix**:
1. **General (non-square) Matrices**
2. **Square Matrices**
3. **Main/src folder**

***Note:*** Some operations are only valid for square matrices (e.g. determinant, inverse), and cannot be performed on general matrices — hence the separation.

## Features
- The number of **rows, columns** and the **data** are generated *randomly*
- The **src** folder contains:<br>
  i) `Matrix.java` **core class** of this project (There we do all the operations and tasks of matrix) <br>
  ii) *One-shot* **Static Matrices** files — simple, self-contained programs that execute matrix operations without calling the core class.

  Purpose: Comparing the **algorithms' complexity** between using the reusable *core class* and the *static (classes)* implementations. 
- The Matrix class has **2 constructors**:
  1. One with defined *rows and columns*
  2. One with predefined *data*
- In some comments there are **simple, custom matrices* — to help visually verify that each method behaves correctly and follows matrix rules — making the output easier to understand   

## Technologies Used
\- `import java.util.*;` 
  - `Random`: generate random number of rows, columns, data
  - `Scanner`: input from keyboard
  - A `LinkedList` data structure: important for finding Triangular Matrix 

\- **Tables** (which often resembles the matrix): *1d, 2d*

## How to run
1. Clone the repository or download the files.
2. Compile and run Java Files (if you run it on cmd):<br>
**\#** Classes are **pre-compiled**
```bash
cd (Project_File_location)/bin
dir

# Run each .class file separately, except for Matrix.class:
java MatrixBasics
java SquareMatrixOperations
java StaticMatrices
...
# Do not run Matrix.class — it is a helper class without a main() method.
```

## Demo/Example Usage
- MatrixBasics
```
Original Matrix (5x6):
50 17 92 67 45 50 
68 16 96 74 77 29 
69 70 76 61 66 89 
62 62 48 20 61 89 
32 96 29 29 13 50 

Tranposed Matrix (6x5):
50 68 69 62 32 
17 16 70 62 96 
92 96 76 48 29 
67 74 61 20 29 
45 77 66 61 13 
50 29 89 89 50 

Main diagonal sum of Matrix = 175
Secondary diagonal sum of Matrix = 332

Matrix's elements in spiral order:
50 17 92 67 45 50 
29 89 89 50 
13 29 29 96 32 
62 69 68 
16 96 74 77 
66 61 
20 48 62 
70 
76 61 


Sum of Matrix's elements each row: 
321 360 431 342 249 

Sum of Matrix's elements each column: 
281 261 341 251 262 307 

Minimum element of Matrix = 13
Maximum element of Matrix = 96
```
- MatrixCalculations
```
Matrix 1 (5x4):
8 40 75 44 
56 14 2 51 
72 18 96 10 
19 23 25 42 
71 36 7 85 

Matrix 2 (5x4):
64 84 86 51 
21 22 46 34 
98 15 85 47 
94 34 32 54 
48 30 53 54 
```
- 
