class Solution {
    int cnt=0;
    public int totalNQueens(int n) {
        ArrayList<String> cur=new ArrayList<>();
        queen_placement(n,0,cur);
        return cnt;
    }
    public void queen_placement(int tq,int tqpsf,ArrayList<String> cur){
        if(tqpsf==tq){
            cnt++;
            return;
        }
        for(int i=0;i<tq;i++){
            if(isSafe(tqpsf,i,cur,tq)){
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < tq; j++) {
                    if (j == i) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                cur.add(sb.toString());
                queen_placement( tq, tqpsf + 1,cur);
                cur.remove(cur.size() - 1); // backtrack
            }
        }
    }
    public boolean isSafe(int row,int col,ArrayList<String> board,int n ){
        // Check the column
        for (int i = 0; i < row; i++) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        // Check the upper left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        // Check the upper right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }
}