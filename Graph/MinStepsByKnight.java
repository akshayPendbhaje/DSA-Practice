/*
**************** Problem Description ****************
Given a square chessboard, the initial position of Knight and position of a target. Find out the minimum steps a Knight will take to reach the target position.
Note:
The initial and the target position co-ordinates of Knight have been given accoring to 1-base indexing.
    Example : 1

    Input:
    N=6
    knightPos[ ] = {4, 5}
    targetPos[ ] = {1, 1}

    Output: 3

    Explanation:
    Knight takes 3 step to reach from
    (4, 5) to (1, 1): (4, 5) -> (5, 3) -> (3, 2) -> (1, 1).

*/
class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        int dx[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
        int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
        boolean[][] visited=new boolean[N+1][N+1];
        Queue<Pair> q= new LinkedList<>();
        if(KnightPos[0] == TargetPos[0] && KnightPos[1] == TargetPos[1]) return 0;
        q.add(new Pair(KnightPos[0],KnightPos[1]));
        visited[KnightPos[0]][KnightPos[1]]=true;
        int ans=0;
        while(!q.isEmpty())
        {

            int size=q.size();
            for(int j=0;j<size;j++)
            {
                Pair cur= q.remove();
                if(cur.row==TargetPos[0] && cur.col==TargetPos[1])
                    return ans;
                // System.out.println("row is "+ cur.row + " col is "+ cur.col + " time is "+ cur.dist);

                for(int i=0;i<8;i++)
                {
                    if( isValidPosition(cur.row+dx[i],cur.col+dy[i],N) && !visited[cur.row+dx[i]][cur.col+dy[i]]  )
                    {
                        visited[cur.row+dx[i]][cur.col+dy[i]]=true;
                        q.add(new Pair(cur.row+dx[i],cur.col+dy[i]));

                    }

                }

            }
            ans++;
        }

        return -1;
    }

    boolean isValidPosition(int row,int col,int size)
    {
        if(row<0 || col <0 || row>size || col > size)
        {
            return false;
        }
        else
            return true;
    }

}

class Pair {
    int row;
    int col;
    public Pair(int row,int col)
    {
        this.row=row;
        this.col=col;
    }
}

/*
**************** Logic ****************
Use BFS to find the shortest path.
*/