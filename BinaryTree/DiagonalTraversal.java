/*
**************** Problem Description ****************
Given a Binary Tree, print the diagonal traversal of the binary tree.
Consider lines of slope -1 passing between nodes.
Given a Binary Tree, print all diagonal elements in a binary tree belonging to same line.
  Example 1 : 
  Input :
            8
         /     \
        3      10
      /   \      \
     1     6     14
         /   \   /
        4     7 13
  Output : 8 10 14 3 6 7 13 1 4
*/

class Tree
{
     public ArrayList<Integer> diagonal(Node root)
      {
           //add your code here.
           ArrayList<Integer> ans=new ArrayList<>();
           if(root==null) return ans;
           
           Queue<Node> q = new LinkedList<>();
           
           q.add(root);
           
           while(!q.isEmpty() )
           {
               Node n=q.remove();
            
            while(n!=null)
            {
               if(n.left!=null)
                 q.add(n.left);
                
                ans.add(n.data);
                n=n.right;
            }
             
           }
           return ans;
      }
}


/*
**************** Logic ****************
Use queue to add nodes of next slope. 
Traverse right and print node until end. 
*/
