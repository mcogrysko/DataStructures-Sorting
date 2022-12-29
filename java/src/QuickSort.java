/** QuickSort class
  * QuickSort methods for first 4 sorts
  *
  * Taken from:
  * QuickSort: https: www.youtube.com/watch?v=Fiot5yuwPAg&t=2s
  * QuickSort: https: www.youtube.com/watch?v=39BV3_DONJc
  * Median-of-three: https://examples.javacodegeeks.com/quicksort-java-algorithm-code-example/
  * Insertion Sort: https://www.youtube.com/watch?v=lCDZ0IprFw4
  * Insertion Sort Recursive: https://www.geeksforgeeks.org/recursive-insertion-sort/
  *
  * @author Mike Ogrysko
  *
  */

import java.io.FileWriter;

public class QuickSort {
   // Initialize counts
   int swapCount = 0;
   int compCount = 0;

   /** quickSort()
    * Recursive method runs the sort
    *
    * Pre-Conditions: arr is an array, outFile is FileWriter type
    *
    * Post-Conditions: NA
    *
    * @param arr int[]
    * @param outFile FileWriter
    *
    * @author Mike Ogrysko (modified from https://www.youtube.com/watch?v=Fiot5yuwPAg&t=2s & https://www.youtube.com/watch?v=39BV3_DONJc)
    */
   void quickSort(int[] arr, FileWriter outFile) { // start quickSort()
      if (arr.length <= 1) {
         return;
      }
      quickSort(arr, 0, arr.length - 1, outFile);
      displayCountsAndSortedList(arr, outFile);
   } // end quickSort()


   /** quickSort()
    * Recursive method that establishes the stopping case, partition
    *
    * Pre-Conditions: arr is an array, low and high are integers outFile is FileWriter type
    *
    * Post-Conditions: NA
    *
    * @param arr int[]
    * @param low int
    * @param high int
    * @param outFile FileWriter
    *
    * @author Mike Ogrysko  (modified from https://www.youtube.com/watch?v=Fiot5yuwPAg&t=2s & https://www.youtube.com/watch?v=39BV3_DONJc)
    */
   void quickSort(int[] arr, int low, int high, FileWriter outFile) { // start quickSort()
      // Stopping case for 1 or 2
      if ((high - low) <= 0) {
         return;
      }
       int p = partition(arr, low, high, outFile);
      quickSort(arr, low, p-1, outFile);
      quickSort(arr, p+1, high, outFile);
   } // end quickSort()


   /** quickSortStop100()
    * Recursive method runs the sort
    *
    * Pre-Conditions: arr is an array, outFile is FileWriter type
    *
    * Post-Conditions: NA
    *
    * @param arr int[]
    * @param outFile FileWriter
    *
    * @author Mike Ogrysko  (modified from https://www.youtube.com/watch?v=Fiot5yuwPAg&t=2s & https://www.youtube.com/watch?v=39BV3_DONJc)
    */
   void quickSortStop100(int[] arr, FileWriter outFile) { // start quickSortStop100()
      if (arr.length <= 1) {
         return;
      }
      quickSortStop100(arr, 0, arr.length - 1, outFile);
      displayCountsAndSortedList(arr, outFile);
   } // end quickSortStop100()


   /** quickSortStop100()
    * Recursive method that establishes the stopping case, partition
    *
    * Pre-Conditions: arr is an array, low and high are integers outFile is FileWriter type
    *
    * Post-Conditions: NA
    *
    * @param arr int[]
    * @param low int
    * @param high int
    * @param outFile FileWriter
    *
    * @author Mike Ogrysko  (modified from https://www.youtube.com/watch?v=Fiot5yuwPAg&t=2s & https://www.youtube.com/watch?v=39BV3_DONJc)
    */
   void quickSortStop100(int[] arr, int low, int high, FileWriter outFile) { // start quickSortStop100()
      // Stopping case for 100, run insertSort
      if ((high - low) <= 100) {
         // Recursive insertion sort call
         //insertionSortRecursive(arr, arr.length, outFile);
         insertSort(arr, outFile);
      }
      else {
          int p = partition(arr, low, high, outFile);
         quickSortStop100(arr, low, p-1, outFile);
         quickSortStop100(arr, p+1, high, outFile);
      }
   } // end quickSortStop100()


   /** quickSortStop50()
    * Recursive method runs the sort
    *
    * Pre-Conditions: arr is an array, outFile is FileWriter type
    *
    * Post-Conditions: NA
    *
    * @param arr int[]
    * @param outFile FileWriter
    *
    * @author Mike Ogrysko  (modified from https://www.youtube.com/watch?v=Fiot5yuwPAg&t=2s & https://www.youtube.com/watch?v=39BV3_DONJc)
    */
   void quickSortStop50(int[] arr, FileWriter outFile) { // start quickSortStop50()
      if (arr.length <= 1) {
         return;
      }
      quickSortStop50(arr, 0, arr.length - 1, outFile);
      displayCountsAndSortedList(arr, outFile);
   } // end quickSortStop50()


