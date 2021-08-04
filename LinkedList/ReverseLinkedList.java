/*
**************** Problem Description ****************
Given a linked list of N nodes. The task is to reverse this list.
  Example 1 : 
  Input:
  LinkedList: 1->2->3->4->5->6
  
  Output: 6 5 4 3 2 1
  Example 2 : 
  Input:
  LinkedList: 2->7->8->9->10
  
  Output: 10 9 8 7 2
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        
        ListNode prev=null;
        
        while(head!=null)
        {
            ListNode nextNode=head.next;
            head.next=prev;
            prev=head;
            head=nextNode;
        }
        
        return prev;
    }

    /* recursive solution*/

    public ListNode reverseList(ListNode head) {
        
        if(head==null|| head.next==null) return head;
        
        ListNode p= reverseList(head.next);
        head.next.next=head;
        head.next=null;
     return p;
    }
}

