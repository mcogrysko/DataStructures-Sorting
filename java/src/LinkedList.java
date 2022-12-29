/** LinkedList class
  * Linked list and natural mergesort methods;
  * provides push, size, setFirst,
  * sort, merge, getMiddle,
  * and displayCountsAndSortedList
  *
  * Traditional mergesort taken from Algorithms 4th ed by Robert Sedgewick and Kevin Wayne
  * Natural mergeSort written by Mike Ogrysko using Traditional mergesort as a baseline
  * Linked list reversal taken from https://www.geeksforgeeks.org/reverse-a-linked-list/
  *
  * @author Mike Ogrysko
  *
  */

import java.io.FileWriter;

public class LinkedList {
   // Initialize counts
   int compCount = 0;
   int swapCount = 0;
   // Initialize head node
   Node head = null;
   // Initialize list size
   int size = 0;
   int runCounter =0;


   /** push()
    * Add items to linked list
    *
    * Pre-Conditions: int newData
    *
    * Post-Conditions: NA
    *
    * @param newData int
    *
    * @author Mike Ogrysko (modified)
    */
   void push(int newData) { // start push()
      // allocate node
      Node newNode = new Node(newData);
      // link the old list off the new node
      newNode.next = head;
      // move the head to point to the new node
      head = newNode;
      size++;
   } // end push()


   /** size()
    * Return the size of the list
    *
    * Pre-Conditions: NA
    *
    * Post-Conditions: size is an int
    *
    * return size int
    *
    * @author Mike Ogrysko (modified)
    */
   int size() { // start size()
      return size;
   } // end size()


