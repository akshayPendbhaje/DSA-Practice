/*
**************** Problem Description ****************
Given a starting vertex in graph, print the BFS traversal.
    Example : 1

    Input:
    5 7
    0 1
    0 4
    1 2
    1 3
    1 4
    2 3
    3 4
    0

    Output:
    BFS Traversal Starting From Vertex 0 :
    0, 1, 4, 2, 3,

*/
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here

        ArrayList<Integer> ans = new ArrayList<>();
        if(adj==null || adj.size()==0)return ans;
        Queue<Integer> q = new LinkedList<>();

        boolean[] visited = new boolean[V];

        //System.out.println("loop of "+i);
        q.add(0);
        while(!q.isEmpty())
        {
            Integer vertices=q.remove();
            if(!visited[vertices])
            {
                //System.out.println("vertices of "+vertices+" "+visited[vertices]);
                ans.add(vertices);
                visited[vertices]=true;

            }
            for(Integer connectedNode:adj.get(vertices))
            {
                if(!visited[connectedNode])
                    q.add(connectedNode);
            }
        }
        return ans;
    }
}