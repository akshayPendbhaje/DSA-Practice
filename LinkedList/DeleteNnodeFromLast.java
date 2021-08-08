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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        
        if (head==null || n<=0)
            return head;
        
        ListNode walker=dummy;
        ListNode behind=dummy;
        
        while(n>=0 && walker!=null)
            {
            walker=walker.next;
            n--;
            }
        
        while(walker!=null)
        {
            walker=walker.next;
            behind=behind.next;
        }
         behind.next=behind.next.next;
         
        return dummy.next;
    }
}


/*

travers fast for N places
then traverse slow and fast one place at a time.
then remove slow.next.
use dummy to avoid corner cases
*/
