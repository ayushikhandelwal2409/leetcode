class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis =new int[n][m];
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0 && vis[i][j]!=1){
                    int area=dfs(grid,vis,i,j);
                    max=Math.max(max,area);
                }
            }
        }
        return max;
    }
    public int dfs(int[][] grid,int[][] vis,int row,int col){
        int n=grid.length;
        int m=grid[0].length;
        vis[row][col]=1;
        int area=1;
        int[] rdir={-1,0,1,0};
        int[] cdir={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nrow=row+rdir[i];
            int ncol=col+cdir[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]!=1 && grid[nrow][ncol]!=0){
                area+=dfs(grid,vis,nrow,ncol);
            }
        }
        return area;
    }
}