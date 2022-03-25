/*
**************** Problem Description ****************
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
  
  Example 1 : 
  
  Input: nums = [1,2,3]
  Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
  
  
  Example 2 : 
  
  Input: nums = [0,1]
  Output: [[0,1],[1,0]]
  
  
  Example 3 : 
  
  Input: nums = [1]
  Output: [[1]]
  
*/


class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        
        if(nums==null || nums.length == 0)
        {
            return ans;
        }
        boolean[] used = new boolean[nums.length];
        List<Integer> permutation=new ArrayList<>();
        getPermutations(nums,used,permutation,ans);
        return ans;
    }
    
    private void getPermutations(int[] nums,boolean[] used,List<Integer> permutations,List<List<Integer>> ans)
    {
        if(permutations.size()==nums.length)
        {
            ans.add(new ArrayList(permutations));
            return;
        }
        
        for(int i=0;i<nums.length;i++)
        {
            if(used[i])
                continue;
            else 
            {
                used[i]=true;
                permutations.add(nums[i]);
                getPermutations(nums,used,permutations,ans);
                permutations.remove(permutations.size()-1);
                used[i]=false;
            }
        }
    }
}

/*
 for each integer if it is not used add it in the permutation list
 and if list is full add to the final answer list of list.
 and remove the number inserted before.
*/