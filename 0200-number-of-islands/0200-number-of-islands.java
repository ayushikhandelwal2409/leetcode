// class Solution {
//     public int numIslands(char[][] grid) {// checking for disconnected components
//         int n=grid.length;
//         int m=grid[0].length;
//         int[][] vis=new int[n][m];
//         int cnt=0;
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(vis[i][j]==0 && grid[i][j]=='1'){
//                     cnt++;
//                     //dfs(i,j,grid,vis);
//                     Queue<int[]> q=new LinkedList<>();
//                     q.add(new int[]{i,j});
//                     vis[i][j]=1;
//                     while(!q.isEmpty()){
//                         int[] k=q.poll();
//                         int r=k[0];
//                         int c=k[1];
//                         int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
//                         for(int p=0;p<4;p++){
//                             int nr=directions[p][0]+r;
//                             int nc=directions[p][1]+c;
//                             if (nr >= 0 && nr < n && nc >= 0 && nc < m 
//                                 && vis[nr][nc] == 0 && grid[nr][nc] == '1') {
//                                 vis[nr][nc] = 1;
//                                 q.add(new int[]{nr, nc});
//                             }
//                         }
//                     }
//                 }
//             }
//         }
//         return cnt;
//     }
// }
class Solution {
    public int numIslands(char[][] grid) {// checking for disconnected components
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