   /** reverse()
    * Reverse the items in a linked list
    *
    * Pre-Conditions: NA
    *
    * Post-Conditions: node is returned
    *
    * @return head Node
    *
    * @author Mike Ogrysko (modified from https://www.geeksforgeeks.org/reverse-a-linked-list/)
    */
    Node reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }


   /** setFirst()
    * Set the first item as the head of the list
    *
    * Pre-Conditions: Node h
    *
    * Post-Conditions: NA
    *
    * @param h Node
    *
    * @author Mike Ogrysko (modified from Algorithms 4th ed by Robert Sedgewick and Kevin Wayne)
    */
   void setFirst(Node h) { // start setFirst()
      head = h;
   } // end setFirst()


   /** sort()
    * Returns the sorted list
    *
    * Pre-Conditions: FileWriter outFile
    *
    * Post-Conditions: Node sort(head)
    *
    * @param outFile FileWriter
    * @return sort(head) Node
    *
    * @author Mike Ogrysko (modified from Algorithms 4th ed by Robert Sedgewick and Kevin Wayne)
    */
   Node sort(FileWriter outFile) { // start sort()
      return sort(head, outFile);
   } // end sort()


   /** sort()
    * Splits the list in the middle and runs the merge to sort
    *
    * Pre-Conditions: Node head, FileWriter outFile
    *
    * Post-Conditions: Node merge()
    *
    * @param head Node
    * @param outFile FileWriter
    * @return merge() Node
    *
    * @author Mike Ogrysko (modified from Algorithms 4th ed by Robert Sedgewick and Kevin Wayne)
    */
   Node sort(Node head, FileWriter outFile) { // start sort()
    	if (head == null || head.next == null) {
    	   return head;
    	}
      Node middle = getMiddle(head);
      Node headHalf = middle.next;
      middle.next = null;
    	return merge(sort(head, outFile),sort(headHalf, outFile), outFile);
   } // end sort()


   /** sortNatMerge()
    * Returns the sorted list
    *
    * Pre-Conditions: FileWriter outFile
    *
    * Post-Conditions: Node sort(head)
    *
    * @param outFile FileWriter
    * @return sort(head) Node
    *
    * @author Mike Ogrysko (modified from Algorithms 4th ed by Robert Sedgewick and Kevin Wayne)
    */
   Node sortNatMerge(FileWriter outFile) { // start sortNatMerge()
      return sortNatMerge(head, outFile);
   } // end sortNatMerge()


   /** sortNatMerge()
    * Splits the list based on runs found in the list and runs the merge to sort
    *
    * Pre-Conditions: Node head, FileWriter outFile
    *
    * Post-Conditions: Node merge()
    *
    * @param head Node
    * @param outFile FileWriter
    * @return merge() Node
    *
    * @author Mike Ogrysko (modified from Algorithms 4th ed by Robert Sedgewick and Kevin Wayne)
    */
   Node sortNatMerge(Node head, FileWriter outFile) { // start sortNatMerge()
      if (head == null || head.next == null) {
         return head;
      }
      Node run = getRun(head, outFile);
      Node nextRun = run.next;
      run.next = null;
      return merge(head,sortNatMerge(nextRun, outFile), outFile);
   } // end sortNatMerge()


   /** merge()
    * Performs merge on list
    *
    * Pre-Conditions: Node a, Node b, FileWriter outFile
    *
    * Post-Conditions: Node temp.next is returned
    *
    * @param a Node
    * @param b Node
    * @return temp.next Node
    *
    * @author Mike Ogrysko (modified from Algorithms 4th ed by Robert Sedgewick and Kevin Wayne)
    */
   Node merge(Node a, Node b, FileWriter outFile) { // start merge()
      Node temp, curr;
      temp = new Node(0);
      curr = temp;
      while ( a != null && b != null) {
    	   if (size <= 50) {
            System.out.println("MergeSort: Comparing " +  a.data + " to " + b.data);
           	try {
           	   outFile.write("MergeSort: Comparing " +  a.data + " to " + b.data + "\n");
           	}
           	catch (Exception e) {
           	   System.out.println("\nError writing to file - natural merge.");
           	}
    	   }
         compCount++;
         if (a.data <= b.data) {
            curr.next = a;
            a = a.next;
         }
         else {
            if (size <= 50) {
               System.out.println("MergeSort: Swapping " +  a.data + " and " + b.data);
               try {
                  outFile.write("MergeSort: Swapping " +  a.data + " and " + b.data + "\n");
               }
               catch (Exception e) {
                  System.out.println("\nError writing to file - natural merge.");
               }
            }
            swapCount++;
            curr.next = b;
            b = b.next;
         }
         curr = curr.next;
      }
      if (a == null) {
         curr.next = b;
      }
      else {
         curr.next = a;
      }
      return temp.next;
    } // end merge()


   /** getMiddle()
    * Gets and returns the middle node of the linked list
    *
    * Pre-Conditions: Node head
    *
    * Post-Conditions: Node middle is returned
    *
    * @param head Node
    * @return middle Node
    *
    * @author Mike Ogrysko (modified from Algorithms 4th ed by Robert Sedgewick and Kevin Wayne)
    */
   Node getMiddle(Node head) { // start getMiddle()
      if (head == null) {
         return head;
      }
      Node middle, temp;
      middle = temp = head;
      while (temp.next != null && temp.next.next != null) {
         middle = middle.next;
         temp = temp.next.next;
      }
      return middle;
    } // end getMiddle()


   /** getRun()
    * Gets and returns the end node of a run in the linked list
    *
    * Pre-Conditions: Node head
    *
    * Post-Conditions: Node end is returned
    *
    * @param head Node
    * @return end Node
    *
    * @author Mike Ogrysko (modified)
    */
   Node getRun(Node head, FileWriter outFile) { // start getRun()
      if (head == null) {
         return head;
      }
      Node end, temp;
      end = temp = head;
      while ((temp.next != null) && (temp.next.next != null) && (temp.data <= temp.next.data)) {
        	end = end.next;
         temp = end;
    	}
      return end;
   } // end getRun()


   /** displayCountsAndSortedList()
    * Displays and prints comparison and swap counts and the sorted list
    *
    * Pre-Conditions: outFile is FileWriter type
    *
    * Post-Conditions: message is printed on screen and in file
    *
    * @param outFile FileWriter
    *
    * @author Mike Ogrysko
    */
   void displayCountsAndSortedList(FileWriter outFile) { // start displayCountsAndSortedList()
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
      // If the size of the list is 50 or less, print the sorted list
      if (size <= 50) {
         System.out.println("Sorted result: ");
         try {
            outFile.write("\nSorted result: ");
         }
         catch (Exception e) {
            System.out.println("\nError writing to file - display.");
         }
         Node curr = head;
         if (curr != null) {
            System.out.println(curr.data);
    	      try {
    	         outFile.write("\n" + curr.data);
    	      }
    	      catch (Exception e) {
    	         System.out.println("\nError writing to file - display.");
    	      }
            while (curr.next != null) {
               System.out.println(curr.next.data);
               try {
                  outFile.write("\n" + curr.next.data);
               }
       	      catch (Exception e) {
       	         System.out.println("\nError writing to file - display.");
       	      }
               curr = curr.next;
            }
       	}
      }
   } // end displayCountsAndSortedList()
}
