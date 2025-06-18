# Changelog
## [1.0.1] - 13-06-2025 12:55
### Changes to `printSpiral()` method:
1. Added *if* before the *right->left* traversal loop 
```java
if(top<=bottom) 
  for(i=right;i>=left;i--) 
     ...
```
2. Same adjustment for the traversal from *down -> up*, but also moving the entire block **inside the main loop** (in the *previous version* this block was outside of the loop - still worked properly)
```java
while(...) { // Bounds for avoiding over-traversing           
   if(left <= right)
     for(i=bottom;i>=top;i--) 
       ...
```
**Conclusion**: While the **previous version** gave *accurate results*, **testing** showed that it only worked for specific shapes, like small or square matrices. So, it wasn't reliable enough for general matrices. Although the **outcome** itself didn’t change significantly, these *updates* improve the method’s **stability and reliability** for general cases.
  
## [1.0.2] - 13-06-2025 13:27
### Changes to `MatrixCalculations` class/problem:
- Chnaged the `do ... while` loop to `while` loop when **prompting** the user for an operation (`+, -, *, /`), in order to avoid an unnecessary **first iteration** when the user wants to *exit immediately*:
  - With **do ... while**
  ```
  # !: symbol of ending the loop
  Give operation (+,-,*,/): !
  Null Operation. Try again (+,-,*,/)!

  Give operation (+,-,*,/): !
  #The End 
  ```
  - With **while**
  ```
  Give operation (+,-,*,/):!
  #The End
  ```
  **Note**: Same thing with below too (which follows after finishing the above)
  ```
  What operation do you want to do with scalar (+,-,*,/): ...
  ...
  ```
**Conclusion**: Even though this slightly changes the **printed output**, the *core process* remains the same. Therefore, it's considered a **patch-level** change rather than a *(minor)* functional change

## [1.1.0] - 13-06-2025 13:52
### Changes to `MatrixRotation` class/problem:
- Added `do ... while` **loop** with a user interaction `Do you want to continue? yes(y) or no(n)` in the main class. This allows the user to explore **all possible outcomes** of the program based on different input choices (if they are acceptable), rather than seeing only a single result:
  - **With the loop**
  ``` 
  Give rotation degree (until 360): ...
  
  Matrix (...) rotated in ... degrees is: 
  ...
  
  Do you want to continue rotating(y/n)? y
  
  Give rotation degree (until 360): ...
  ...
  ```
  - **Without the loop**
  ```
  Give rotation degree (until 360): ...

  Matrix (...) rotated in ... degrees is: 
  ...

  #The end
  ```   
**Summary**: Although this change may appear *similar* to the previous one, the **printed output** differs *significantly* from the original behavior. However, the core logic remains unchanged, so it is considered a **minor** change.  

## [2.0.0] - 14-06-2025 12:33
### Extra classes in src folder
- Added 2 **StaticMatrices** classes in the same folder as the core **Matrix.java**. These classes demonstrate an *alternative* way of working with matrices using **static methods**, without interacting with the core class.

  The classes are:
  1. **StaticMatrices**: Implements approximately **75%** of the functions found in the *previous code versions* (e.g. matrix rotation, symmetric/identity matrix, etc.).
  2. **StaticMatricesInverse**: Contains the full procedure for computing the inverse of the matrix (if it's possible)

**Summary**: Even though these classes are *one-shots* procedural implementations, they introduce a completely different **structural approach** to the project. As a result, this is considered a **major** change.

## [2.1.1] - 15-06-2025 16:11
### Change in both `calculate()` methods of `Matrix` class
- Replaces `if-else` with `switch` statement. This improves **readability**, simplifies **execution flow**, and makes the logic easier to **write, understand, and maintain**.
  - with **if**
  ```java
  if(op.equals(+))
    ...
  else if(op.equals(-))
    ...
  ...
  else
    ...
  ```
  - with **switch**
  ```java
  switch(op) {
    case("+"):
        ...
        break;
    case("-):
        ...
        break;
    ...
    default:
      ... 
  }
  ```
**Final Notes**: The printed **result** remains the same, only  **internal code structure** was modified. Therefore, this is considered a **patch-level** change.

## [2.1.2] - 15-06-2025 17:11
### Change in `calculate(String)` method of `Matrix` class
- Replaced the `default:` case in`switch` statement with an `if` condition and placed **before** the `switch` and **scalar input**. This change prevents the program from asking for a **scalar value** when the user intends to *stop* the matrix calculations (e.g. by entering `!`).
  - With **default**
  ```java
  System.out.print("Give scalar: ");
  int scalar=new Scanner(System.in).nextInt();

  switch(...) {
      ...
      default:
          ...
  }
  ```
  > **Outcome**
  ```
  What operation do you want to do with scalar (+,-,*,/): !
  Give scalar:

  End of operations.
  ```
  - With new updated **if**
  ```java
  if(...)
    ...
  
  System.out.print("Give scalar: ");
  int scalar=new Scanner(System.in).nextInt();

  switch(...) {
      ...
  }
  ```
  > **Outcome**
  ```
  What operation do you want to do with scalar (+,-,*,/): !

  End of operations.
  ```
**Final Notes**: This change improves **input handling** by preventing unnecessary **scalar input** when the user exits, but the *core logic* was not altered. Therefore, this is considered a **patch-level** update.

## [2.1.3] - 15-06-2025 18:43
### Change in `display()` method of `SquareMatrixOperations` class
- Replaced `System.out.println()` -> `System.out.printf()` to display **floating-point** results with at least *3 decimal digits*.
  - `System.out.println()`
  ```
  # Positive
  4.7858663
  
  # Negative
  -0.73599553
  ```
  - `System.out.printf("%.3f", ...)`
  ```
  # Positive
  4.785
  
  # Negative
  -0.735
  ```
**Final Remark**: This is a **visual improvement** — the *calculation logic* remains unchanged. So, it's **patch-level** change.
