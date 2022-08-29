/*
**************** Problem Description ****************
Given an unsorted linked list of N nodes. The task is to remove duplicate elements from this unsorted Linked List.
When a value appears in multiple nodes, the node which appeared first should be kept, all others duplicates are to be removed.
  Example 1 : 
  Input: {5,2,2,4}
  Output: 5 2 4
  Example 2 : 
  Input: {2,2,2,2,2}
  Output: 2
*/

//{ Driver Code Starts
/* package whatever; // don't place package name! */
import java.util.*;
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

class Remove_Duplicate_From_LL
{
    Node head;
    Node temp;
    public void addToTheLast(Node node)
    {

        if (head == null)
        {
            head = node;
            temp = node;
        }
        else{
            temp.next = node;
            temp = node;
        }
    }

    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions */
    public static void main(String args[])
    {


        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();

        while(t>0)
        {
            int n = sc.nextInt();
            Remove_Duplicate_From_LL llist = new Remove_Duplicate_From_LL();
            int a1=sc.nextInt();
            Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }
            //llist.printList();
            Solution g = new Solution();
            llist.head = g.removeDuplicates(llist.head);
            llist.printList();

            t--;
        }
    }
}

// } Driver Code Ends


/* The structure of linked list is the following
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution
{
    //Function to remove duplicates from unsorted linked list.
    public Node removeDuplicates(Node head)
    {
        if(head==null)
            return head;
        Node walker=head;
        HashSet<Integer> visited = new HashSet<>();
        visited.add(walker.data);
        while(walker!=null && walker.next!=null)
        {
            if(visited.contains(walker.next.data))
            {
                walker.next=walker.next.next;
            }
            else
            {
                visited.add(walker.next.data);
                walker=walker.next;
            }
        }

        return head;
    }
}


/*
**************** Logic ****************
Iterate the linked list and store unique nodes in map to identify duplicate.
*/