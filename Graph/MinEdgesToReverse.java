/*
**************** Problem Description ****************
Given a directed graph and a source node and destination node, we need to find how many edges we need to reverse in order to make at least 1 path from source node to destination node.
Input :
First Line contains four space separated integers denoting number of vertices(V), edges(E), start(src) and end(dest) node.
The next E line contains two space separated integers denoting an edge from u to v.
    Example : 1

    Input:
    7 7 0 6
    0 1
    2 1
    5 1
    2 3
    6 3
    6 4
    4 5

    Output:
    Minimum Edges to Reverse : 2
*/


class Solution {
    public static int minimumEdgeReversal(int[][] edges, int n, int m, int src, int dst) {
        // code here
        Map<Integer,ArrayList<Pair>> adj = new HashMap<>();

        for(int[] edge : edges )
        {
            ArrayList<Pair> edge1=adj.getOrDefault(edge[0],new ArrayList<Pair>());
            edge1.add(new Pair(edge[1],0));
            adj.put(edge[0],edge1);

            ArrayList<Pair> edge2=adj.getOrDefault(edge[1],new ArrayList<Pair>());
            edge2.add(new Pair(edge[0],1));
            adj.put(edge[1],edge2);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src,0));
        int[] weights = new int[n+1];
        Arrays.fill(weights,9999);
        boolean[] visited= new boolean[n+1];
        while(!pq.isEmpty())
        {
            Pair p=pq.remove();
            visited[p.node]=true;
            for(Pair neighbor: adj.get(p.node))
            {
                weights[neighbor.node]=Math.min(weights[neighbor.node],p.weight+neighbor.weight);
                if(!visited[neighbor.node])
                    pq.add(new Pair(neighbor.node,weights[neighbor.node]));
            }
        }

        return (weights[dst]==9999)?-1:weights[dst];
    }


}


public class Pair implements Comparable<Pair>
{
    int node;
    int weight;
    public Pair(int node,int weight)
    {
        this.node=node;
        this.weight=weight;
    }

    public int compareTo(Pair other)
    {
        return this.weight-other.weight;
    }
}


/*
**************** Logic ****************
This problem can be solved assuming a different version of the given graph.
In this version we make a reverse edge corresponding to every edge and we assign that a weight 1 and assign a weight 0 to original edge.
Now we can see that we have modified the graph in such a way that, if we move towards original edge, no cost is incurred, but if we move toward reverse edge 1 cost is added.
So if we apply Dijkstra’s shortest path on this modified graph from given source, then that will give us minimum cost to reach from source to destination i.e. minimum edge reversal from source to destination.
*/