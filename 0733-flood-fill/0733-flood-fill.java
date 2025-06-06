class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int inicolor=image[sr][sc];
        int[][] ans=image;
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        dfs(image ,sr, sc, inicolor,color,delrow,delcol,ans);
        return ans;
    }
    private void dfs(int[][] image ,int row,int col,int inicolor,int newcolor,int[]delrow,int[] delcol,int[][]ans){
        ans[row][col]=newcolor;
        int n=image.length;
        int m=image[0].length;
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==inicolor && ans[nrow][ncol]!=newcolor){
                dfs(image,nrow,ncol,inicolor,newcolor,delrow,delcol,ans);
            }
        }
    }
}