   /** quickSortStop50()
    * Recursive method that establishes the stopping case, pivot, partition
    *
    * Pre-Conditions: arr is an array, low and high are integers outFile is FileWriter type
    *
    * Post-Conditions: NA
    *
    * @param arr int[]
    * @param low int
    * @param high int
    * @param outFile FileWriter
    *
    * @author Mike Ogrysko  (modified from https://www.youtube.com/watch?v=Fiot5yuwPAg&t=2s & https://www.youtube.com/watch?v=39BV3_DONJc)
    */
   void quickSortStop50(int[] arr, int low, int high, FileWriter outFile) { // start quickSortStop50()
      // Stopping case for 50, run insertSort
      if ((high - low) <= 50) {
         // Recursive insertion sort call
         //insertionSortRecursive(arr, arr.length, outFile);
         insertSort(arr, outFile);
      }
      else {
         int p = partition(arr, low, high, outFile);
         quickSortStop50(arr, low, p-1, outFile);
         quickSortStop50(arr, p+1, high, outFile);
      }
   } // end quickSortStop50()


   /** quickSortMedian()
    * Recursive method runs the sort
    *
    * Pre-Conditions: arr is an array, outFile is FileWriter type
    *
    * Post-Conditions: NA
    *
    * @param arr int[]
    * @param outFile FileWriter
    *
    * @author Mike Ogrysko  (modified from https://www.youtube.com/watch?v=Fiot5yuwPAg&t=2s & https://www.youtube.com/watch?v=39BV3_DONJc)
    */
   void quickSortMedian(int[] arr, FileWriter outFile) { // start quickSortMedian()
      // If array is less than or equal to 1, end
      if (arr.length <= 1) {
         return;
      }
      quickSortMedian(arr, 0, arr.length - 1, outFile);
      displayCountsAndSortedList(arr, outFile);
   } // end quickSortMedian()


   /** quickSortMedian()
    * Recursive method that establishes the stopping case, pivot, partition
    *
    * Pre-Conditions: arr is an array, low and high are integers outFile is FileWriter type
    *
    * Post-Conditions: NA
    *
    * @param arr int[]
    * @param low int
    * @param high int
    * @param outFile FileWriter
    *
    * @author Mike Ogrysko  (modified from https://www.youtube.com/watch?v=Fiot5yuwPAg&t=2s & https://www.youtube.com/watch?v=39BV3_DONJc)
    */
   void quickSortMedian(int[] arr, int low, int high, FileWriter outFile) { // start quickSortMedian()
      // Stopping case for 1 or 2
      if ((high - low) <= 0) {
         return;
      }
      int pivot = getMedian(arr, low, high, outFile);
      int p = partitionMed(arr, low, high, pivot, outFile);
      quickSortMedian(arr, low, p-1, outFile);
      quickSortMedian(arr, p+1, high, outFile);
   } // end quickSortMedian()


   /** swap()
    * Performs the swap on all quicksort and insertion sort methods
    *
    * Pre-Conditions: arr is an array, index1 and index2 are integers outFile is FileWriter type
    *
    * Post-Conditions: NA
    *
    * @param arr int[]
    * @param index1 int
    * @param index2 int
    * @param outFile FileWriter
    *
    * @author Mike Ogrysko  (modified from https://www.youtube.com/watch?v=Fiot5yuwPAg&t=2s & https://www.youtube.com/watch?v=39BV3_DONJc)
    */
   void swap(int[] arr, int index1, int index2, FileWriter outFile) { // start swap()
      if (index1 != index2) {
         if (arr.length <= 50) {
            System.out.println("QuickSort: Swapping " + arr[index1] + " and " + arr[index2]);
            try {
               outFile.write("QuickSort: Swapping " + arr[index1] + " and " + arr[index2] + "\n");
            }
            catch (Exception e) {
               System.out.println("\nError writing to file.");
            }
         }
         swapCount++;
      }
      int temp = arr[index1];
      arr[index1] = arr[index2];
      arr[index2] = temp;
   } // end swap()


