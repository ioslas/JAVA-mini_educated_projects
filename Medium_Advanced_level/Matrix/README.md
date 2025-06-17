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
3. **Main/src folder** — contains the project's **core logic** and additional programs **independent** from the core - hence they are in src folder

***Note:*** Some operations are only valid for square matrices (e.g. determinant, inverse), and cannot be performed on general matrices — hence the separation.

## Features
- The number of **rows, columns** and the **data** are generated *randomly*
- The **src** folder contains:<br>
  i) `Matrix.java` **core class** of this project (There we do all the operations and tasks of matrix) <br>
  ii) *One-shot* **Static Matrices** files — simple, self-contained programs that execute matrix operations without calling the core class.

  Purpose: Comparing the **algorithms' complexity** between using the reusable *core class* and the *static (classes)* implementations. 
- The Matrix class has **2 constructors**:
  1. One that initializes the *rows and columns*
  2. One that initializes the *data* of matrix using predefined data
  
- In some comments there are **simple, custom matrices** — to help *visually* verify that each method behaves correctly and follows matrix rules — making the output *easier to understand*   

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
- **General Matrix** folder
  - **MatrixBasics**
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
  - **MatrixCalculations**
    - Initial Matrices 
    ```
    Matrix 1 (4x5):
    0 57 72 96 3 
    92 78 77 23 79 
    13 92 21 22 85 
    4 81 91 23 20 
    
    Matrix 2 (4x5):
    1 51 94 12 63 
    15 19 95 50 23 
    9 51 74 35 28 
    19 16 0 41 88
    
    Give operation (+,-,*,/): ...
    ```
    - Calculation between Matrices <br>
      \- *Addition*
      ```
      Give operation (+,-,*,/): +
    
      New Matrix (4x5):
      112 172 98  94  125 
      152 107 86  63  105 
      82  120 142 81  182 
      61  179 36  118 177
      ```
      \- *Subtraction*
      ```
      Give operation (+,-,*,/): -
    
      New Matrix (4x5):
      -1 6 -22 84 -60 
      77 59 -18 -27 56 
      4 41 -53 -13 57 
      -15 65 91 -18 -68
      ```
      \-  *Multiplication*
      ```
      Give operation (+,-,*,/): *
  
      New Matrix (4x5):
       0   2907 6768 1152  189 
      1380 1482 7315 1150 1817 
      117  4692 1554 770  2380 
      76   1296   0  943  1760
      ```
      \- *Division* --> A/B = A*B^(-1)
        * 2nd matrix not invertible
        ```
        Give operation (+,-,*,/): /
        2nd Matrix not Squared/Invertible -> No Division!
        ```
        * 2nd matrix invertible  
        ```
        # I use these simple matrices due to the complications this operation can have
        Matrix 1 (3x3):
        2 0 1 
        1 3 2 
        0 1 1 
        
        Matrix 2 (3x3):
        2 0 1 
        1 2 1 
        3 4 2 
        
        Give operation (+,-,*,/): /
  
        # Approximately Result due to Math.round()
        New Matrix (3x3):
        0  0  1 
        0 -1  1 
        0  4 -2 
        ```
      \- *Error Message*
      ```
      Give operation (+,-,*,/): (Anything that doesn't equal: +, -, *, /) 
      Null Operation. Try again (+,-,*,/)!
      ```
      \- Ending Symbol
      ```
      Give operation (+,-,*,/): !
      End of this operation.
  
      What operation do you want to do with scalar (+,-,*,/): ...
      ```
    - Calculation between matrix and number<br>
      \- *Addition*
      ```
      What operation do you want to do with scalar (+,-,*,/): +
      Give scalar: 8
  
      New Matrix (4x5):
      8 65 80 104 11 
      100 86 85 31 87 
      21 100 29 30 93 
      12 89 99 31 28
      ```
       \- *Subtraction*
      ```
      What operation do you want to do with scalar (+,-,*,/): -
      Give scalar: 3
  
      New Matrix (4x5):
      -3 54 69 93 0 
      89 75 74 20 76 
      10 89 18 19 82 
      1 78 88 20 17 
      ```
      \- *Multiplication* (**Hadamard product**)
      ```
      What operation do you want to do with scalar (+,-,*,/): *
      Give scalar: 2
      
      New Matrix (5x4):
      0 114 144 192 6 
      184 156 154 46 158 
      26 184 42 44 170 
      8 162 182 46 40
      ```
      \- *Division* (scalar -> denominator)
        > scalar=0 
        ```
        # Dominator can't be 0
        What operation do you want to do with scalar (+,-,*,/): /
        Give scalar: 0
        Unapropriate Number. No operation done!
        ```
        > scalar!=0 
        ```
        What operation do you want to do with scalar (+,-,*,/): /
        Give scalar: 5
        
        # Approximately Result due to Math.round()
        New Matrix (4x5):
        0 11 14 19 0 
        18 15 15 4 15 
        2 18 4 4 17 
        0 16 18 4 4
        ```
      \- *Error Message*
      ```
      What operation do you want to do with scalar (+,-,*,/): (Anything that doesn't equal: +, -, *, /)
      Null Operation. Try again (+,-,*,/)!
      ```
      \- Ending Symbol
      ```
      What operation do you want to do with scalar (+,-,*,/): !
      
      End of operations.
      ```
  - **MatrixRotation**
    - Initial Matrices 
    ```
    Original Matrix (5x4):
    29 93  1 90 
     9 53 56 55 
    74 28 95 43 
    93 93 43 39 
    38  0 77 15 
  
    Give rotation degree (until 360): ...
    ```
    - Rotation (in degrees)<br>
      \* *0, 360*
        ```
        Give rotation degree (until 360): (0 or 360)
        Matrix doesn't change/remains the same
        ```
      \* *90*
        ```
        Give rotation degree (until 360): 90
  
        Matrix (4x5) rotated in 90 degrees is: 
        38 93 74  9 29 
         0 93 28 53 93 
        77 43 95 56  1 
        15 39 43 55 90
        
        ```
      \* *180*
        ```
        Give rotation degree (until 360): 180
  
        Matrix (5x4) rotated in 180 degrees is: 
        15 77  0 38 
        39 43 93 93 
        43 95 28 74 
        55 56 53  9 
        90  1 93 29  
  
        ```
      \* *270*
        ```
        Give rotation degree (until 360): 270
  
        Matrix (4x5) rotated in 270 degrees is: 
        90 55 43 39 15 
        1 56 95 43 77 
        93 53 28 93 0 
        29 9 74 93 38 
  
        ```
      \* *Not valid (degree) value* message
        > Multiples of *90* ((value % 90)==0 (e.g. the above))
        ```
        Give rotation degree (until 360): 156
        Invalid rotation degree.Try again!
  
        Give rotation degree (until 360):
        ```
        > Bigger than 360
        ```
        # 450= 360+90 --> Multiple of 90
        Give rotation degree (until 360): 450 
        Invalid rotation degree.Try again!
      
        Give rotation degree (until 360):
        ```
    - *User Interaction*(Decision)<br>
      \- yes
      ```
      Do you want to continue rotating(y/n)? y
      
      Give rotation degree (until 360): 
      ```
      \- no
      ```
      Do you want to continue rotating(y/n)? n
      
      End of rotation!
      ```
      \- *Message*
      ```
      Do you want to continue rotating(y/n)? (not y/Y or n/N)
      Invalid answer.Try again!
      
      Give rotation degree (until 360):
      ```
      Note: The y/n are **case-insensitive**
      
