/*
**************** Problem Description ****************
Given a weighted directed graph with n nodes and m edges. Nodes are labeled from 0 to n-1, the task is to check if it contains a negative weight cycle or not.
Note: edges[i] is defined as u, v and weight.
    Example : 1

    Input: n = 3, edges = {{0,1,-1},{1,2,-2},{2,0,-3}}

    Output: 1
    Explanation: The graph contains negative weight cycle as 0->1->2->0 with weight -1,-2,-3,-1.
    Example : 2

    Input: n = 3, edges = {{0,1,-1},{1,2,-2},{2,0,3}}
    Output: 0
    Explanation: The graph does not contain any negative weight cycle.
*/

class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        //code here

        int[] cost = new int[n];
        Arrays.fill(cost, 999999);
        distance[0] = 0;

        for(int i=1;i<n;i++)
        {
            for(int j=0;j<edges.length;j++)
            {
                int nodeSrc = edges[j][0];
                int nodeDest = edges[j][1];
                int weight = edges[j][2];
                cost[nodeDest]=Math.min(cost[nodeDest],cost[nodeSrc]+weight);
            }
        }


        for(int j=0;j<edges.length;j++)
        {
            int nodeSrc = edges[j][0];
            int nodeDest = edges[j][1];
            int weight = edges[j][2];
            if(cost[nodeDest] > cost[nodeSrc]+weight)
                return 1;
        }
        return 0;
    }
}