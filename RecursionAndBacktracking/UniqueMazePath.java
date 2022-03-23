/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

Example 1:
Input: m = 3, n = 7
Output: 28

Example 2:
Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down

*/

class Solution {
    public int uniquePaths(int m, int n) {
        int ans=pathHelper(0,0,m-1,n-1);
        return ans;
    }
    
    public static int pathHelper(int cr,int cc,int dr,int dc)
    {
        int hpath=0;
        int vpath=0;
        
        if(cr==dr && cc==dc)
        {
            return 1;
        }
     if(cr<dr)
        {
              hpath= pathHelper(cr+1,cc,dr,dc);
        }
    if(cc<dc)
        {
              vpath= pathHelper(cr,cc+1,dr,dc);
        }
        
        return hpath+vpath;
    }
}

/* 
we keep faith that for next position the helper method will give us total count, 
get this count for horizontal and vertical till it is not out of maze and return the sum to meet expectation
*/ 