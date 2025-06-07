class Solution {
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int[][] vis=new int[n][m];
         int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};
        //for 1st nad last row
        for(int j=0;j<m;j++){
            if(board[0][j]=='O' && vis[0][j]==0){
                dfs(board,vis,0,j,delrow,delcol);
            }
            if(board[n-1][j]=='O' && vis[n-1][j]==0){
                dfs(board,vis,n-1,j,delrow,delcol);
            }
        }
        //for 1st and last col
        for(int i=0;i<n;i++){
            if(board[i][0]=='O' && vis[i][0]==0){
                dfs(board,vis,i,0,delrow,delcol);
            }
            if(board[i][m-1]=='O' && vis[i][m-1]==0){
                dfs(board,vis,i,m-1,delrow,delcol);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O' && vis[i][j]==0){
                    board[i][j]='X';
                }
            }
        }
    }
    public static void dfs(char[][] board,int[][]vis,int row,int col,int[] delrow,int[] delcol){
        int n=board.length;
        int m=board[0].length;
        vis[row][col]=1;
        for(int i=0;i<4;i++){
            int nrow=delrow[i]+row;
            int ncol=delcol[i]+col;
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && board[nrow][ncol]=='O'){
                dfs(board,vis,nrow,ncol,delrow,delcol);
            }
        }
    }
}