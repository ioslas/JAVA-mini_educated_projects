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
- The number of **rows, columns** and the **data** are given *randomly*
- The **src** folder contains:<br>
  i) `Matrix.java` class which is the core of this project (There we do all the operations and tasks of matrix) <br>
  ii) *One-shot* **Static Matrices** codes which execute the methods of the above class without calling it.

  Purpose: Compare the **complexity of the algorithms** when we use the *core class* and the *static classes*
- There are **2 constructors** of the matrix:
  1. When we know its *rows and columns*
  2. When we know its *data*
- In some comments there are simple, custom matrices (if we want to check if the codes follows matrices' algorithm right) in order to make the results more easy understanding   

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

