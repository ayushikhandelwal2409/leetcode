class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int[][] ans=new int[n][m];
        int[][] vis=new int[n][m];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.offer(new int[]{i,j,0});
                    vis[i][j]=1;
                }
                else{
                    vis[i][j]=0;
                }
            }
        }
        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};
        
        while(!q.isEmpty()){
            int[] arr=q.poll();
            int row=arr[0];
            int col=arr[1];
            int steps=arr[2];
            ans[row][col]=steps;
            for(int i=0;i<4;i++){
                int nrow=delrow[i]+row;
                int ncol=delcol[i]+col;
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0){
                    vis[nrow][ncol]=1;
                    q.offer(new int[]{nrow,ncol,steps+1});
                }
            }
        }
        return ans;
    }
}