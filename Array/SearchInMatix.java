/*
**************** Problem Description ****************
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
    Example1 : 
    Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
    Output: true
    Example2 : 
    Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
    Output: false
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m=matrix[0].length-1;
        int n=matrix.length-1;
        int row=0;
        int col=m;
        while(row>=0 && col>=0 && row <=n && col<=m)
        {
            //System.out.println(row+" "+col+" "+m+ " "+n);
            if(matrix[row][col]==target)
            {
                return true;
            }
            else if(matrix[row][col]>target)
            {
                col--;
            }
            else
            {
                row++;
            }
        }
        
        return false;
    }
}


/* 
start with top right position as mid and if target > mid we do not have to treverse the column 
so col--;
if target < column means we have to check entire column for element
if not found return false.
*/