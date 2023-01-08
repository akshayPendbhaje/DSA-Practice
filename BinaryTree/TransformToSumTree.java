/*
**************** Problem Description ****************
Given a Binary Tree of size N , where each node can have positive or negative values.
Convert this to a tree where each node contains the sum of the left and right sub trees of the original tree.
The values of leaf nodes are changed to 0.
  Example 1 : 
  Input:
             10
          /      \
        -2        6
       /   \     /  \
     8     -4   7    5
  Output:
              20
            /    \
          4        12
        /  \     /  \
      0     0   0    0
  Explanation:
            (4-2+12+6)
            /           \
        (8-4)          (7+5)
        /   \         /  \
        0     0       0    0
*/


class Solution{
    public void toSumTree(Node root){
        //add code here.
        if(root==null)
            return;

        transformSumTree(root);
    }

    public int transformSumTree(Node root)
    {
        if(root==null) return 0;
        int temp=root.data;
        int left=transformSumTree(root.left);
        int right=transformSumTree(root.right);
        root.data=left+right;
        return temp+root.data;
    }
}

/*
**************** Logic ****************
Recursively call for left and right subtrees and change the value of current node as sum of the values returned by the recursive calls.
*/