   /** partition()
    * Partition for quicksort using first item as pivot
    *
    * Pre-Conditions: arr is an array, low and high are integers outFile is FileWriter type
    *
    * Post-Conditions: left-1 an int is returned
    *
    * @param arr int[]
    * @param low int
    * @param high int
    * @param outFile FileWriter
    * @return left-1 int
    *
    * @author Mike Ogrysko  (modified from https://www.youtube.com/watch?v=Fiot5yuwPAg&t=2s & https://www.youtube.com/watch?v=39BV3_DONJc)
    */
   int partition(int[] arr, int low, int high, FileWriter outFile) { // start partition()
      int left = low + 1;
      int right = high;
      int pivot = arr[low];
      while (true) {
         while (left <= right) {
            if (arr.length <= 50) {
               System.out.println("QuickSort: Comparing " + arr[left] + " to " + pivot);
               try {
                  outFile.write("QuickSort: Comparing " + arr[right] + " to " + pivot + "\n");
               }
               catch (Exception e) {
                  System.out.println("\nError writing to file - partition.");
               }
            }
            compCount++;
            if (arr[left] < pivot) {
               left++;
            }
            else {
               break;
            }
         }
         while (right > left) {
            if (arr.length <= 50) {
               System.out.println("QuickSort: Comparing " + arr[right] + " to " + pivot);
               try {
                  outFile.write("QuickSort: Comparing " + arr[right] + " to " + pivot + "\n");
               }
               catch (Exception e) {
                  System.out.println("\nError writing to file - partition.");
               }
            }
            compCount++;
            if (arr[right] < pivot) {
               break;
            }
            else {
               right--;
            }
         }
         if (left >= right) {
            break;
         }
         swap(arr, left, right, outFile);
         left++; right--;
      }
      swap(arr,low,left-1,outFile);
      return left-1;
   } // end partition()


   /** partitionMed()
    * Partition for the quicksort using the median of 3
    *
    * Pre-Conditions: arr is an array, low, high, and pivot are integers outFile is FileWriter type
    *
    * Post-Conditions: leftCursor an int is returned
    *
    * @param arr int[]
    * @param low int
    * @param high int
    * @param pivot int
    * @param outFile FileWriter
    * @return leftCursor int
    *
    * @author Mike Ogrysko (modified from https://examples.javacodegeeks.com/quicksort-java-algorithm-code-example/)
    */
   int partitionMed(int[] arr, int low, int high, int pivot, FileWriter outFile) { // start partitionMed()
      int leftCursor = low-1;
      int rightCursor = high;
      while(leftCursor < rightCursor){
      while(arr[++leftCursor] < pivot);
      while(rightCursor > 0 && arr[--rightCursor] > pivot);
         if (arr.length <= 50) {
            System.out.println("QuickSort: Comparing " +  arr[leftCursor] + " to " + arr[rightCursor]);
            try {
               outFile.write("QuickSort: Comparing " +  arr[leftCursor] + " to " + arr[rightCursor] + "\n");
            }
            catch (Exception e) {
               System.out.println("\nError writing to file - partition for median of 3.");
            }
         }
         compCount++;
         if (leftCursor >= rightCursor) {
            break;
         }
         else {
            swap(arr, leftCursor, rightCursor, outFile);
         }
      }
      if (arr.length <= 50) {
         System.out.println("QuickSort: Comparing " +  arr[leftCursor] + " to " + pivot);
         try {
            outFile.write("QuickSort: Comparing " +  arr[leftCursor] + " to " + pivot + "\n");
         }
         catch (Exception e) {
            System.out.println("\nError writing to file - partition for median of 3.");
         }
      }
      compCount++;
      swap(arr, leftCursor, high, outFile);
      return leftCursor;
   } // end partitionMed()


   /** getMedian()
    * Get the median of 3 for one of the quicksort methods
    *
    * Pre-Conditions: arr is an array, low and high are integers outFile is FileWriter type
    *
    * Post-Conditions: arr[high] (pivot or median of 3) an int is returned
    *
    * @param arr int[]
    * @param low int
    * @param high int
    * @param outFile FileWriter
    * @return arr[high] int
    *
    * @author Mike Ogrysko (modified from https://examples.javacodegeeks.com/quicksort-java-algorithm-code-example/)
    */
   int getMedian(int[] arr, int low, int high, FileWriter outFile) { // start getMedian()
      int center = (low+high)/2;
      if (arr.length <= 50) {
         System.out.println("QuickSort: Comparing " +  arr[low] + " to " + arr[center]);
         try {
            outFile.write("QuickSort: Comparing " +  arr[low] + " to " + arr[center] + "\n");
         }
         catch (Exception e) {
            System.out.println("\nError writing to file - median of 3.");
         }
      }
      compCount++;
      if(arr[low] > arr[center]) {
         swap(arr, low, center, outFile);
      }
      if (arr.length <= 50) {
         System.out.println("QuickSort: Comparing " +  arr[low] + " to " + arr[high]);
         try {
            outFile.write("QuickSort: Comparing " +  arr[low] + " to " + arr[high] + "\n");
         }
         catch (Exception e) {
            System.out.println("\nError writing to file - median of 3.");
         }
      }
      compCount++;
      if(arr[low] > arr[high]) {
         swap(arr, low, high, outFile);
      }
      if (arr.length <= 50) {
         System.out.println("QuickSort: Comparing " +  arr[center] + " to " + arr[high]);
         try {
            outFile.write("QuickSort: Comparing " +  arr[center] + " to " + arr[high] + "\n");
         }
         catch (Exception e) {
            System.out.println("\nError writing to file - median of 3.");
         }
      }
      compCount++;
      if(arr[center] > arr[high]) {
         swap(arr, center, high, outFile);
      }
      swap(arr, center, high, outFile);
      return arr[high];
   } // end getMedian()


