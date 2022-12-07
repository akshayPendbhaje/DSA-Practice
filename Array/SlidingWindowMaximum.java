/*
**************** Problem Description ****************
Given an array of integers A. There is a sliding window of size B which
is moving from the very left of the array to the very right.
You can only see the w numbers in the window. Each time the sliding window moves
rightwards by one position. You have to find the maximum for each window.
The following example will give you more clarity.
Note: If B > length of the array, return 1 element with the max of the array.
  Example :
  Input:
    A = [1, 3, -1, -3, 5, 3, 6, 7]
    B = 3

  Output:
    C = [3, 3, 5, 5, 6, 7]

  Explanation: for, orf and ofr appears
  in the txt, hence answer is 3.
*/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] slidingMaximum(final int[] A, int B) {

        int left=0;
        int right=0;
        int index=0;
        int size=A.length;
        int[] ans = new int[size-B+1];
        Deque<Integer> q = new ArrayDeque<>();

        while(right<size)
        {
            while(!q.isEmpty() && q.peekLast()<A[right])
                q.removeLast();

            q.add(A[right]);

            if(right-left+1<B)
            {
                right++;
            }
            else if(right-left+1==B)
            {
                ans[index++]=q.peek();
                if(q.peek()==A[left])
                    q.removeFirst();
                left++;
                right++;
            }
        }
        return ans;
    }
}


/*
**************** Logic ****************
Sliding window. Store only relevent element in queue.
Max element will always be at front of the queue.
*/