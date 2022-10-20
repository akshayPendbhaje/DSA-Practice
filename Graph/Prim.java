/*
**************** Problem Description ****************
Given a weighted, undirected and connected graph of V vertices and E edges. The task is to find the sum of weights of the edges of the Minimum Spanning Tree.
First line of the custom input must contain two space separated integers V denoting the number of vertices and E denoting the number of edges.
Next E lines contains three space-separated integers denoting each edge and weight between the edges.
    Example : 1

    Input:
    3 3
    0 1 5
    1 2 3
    0 2 1

    Output: 4
*/

class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj)
    {
        boolean visited[] = new boolean[V+1];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(adj.get(0).get(0).get(0),0));
        int ans=0;
        while(!pq.isEmpty())
        {
            Pair current= pq.remove();
            if(visited[current.src]) continue;
            ans+=current.weight;
            visited[current.src]=true;
            //   System.out.println(current.src+" "+adj.get(current.src));
            for(ArrayList<Integer> weight: adj.get(current.src))
                if(!visited[weight.get(0)])
                    pq.add(new Pair(weight.get(0),weight.get(1)));
        }
        return ans;
    }
}


class Pair implements Comparable<Pair>
{
    int src;
    int weight;

    public Pair(int src , int weight)
    {
        this.src=src;
        this.weight=weight;
    }

    public int compareTo(Pair other)
    {
        return this.weight-other.weight;
    }
}

