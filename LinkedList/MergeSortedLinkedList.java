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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode mergedList=new ListNode();
        ListNode dummy=mergedList;
        
        while(l1!=null && l2!=null)
        {
            if(l1.val>l2.val)
            {
                mergedList.next=l2;
                l2=l2.next;
            }
            else
            {
                mergedList.next=l1;
                l1=l1.next;
            }
            mergedList=mergedList.next;
            
        }
        
        while(l1!=null)
        {
            mergedList.next=l1;
            l1=l1.next;
            mergedList=mergedList.next;
        }
        
        
        while(l2!=null)
        {
            mergedList.next=l2;
            l2=l2.next;
            mergedList=mergedList.next;
        }
        
        
        return dummy.next;
    }
}

/**
 * First treverse both list together and add large element in new list , 
 * later merge both lists whichever is not empty append to the list   
 */