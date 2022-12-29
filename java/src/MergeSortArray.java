/** MergeSortArray class
  * Methods for iterative array based Natural merge sort
  *
  * Taken from:
  * //https://github.com/SvenWoltmann/sorting-algorithms-ultimate-guide/blob/main/src/main/java/eu/happycoders/sort/method/mergesort/NaturalMergeSort.java
  *
  * @author Mike Ogrysko (modified)
  *
  */

import java.io.FileWriter;

public class MergeSortArray {
   // Initialize counts
   int swapCount = 0;
   int compCount = 0;

   /** natMergeSortCall()
    * Recursive method runs the sort
    *
    * Pre-Conditions: arr is an array, outFile is FileWriter type
    *
    * Post-Conditions: NA
    *
    * @param arr int[]
    * @param outFile FileWriter
    *
    * @author Sven Woltmann
    */
   void natMergeSortCall(int[] arr, FileWriter outFile) { // start natMergeSortCall()
      if (arr.length <= 1) {
         return;
      }
      natMergeSort(arr, outFile);
      displayCountsAndSortedList(arr, outFile);
   } // end natMergeSortCall()


   /** natMergeSort()
    * Recursive method runs the sort
    *
    * Pre-Conditions: elements is an array, outFile is FileWriter type
    *
    * Post-Conditions: NA
    *
    * @param elements int[]
    * @param outFile FileWriter
    *
    * @author Sven Woltmann
    */
   void natMergeSort(int[] elements, FileWriter outFile) { // start natMergeSort()
      int numElements = elements.length;
      int[] tmp = new int[numElements];
      int[] starts = new int[numElements + 1];
     // Step 1: identify runs
      int runCount = 0;
      starts[0] = 0;
      for (int i = 1; i <= numElements; i++) {
         if (i <= numElements-1) {
            if (elements.length <= 50) {
               System.out.println("MergeSort: Comparing " + elements[i-1] + " to " + elements[i]);
               try {
                  outFile.write("MergeSort: Comparing " + elements[i-1] + " to " + elements[i] + "\n");
               }
               catch (Exception e) {
                  System.out.println("\nError writing to file - partition.");
               }
            }
            compCount++;
         }
         if (i == numElements || elements[i] < elements[i - 1]) {
            starts[++runCount] = i;
         }
      }
      // Step 2: merge runs, until only 1 run is left
      int[] from = elements;
      int[] to = tmp;
      while (runCount > 1) {
         int newRunCount = 0;
         // Merge two runs each
         for (int i = 0; i < runCount - 1; i += 2) {
            merge(from, to, starts[i], starts[i + 1], starts[i + 2], outFile);
            starts[newRunCount++] = starts[i];
         }
         // Odd number of runs? Copy the last one
         if (runCount % 2 == 1) {
            int lastStart = starts[runCount - 1];
            System.arraycopy(from, lastStart, to, lastStart,
            numElements - lastStart);
            starts[newRunCount++] = lastStart;
         }
         // Prepare for next round...
         starts[newRunCount] = numElements;
         runCount = newRunCount;
         // Swap "from" and "to" arrays
         int[] help = from;
         from = to;
         to = help;
      }
      // If final run is not in "elements", copy it there
      if (from != elements) {
         System.arraycopy(from, 0, elements, 0, numElements);
      }
   } // end natMergeSort()


   /** merge()
    * Recursive method runs the sort
    *
    * Pre-Conditions: elements is an array, outFile is FileWriter type
    *
    * Post-Conditions: NA
    *
    * @param elements int[]
    * @param outFile FileWriter
    *
    * @author Sven Woltmann
    */
   void merge(int[] source, int[] target, int startLeft,
      int startRight, int endRight, FileWriter outFile) { // start merge()
      int leftPos = startLeft;
      int rightPos = startRight;
      int targetPos = startLeft;
      // As long as both arrays contain elements...
      while (leftPos < startRight && rightPos < endRight) {
         // Which one is smaller?
         int leftValue = source[leftPos];
         int rightValue = source[rightPos];
         if (source.length <= 50) {
            System.out.println("MergeSort: Comparing " + leftValue + " to " + rightValue);
            try {
               outFile.write("MergeSort: Comparing " + leftValue + " to " + rightValue + "\n");
            }
            catch (Exception e) {
               System.out.println("\nError writing to file - partition.");
            }
         }
         compCount++;
         if (leftValue <= rightValue) {
            target[targetPos++] = leftValue;
            leftPos++;
         }
         else {
            if (source.length <= 50) {
               System.out.println("MergeSort: Swapping " +  leftValue + " and " + rightValue);
               try {
                  outFile.write("MergeSort: Swapping " +  leftValue + " and " + rightValue + "\n");
               }
               catch (Exception e) {
                  System.out.println("\nError writing to file - natural merge.");
               }
            }
            swapCount++;
            target[targetPos++] = rightValue;
            rightPos++;
         }
      }
      // Copy the rest
      while (leftPos < startRight) {
         target[targetPos++] = source[leftPos++];
      }
      while (rightPos < endRight) {
         target[targetPos++] = source[rightPos++];
      }
   } // end merge()

   /** displayCountsAndSortedList()
    * Displays and prints comparison and swap counts and the sorted list
    *
    * Pre-Conditions: arr is an array, outFile is FileWriter type
    *
    * Post-Conditions: message is printed on screen and in file
    *
    * @param arr int[]
    * @param outFile FileWriter
    *
    * @author Mike Ogrysko
    */
   void displayCountsAndSortedList(int[] arr, FileWriter outFile) { // start displayCountsAndSortedList()
      System.out.println("\nNumber of swaps: " + swapCount);
      try {
         outFile.write("\nNumber of swaps: " + swapCount + "\n");
      }
      catch (Exception e) {
         System.out.println("\nError writing to file - display.");
      }
      System.out.println("Number of comparisons: " + compCount + "\n");
      try {
         outFile.write("\nNumber of comparisons: " + compCount + "\n");
      }
      catch (Exception e) {
         System.out.println("\nError writing to file - display.");
      }
      if (arr.length <= 50) {
         System.out.println("Sorted result: ");
         try {
            outFile.write("\nSorted result: \n");
         }
         catch (Exception e) {
            System.out.println("\nError writing to file - display.");
         }
         for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
            try {
               outFile.write(arr[i] + "\n");
            }
            catch (Exception e) {
               System.out.println("\nError writing to file.");
            }
         }
      }
   } // end displayCountsAndSortedList()
}