- **Square Matrix** folder
  - **SquareMatrixBasics**
  ```
  Matrix (4x4):
  94 16 23 94 
  0 14 17 8 
  65 18 59 9 
  50 39 86 49 
  
  The matrix is not symmetric
  
  This matrix is not identity matrix
  
  Upper Triangular of matrix: 
  0 16 23 94 
  0 0  17 8 
  0 0  0  9 
  0 0  0  0 
  
  Lower Triangular of matrix: 
  0  0  0  0 
  0  0  0  0 
  65 18 0  0 
  50 39 86 0 
  ```
  
  > For **Symmetric** matrix
  ```
  Matrix (3x3):
  1 2 3
  2 4 5
  3 5 6

  The matrix is not symmetric
  
  This matrix is not identity matrix
  .
  .
  .
  ```
  
  > For **Identity** matrix
  ```
  Matrix (3x3):
  1 0 0
  0 1 0
  0 0 1

  The matrix is symmetric
  
  This matrix is not identity matrix
  .
  .
  .
  ```
  
  - **SquareMatrixOperations** (Mostly like find the *inverse* of matrix, showing each step of solving that problem)
  ```
  Matrix (3x3):
  43 13 5 
  10 37 46 
  2 6 38 

  # Find Determinant which can be also negative
  det= 44776.0 

  # Find the Adjoint which needs Determinant
  Adjoint of matrix (3x3):
  1130 -464   413 
  -288 1624 -1928 
  -14  -232  1461 

  # Inverse matrix = Adjoint / Determinant
  Inverse matrix (3x3):
   0,025 -0,010  0,009 
  -0,006  0,036 -0,043 
  -0,000 -0,005  0,033 
  ```
  > Matrix with det=0 -> not invertible
  ```
  Matrix (3x3):
  2 4 6 
  1 3 5 
  0 2 4 
  
  det= 0.0
  
  Adjoint of matrix (3x3):
   2  -4  2 
  -4   8 -4 
   2  -4  2 


  Matrix is not invertible
  ```
