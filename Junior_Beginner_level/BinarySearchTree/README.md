# JAVA Binary Search Tree (BST)
![Java](https://img.shields.io/badge/Language-Java-blue)
![Version](https://img.shields.io/badge/Version-1.0-orange)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen)

## Module
This modules demonstrates basic implemantations and functions of a **Binary Search Tree (BST)**: a specialized form of a **binary tree** -> one of the most common-used categories of the **Trees** data structure. The operations that it implements are basics:
- **Insert** node
- **Search** node
- **Delete** node
- **Order Traversal(Printing)** node

## Features 
- The types of order-traversal are:
  1. **In-order** (most common)
  2. **Pre-order**
  3. **Post-order**
- The **creation** of the tree happens along with the help of node's **insertion**
- ALL operations are *recursive* methods because the **recursion** works as tree's **traversal** through the links

## Technologies Used
- `import java.util.*;`
  - **Scanner**: keyboard input
  - **Random**: random (number) genarator -> size of tree
- `Node.java`: class with only constructor which defines the **basic structure** of a tree node (**key (vertice), 2 links(left and right)**). Usefull for node creation and link connection for recursive methods

