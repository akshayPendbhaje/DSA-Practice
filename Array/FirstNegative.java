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

public class FirstNegative {

    public long[] printFirstNegativeInteger(long A[], int N, int K) {
        Queue<Long> q = new LinkedList<>();
        List<Long> answer = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (j < N) {
            if (A[j] < 0) {
                q.add(A[j]);
            }
            if (j - i + 1 < K) {
                j++;
            } else if (j - i + 1 == K) {

                if (q.isEmpty()) {
                    answer.add(Long.parseLong("0"));

                } else {
                    answer.add(q.peek());
                }
                if (q.size() != 0 && q.peek() == A[i]) {
                    q.remove();
                }

                i++;
                j++;
            }

        }

        long[] a = new long[answer.size()];

        for (int m = 0; m < answer.size(); m++) {
            a[m] = answer.get(m);
        }

        return a;

    }
}

/*
 **************** Logic **************** Sliding window variation, store only essential
 * elements in queue.
 * 
 */