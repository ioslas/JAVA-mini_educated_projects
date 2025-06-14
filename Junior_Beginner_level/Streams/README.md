# JAVA Streams
![Java](https://img.shields.io/badge/Language-Java-blue)
![Version](https://img.shields.io/badge/Version-2.1-b71c1c?style=flat)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen)

# Module
This module implements a set of *simple, focused programming tasks* using a very special feature of **Java 8** language: **Streams API**

Streams allow for:
- More readable and functional-style code
- Clear data transformations

Each task is to show how the **streams** can make your **code cleaner, shorter, and reducing its complexity**

## Features
- Multiple `List` collections are used to compare original vs transformed data.
- The *main original lists* are:<br>
![Ανώνυμο διάγραμμα](https://github.com/user-attachments/assets/93d00d10-6a96-4106-a54c-e6d3058abb23)<br>
  3. **lines** -> for a specific treatment 
- Tasks demonstrate core stream operations such as:
  - `map()`, `filter()`, `sorted()` etc.

## Technologies used
```
import java.util.*; -> Creating LISTS & Sets (basically data structures)
import java.util.stream.*; -> IMPORTANT for calling .stream() method and everything that follows (e.g. .stream().filter()...)
```

## How to run
1. Clone the repository or download the files.
2. Compile and run Java Files (if you run it on cmd):
```bash
cd (Project_File_location)/src
javac StreamTasks.java
java StreamTasks
```
**\# Alternatively**, if classes are pre-compiled
```bash
cd (Project_File_location)/bin
java StreamTasks
```

## Demo/Example Usage
- Tasks with Integer List
```
Original Array
17 46 45 14 1 42 31 44 

Average Array
30.0 

Sorted Array
1 14 17 31 42 44 45 46 

Sum of list: 240

Count of even numbers in List are: 4

The first even number in List are: 46
The found even number in List are: 46

```
- Tasks with String List
```
Original Array
apple
Banana
chair
river
sea
school
Mountain
Any
bacon

Stream Array
APPLE
BANANA
CHAIR
RIVER
SEA
SCHOOL
MOUNTAIN
ANY
BACON

Set Array
apple bacon Mountain school chair river Any sea Banana 

Filtered Array
apple

```
- Extras (with both of the above and a special one (list) for a specific task)
```
Stringed Number
o17,e46,o45,e14,o1,e42,o31,e44 

Initial List
one,two three,four 
Flat Map List
one two three four 

Groupped List Map
{A=[Any], a=[apple], b=[bacon], r=[river], B=[Banana], s=[sea, school], c=[chair], M=[Mountain]}
```
*Note: Everything above follows the program's execution flow.* 
