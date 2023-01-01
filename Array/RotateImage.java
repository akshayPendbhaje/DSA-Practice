/*
**************** Problem Description ****************
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
    Example 1 : 
    Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
    Output: [[7,4,1],[8,5,2],[9,6,3]]
    Example 2 : 
    Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
    
    Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
    Example 3 : 
    Input: matrix = [[1]]
    
    Output: [[1]]
    Example 4 : 
    Input: matrix = [[1,2],[3,4]]
    Output: [[3,1],[4,2]]
*/

class Solution {
    public void rotate(int[][] matrix) {
        
        int size=matrix.length;
        
        for(int i=0;i<size;i++)
        {
            for(int j=i;j<size;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size/2;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][size-j-1];
                matrix[i][size-j-1]=temp;
            }
        }
        
    }
}

*
**************** Logic ****************
* clockwise rotate
* first reverse up to down, then swap the symmetry 
* 1 2 3     7 8 9     7 4 1
* 4 5 6  => 4 5 6  => 8 5 2
* 7 8 9     1 2 3     9 6 3
* anticlockwise rotate
* first reverse left to right, then swap the symmetry
* 1 2 3     3 2 1     3 6 9
* 4 5 6  => 6 5 4  => 2 5 8
* 7 8 9     9 8 7     1 4 7
  
*/
