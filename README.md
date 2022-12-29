# DataStructures-Sorting

Mike Ogrysko<br>
Data Structures 605.202 - JHU MS Data Science program<br>
Lab 4 - SortComparison<br>

java version "1.8.0_121"<br>
Java(TM) SE Runtime Environment (build 1.8.0_121-b13)<br>
Java HotSpot(TM) 64-Bit Server VM (build 25.121-b13, mixed mode)<br>

Developed files in Atom 1.49.0<br>
Debugged in Eclipse Photon Release (4.8.0)<br>

To compile and run the program:
- Unzip package ensuring that all files appear in the same directory
- In terminal, type javac SortComparison to compile
- Ensure that all inputs are placed in the project
- To run, type java SortComparison "ran50.txt" "ran50out.txt" "1"

The 3rd argument represents the type of sort to be run. Here are the options:
1. QuickSort
2. QuickSort with 100 as stopping case
3. QuickSort with 50 as stopping case
4. QuickSort with median-of-3 as pivot
5. Natural MergeSort
6. Traditional MergeSort
7. Natural MergeSort w/Array

Specified output files will be placed in the project directory<br>
Output will display on screen and will print to the specified file<br>
As specified in the lab, comparisons, swaps, totals, and sorts for lists of size 50 will be displayed and printed in the files. Only totals will be displayed and printed for all other sized lists.<br>

If using a different input file other than those provided, please include the full number of records in the file name - e.g., ran8000.dat instead of "8K". The program will pull the number from the file name to process the list. 
