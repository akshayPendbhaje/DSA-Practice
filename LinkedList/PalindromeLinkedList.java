/*
Identify if given singly linkedlist is palindrome or not 
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
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        if (head==null)
            return true;
 
        
        ListNode fastWalker=head;
        ListNode slowWalker=head;
        
        while(fastWalker!=null && fastWalker.next!=null)
        {
            fastWalker=fastWalker.next.next;
            slowWalker=slowWalker.next;
        }
        
        ListNode rev=reverseLinkedList(slowWalker);
        
        while(head!=null && rev!=null)
        {
            if(head.val !=rev.val) return false;
            head=head.next;
            rev=rev.next;
        }
      return true;
    
 
}
    
    public static ListNode reverseLinkedList(ListNode point)
    {
        ListNode prev=null;
        while(point!=null)
        {
            ListNode next=point.next;
            point.next=prev;
            prev=point;
            point=next;
            
        }

        return prev;
    }
}    
   
    

/*
Go to mid of the linkedlist 
and reverse from mid 
later check reverse and original node by node if equal
*/