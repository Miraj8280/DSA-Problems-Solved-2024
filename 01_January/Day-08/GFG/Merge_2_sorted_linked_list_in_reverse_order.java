//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}


public class Merge_2_sorted_linked_list_in_reverse_order {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0)
        {
            int N = scanner.nextInt();
            int M = scanner.nextInt();

            Node node1 = null;
            Node temp1 = null;
            for (int i = 0; i < N; i++) {
                int value = scanner.nextInt();
                Node newNode = new Node(value);
                if (node1 == null) {
                    node1 = newNode;
                    temp1 = node1;
                } else {
                    temp1.next = newNode;
                    temp1 = temp1.next;
                }
            }
    
            Node node2 = null;
            Node temp2 = null;
            for (int i = 0; i < M; i++) {
                int value = scanner.nextInt();
                Node newNode = new Node(value);
                if (node2 == null) {
                    node2 = newNode;
                    temp2 = node2;
                } else {
                    temp2.next = newNode;
                    temp2 = temp2.next;
                }
            }
    
            GfG gfg = new GfG();
            Node result = gfg.mergeResult(node1, node2);
            scanner.close();
            printList(result);
        }
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends


/*-----------------------------------------------------------------------------------
                                APPROACH
 ------------------------------------------------------------------------------------
    1. Create a dummy node to serve as the starting point of the merged list.

    2. Initialize a pointer 'current' to the dummy node to traverse over the list.

    3. Iterate through the nodes of both input lists.
        i) Compare the data values of the current nodes in both lists.
        ii) Append the smaller node to the merged list and move to the next node.
        iii) Then, move the 'current' pointer to the newly added node.
    
    4. If there are remaining nodes in list one, append them to the merged list.

    5. Similarly, if there are remaining nodes in list two, append them to the merged list.

    6. And, finally, return the head of the merged list after reversing it
 */

class GfG {
    Node mergeResult(Node node1, Node node2) {
	    // Create a dummy node to serve as the starting point of the merged list
        Node dummy = new Node(-1);
        // Initialize a pointer 'current' to the dummy node
        Node current = dummy;
    
        // Iterate through the nodes of both input lists
        while (node1 != null && node2 != null) {
            // Compare the data values of the current nodes in node1 and node2
            if (node1.data < node2.data) {
                // Append the smaller node to the merged list
                current.next = node1;
                // Move to the next node in node1
                node1 = node1.next;
            } else {
                // Append the smaller node to the merged list
                current.next = node2;
                // Move to the next node in node2
                node2 = node2.next;
            }
    
            // Move the 'current' pointer to the newly added node
            current = current.next;
        }
    
        // If there are remaining nodes in node1, append them to the merged list
        if (node1 != null) {
            current.next = node1;
        }
    
        // If there are remaining nodes in node2, append them to the merged list
        if (node2 != null) {
            current.next = node2;
        }
    
        // Return the head of the merged list after reversing it
        return reverseList(dummy.next);
    }
    
    // Reverse a linked list and return the head of the reversed list
    Node reverseList(Node head) {
        // Initialize pointers for the previous, current, and next nodes
        Node prevNode = null;
        Node currNode = head;
        Node nextNode = null;
    
        // Traverse the linked list and reverse the direction of the pointers
        while (currNode != null) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
    
        // Return the head of the reversed list
        return prevNode;
    }
}
/* -----------------------------------------------------------------------------------
                            COMPLEXITY ANALYSIS
 -------------------------------------------------------------------------------------
    - Time Complexity: O(M + N) (linear).
    - Space Complexity: O(1) (Constant)
 */