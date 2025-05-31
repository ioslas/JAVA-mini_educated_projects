# JAVA Graphs Shortest Path
![Java](https://img.shields.io/badge/Language-Java-blue)
![Version](https://img.shields.io/badge/Version-1.1.2-orange)
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

## Demo/Example Usage
- Graph Creation
```
Add edges with src=0: 2
Add edges with src=1: 4
          .
          .
          .
Add edges with src=numVert: 3
```
- Graph Visualization (This below is just an example)<br>
![Στιγμιότυπο οθόνης 2025-05-31 001920-imageonline co-merged](https://github.com/user-attachments/assets/608ada87-2c69-446a-b620-0af594345630)
- Find Shortest Path
```
FIND SHORTEST PATH with SRC and TARGET
Give start vertices: 1
Give target vertices: 2
```

  \* If path exists <br>
![Στιγμιότυπο οθόνης 2025-05-31 005406](https://github.com/user-attachments/assets/1b4b7cdf-3819-4d9a-8db7-14a8216b887d)<br>
![Στιγμιότυπο οθόνης 2025-05-31 005531-imageonline co-merged](https://github.com/user-attachments/assets/c77cb21a-091f-418f-8d99-fe6928a0874c) <br>
  \* If path doesn't exist <br>
![Στιγμιότυπο οθόνης 2025-05-31 010109](https://github.com/user-attachments/assets/2b767dee-8519-43f1-bf4f-ebae6fd10425)<br>
![Στιγμιότυπο οθόνης 2025-05-31 010812](https://github.com/user-attachments/assets/d277a0b8-d28f-477b-a13a-dcd52695325c)<br>

- User Interaction(Decision)<br>
\- yes
```
Do you want to continue(y/n)? y

Give start vertices: ...
Give target vertices: ...
            .
            .
            .
```
\- no
```
Do you want to continue(y/n)? y

End of operations!
```

### Notes
1. Algorithms of **Prim & Kruskal** are not included because our goal is the **shortest path problem**, and these 2 are for **Minimum Spanning Tree (MST)**
2. Some parts of code are violating the principle of **DRY (Don't Repeat Yourself)**:<br>
   \- Same method in 2 different classes (e.g. Dijkstra on both Weighted Directed and Undirected Graph)<br>
   \- Some methods executed more than once (**Nested algorithm calls**) such as Johnson uses Dijkstra and Bellman<br>
*Unfortunately, we can't afford this, otherwise we will have syntax or logical errors.*

## Changelog
- **1.1.0**: Added Johnson Algorithm implementation in two classes: `WeightDirectGraph, WeightUndirectGraph`.
- **1.1.1**: Added a variable `flag` to avoid printing_path when calling Bellman or Dijkstra from Johnson algorithm.
- **1.1.2**: Added method `setFlag` to give `flag` the suitable value (0,1) in the suitable situation in order to achieve the above behavior.  
