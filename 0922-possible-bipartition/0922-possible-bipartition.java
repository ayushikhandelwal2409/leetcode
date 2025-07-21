class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <=n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] con : dislikes) {
            adj.get(con[0]).add(con[1]);
            adj.get(con[1]).add(con[0]);
        }
        int[] color=new int[n+1];
        Arrays.fill(color,-1);
        for(int i=1;i<=n;i++){
            if(color[i]==-1){
                if(dfs(adj,color,i,0)==false) return false;
            }
        }
        return true;
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int[] color,int node,int col){
        color[node]=col;
        for(int neighbour:adj.get(node)){
            if(color[neighbour]==-1){
                if (dfs(adj,color,neighbour,1-col) == false) return false;
            }
            else if(color[node]==color[neighbour]) return false;
        }
        return true;
    }
}