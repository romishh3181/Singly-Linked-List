import java.util.*;
class Node {
    int data;
    Node next;

}
 public class SLL {
     Scanner sc = new Scanner(System.in);

     boolean underflow(Node start) {
         if (start == null)
             return true;
         else
             return false;
     }

     Node create() {
         Node start = new Node();
         Node node1 = new Node();
         int n;
         System.out.print("Enter the element: ");
         node1.data = sc.nextInt();
         node1.next = null;
         start = node1;
         System.out.print("Want to enter more ass4.node 0/1 ? ");
         n = sc.nextInt();
         Node temp_start = start;
         while(n != 0) {
             Node node2 = new Node();
             System.out.print("Enter the element: ");
             node2.data = sc.nextInt();
             node2.next = null;
             while(temp_start.next != null) {
                 temp_start = temp_start.next;
             }
             System.out.print("Want to enter more ass4.node 0/1 ? ");
             n = sc.nextInt();
             temp_start.next = node2;
         }
         return start;
     }

     void display(Node start) {
         if (underflow(start))
             System.out.println("Empty List");
         else {
             Node curr_node = start;
             System.out.print("Linked list elements are: ");
             while(curr_node != null) {
                 System.out.print(curr_node.data + " ");
                 curr_node = curr_node.next;
             }
             System.out.println();
         }
     }

     int count(Node start) {
         int nodes = 0;
         Node curr_node = start;
         while(curr_node != null) {
             nodes++;
             curr_node = curr_node.next;
         }
         return nodes;
     }

     Node insert_beg(Node start) {
         Node node = new Node();
         System.out.print("Enter the element: ");
         node.data = sc.nextInt();
         node.next = start;

         return node;
     }

     void insert_end(Node start) {
         Node node = new Node();
         Node temp_start = start;
         System.out.print("Enter the element: ");
         node.data = sc.nextInt();
         node.next = null;
         while(temp_start.next != null) {
             temp_start = temp_start.next;
         }
         temp_start.next = node;
     }

     Node insert_any(Node start) {
         Node temp_start = start;
         int nodes = count(start);

         System.out.print("Enter the position: ");
         int pos = sc.nextInt();

         if (pos<1 || pos>nodes+1) {
             System.out.println("Invalid Position");
         }
         else if(pos == 1) {
             start = insert_beg(start);
         }
         else if(pos == nodes+1) {
             insert_end(start);
         }
         else {
             Node node = new Node();
             System.out.print("Enter the element: ");
             node.data =sc.nextInt();
             for(int i=1; i<pos-1; i++) {
                 temp_start = temp_start.next;
             }
             node.next = temp_start.next;
             temp_start.next = node;
         }
         return start;
     }

     Node delete_beg(Node start) {
         if(underflow(start))
             System.out.println("Empty List");
         else
             start = start.next;
         return start;
     }

     void delete_end(Node start) {
         if (underflow(start))
             System.out.println("Empty List");
         else {
             Node curr_node = start, prev_node = null;
             while(curr_node.next != null) {
                 prev_node = curr_node;
                 curr_node = curr_node.next;
             }
             prev_node.next = null;
         }
     }

     Node delete_any(Node start) {
         if(underflow(start))
             System.out.println("Empty List");
         else {
             Node curr_node = start;
             int nodes = count(start);

             System.out.print("Enter the position: ");
             int pos = sc.nextInt();

             if (pos<1 || pos>nodes) {
                 System.out.println("Invalid Position");
             }
             else if (pos == 1) {
                 start = delete_beg(start);
             }
             else if (pos == nodes) {
                 delete_end(start);
             }
             else {
                 for(int i=1; i<pos-1; i++) {
                     curr_node = curr_node.next;
                 }
                 curr_node.next = curr_node.next.next;
             }
         }
         return start;
     }

     Node reverse(Node start) {
         Node curr_node = start, next_node = null, prev_node = null;

         while(curr_node != null) {
             next_node = curr_node.next;
             curr_node.next = prev_node;
             prev_node = curr_node;
             curr_node = next_node;
         }

         return prev_node;
     }
 }class SLL_Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SLL l1 = new SLL();
        Node start = null;
        while(true) {
            System.out.println("***********************");
            System.out.println(" 0. Exit");
            System.out.println(" 1. Create");
            System.out.println(" 2. Display");
            System.out.println(" 3. Count");
            System.out.println(" 4. Insert @ Begining");
            System.out.println(" 5. Insert @ End");
            System.out.println(" 6. Insert @ Any");
            System.out.println(" 7. Delete @ Begining");
            System.out.println(" 8. Delete @ End");
            System.out.println(" 9. Delete @ Any");
            System.out.println(" 10. Reverse the LL");
            System.out.println("***********************");

            System.out.print("Enter you choice: ");
            int choice = sc.nextInt();

            switch(choice) {
                case 0:
                    sc.close();
                    return;
                case 1:
                    start = l1.create();
                    break;
                case 2:
                    l1.display(start);
                    break;
                case 3:
                    System.out.println("Numner of nodes in the linked list: " + l1.count(start));
                    break;
                case 4:
                    start = l1.insert_beg(start);
                    break;
                case 5:
                    l1.insert_end(start);
                    break;
                case 6:
                    start = l1.insert_any(start);
                    break;
                case 7:
                    start = l1.delete_beg(start);
                    break;
                case 8:
                    l1.delete_end(start);
                    break;
                case 9:
                    start = l1.delete_any(start);
                    break;
                case 10:
                    start = l1.reverse(start);
                    break;
                default:
                    System.out.println("Invalid Choice");

            }
        }

    }

}
