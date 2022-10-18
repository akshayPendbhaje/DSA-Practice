
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here

        if(adj==null) return false;

        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++)
        {if(!visited[i])
        {
            if(checkCyclic(visited,adj,i,-1))
                return true;
        }
        }
        return false;
    }

    boolean checkCyclic(boolean[] visited,ArrayList<ArrayList<Integer>> adj,int index,int parent)
    {


        visited[index]=true;
        for(int connected:adj.get(index))
        {
            if(!visited[connected]){
                if( checkCyclic(visited,adj,connected,index))
                    return true;
            }
            else if(connected!=parent)
                return true;
        }


        return false;
    }
}