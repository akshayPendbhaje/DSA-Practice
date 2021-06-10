/*
**************** Problem Description ****************
A celebrity is a person who is known to all but does not know anyone at a party.
If you go to a party of N people, find if there is a celebrity in the party or not.
A square NxN matrix M[][] is used to represent people at the party such that if an element of row i and column j  is set to 1 it means ith person knows jth person.
Here M[i][i] will always be 0.
Note: Follow 0 based indexing.
  Example : 
  Input:
  N = 3
  M[][] = {{0 1 0},
          {0 0 0}, 
          {0 1 0}}
  Output: 1
  Input:
  N = 2
  M[][] = {{0 1},
          {1 0}}
  Output: -1
*/

public class CelebrityProblem {

    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	Stack<Integer> stack=new Stack<>();
    	
    	for(int i=0;i<n;i++)
    	{
    	    stack.add(i);
    	}
    	
    	while(stack.size()>=2)
    	{
    	    int i=stack.pop();
    	    int j=stack.pop();
    	    
    	    if(M[i][j]==1)
    	    {
    	        stack.push(j);
    	    }
    	    else
    	    {
    	        stack.push(i);
    	    }
    	}
    	int pot=stack.pop();
    	
    	for(int i=0;i<n;i++)
    	{
    	    if(M[pot][i]==1)
    	    {
    	        pot=-1;
    	        break;
    	    }
    	}
    	
    	if(pot==-1) return pot;
    	
    	for(int i=0;i<n;i++)
    	{
    	    if(i!=pot){
    	    if(M[i][pot]==0)
    	    {
    	        pot=-1;
    	        break;
    	    }}
    	}    	
    	
    	return pot;
    }
}

/*
**************** Logic ****************
Push all the indices in the stack. Keep comparing and eliminating from stack until only one candidate remains.
Check the row and column in the matrix for the candidate to find if it is a celebrity or not.
*/
