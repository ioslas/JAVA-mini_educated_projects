# JAVA Streams
![Java](https://img.shields.io/badge/Language-Java-blue)
![Version](https://img.shields.io/badge/Version-2.1-darkred)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen)

# Module
This module impliments simple *basic tasks of programming* using a very special tool of **Java 8** language: **Streams**

## Features
- We use many **Lists** in order to show the differences or the modifications happen to the "ORIGINAL" list and also they are mvery helpful for the streams.
- The *main original lists* are:<br>
![Ανώνυμο διάγραμμα](https://github.com/user-attachments/assets/c2b0e2cc-40b0-4b69-90ec-f2778ce4d5ab)<br>
  3. **lines** -> for a specific treatment
- Each task is to show how the **streams** are benefecial about writing code and reducing code complexity

## Technologies used
```
import java.util.*; -> Creating LISTS & Sets (basically data structures)
import java.util.stream.*; -> IMPORTANT for calling .stream() method and everything it follws then (e.g. .stream().filter()...)
```

## How to run
1. Clone the repository or download the files.
2. Compile and run Java Files (if you run it on cmd):
```
javac StreamTasks.java
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
*Note: All of this is the following order of the program execution* 
