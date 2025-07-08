class Solution {
    public int[] findRedundantConnection(int[][] edges) {  //using dfs
        int n=edges.length;
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>(n+1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            boolean[] vis=new boolean[n+1];
            if(isConnected(graph,u,v,vis)){
                return edge;
            }
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return new int[0];
    }
    public boolean isConnected(ArrayList<ArrayList<Integer>> graph, int start, int target, boolean[] vis){
        if (start == target) {
            return true;
        }
        vis[start]=true;
        for(int neighbour:graph.get(start)){
            if(!vis[neighbour] && isConnected(graph,neighbour,target,vis)){
                return true;
            }
        }
        return false;
    }
}