/*
**************** Problem Description ****************
There are n computers numbered from 0 to n-1 connected by ethernet cables connections forming a network where
connections[i] = [a, b] represents a connection between computers a and b.
Any computer can reach any other computer directly or indirectly through the network.
Given an initial computer network connections. You can extract certain cables between two directly connected computers,
and place them between any pair of disconnected computers to make them directly connected.
Return the minimum number of times you need to do this in order to make all the computers connected. If it's not possible, return -1.


    Example : 1

    Input: n = 4, connections = [[0,1],[0,2],[1,2]]
    Output: 1
    Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.


    Example : 2

    Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
    Output: 2


    Example : 3

    Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
    Output: -1
    Explanation: There are not enough cables.


    Example : 4

    Input: n = 5, connections = [[0,1],[0,2],[3,4],[2,3]]
    Output: 0

*/
class Solution {
    Map<Integer,ArrayList<Integer>> adj;
    int components=0;
    public int makeConnected(int n, int[][] connections) {
        generateList(n,connections);
        boolean[] visited = new boolean[n];
        countComponents(adj,visited);
        int redandantEdges=connections.length-((n-1)-(components-1));
        return (redandantEdges>=components-1)?components-1:-1;
    }


    void generateList(int n, int[][] connections)
    {
        adj= new HashMap<>();

        for(int[] edge:connections)
        {
            ArrayList al1=adj.getOrDefault(edge[0],new ArrayList<Integer>());
            al1.add(edge[1]);
            adj.put(edge[0],al1);

            ArrayList al2=adj.getOrDefault(edge[1],new ArrayList<Integer>());
            al2.add(edge[0]);
            adj.put(edge[1],al2);
        }

    }

    void countComponents(Map<Integer,ArrayList<Integer>> adj,boolean[] visited)
    {
        for(int i=0;i<visited.length;i++)
        {
            if(!visited[i])
            {
                treverseGraph(adj,i,visited);
                components++;
            }
        }
    }

    void treverseGraph(Map<Integer,ArrayList<Integer>> adj,int index,boolean[] visited)
    {
        if(visited[index])return;
        visited[index]=true;
        for(int key: adj.getOrDefault(index,new ArrayList<Integer>()))
            treverseGraph(adj,key,visited);
    }

}

/*
**************** Logic ****************
We need at least n - 1 cables to connect all nodes (like a tree). If connections.size() < n - 1, we can directly return -1.
One trick is that, if we have enough cables, we don't need to worry about where we can get the cable from.
We only need to count the number of connected networks (clusters). To connect two unconneccted networks, we need to set one cable.
The number of operations we need = the number of connected networks - 1
*/