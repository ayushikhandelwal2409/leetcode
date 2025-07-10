class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == word.charAt(0) && dfs(board,word,i,j,0) )return true;  // 0==>index of string {word}
            }
        }
        return false;
    }
    public boolean dfs(char[][] board,String word,int row,int col,int idx){
        int n=board.length;
        int m=board[0].length;
        if(idx==word.length()) return true;
        if(row<0 || row>=n ||col<0 || col>=m || board[row][col]!=word.charAt(idx)){
            return false;
        }
        char value=board[row][col];
        board[row][col]='-';
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (dfs(board, word,newRow, newCol, idx + 1)) {
                return true;
            }
        }
        board[row][col]=value;
        return false;
    }
}