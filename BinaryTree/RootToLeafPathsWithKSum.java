/*
**************** Problem Description ****************
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum.
A leaf is a node with no children.
  
  Example 1 : 
  Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
  Output: [[5,4,11,2],[5,8,4,5]]
  Example 2 : 
  Input: root = [1,2,3], targetSum = 5
  Output: []
  Example 3 : 
  Input: root = [1,2], targetSum = 0
  Output: []
*/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */


class Solution {
    List<List<Integer>> ans=new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if(root==null)
        {
            return ans;
        }

        getPath(root,targetSum,new ArrayList<Integer>());

        return ans;
    }

    void getPath(TreeNode root,int targetSum,ArrayList<Integer> ansSoFar)
    {
        // if(targetSum<0) return;
        if(root==null)
        {
            return;
        }


        //  System.out.println(ansSoFar+" "+root.val+" "+targetSum);

        ansSoFar.add(root.val);
        if(root.left==null && root.right==null && root.val==targetSum)
            ans.add(new ArrayList(ansSoFar));
        else
        {
            getPath(root.left,targetSum-root.val,ansSoFar);
            getPath(root.right,targetSum-root.val,ansSoFar);
        }
        ansSoFar.remove(ansSoFar.size()-1);
    }


}


/*
**************** Logic ****************
Recursively traverse the left and right subtree and pass the prefix path.
If the sum is equal to target sum then add the current path to answer.
*/