/** Node class
  * Node for linked list; sets data value;
  * sets the next pointer
  *
  * @author Mike Ogrysko
  *
  */

public class Node {
   // Initialize integer data and Node next
   int data;
   Node next;


   /** Node()
    * Default constructor for node
    *
    * Pre-Conditions: Nodes next and below are set to null
    *
    * Post-Conditions: na
    *
    * @author Mike Ogrysko
    */
   Node() {
      this.next = null;
   }


   /** Node()
    * Clone for Node passes objects to constructor
    *
    * Pre-Conditions: integer d
    *
    * Post-Conditions: na
    *
    * @param d int
    *
    * @author Mike Ogrysko
    */
   Node(int d) {
      this.data = d;
      this.next = null;
   }
}
