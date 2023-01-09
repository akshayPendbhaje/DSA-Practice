/*
**************** Problem Description ****************
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree,
construct and return the binary tree.
  Example 1 : 
  Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
  Output: [3,9,20,null,null,15,7]
  Example 2 : 
  Input: preorder = [-1], inorder = [-1]
  Output: [-1]
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder==null || inorder==null ||preorder.length==0|| inorder.length==0) return null;

        TreeNode root=new TreeNode(preorder[0]);

        int mid= IntStream.range(0, inorder.length)
                .filter(i -> preorder[0] == inorder[i])
                .findFirst()
                .orElse(-1);

        //  System.out.println(Arrays.toString(preorder)+" "+Arrays.toString(inorder)+" "+mid);

        root.left=buildTree(Arrays.copyOfRange(preorder, 1, 1+mid),Arrays.copyOfRange(inorder, 0, mid));
        root.right=buildTree(Arrays.copyOfRange(preorder, mid+1, preorder.length),Arrays.copyOfRange(inorder,mid+1, inorder.length)) ;
        return root;

    }
}



/*
**************** Logic ****************
Preorder traversing implies that PRE[0] is the root node.
Then we can find this PRE[0] in IN, say it's IN[5].
Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side, IN[6] to the end is on the right side.
Recursively doing this on subarrays, we can build a tree out of it.
*/