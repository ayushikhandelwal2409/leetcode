class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        int[][] vis=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(dfs(board,word,i,j,0,vis) )return true;  // 0==>index of string {word}
            }
        }
        return false;
    }
    public boolean dfs(char[][] board,String word,int row,int col,int idx,int[][] vis){
        int n=board.length;
        int m=board[0].length;
        if(idx==word.length()) return true;
        if(row<0 || row>=n ||col<0 || col>=m|| vis[row][col]==1 || board[row][col]!=word.charAt(idx)){
            return false;
        }
        vis[row][col]=1;
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (dfs(board, word,newRow, newCol, idx + 1,vis)) {
                vis[row][col] = 0; // backtrack
                return true;
            }
        }
        vis[row][col]=0;
        return false;
    }
}