   /** insertSort()
    * Iterative nsertion sort method
    *
    * Pre-Conditions: arr is an array, outFile is FileWriter type
    *
    * Post-Conditions: message is printed on screen and in file
    *
    * @param arr int[]
    * @param outFile FileWriter
    *
    * @author Mike Ogrysko (modified from https://www.youtube.com/watch?v=lCDZ0IprFw4)
    */
   void insertSort(int arr[], FileWriter outFile) { // start insertSort()
      for (int i = 1; i < arr.length; i++) {
         int key = arr[i];
         int j = i - 1;
         if (arr[j] <= key) {
            if (arr.length <= 50) {
               System.out.println("Insertion sort: Comparing " +  key + " to " + arr[j]);
               try {
                  outFile.write("Insertion sort: Comparing " +  key + " to " + arr[j] + "\n");
               }
               catch (Exception e) {
                  System.out.println("\nError writing to file - insertSort.");
               }
            }
            compCount++;
         }
         while (j >= 0 && arr[j] > key) {
            if (arr.length <= 50) {
               System.out.println("Insertion sort: Comparing " +  key + " to " + arr[j]);
               try {
                  outFile.write("Insertion sort: Comparing " +  key + " to " + arr[j] + "\n");
               }
               catch (Exception e) {
                  System.out.println("\nError writing to file - insertSort.");
               }
            }
            compCount++;
            if (arr.length <= 50) {
               System.out.println("Insertion sort: Swapping " +  key + " and " + arr[j]);
               try {
                  outFile.write("Insertion sort: Swapping " +  key + " and " + arr[j] + "\n");
               }
               catch (Exception e) {
                  System.out.println("\nError writing to file - insertSort.");
               }
            }
            swapCount++;
            int temp = arr[j];
            arr[j] = arr[j+1];
            arr[j+1] = temp;
            j--;
            if (j >= 0 && arr[j] <= key) {
               if (arr.length <= 50) {
                  System.out.println("Insertion sort: Comparing " +  key + " to " + arr[j]);
                  try {
                     outFile.write("Insertion sort: Comparing " +  key + " to " + arr[j] + "\n");
                  }
                  catch (Exception e) {
                     System.out.println("\nError writing to file - insertSort.");
                  }
               }
               compCount++;
            }
         }
      }
   } // end insertSort()

   /** insertionSortRecursive()
    * Iterative nsertion sort method
    *
    * Pre-Conditions: arr is an array, n is an integer, outFile is FileWriter type
    *
    * Post-Conditions: message is printed on screen and in file
    *
    * @param arr int[]
    * @param n int
    * @param outFile FileWriter
    *
    * @author Mike Ogrysko (modified from https://www.geeksforgeeks.org/recursive-insertion-sort/)
    */
   void insertionSortRecursive(int arr[], int n, FileWriter outFile) {
      // Base case
      if (n <= 1)
           return;
      // Sort first n-1 elements
      insertionSortRecursive( arr, n-1, outFile);
      // Insert last element at its correct position
      // in sorted array.
      int last = arr[n-1];
      int j = n-2;
      /* Move elements of arr[0..i-1], that are
         greater than key, to one position ahead
         of their current position */
      while (j >= 0 && arr[j] > last) {
         if (arr.length <= 50) {
            System.out.println("Recursive Insertion sort: Comparing " +  arr[j] + " to " + last);
            try {
               outFile.write("Recursive Insertion sort: Comparing " +  arr[j] + " to " + last + "\n");
            }
            catch (Exception e) {
               System.out.println("\nError writing to file - insertSort.");
            }
         }
         compCount++;
         arr[j+1] = arr[j];
         if (arr.length <= 50) {
            System.out.println("Recursive Insertion sort: Swapping " +  arr[j+1] + " and " + arr[j]);
            try {
               outFile.write("Recursive Insertion sort: Swapping " +  arr[j+1] + " and " + arr[j] + "\n");
            }
            catch (Exception e) {
               System.out.println("\nError writing to file - insertSort.");
            }
         }
         swapCount++;
         j--;
      }
      arr[j+1] = last;
   }


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
