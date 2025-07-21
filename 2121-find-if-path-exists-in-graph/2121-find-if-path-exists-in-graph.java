class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
      ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int[] vis=new int[n];
        return (dfs(adj,vis,source,destination)) ;
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int[] vis ,int node,int destination){
        if(node==destination) return true;
        vis[node]=1;
        for(int neighbour:adj.get(node)){
             if(vis[neighbour]!=1){
                if(dfs(adj,vis,neighbour,destination)) return true;
            }
        }
        return false;
    }
}