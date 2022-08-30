/*
**************** Problem Description ****************
Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
(i) a next pointer to the next node,
(ii) a bottom pointer to a linked list where this node is head.
Each of the sub-linked-list is in sorted order.
Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order.
Note: The flattened list will be printed using the bottom pointer instead of next pointer.
  Example 1 :
  Input:
  5 -> 10 -> 19 -> 28
  |     |     |     |
  7     20    22   35
  |           |     |
  8          50    40
  |                 |
  30               45
  Output: 5-> 7-> 8- > 10 -> 19-> 20->22-> 28-> 30-> 35-> 40-> 45-> 50
  Explanation:
  The resultant linked lists has every node in a single level.
  (Note: | represents the bottom pointer.)
*/

class Solution
{
    Node compute(Node head)
    {
        if(head==null)
            return null;

        Node rev=reverseList(head);
        Node revHead=rev;
        while(rev!=null && rev.next !=null)
        {
            if(rev.next.data<rev.data)
                rev.next=rev.next.next;
            else
                rev=rev.next;
        }

        return reverseList(revHead);

    }

    Node reverseList(Node head)
    {
        Node prev=null;
        while(head!=null)
        {
            Node next=head.next;
            head.next=prev;
            prev=head;
            head=next;

        }

        return prev;
    }

}


/*
**************** Logic ****************
Consider each vertical column as a list. Merge two vertical lists to create one sorted list.
Now merge the sorted list with the next vertical list. Keep repeating until only one list is remaining.
*/