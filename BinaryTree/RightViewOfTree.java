/*
**************** Problem Description ****************
Given the root of a binary tree, imagine yourself standing on the right side of it,
return the values of the nodes you can see ordered from top to bottom.
  Example 1 : 
  Input: root = [1,2,3,null,5,null,4]
  Output: [1,3,4]
  Example 2 : 
  Input: root = [1,null,3]
  Output: [1,3]
  Example 3 : 
  Input: root = []
  Output: []
*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/* BFS APPROACH  
class Solution {
    List<Integer>  ans=new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null)
            return ans;
        
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode cur=q.poll();
                if(i==0)
                    ans.add(cur.val);
                if(cur.right!=null)
                q.add(cur.right);
                if(cur.left!=null)
                q.add(cur.left);
                
            }
            
            
        }
        return ans;
    }
}
 */

//DFS approach

class Solution {
    List<Integer>  ans=new ArrayList<>();
    int h=0;
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null)
            return ans;
       
        helper(root,1);
        return ans;
    }
    
    void helper(TreeNode root,int level)
    {
        if(root==null)
        {
            return;
        }
        
        if(level>h)
        {
            ans.add(root.val);
            h++;
        }
        helper(root.right,level+1);
        helper(root.left,level+1);
    }
}

/*
**************** Logic ****************
BFS approach - keep adding right then left elements in Queue , 
if first iteration of each level add first element in the ans

DFS approach- 
Use pre order traversal and store node data at depth index of result vector.
when level greater than height then add digit to ans.
*/