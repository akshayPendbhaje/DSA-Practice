/*
**************** Problem Description ****************
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

    Example : 1

    Input: grid = [
        ["1","1","1","1","0"],
        ["1","1","0","1","0"],
        ["1","1","0","0","0"],
        ["0","0","0","0","0"]
    ]
    Output: 1


    Example : 2

    Input: grid = [
        ["1","1","0","0","0"],
        ["1","1","0","0","0"],
        ["0","0","1","0","0"],
        ["0","0","0","1","1"]
    ]
    Output: 3
*/
class Solution {
    int islands=0;
    public int numIslands(char[][] grid) {

        if(grid==null) return 0;

        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1')
                {
                    islands++;
                    colorIsland(grid,i,j);
                }
            }
        }
        return islands;
    }


    void colorIsland(char[][]island,int row,int col)
    {
        if(row<0 || col < 0 || row >=island.length || col >= island[0].length || island[row][col]!='1' )
        {
            return;
        }

        island[row][col]=2;

        colorIsland(island,row+1,col);
        colorIsland(island,row,col+1);
        colorIsland(island,row-1,col);
        colorIsland(island,row,col-1);
    }
}

/*
**************** Logic ****************
Iterate through each of the cell and if it is an island, do dfs to mark all adjacent islands, then increase the counter by 1.
*/