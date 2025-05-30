# JAVA Graphs Shortest Path
![Java](https://img.shields.io/badge/Language-Java-blue)
![Version](https://img.shields.io/badge/Version-1.2.0-orange)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen)

## Module
This module supports the **basic principle and philosophy** of one of the most important data structures called as **Graphs** and is organized into **2 main components**:
1. **Graph Creation and (sort-of) Visualization** categorized into *4 distinct graph types*:
![Ανώνυμο διάγραμμα drawio](https://github.com/user-attachments/assets/6dfdb800-5da4-4f84-8935-ee5d259fcca8)
2. Calculates the **Shortest Path and Distance** (for the weighted graphs) between 2 vertices referred to as **start & target**

## Features
- The number of **vertices** are given randomly
- We use an **abstract superclass** and **its subclasses** which represent the above diagram
- In main we use tables to differentiate the classes based on the graph types 
- Uses well-known **shortest path algorithms**, chosen dynamically depending on the **type of graph**:
  
  | Graph Types        | Algorithms                       |
  |------------------  |----------------------------------|
  |Weigthed Graphs     | **DIJKSTRA, Bellman-Ford, ...**  |
  |Unweighted Graphs   | **DFS, BFS, ...**                |
  | ...                | **...**                          |
  | All                | **Floyd-Warshall, ...**          |

## Technologies Used
`import java.util.*;`
- `Random`: generate random number of vertices
- `Scanner`: input from keyboard
- ALL the important **data structures**: `LinkedList, HashMap, HashSet(for duplicates), Queue(PriorityQueue)`, etc.

## How to run
1. Clone the repository or download the files.
2. Compile and run Java Files (if you run it on cmd):
```
javac *.java
java GraphShortestPath
```

### Notes
1. Algorithms of **Prim & Kruskal** are not included because our goal is the **shortest path problem**, and these 2 are for **Minimum Spanning Tree (MST)**
2. Some parts of code are violating the principle of **DRY (Don't Repeat Yourself)**:<br>
   \- Same method in 2 different classes (e.g. Dijkstra on both Weighted Directed and Undirected Graph)<br>
   \- Some methods executed more than once (**Nested algorithm calls**) such as Johnson uses Dijkstra and Bellman<br>
*Unfortunately, we can't afford this, otherwise we will have syntax or logical errors.*

## Changelog
- **1.2.0**: Adding Johnson Algorithm in 2 classes which can work Weighted_Direct_Graph, Weight_Undirected_Graph. This counts as 2
- **1.2.1**: Adding a variable flag to avoid printing_path when i call Bellman or Dijkstra from Johnson algorithm.
- **1.3.1**:   
