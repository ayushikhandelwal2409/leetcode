class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    cnt++;
                    dfs(i,j,grid,vis);
                }
            }
        }
        return cnt;
    }
    public static void dfs(int r,int c,char[][] arr,int[][] vis){
        if(r < 0 || r>=arr.length || c<0 || c>=arr[0].length ||vis[r][c]==1 || arr[r][c]=='0'){
            return;
        }
        vis[r][c]=1;

        dfs(r+1,c, arr, vis); 
        dfs(r-1,c, arr, vis);
        dfs(r,c+1, arr, vis);
        dfs(r,c-1, arr, vis);       
    }
}