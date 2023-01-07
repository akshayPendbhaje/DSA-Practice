/*
**************** Problem Description ****************
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
(i.e., from left to right, then right to left for the next level and alternate between).
  Example 1 : 
  Input: root = [3,9,20,null,null,15,7]
  Output: [[3],[20,9],[15,7]]
  Example 2 : 
  Input: root = [1]
  Output: [[1]]
  Example 3 : 
  Input: root = []
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
     List<List<Integer>>  ans=new ArrayList<>();
         
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root ==null)
            return ans;
        
        boolean isEven=false;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            List<Integer> level=new ArrayList<>();
            int size=q.size();
            isEven=!isEven;
            for(int i=0;i<size;i++)
            {
                TreeNode cur=q.poll();
                
                if(isEven)
                    level.add(cur.val);
                else
                    level.add(0,cur.val);
                
                if(null!=cur.left)
                    q.add(cur.left);
                if(null!=cur.right)
                    q.add(cur.right);
                
                
            }
            ans.add(level);
        }
        return ans;
    }
}



/*
**************** Logic ****************
maintain a odd even flag , change the direction of adding element after each level iteration.
*/
