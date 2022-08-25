/*
**************** Problem Description ****************
You are given a linked list of N nodes. Remove the loop from the linked list, if present.
Note: X is the position of the node to which the last node is connected to. If it is 0, then there is no loop.
Return true if there is a cycle in the linked list. Otherwise, return false.
  Example 1 :
  Input:
  N = 3
  value[] = {1,3,4}
  X = 2

  Output: 1
  Explanation: The link list looks like
      1 -> 3 -> 4
          ^    |
          |____|
  A loop is present. If you remove it successfully, the answer will be 1.
  Example 2 :
  Input:
  N = 4
  value[] = {1,8,3,4}
  X = 0

  Output: 1
  Explanation: The Linked list does not contains any loop.
*/

import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
}

class GFG
{
    public static Node newNode(int data){
        Node temp = new Node();
        temp.data = data;
        temp.next = null;
        return temp;
    }

    public static void makeLoop(Node head, int x){
        if (x == 0)
            return;
        Node curr = head;
        Node last = head;

        int currentPosition = 1;
        while (currentPosition < x)
        {
            curr = curr.next;
            currentPosition++;
        }

        while (last.next != null)
            last = last.next;
        last.next = curr;
    }

    public static boolean detectLoop(Node head){
        Node hare = head.next;
        Node tortoise = head;
        while( hare != tortoise )
        {
            if(hare==null || hare.next==null) return false;
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        return true;
    }

    public static int length(Node head){
        int ret=0;
        while(head!=null)
        {
            ret += 1;
            head = head.next;
        }
        return ret;
    }

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t--> 0)
        {
            int n = sc.nextInt();

            int num = sc.nextInt();
            Node head = newNode(num);
            Node tail = head;

            for(int i=0; i<n-1; i++)
            {
                num = sc.nextInt();
                tail.next = newNode(num);
                tail = tail.next;
            }

            int pos = sc.nextInt();
            makeLoop(head, pos);

            Solution x = new Solution();
            x.removeLoop(head);

            if( detectLoop(head) || length(head)!=n )
                System.out.println("0");
            else
                System.out.println("1");
        }
    }
}

// } Driver Code Ends


/*
class Node
{
    int data;
    Node next;
}
*/

class Solution
{
    //Function to remove a loop in the linked list.
    public static void removeLoop(Node head){
        // code here
        // remove the loop without losing any nodes
        if(head==null || head.next==null)
            return ;

        if(head.next==head)
        {
            head.next=null;
            return;
        }

        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast )
                break;
        }

        if(fast==null || fast.next==null)
            return ;

        if (slow == head) {
            while (slow.next != head)
                slow = slow.next;
            slow.next = null;
        }

        if (slow == fast) {
            slow=head;
            while(slow.next!=fast.next)
            {
                slow=slow.next;
                fast=fast.next;
            }
            fast.next=null;
        }
    }
}

/*
**************** Logic ****************
Use slow pointer and fast pointer.
If fast pointer reaches end or becomes null there is no loop.
If both pointers overlap then there is a loop.

*/