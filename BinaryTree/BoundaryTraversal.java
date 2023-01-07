/*
**************** Problem Description ****************
Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order: 
Left boundary nodes: defined as the path from the root to the left-most node 
ie- the leaf node you could reach when you always travel preferring the left subtree over the right subtree. 
Leaf nodes: All the leaf nodes except for the ones that are part of left or right boundary.
Reverse right boundary nodes: defined as the path from the right-most node to the root.
The right-most node is the leaf node you could reach when you always travel preferring the right subtree over the left subtree.
Exclude the root from this as it was already included in the traversal of left boundary nodes.
Note: If the root doesn't have a left subtree or right subtree, then the root itself is the left or right boundary. 
  Example 1 : 
  Input:
        1
      /   \
     2     3    
   
  Output: 1 2 3
  Example 2 : 
  Input:
          20
        /   \
       8     22
     /   \    \
    4    12    25
        /  \ 
       10   14 
  Output: 20 8 4 10 14 25 22
*/


class Solution
{
    ArrayList <Integer> ans=new ArrayList<>();
	ArrayList <Integer> boundary(Node node)
	{
	    if(node==null) return ans;
	    
	    ans.add(node.data);
	    treverseLeft(node.left);
	    treverseLeaf(node.left);
	    treverseLeaf(node.right);
	    treverseRight(node.right);
	    
	    return ans;
	}
	
	 void treverseLeft(Node node){
	     if(node ==null || (node.left==null &&node.right==null))
	     {
	         return;
	     }
	     
	     ans.add(node.data);
	     if(node.left!=null)
	     {
	         treverseLeft(node.left);
	         
	     }
	     else
	     {
	         treverseLeft(node.right);
	     }
	 }
	 
	 void treverseRight(Node node){
	     if(node ==null || (node.left==null &&node.right==null))
	     {
	         return;
	     }
	     
	     if(node.right!=null)
	     {
	         treverseRight(node.right);
	         
	     }
	     else
	     {
	         treverseRight(node.left);
	     }
	     ans.add(node.data);
	 }
	 
	 
	 void treverseLeaf(Node node){
	    if(node ==null)
	     {
	         return;
	     }
	     
	     if (node.left==null &&node.right==null)
	     {
	         ans.add(node.data);
	         return;
	         
	     }
	     
	     treverseLeaf(node.left);
	     treverseLeaf(node.right);
	     
	     
	 }
	 
	 
}

/*
**************** Logic ****************
We break the problem in 3 parts:
1. Print the left boundary in a top-down manner.
2. Print all leaf nodes from left to right, which can again be sub-divided into two sub-parts:
…..2.1 Print all leaf nodes of left sub-tree from left to right.
…..2.2 Print all leaf nodes of a right subtree from left to right.
3. Print the right boundary in a bottom-up manner.
*/
