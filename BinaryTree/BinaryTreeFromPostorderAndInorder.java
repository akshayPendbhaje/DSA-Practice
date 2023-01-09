/*
**************** Problem Description ****************
Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree,
construct and return the binary tree.
  Example 1 : 
  Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
  Output: [3,9,20,null,null,15,7]
  Example 2 : 
  Input: inorder = [-1], postorder = [-1]
  Output: [-1]
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if(postorder==null || inorder==null ||postorder.length==0|| inorder.length==0) return null;

        TreeNode root=new TreeNode(postorder[postorder.length-1]);

        int mid= IntStream.range(0, inorder.length)
                .filter(i -> postorder[postorder.length-1] == inorder[i])
                .findFirst()
                .orElse(-1);

        // System.out.println(Arrays.toString(inorder)+" "+Arrays.toString(postorder)+" "+mid);


        root.left=buildTree(Arrays.copyOfRange(inorder, 0, mid), Arrays.copyOfRange(postorder, 0, mid));
        root.right=buildTree(Arrays.copyOfRange(inorder, mid+1, inorder.length), Arrays.copyOfRange(postorder, mid, inorder.length-1));

        return root;
    }
}



/*
**************** Logic ****************
Postorder traversing implies that PRE[size - 1] is the root node.
Then we can find this PRE[size - 1] in POST, say it's POST[5].
Now we know that POST[5] is root, so we know that POST[0] - POST[4] is on the left side, POST[6] to the end is on the right side.
Recursively doing this on subarrays, we can build a tree out of it.
*/