class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;//no. of nodes
        int[] vis=new int[n];
        int cnt=0;
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                cnt++;
                dfs(i,isConnected,vis);
            }
        }
        return cnt;
    }
    public static void dfs(int node,int[][] arr,int[] vis){
        vis[node]=1;
        for (int k = 0; k < arr[node].length; k++) { 
            if (arr[node][k] == 1 && vis[k] == 0){ 
                dfs(k, arr, vis);
            }
        }
    }
}