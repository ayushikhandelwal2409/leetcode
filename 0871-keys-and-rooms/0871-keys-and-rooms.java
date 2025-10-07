class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] vis=new boolean[n];
        dfs(rooms,0,vis);
        for(int i=0;i<n;i++){
            if (!vis[i])return false;
        }
        return true;
    }
    public boolean dfs(List<List<Integer>> rooms,int node,boolean[] vis){
        if(vis[node]) return false;
        vis[node]=true;
        for(int neighbour:rooms.get(node)){
           if(dfs(rooms,neighbour,vis)) return true;
        }
        return false;
    }
}