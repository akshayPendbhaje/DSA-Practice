/* 
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
*/
class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)
            return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty())
        {
            List<Integer> level =new ArrayList<>();
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode cur=q.poll();
                if(cur.left!=null)
                    q.add(cur.left);
                if(cur.right!=null)
                    q.add(cur.right);
                level.add(cur.val);
            }
            ans.add(level);
        }
        
        return ans;
    }
}


/*
**************** Logic ****************
Maintain a queue with elements of current level , for each element of queue affter polling
add left and right child in the queue and polled elemnt in answer
*/