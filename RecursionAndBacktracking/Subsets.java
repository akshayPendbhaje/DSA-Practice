/*
**************** Problem Description ****************
Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.
  Example 1 : 
  Input: nums = [1,2,3]
  Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
  Example 2 : 
  Input: nums = [0]
  Output: [[],[0]]
*/

class Solution {
    List<List<Integer>> output = new ArrayList();
          
        public List<List<Integer>> subsets(int[] nums) {
            
             solve(0,nums,new ArrayList<Integer>());
            return output;
        }
        
        private void solve(int n,int[]nums,ArrayList<Integer> sets)
        {
            if(n==nums.length)
            {
                
            output.add(new ArrayList(sets));
                return;
            }
            
             
            ArrayList<Integer> sets1=new ArrayList(sets);
            solve(n+1,nums,sets1);
            sets.add(nums[n]);
            ArrayList<Integer> sets2=new ArrayList(sets);
            solve(n+1,nums,sets2 );
            
        }
    }


/* 
Each time there is choice to add element to subset or not to add and in last element add it to output.
*/