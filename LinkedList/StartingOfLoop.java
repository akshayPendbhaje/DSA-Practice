/*
**************** Problem Description ****************
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
Note that pos is not passed as a parameter.
Notice that you should not modify the linked list.
  Example 1 : 
  Input: head = [3,2,0,-4], pos = 1
  Output: tail connects to node index 1
  Explanation: There is a cycle in the linked list, where tail connects to the second node.
  Example 2 : 
  Input: head = [1,2], pos = 0
  Output: tail connects to node index 0
  Explanation: There is a cycle in the linked list, where tail connects to the first node.
  Example 3 :
  Input: head = [1], pos = -1
  Output: no cycle
  Explanation: There is no cycle in the linked list.
*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

 public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        if(head==null || head.next==null)
        {
            return null;
        }
        
        ListNode slow=head;
        ListNode fast=head.next;
        
        while(fast!=null || fast.next!=null)
        {
            if(slow==fast)
            {
                slow=head;
                while(slow!=fast)
                {
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return null;
    }
}

/*
**************** Logic ****************
Use slow pointer and fast pointer.
If fast pointer reaches end or becomes null there is no loop. 
If both pointers overlap then there is a loop.
 
*/