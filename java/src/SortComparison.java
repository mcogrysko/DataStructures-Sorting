/** SortComparison
  * Reads data from files and performs sorts
  *
  * @author Mike Ogrysko
  *
  */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SortComparison {
   public static void main(String[] args) throws IOException { // Start main
      if (args.length != 3) {
         throw new IllegalArgumentException("\n\nOne or more args are missing. \n\nPlease provide them in quotes - e.g., java SortComparison \"ran50.dat\" \"qsRan50out.dat\" \"1\" \n");
      }
      FileReader inFile = null;
      FileWriter outFile = null;
      inFile = new FileReader(args[0]);
      File ifile = new File(args[0]);
      BufferedReader inputCheck = new BufferedReader(new FileReader(args[0]));
      outFile = new FileWriter(args[1]);
      File ofile = new File(args[1]);

      String selection = args[2];
      // Catch blank files
      if (ifile.length() == 0) {
         System.out.println("This file is empty...Stopping.");
         outFile.write("\nThis file is empty...Stopping.\n\n");
         outFile.close();
      }
      // Assuming the file is not blank
      else {
         // Intro headers
         displayHeaders(ifile,ofile,outFile);
         // Initialize line and set it equal to null
         String line = null;
         // Initialize data, intCount and  and set it equal to 0
         int data;
         int intCount = 0;
         // Grab the input size
         String arrayLengthStr = args[0];
         arrayLengthStr = arrayLengthStr.replaceAll("\\D+","");
         if (arrayLengthStr.equals("")) {
            System.out.println("File size is missing. File name should include size - e.g., asc5000.txt");
            return;
         }
         int arrayLength;
         arrayLength = Integer.parseInt(arrayLengthStr.replaceAll("\\s",""));
         int[] sortArray = new int[arrayLength];
         LinkedList sortList = new LinkedList();
         // Iterate through the file
         while ((line = inputCheck.readLine() ) != null) {
            if (arrayLength == intCount) {
               System.out.println("Size specified does not align with number of items in the file. Check the file and run again.");
               break;
            }
            data = Integer.parseInt(line.replaceAll("\\s",""));
            sortArray[intCount] = data;
            sortList.push(data);
            intCount++;
         }
         inputCheck.close();
         QuickSort qs = new QuickSort();
         MergeSortArray ms = new MergeSortArray();
         if (selection.equals("1")) {
            System.out.println("Running a QuickSort\n");
            try {
               outFile.write("Running a QuickSort\n");
            }
            catch (Exception e) {
               System.out.println("\nError writing selection type.");
            }
            qs.quickSort(sortArray,outFile);
         }
         else if (selection.equals("2")) {
            System.out.println("Running a QuickSort with 100 as stopping case\n");
            try {
               outFile.write("Running a QuickSort with 100 as stopping case\n");
            }
            catch (Exception e) {
               System.out.println("\nError writing selection type.");
            }
            qs.quickSortStop100(sortArray,outFile);
         }
         else if (selection.equals("3")) {
            System.out.println("Running a QuickSort with 50 as stopping case\n");
            try {
               outFile.write("Running a QuickSort with 50 as stopping case\n");
            }
            catch (Exception e) {
                  System.out.println("\nError writing selection type.");
            }
            qs.quickSortStop50(sortArray,outFile);
          }
         else if (selection.equals("4")) {
            System.out.println("Running a QuickSort with median-of-3 as pivot\n");
            try {
               outFile.write("Running a QuickSort with median-of-3 as pivot\n");
            }
            catch (Exception e) {
                  System.out.println("\nError writing selection type.");
            }
            qs.quickSortMedian(sortArray,outFile);
         }
         else if (selection.equals("5")) {
            System.out.println("Running a Natural MergeSort\n");
            try {
               outFile.write("Running a Natural MergeSort\n");
            }
            catch (Exception e) {
               System.out.println("\nError writing selection type.");
            }
            sortList.reverse();
            sortList.setFirst(sortList.sortNatMerge(outFile));
            sortList.displayCountsAndSortedList(outFile);
          }
          else if (selection.equals("6")) {
            System.out.println("Running a Traditional MergeSort\n");
            try {
               outFile.write("Running a Traditional MergeSort\n");
            }
            catch (Exception e) {
               System.out.println("\nError writing selection type.");
            }
            sortList.reverse();
            sortList.setFirst(sortList.sort(outFile));
            sortList.displayCountsAndSortedList(outFile);
         }
         else if (selection.equals("7")) {
            System.out.println("Running a Natural MergeSort w/Array\n");
            try {
               outFile.write("Running a Natural MergeSort w/Array\n");
            }
            catch (Exception e) {
               System.out.println("\nError writing selection type.");
            }
            ms.natMergeSortCall(sortArray,outFile);
         }
         else {
            System.out.println("The command prompt requires a number 1 - 7 to select the appropriate program.");
            System.out.println("1. QuickSort");
            System.out.println("2. QuickSort with 100 as stopping case");
            System.out.println("3. QuickSort with 50 as stopping case");
            System.out.println("4. QuickSort with median-of-3 as pivot");
            System.out.println("5. Natural MergeSort");
            System.out.println("6. Traditional MergeSort");
            System.out.println("7. Natural MergeSort w/Array");
         }
      }
      outFile.close();
   }

      /** displayHeaders()
       * Displays and prints headers for output
       *
       * Pre-Conditions: ifile and ofile are of File type; outFile is FileWriter type
       *
       * Post-Conditions: message is printed on screen and in file
       *
       * @param ifile File
       * @param ofile File
       * @param outFile FileWriter
       *
       * @author Mike Ogrysko
       */
      public static void displayHeaders(File ifile, File ofile, FileWriter outFile) { // start displayHeaders()
         try {
            // Output heading messages
            System.out.println("\nMike Ogrysko");
            outFile.write("Mike Ogrysko\n");
            System.out.println("\njava SortComparison \"" + ifile.getName() + "\" \"" + ofile.getName() + "\"");
            outFile.write("java SortComparison \"" + ifile.getName() + "\" \"" + ofile.getName() + "\"\n");
            System.out.println("\nReading \"" + ifile.getName() + "\" and writing to \"" + ofile.getName() + "\"");
            outFile.write("Reading \"" + ifile.getName() + "\" and writing to \"" + ofile.getName() + "\"\n");
         }
         catch (Exception e) {
            System.out.println("\nError writing headers.");
         }
      }

}
