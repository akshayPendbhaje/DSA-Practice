/*
**************** Problem Description ****************
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
  
  
  Example 1 : 
  
  Input: n = 4
  
  Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
  
  Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
  
  
  Example 2 : 
  
  Input: n = 1
  
  Output: [["Q"]]
  
*/

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        if(n==0)
            return ans;
        boolean board[][]=new boolean[n][n];
        placeQueens(n,ans,0,new ArrayList<String>(),board);
        return ans;
    }
    
    public void placeQueens(int n,List<List<String>> ans,int row,ArrayList<String> qsf,boolean[][] board){
        if(row==n)
        {
            ans.add(new ArrayList(qsf));
            return;
        }
        
       for(int col=0;col<n;col++)
       {
           if(isQueenSafe(board,row,col)){
               board[row][col]=true;
               char[] charArray=new char[n];
               Arrays.fill(charArray,'.');
               charArray[col]='Q';
               qsf.add(new String(charArray));
               placeQueens(n,ans,row+1,qsf,board);
               board[row][col]=false;
               qsf.remove(qsf.size()-1);
           }
       }
    }
    public static boolean isQueenSafe(boolean[][] board,int row,int col)
              {
                // Check all rows
                  for(int i=row-1, j=col;i>=0;i--)
                  {
                      if(board[i][j]==true)
                          return false;
                  }
                  // Check 45 degree diagonal
                  for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--)
                  {
                      if(board[i][j]==true)
                          return false;
                  }
                  // Check 135 degree diagonal
                  for(int i=row-1, j=col+1;i>=0 && j<board.length;i--,j++)
                  {
                      if(board[i][j]==true)
                      {
                          return false;
                      }
                  }
                  
                  return true;
              }
}


/*
**************** Logic ****************
In this problem, we can go row by row, and in each position, we need to check if the column, the 45° diagonal and the 135° diagonal had a queen before.
*/