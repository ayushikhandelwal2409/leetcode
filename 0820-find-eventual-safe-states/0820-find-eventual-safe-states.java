class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V=graph.length;
        int[] vis=new int[V];
        int[] visPath=new int[V];
        int[] check=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(vis,visPath,check,i,graph);
            }
        }
        ArrayList<Integer> safeNodes=new ArrayList<>();
        for(int i=0;i<V;i++){
            if(check[i]==1){
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }
    private boolean dfs(int[] vis,int[] visPath ,int[] check,int node,int[][] graph ){
        vis[node]=1;
        visPath[node]=1;
        check[node]=0;
        for(int neighbour:graph[node]){
            if(vis[neighbour]==0){
                if(dfs(vis,visPath,check,neighbour,graph)==true) return true;
            }
            else if(visPath[neighbour]==1){
                return true;
            }
        }
        visPath[node]=0;
        check[node]=1;
        return false;
    }
}
