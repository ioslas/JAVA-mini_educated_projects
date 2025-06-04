# JAVA Binary Search Tree (BST)
![Java](https://img.shields.io/badge/Language-Java-blue)
![Version](https://img.shields.io/badge/Version-1.0-orange)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen)

## Module
This modules demonstrates basic implemantations and functions of a **Binary Search Tree (BST)**. A BST a specialized form of a **binary tree** which itself is a (common-used) subcategory of the broader **Tree** data structure family.
The module includes basic operations such as:
- **Insertion** of nodes
- **Search**
- **Deletion**
- **Order Traversals(Printing)** of tree

## Features
- Recursion used to build and link nodes according to Tree rules
- The types of order-traversal are:
  1. **In-order** (most common)
  2. **Pre-order**
  3. **Post-order**
- The tree is **dynamically constructed** as elements are inserted.
- ALL operations are implemented *recursively*, taking advantage of the tree's **hierarchical structure**.

## Technologies Used
- `import java.util.*;`
  - **Scanner**: keyboard input
  - **Random**: random (number) generator -> size of tree
- `Node.java`: Class with constructor only which defines the **basic structure** of a tree node (**key (vertice), 2 links(left and right)**).

 ## How to run
1. Clone the repository or download the files.
2. Compile and run Java Files (if you run it on cmd):
```
javac *.java
java BSToperations
```

## Demo/Example Usage
- Tree Creation (Node Insertion) <br>
  \# In-order traversal<br>
  ![Στιγμιότυπο οθόνης 2025-06-03 215525](https://github.com/user-attachments/assets/b610cf29-2ae8-4895-a6be-93a49c0cc81e)

- Node(key) Search&Deletion <br>
  \* If key exists <br>
  ![Στιγμιότυπο οθόνης 2025-06-03 221116](https://github.com/user-attachments/assets/63765c41-455c-4bb9-9399-47d813864920)
   
  \* If key doesn't exist <br>
  ![Στιγμιότυπο οθόνης 2025-06-03 220524](https://github.com/user-attachments/assets/a6bf6d5b-c23d-436b-9b0c-25f2581b94af)
  
- User Interaction(Decision) <br>
  \- yes
    ```
    Do you want to continue(y/n)? y
  
    Delete from tree the number: ...
    ```
  \- no
    ```
    Do you want to continue(y/n)? n
    ```
  \- *Message*
    ```
    Do you want to continue(y/n)? (not y or n)

    Wrong answer.Try again(y/n)? ...
    ```

    *After that, the following(down-below) output is displayed*

    Note: The y/n are case-insensitive
  
- Tree's Order-Traversal (The 'in-order' is already printed, so we are going to see the other traversal (*pre & post*) in the **final** tree)
![Στιγμιότυπο οθόνης 2025-06-03 221952](https://github.com/user-attachments/assets/d12283d0-23ee-4755-8abc-7fa17de850ed)
