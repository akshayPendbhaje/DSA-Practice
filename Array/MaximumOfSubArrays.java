/*
https://leetcode.com/problems/sliding-window-maximum/
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

*/

class MaximumOfSubArrays {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int i=0, j=0, n=nums.length; 
        Deque<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> ans =new ArrayList<>();
        
        while (j<n) {
            while(!queue.isEmpty() && queue.peekLast()<nums[j])
                queue.removeLast();
            queue.addLast(nums[j]);
            if(j-i+1<k)
            {
                j++;
            }
            else
            {
                if(queue.isEmpty())
                {
                    ans.add(0);
                }
                else
                {
                    ans.add(queue.peekFirst());                    
                }
                if(queue.peekFirst()==nums[i])
                    queue.removeFirst();
                
                i++;
                j++;
            }
        }
        return ans.stream().mapToInt(x->x).toArray();       
                       
        }
        
    } 

/*
**************** Logic ****************
Sliding window. Store only relevent element in queue.
Max element will always be at front of the queue.
*/