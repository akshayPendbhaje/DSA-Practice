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

class Solution
{
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
        // code here
        int i=0;
        int j=n-1;

        while(i!=j)
        {
            if(M[i][j]==1)
            {
                i++; //i knows j so i is not celebrity
            }
            else
            {
                j--; // i does not know j so j is not celebrity
            }
        }

        for(int k=0;k<n;k++)
        {
            if(M[i][k]==1) return -1; //i knows someone so not celeb
            if(k!=i && M[k][i]==0) return -1; // someone does not know i so not a celeb
        }

        return i;
    }
}

/*
**************** Logic ****************
Start one pointer at start and one at end. Keep eliminating indexes one by one until only one candidate remains.
Check the row and column in the matrix for the candidate to find if it is a celebrity or not.
*/