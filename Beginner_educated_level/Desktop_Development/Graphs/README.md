# JAVA Graphs Shortest Path
## Module
This module supports the **basic principle and philosophy** of one of the most important data types called as **Graphs** and is implemented into **2 procedures**:
1. **Graph Creation and Printing** which is distinguished into 4 parts or types:
![Ανώνυμο διάγραμμα drawio](https://github.com/user-attachments/assets/6dfdb800-5da4-4f84-8935-ee5d259fcca8)
2. Finding the **Shortest Path and Distance** (for the weighted graphs) of 2 graph's vertices known as **start & target**

## Features
- The number of **vertices and edges** are given randomly
- We use an **abstract superclass** and **it's subclasses** which represent the above diagram
- Following the method of the known **graph algorithms (solutions)** of the **shortest path problem** between 2 vertices which depends on the **type of graph**:
  
  | Graph Types        | Algorithms                       |
  |------------------  |----------------------------------|
  |Weigthed Graphs     | **DIJKSTRA, Bellman-Ford, ...**  |
  |Unweighted Graphs   | **DFS, BFS, ...**                |
  | ...                | **...**                          |
  | All                | **Floyd-Warshall, ...**          |

### Notes
1. Algotihms of **Prim & Kruskal** are not included because our goal is the **shortest path problem**, and these 2 are for **Minimum Spanning Tree (MST)**
2. Some parts of code are breaking the principle of **DRY (Don't Repeat Yourself)**:
   - Same method in 2 different classes (e.g. Dijkstra on both Weighted Directed and Undirected Graph)
   - Some methods executed more than once (Johnson uses Dijkstra and Bellman)<br>
   Unfortunately, we can't afford this, else we will have syntax or logical errors
