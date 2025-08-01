class Solution {
    public void solveSudoku(char[][] board) {
        solver(board,0,0);
    }
    public static boolean solver(char[][] board,int r,int c){
        if(c==9){
            r++;
            c=0;
        }
        if(r==9){
            return true;
        }
        if (board[r][c] != '.') {
            return solver(board, r, c + 1);
        }
        for(int val=1;val<=9;val++){
            if(check(board,r,c,val)){
                board[r][c]=(char)('0'+val);
                if(solver(board,r,c)) return true;
                board[r][c]='.';
            }
        }
        return false;
    }
    
    public static boolean check(char[][] board, int row, int col, int val) {
        // Row check
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == (char) ('0' + val)) {
                return false;
            }
        }

        // Column check
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == (char) ('0' + val)) {
                return false;
            }
        }

        // 3x3 matrix check
        int r = row - row % 3;
        int c = col - col % 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[i][j] == (char) ('0' + val)) {
                    return false;
                }
            }
        }
        return true; 
    }
}