- **Main/src** folder (*static* Matrix)
  - **Static Matrices**
  ```
  Original Matrix (5x5):
  54 64 87 60 6 
  88 76 2 79 90 
  82 37 7 10 69 
  41 11 54 42 75 
  96 25 15 54 91 
  
  Transposed Matrix (5x5):
  54 88 82 41 96 
  64 76 37 11 25 
  87 2 7 54 15 
  60 79 10 42 54 
  6 90 69 75 91 
  
  Main diagonal sum of Matrix = 270
  Secondary diagonal sum of Matrix = 199
  
  The matrix is not symmetric
  
  The matrix is not identity
  
  Upper Triangular of matrix:
  0 64 87 60 6 
  0 0 2 79 90 
  0 0 0 10 69 
  0 0 0 0 75 
  0 0 0 0 0 
  
  Lower Triangular of matrix:
  0 0 0 0 0 
  88 0 0 0 0 
  82 37 0 0 0 
  41 11 54 0 0 
  96 25 15 54 0 
  
  Sum of Matrix's elements each row: 
  271 335 205 223 281 
  
  Sum of Matrix's elements each column: 
  361 213 165 245 331 
  
  Minimum element of Matrix = 2
  Maximum element of Matrix = 96
  
  Matrix's elements in spiral order:
  54 64 87 60 6 
  90 69 75 91 
  54 15 25 96 
  41 82 88 
  76 2 79 
  10 42 
  54 11 
  37 
  7 
 
  Matrix (5x5) rotated in 90 degrees is: 
  96 41 82 88 54 
  25 11 37 76 64 
  15 54 7 2 87 
  54 42 10 79 60 
  91 75 69 90 6 
  
  Matrix (5x5) rotated in 180 degrees is: 
  91 54 15 25 96 
  75 42 54 11 41 
  69 10 7 37 82 
  90 79 2 76 88 
  6 60 87 64 54 
  
  Matrix (5x5) rotated in 270 degrees is: 
  6 90 69 75 91 
  60 79 10 42 54 
  87 2 7 54 15 
  64 76 37 11 25 
  54 88 82 41 96 
  ```
  *Note*: The degree values are generated **automatically (not provided by the user)**, and there is no *validation* to check if the value is appropriate *(e.g. being a multiple of 90)* or value=*0 or 360 -> matrix is the same*. This was done to keep the code **minimal** and **focused** on the core transformation logic.
  
  - **StaticMatricesInverse**
  ```
  Original Matrix (4x4):
  47 43 52 24 
  77 68 9 90 
  83 10 3 27 
  36 70 34 46 
  
  Inverse matrix (4x4):
  -0,006 -0,010 0,020 0,010 
  -0,035 -0,026 0,019 0,058 
  0,041 0,013 -0,020 -0,035 
  0,027 0,038 -0,029 -0,049 
  ```
  *Note*: The **adjoint** and **determinant** are used *internally* as **value-based steps** for calculating the inverse. Their results are not printed which is not considered as an **issue** because both implementations follow the *same logic** and produce *identical results* — meaning the **final outcome (inverse)** is not affected.<br>
  Same thing can be applied when `det=0`:
  ```
  # The det of this matrix = 0
  Original Matrix (3x3):
  2 4 6 
  1 3 5 
  0 2 4 
  
  Matrix is not invertible
  ```

## Notes
1. In **Multiplication** between matrices, I use the **Hadamard product/element-wise multiplication** (providing that the 2 matrices have the **same dimensions**) in order to:<br>
   a) Avoid an extra nested loop
      ```java
      // General Matrix Multiplication
      for(int i=0;i<rows;i++)
        for(int j=0;j<cols;j++)
           C[i][j]=0;
           for(int k=0;k<rows;k++) // or k<cols
             C[i][j] += A[i][k] * B[k][j];

      // Hadamard
      for(int i=0;i<rows;i++)
        for(int j=0;j<cols;j++)
           C[i][j] = A[i][J] * B[I][j];
        			
      ```
   b) Make the result easy to interpret visually (because with the raw matrix multiplication can be hard for users to follow) 
      ```
      Matrix A(2x2)      Matrix B(2x2)
      3 20               11  4
      5 1                 5 47 

      Matrix C = A*B (2x2)
      33 80 
      25 47 
      ``` 
2.   
 
