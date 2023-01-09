/*
**************** Problem Description ****************
Given the root of a binary tree, return all duplicate subtrees.
For each kind of duplicate subtrees, you only need to return the root node of any one of them.
Two trees are duplicate if they have the same structure with the same node values.
  Example 1 : 
  Input: root = [1,2,3,4,null,2,4,null,null,4]
  Output: [[2,4],[4]]
  Example 2 : 
  Input: root = [2,1,1]
  Output: [[1]]
  Example 3 : 
  Input: root = [2,2,2,3,null,3,null]
  Output: [[2,3],[3]]
*/

/*
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
    HashMap<String,Integer> counter = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if(root==null)
            return ans;
        inOrder(root);


        return ans;
    }

    String inOrder(TreeNode root)
    {
        if(root==null)
        {
            return "X";
        }

        String left= inOrder(root.left);
        String right= inOrder(root.right);

        String cur=left+","+right+","+root.val;
        counter.put(cur, counter.getOrDefault(cur, 0) + 1);
        //System.out.println(cur);
        if (counter.get(cur) == 2) {
            ans.add(root);
        }
        return cur;

    }
}

/*
**************** Logic ****************
Serialize the subtree for each node and store in map.
If the serialized subtree already exists in map that means the current node is duplicate.
*/