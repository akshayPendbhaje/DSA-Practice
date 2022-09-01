/*
**************** Problem Description ****************
Given Pointer/Reference to the head of the linked list, the task is to Sort the given linked list using Merge Sort.
Note: If the length of linked list is odd, then the extra node should go in the first list while splitting.
  Example 1 :
  Input:
  N = 5
  value[]  = {3,5,2,4,1}
  Output: 1 2 3 4 5
  Explanation:
  After sorting the given linked list, the resultant matrix will be 1->2->3->4->5.
  Example 2 :
  Input:
  N = 3
  value[]  = {9,15,0}
  Output: 0 9 15
  Explanation:
  After sorting the given linked list , resultant will be 0->9->15.
*/
/**https://leetcode.com/problems/merge-k-sorted-lists/submissions/
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        if(lists.length==1)
            return lists[0];

        ListNode merged=null;

        for(ListNode l:lists)
        {
            merged=mergeLists(merged,l);
        }
        return merged;
    }

    private ListNode mergeLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        //System.out.println(list1.val +" "+ list2.val);
        if (list1.val < list2.val) {
            list1.next = mergeLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeLists(list2.next, list1);
            return list2;
        }
    }

        if(list1 == null)
            return list2;
    if(list2==null)
            return list1;

    ListNode ans=new ListNode();
    ListNode walker=ans;
    while(list1!=null &&list2 !=null)
    {
        if(list1.val<list2.val)
        {
            walker.next=list1;
            walker=walker.next;
            list1=list1.next;
        }
        else
        {
            walker.next=list2;
            walker=walker.next;
            list2=list2.next;
        }

        if(list1==null)
            walker.next=list2;
        if(list2==null)
            walker.next=list1;

    }

        return ans.next;
}
}


