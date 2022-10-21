/*
**************** Problem Description ****************
Check if the graph is Eulerian or not.
Print Eulerian path for semi Eulerian graph.
Input :
First Line contains four space separated integers denoting number of vertices(V) and edges(E).
The next E line contains two space separated integers denoting an edge from u to v.
    Example : 1

    Input:
    5 5
    0 1
    0 2
    1 2
    0 3
    3 4

    Output:
    Graph is Semi-Eulerian
    Euler Path : 0, 1, 2, 0, 3, 4,
*/
class Solution
{
    public int isEularCircuitExist(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here

        boolean[] visited = new boolean[V];
        int nodeWithEdge=0;
        for(int i=0;i<V;i++)
        {
            if(adj.get(i).size()>0)
            {nodeWithEdge=i;
                break;}
        }

        treverseGraph(adj,visited,nodeWithEdge);

        for(int i=0;i<V;i++)
        {
            if(!visited[i] && adj.get(i).size()>0) return 0;
        }

        int oddCount=0;
        for(int i=0;i<V;i++)
        {
            if(adj.get(i).size()%2==1)oddCount++;
        }

        if(oddCount == 0 ) return 2;
        else if (oddCount == 2) return 1;
        else return 0;
    }

    public void treverseGraph(ArrayList<ArrayList<Integer>> adj,boolean[] visited,int index)
    {
        if(visited[index]) return;

        visited[index]=true;
        for(int neighbor : adj.get(index))
        {
            if(!visited[neighbor])
                treverseGraph(adj,visited,neighbor);
        }

    }
}