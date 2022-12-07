/*
**************** Problem Description ****************
Given an array A[] of size N and a positive integer K,
find the first negative integer for each and every window(contiguous subarray) of size K.
  Example :
  Input : 
  N = 5
  A[] = {-8, 2, 3, -6, 10}
  K = 2
  Output : 
  -8 0 -6 -6
  Explanation :
  First negative integer for each window of size k
  {-8, 2} = -8
  {2, 3} = 0 (does not contain a negative integer)
  {3, -6} = -6
  {-6, 10} = -6
*/


class Compute {

    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {

        long[] ans = new long[N-K+1];

        int left=0;
        int right=0;
        Queue<Long> q= new LinkedList<>();
        int index=0;
        while(right<N)
        {
            if(A[right]<0)
            {
                q.add(A[right]);
            }

            if(right-left+1<K)
            {
                right++;
            }
            else if(right-left+1==K)
            {
                if(!q.isEmpty())
                {
                    ans[index++]=q.peek();
                    if(q.peek()==A[left])
                    {
                        q.remove();
                    }

                }
                else
                {
                    ans[index++]=0;
                }
                left++;
                right++;
            }
        }
        return ans;
    }
}

/*
**************** Logic ****************
Sliding window variation, store only essential elements in queue.

*/