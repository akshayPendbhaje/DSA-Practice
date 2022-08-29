/*
**************** Problem Description ****************
Given two lists sorted in increasing order, create a new list representing the intersection of the two lists.
The new list should be made with its own memory — the original lists should not be changed.
  Example 1 :
  Input:
  L1 = 1->2->3->4->6
  L2 = 2->4->6->8
  Output: 2 4 6
  Explanation: For the given first two linked list, 2, 4 and 6 are the elements in the intersection.
  Example 2 :
  Input:
  L1 = 10->20->40->50
  L2 = 15->40
  Output: 40
  Explanation: For the given first two linked list, 40 is the element in the intersection.
*/

class Sol
{
    public static Node findIntersection(Node head1, Node head2)
    {
        if(head1==null || head2==null)
            return null;

        Node ans=new Node(-1);
        Node walker=ans;

        while(head1!=null && head2 !=null)
        {
            if(head1.data==head2.data)
            {
                walker.next=new Node(head1.data);
                walker=walker.next;
                head1=head1.next;
                head2=head2.next;
            }
            else if(head1.data>head2.data)
            {
                head2=head2.next;
            }
            else
            {
                head1=head1.next;
            }
        }
        return ans.next;
    }
}

/*
**************** Logic ****************
Iterate both lists. If both nodes have same data then push the node into result and increment both iterators.
If data is not equal then only increment the iterator of the list with smaller data.
*/