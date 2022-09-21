/*
**************** Problem Description ****************
Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1).
Find all possible paths that the rat can take to reach from source to destination.
The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right).
Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
Note: In a path, no cell can be visited more than one time.


  Example 1 :

  Input:
  N = 4
  m[][] = {{1, 0, 0, 0},
           {1, 1, 0, 1},
           {1, 1, 0, 0},
           {0, 1, 1, 1}}

  Output: DDRDRR DRDDRR
  Explanation:
  The rat can reach the destination at (3, 3) from (0, 0) by two paths - DRDDRR and DDRDRR, when printed in sorted order we get DDRDRR DRDDRR.


  Example 2 :

  Input:
  N = 2
  m[][] = {{1, 0},
           {1, 0}}
  Output: -1

  Explanation:
  No path exists and destination cell is blocked.

*/
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans=new ArrayList<>();

        int[][] visited= new int[n][n];
        if(n<=1 || m==null)
            return ans;
        findPath(ans,m,visited,n,0,0,"");
        return ans;
    }

    static void findPath(ArrayList<String> ans,int[][]m,int[][] visited,int n,int rowLocation,int colLocation,String pathSoFar)
    {
        if(rowLocation >=n || colLocation>=n || rowLocation <0 || colLocation<0 || visited[rowLocation][colLocation] == 1 || m[rowLocation][colLocation]==0 )
            return;
        if(rowLocation==n-1 && colLocation==n-1)
        {
            ans.add(pathSoFar);
            return;
        }



        visited[rowLocation][colLocation]=1;
        findPath(ans,m,visited,n,rowLocation-1,colLocation,pathSoFar+"U");
        findPath(ans,m,visited,n,rowLocation+1,colLocation,pathSoFar+"D");
        findPath(ans,m,visited,n,rowLocation,colLocation-1,pathSoFar+"L");
        findPath(ans,m,visited,n,rowLocation,colLocation+1,pathSoFar+"R");
        visited[rowLocation][colLocation]=0;
    }
}

/*
**************** Logic ****************
Use backtracking. For each cell, try to move to all its four neighbors. Use a visited matrix to check if a cell is already visited or not.
*/