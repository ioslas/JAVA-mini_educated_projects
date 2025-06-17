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
  - With do ... while
  ```
  # !: symbol of ending the loop
  Give operation (+,-,*,/): !
  Null Operation. Try again (+,-,*,/)!

  Give operation (+,-,*,/): !
  #The End 
  ```
  - With while
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

## [1.1.] - 13-06-2025 13:52
### Changes to `MatrixRotation` class/problem:
- Added `do ... while` **loop** with a user interaction `Do you want to continue? yes(y) or no(n)` in the main class. This allows the user to explore **all possible outcomes** of the program based on different input choices (if they are acceptable), rather than seeing only a single result:
  - With the loop
  ``` 
  Give rotation degree (until 360): ...
  
  Matrix (...) rotated in ... degrees is: 
  ...
  
  Do you want to continue rotating(y/n)? y
  
  Give rotation degree (until 360): ...
  ...
  ```
  - Without the loop
  ```
  Give rotation degree (until 360): ...

  Matrix (...) rotated in ... degrees is: 
  ...

  #The end
  ```   
**Summary**: Although this change may appear *similar* to the previous one, the **printed output** differs *significantly* from the original behavior. However, the core logic remains unchanged, so it is considered a minor change.  

13/6 13:52 Add while in rotation
14/6 12:33 Add static metrices
15/6 16:11 change operations if -> switch
16/6 17:11 move default check -> first if check
