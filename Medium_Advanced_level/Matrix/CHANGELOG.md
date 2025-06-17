# Changelog
## [1.0.1] - 13-06-2025 12:55
### Changes to `printSpiral()` method:
1. Add an if before the right->left traversal loop 
```java
if(top<=bottom) 
  for(i=right;i>=left;i--) 
     ...
```
2. Same adjustment for the traversal from down -> up, but also moving the entire block inside of the main loop (in the *previous version* this block was outside of the loop - still worked properly)
```java
while(...) { // Bounds for avoiding over-traversing           
   if(left <= right)
     for(i=bottom;i>=top;i--) 
       ...
```
**Conclusion**: While the **previous version** gave *accurate results*, **testing** showed that it only worked for specific shapes, like small or square matrices. So, it wasn't reliable enough for general matrices. Although the **outcome** itself didn’t change significantly, these *updates* improve the method’s **stability and reliability** for general cases.
  






13/6 13:27 change do ... while -> while{} in operation
13/6 13:52 Add while in rotation
14/6 12:33 Add static metrices
15/6 16:11 change operations if -> switch
16/6 17:11 move default check -> first if check
