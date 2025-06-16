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
        * scalar=0 
        ```
        # Dominator can't be 0
        What operation do you want to do with scalar (+,-,*,/): /
        Give scalar: 0
        Unapropriate Number. No operation done!
        ```
        * scalar!=0 
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
      \* *Not valid (degree) value* message<br>

          - Multiples of *90* ((value % 90)==0 (e.g. the above))
          ```
          Give rotation degree (until 360): 156
          Invalid rotation degree.Try again!
  
          Give rotation degree (until 360):
          ```
      
          - Bigger than 360
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
  - 
